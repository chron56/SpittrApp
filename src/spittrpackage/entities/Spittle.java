package spittrpackage.entities;

import javax.persistence.*;

@Entity
@Table(name = "spittles")
public class Spittle {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name="TextValue")
    private String text;
    @ManyToOne
    @JoinColumn(name="SpitterID")
    private Spitter spitter;

    public Spittle(){

    }

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
