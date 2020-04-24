package spittrpackage;

public class Spittle {

    private int id;
    private int spitterId;
    private String text;

    public Spittle(int anId, int anSpitterId, String aText){
        this.id = anId;
        this.spitterId = anSpitterId;
        this.text = aText;
    }

    public void setId(int anId){
        this.id = anId;
    }

    public int getId(){
        return id;
    }

    public void setSpitterId(int anId){
        this.spitterId = anId;
    }

    public int getSpitterId(){
        return spitterId;
    }

    public void setText(String aText){
        this.text = aText;
    }

    public String getText(){
        return text;
    }
}
