package spittrpackage;

import java.util.List;

public class Spitter {

    private int id;
    private String username;
    private List<Spittle> spittles;

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

    public void setSpittlesList(List<Spittle> aList){
        this.spittles = aList;
    }

    public List<Spittle> getSpittlesList(){
        return spittles;
    }
}
