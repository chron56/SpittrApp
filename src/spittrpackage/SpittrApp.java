package spittrpackage;

import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.persistence.*;
import spittrpackage.service.SpittrServiceImpl;

public class SpittrApp {

    public static void main(String[] args) {
        SpittrDao mydao = new SpittrDaoHibernateImpl();
        SpittrServiceImpl aService = new SpittrServiceImpl(mydao);
        aService.init();
        //add
        Spitter spitter =  new Spitter(1,"user1");
        Spitter spitter2 =  new Spitter(2,"user2");
        aService.addSpitter(spitter);
        aService.addSpitter(spitter2);
        Spittle spittle1 = new Spittle(1,"first");
        spittle1.setSpitter(spitter);
        Spittle spittle2 = new Spittle(2,"second");
        spittle2.setSpitter(spitter);
        Spittle spittle3 = new Spittle(3, "third");
        spittle3.setSpitter(spitter2);
        aService.addSpittle(spittle1);
        aService.addSpittle(spittle2);
        aService.addSpittle(spittle3);
        //get
        int spitterId=2;
        spitter = aService.getSpitter(spitterId);
        System.out.println("Spitter with id="+spitterId+" has "+(spitter.getUsername())+" as username");
        System.out.println("Spitter with id="+spitterId+" has the following spittles");
        spitter.setSpittlesList(aService.getSpittersSpittles(spitter));
        for(Spittle aSpittle : spitter.getSpittlesList()) {
            System.out.println(aSpittle.getText());
        }
        int spittleId=2;
        spittle2 = aService.getSpittle(spittleId);
        System.out.println("Spittle with id="+spittleId+" : "+spittle2.getText());
        //update
        spitter.setUsername("chronarakis user");
        aService.updateSpitter(spitter);
        spittle2.setText("chronarakis text");
        aService.updateSpittle(spittle2);
        //delete
        aService.deleteSpittle(spittle3);
        aService.deleteSpitter(spitter);
        aService.close();
    }
}
