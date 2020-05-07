package spittrpackage.domain;

import org.hibernate.annotations.Proxy;
import javax.persistence.*;
import java.util.List;

@Proxy(lazy=false)
@Entity
@Table(name = "spitters")
public class Spitter {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Username")
    private String username;
    @OneToMany(mappedBy = "spitter",fetch = FetchType.EAGER)
    private List<Spittle> spittles;

    public Spitter(){

    }

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
