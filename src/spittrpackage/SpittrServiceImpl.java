package spittrpackage;

import java.util.List;

public class SpittrServiceImpl implements SpittrService {

    private SpittrDao mydao;

    public SpittrServiceImpl(SpittrDao adao){
        this.mydao = adao;
    }

    public void init(){
        mydao.init();
    }
    public void addSpitter(Spitter aSpitter){
        mydao.addSpitterToDB(aSpitter);
    }

    public void addSpittle(Spittle aSpittle){
        mydao.addSpittleToDB(aSpittle);
    }

    public Spitter getSpitter(int aSpitterId){
        return mydao.getSpitterFromDB(aSpitterId);
    }

    public Spittle getSpittle(int aSpittleId){
        return mydao.getSpittleFromDB(aSpittleId);
    }

    public List<Spittle> getSpittersSpittles(Spitter aSpitter){
        return mydao.getSpittersSpittlesFromDB(aSpitter);
    }

    public void updateSpitter(Spitter aSpitter){
        mydao.updateSpitterToDB(aSpitter);
    }

    public void updateSpittle(Spittle aSpittle){
        mydao.updateSpittleToDB(aSpittle);
    }

    public void deleteSpitter(Spitter aSpitter){
        mydao.deleteSpitterFromDB(aSpitter);
    }

    public void deleteSpittle(Spittle aSpittle){
        mydao.deleteSpittleFromDB(aSpittle);
    }

    public void close(){
        mydao.close();
    }

}
