package spittrpackage;

import java.sql.*;
import java.util.ArrayList;

public class DBHandler {

    private String url="jdbc:mysql://localhost/spitterdb?user=user";
    private Connection con;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;

    public void init(){
        try{
            con = DriverManager.getConnection (url, "user", "userpassword");
        }
        catch(SQLException ex) {
            System.err.println("SQLException: "+ex.getMessage());
        }
    }

    public void close(){
        try{
            con.close();
        }
        catch(SQLException ex) {
            System.err.println("SQLException: "+ex.getMessage());
        }
    }


    public void addSpitterToDB(Spitter aSpitter){
        try{
            pst=con.prepareStatement("INSERT INTO spitters(ID,Username) values (?,?)");
            pst.setString(1,Integer.toString(aSpitter.getId()));
            pst.setString(2,aSpitter.getUsername());
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }

    public Spitter getSpitterFromDB(String aString){
        String query="SELECT * FROM `spitters` WHERE Username='"+aString+"'";
        int tempId=0;
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            if(res.next()){
                tempId=res.getInt("ID");
            }
            stmt.close();
        }
        catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return new Spitter(tempId,aString);
    }

    public ArrayList<Spittle> getSpittersSpittlesFromDB(Spitter aSpitter){
        String spitterId=Integer.toString(aSpitter.getId());
        String query="SELECT * FROM `spittles` WHERE SpitterId='"+spitterId+"'";
        int tempId=0;
        String tempText=null;
        ArrayList<Spittle> spittles= new ArrayList<Spittle>();
        try
        {
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            while( res.next() )
            {
                tempId = res.getInt("ID");
                tempText = res.getString("TextValue");
                Spittle tempSpittle = new Spittle(tempId,aSpitter.getId(),tempText);
                spittles.add(tempSpittle);
            }
            stmt.close();
        }
        catch(SQLException ex)
        {
            System.err.println("SQLException: "+ex.getMessage());
        }
        return spittles;
    }

    public void updateSpitterToDB(Spitter aSpitter){
        try{
            pst=con.prepareStatement("UPDATE spitters SET Username=? WHERE ID='"+Integer.toString(aSpitter.getId())+"'");
            pst.setString(1,aSpitter.getUsername());
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }

    public void deleteSpitterFromDB(Spitter aSpitter){
        try{
            pst=con.prepareStatement("DELETE FROM  spitters  WHERE ID='"+Integer.toString(aSpitter.getId())+"'");
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }


    public void addSpittleToDB(Spittle aSpittle){
        try{
            pst=con.prepareStatement("INSERT INTO spittles(ID,SpitterId,TextValue) values (?,?,?)");
            pst.setString(1,Integer.toString(aSpittle.getId()));
            pst.setString(2,Integer.toString(aSpittle.getSpitterId()));
            pst.setString(3,aSpittle.getText());
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }

    public Spittle getSpittleFromDB(int anId){
        String spittleId=Integer.toString(anId);
        String query="SELECT * FROM `spittles` WHERE ID='"+spittleId+"'";
        int tempSpitterId=0;
        String tempText=null;
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            if(res.next()){
                tempSpitterId=res.getInt("SpitterID");
                tempText=res.getString("TextValue");
            }
            stmt.close();
        }
        catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return new Spittle(anId,tempSpitterId,tempText);
    }

    public void updateSpittleToDB(Spittle aSpittle){
        try{
            pst=con.prepareStatement("UPDATE spittles SET TextValue=? WHERE ID='"+Integer.toString(aSpittle.getId())+"'");
            pst.setString(1,aSpittle.getText());
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }

    public void deleteSpittleFromDB(Spittle aSpittle){
        try{
            pst=con.prepareStatement("DELETE FROM  spittles  WHERE ID='"+Integer.toString(aSpittle.getId())+"'");
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            System.err.println("SQLException: "+ex.getMessage());
        }
    }
}
