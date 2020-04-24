package spittrpackage;

public class SpittrService {

    public void doStuff(){
        SpittrDao mydao = new SpittrDaoImpl();
        mydao.init();
        //add
        Spitter spitter =  new Spitter(1,"user1");
        Spitter spitter2=  new Spitter(2,"user2");
        mydao.addSpitterToDB(spitter);
        mydao.addSpitterToDB(spitter2);
        Spittle spittle1 = new Spittle(1,"first");
        spittle1.setSpitter(spitter);
        Spittle spittle2 = new Spittle(2,"second");
        spittle2.setSpitter(spitter);
        Spittle spittle3 = new Spittle(3, "third");
        spittle3.setSpitter(spitter2);
        mydao.addSpittleToDB(spittle1);
        mydao.addSpittleToDB(spittle2);
        mydao.addSpittleToDB(spittle3);
        //get
        spitter = mydao.getSpitterFromDB(2);
        if(spitter.getId() != 0){
            System.out.println("The selected spitter exists");
            System.out.println("spitter's username is "+(spitter.getUsername()));
            spitter.setSpittlesList(mydao.getSpittersSpittlesFromDB(spitter));
            System.out.println("spitter's spittles are :");
            for(int i = 0; i < spitter.getSpittlesList().size(); i++) {
                System.out.println(spitter.getSpittlesList().get(i).getText());
            }
        }
        spittle2 = mydao.getSpittleFromDB(2);
        System.out.println("spittle2 text is "+ spittle2.getText());
        //update
        spitter.setUsername("chronarakis user");
        mydao.updateSpitterToDB(spitter);
        System.out.println("spitter's new username is "+ spitter.getUsername());
        spittle2.setText("chronarakis text");
        mydao.updateSpittleToDB(spittle2);
        System.out.println("spittle 2 new text is "+ spittle2.getText());
        //delete
        mydao.deleteSpitterFromDB(spitter2);
        mydao.deleteSpittleFromDB(spittle3);
        mydao.close();


    }
}
