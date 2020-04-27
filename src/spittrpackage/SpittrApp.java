package spittrpackage;

public class SpittrApp {

    public static void main(String[] args)
    {

        SpittrDao mydao = new SpittrDaoImpl();
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
        spitter = aService.getSpitter(2);
        if(spitter.getId() != 0) {
            System.out.println("The selected spitter exists");
            System.out.println("spitter's username is " + (spitter.getUsername()));
            System.out.println("spitter's spittles are :");
            spitter.setSpittlesList(aService.getSpittersSpittles(spitter));
            for(Spittle aSpittle : spitter.getSpittlesList()) {
                System.out.println(aSpittle.getText());
            }
        }
        spittle2 = aService.getSpittle(2);
        System.out.println("spittle2 text is "+ spittle2.getText());
        //update
        spitter.setUsername("chronarakis user");
        aService.updateSpitter(spitter);
        spittle2.setText("chronarakis text");
        aService.updateSpittle(spittle2);
        //delete
        aService.deleteSpitter(spitter2);
        aService.deleteSpittle(spittle3);
        aService.close();
    }

}
