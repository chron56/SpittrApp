package spittrpackage;

public class Spittle {

    private int id;
    private String text;
    private Spitter spitter;

    public Spittle(int anId, String aText){
        this.id = anId;
        this.text = aText;
    }

    public void setId(int anId){
        this.id = anId;
    }

    public int getId(){
        return id;
    }

    public void setSpitter(Spitter aSpitter){
        this.spitter = aSpitter;
    }

    public Spitter getSpitter(){
        return spitter;
    }

    public void setText(String aText){
        this.text = aText;
    }

    public String getText(){
        return text;
    }
}
