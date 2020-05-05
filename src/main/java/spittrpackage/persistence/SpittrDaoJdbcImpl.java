package spittrpackage.persistence;

import org.springframework.stereotype.Repository;
import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.exceptions.SpittrDaoException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

@Repository("spittrDaoJdbcImpl")
public class SpittrDaoJdbcImpl implements SpittrDao {

    private String url="jdbc:mysql://localhost/spitterdb?user=user";
    private Connection con;
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet res;

    public void init() throws SpittrDaoException {
        try{
            con = DriverManager.getConnection (url, "user", "userpassword");
        }
        catch(SQLException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void close() throws SpittrDaoException {
        try{
            con.close();
        }
        catch(SQLException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void addSpitterToDB(Spitter aSpitter) throws SpittrDaoException {
        try{
            pst=con.prepareStatement("INSERT INTO spitters(ID,Username) values (?,?)");
            pst.setString(1,Integer.toString(aSpitter.getId()));
            pst.setString(2,aSpitter.getUsername());
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public Spitter getSpitterFromDB(int anId) throws SpittrDaoException {
        String query="SELECT * FROM `spitters` WHERE ID='"+anId+"'";
        String tempUsername=null;
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            if( res.next() ){
                tempUsername=res.getString("Username");
            }
            stmt.close();
        }
        catch(SQLException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
        return new Spitter(anId,tempUsername);
    }

    public List<Spittle> getSpittersSpittlesFromDB(Spitter aSpitter) throws SpittrDaoException {
        String spitterId=Integer.toString(aSpitter.getId());
        String query="SELECT * FROM `spittles` WHERE SpitterId='"+spitterId+"'";
        int tempId=0;
        String tempText=null;
        List<Spittle> spittles= new ArrayList<Spittle>();
        try
        {
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            while( res.next() )
            {
                tempId = res.getInt("ID");
                tempText = res.getString("TextValue");
                Spittle tempSpittle = new Spittle(tempId,tempText);
                tempSpittle.setSpitter(aSpitter);
                spittles.add(tempSpittle);
            }
            stmt.close();
        }
        catch(SQLException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
        return spittles;
    }

    public List<Spitter> getAllSpittersFromDB() throws SpittrDaoException {
        String query="SELECT * FROM `spitters`";
        List<Spitter> spitters = new ArrayList<Spitter>();
        List<Spittle> spittles = new ArrayList<Spittle>();
        int tempId=0;
        String tempUsername=null;
        int tempId2=0;
        String tempText=null;
        Connection con2;
        Statement stmt2;
        ResultSet res2;
        try
        {
            con2 = DriverManager.getConnection (url, "user", "userpassword");
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            while( res.next() )
            {
                tempId = res.getInt("ID");
                tempUsername = res.getString("Username");
                Spitter tempSpitter = new Spitter(tempId,tempUsername);
                stmt2 = con2.createStatement();
                res2 = stmt2.executeQuery("SELECT * FROM `spittles` WHERE SpitterId='"+tempId+"'");
                while( res2.next() )
                {
                    tempId2 = res2.getInt("ID");
                    tempText = res2.getString("TextValue");
                    Spittle tempSpittle = new Spittle(tempId2,tempText);
                    tempSpittle.setSpitter(tempSpitter);
                    spittles.add(tempSpittle);
                }
                stmt2.close();
                tempSpitter.setSpittlesList(spittles);
                spitters.add(tempSpitter);
            }
            stmt.close();
        }
        catch(SQLException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
        return spitters;
    }

    public void updateSpitterToDB(Spitter aSpitter) throws SpittrDaoException {
        try{
            pst=con.prepareStatement("UPDATE spitters SET Username=? WHERE ID='"+Integer.toString(aSpitter.getId())+"'");
            pst.setString(1,aSpitter.getUsername());
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void deleteSpitterFromDB(Spitter aSpitter) throws SpittrDaoException {
        try{
            pst=con.prepareStatement("DELETE FROM  spitters  WHERE ID='"+Integer.toString(aSpitter.getId())+"'");
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void addSpittleToDB(Spittle aSpittle) throws SpittrDaoException {
        try{
            pst=con.prepareStatement("INSERT INTO spittles(ID,SpitterId,TextValue) values (?,?,?)");
            pst.setString(1,Integer.toString(aSpittle.getId()));
            pst.setString(2,Integer.toString(aSpittle.getSpitter().getId()));
            pst.setString(3,aSpittle.getText());
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public Spittle getSpittleFromDB(int anId) throws SpittrDaoException {
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
        catch(SQLException ex){
            throw new SpittrDaoException("Exception", ex);
        }
        return new Spittle(anId,tempText);
    }

    public List<Spittle> getAllSpittlesFromDB() throws SpittrDaoException {
        String query="SELECT * FROM `spittles`";
        List<Spittle> spittles= new ArrayList<Spittle>();
        int tempId=0;
        String tempText=null;
        int tempSpitterId=0;
        String tempUsername=null;
        Connection con2;
        Statement stmt2;
        ResultSet res2;
        try
        {
            con2 = DriverManager.getConnection (url, "user", "userpassword");
            stmt = con.createStatement();
            res = stmt.executeQuery(query);
            while( res.next() )
            {
                tempId = res.getInt("ID");
                tempText = res.getString("TextValue");
                tempSpitterId = res.getInt("SpitterID");
                Spittle tempSpittle = new Spittle(tempId,tempText);
                stmt2 = con2.createStatement();
                res2 = stmt2.executeQuery("SELECT * FROM `spitters` WHERE ID='"+tempSpitterId+"'");
                res2.first();
                tempUsername = res2.getString("Username");
                stmt2.close();
                Spitter tempSpitter = new Spitter(tempId,tempUsername);
                tempSpittle.setSpitter(tempSpitter);
                spittles.add(tempSpittle);
            }
            con2.close();
            stmt.close();
        }
        catch(SQLException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
        return spittles;
    }

    public void updateSpittleToDB(Spittle aSpittle) throws SpittrDaoException{
        try{
            pst=con.prepareStatement("UPDATE spittles SET TextValue=? WHERE ID='"+Integer.toString(aSpittle.getId())+"'");
            pst.setString(1,aSpittle.getText());
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void deleteSpittleFromDB(Spittle aSpittle) throws SpittrDaoException {
        try{
            pst=con.prepareStatement("DELETE FROM  spittles  WHERE ID='"+Integer.toString(aSpittle.getId())+"'");
            pst.executeUpdate();
            pst.close();
        }
        catch(SQLException ex){
            throw new SpittrDaoException("Exception", ex);
        }
    }

}
