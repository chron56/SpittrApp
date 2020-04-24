package spittrpackage;

import java.util.ArrayList;

public class Spitter {

    private int id;
    private String username;
    private ArrayList<Spittle> spittles;

    public Spitter(int anId, String aUsername){
        this.id = anId;
        this.username = aUsername;
    }

    public void setId(int anId){
        this.id = anId;
    }

    public int getId(){
        return id;
    }

    public void setUsername(String aUsername){
        this.username = aUsername;
    }

    public String getUsername(){
        return username;
    }

    public void setSpittlesList(ArrayList<Spittle> aList){
        this.spittles = aList;
    }

    public ArrayList<Spittle> getSpittlesList(){
        return spittles;
    }
}
