package spittrpackage;

public class SpittrApp {

    public static void main(String[] args)
    {
        DBHandler handler = new DBHandler();
        handler.init();
        //add
        Spitter spitter =  new Spitter(1,"user1");
        Spitter spitter2=  new Spitter(2,"user2");
        handler.addSpitterToDB(spitter);
        handler.addSpitterToDB(spitter2);
        Spittle spittle1 = new Spittle(1,1,"first");
        Spittle spittle2 = new Spittle(2,1,"second");
        Spittle spittle3 = new Spittle(3,2,"third");
        handler.addSpittleToDB(spittle1);
        handler.addSpittleToDB(spittle2);
        handler.addSpittleToDB(spittle3);
        //get
        spitter = handler.getSpitterFromDB("user1");
        if(spitter.getId() != 0){
            System.out.println("The selected spitter exists");
            System.out.println("user1 id is "+(spitter.getId()));
            spitter.setSpittlesList(handler.getSpittersSpittlesFromDB(spitter));
            System.out.println("user1 spittles are :");
            for(int i = 0; i < spitter.getSpittlesList().size(); i++) {
                System.out.println(spitter.getSpittlesList().get(i).getText());
            }
        }
        spittle2 = handler.getSpittleFromDB(2);
        System.out.println("spittle2 text is "+ spittle2.getText());
        //update
        spitter.setUsername("chronarakis user");
        handler.updateSpitterToDB(spitter);
        System.out.println("spitter's new username is "+ spitter.getUsername());
        spittle2.setText("chronarakis text");
        handler.updateSpittleToDB(spittle2);
        System.out.println("spittle 2 new text is "+ spittle2.getText());
        //delete
        handler.deleteSpitterFromDB(spitter2);
        handler.deleteSpittleFromDB(spittle3);
        handler.close();

    }

}
