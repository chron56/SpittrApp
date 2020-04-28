package spittrpackage.persistence;

import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import java.util.List;

public interface SpittrDao {

    void init();

    void close();

    void addSpitterToDB(Spitter aSpitter);

    Spitter getSpitterFromDB(int anId);

    List<Spittle> getSpittersSpittlesFromDB(Spitter aSpitter);

    void updateSpitterToDB(Spitter aSpitter);

    void deleteSpitterFromDB(Spitter aSpitter);

    void addSpittleToDB(Spittle aSpittle);

    Spittle getSpittleFromDB(int anId);

    void updateSpittleToDB(Spittle aSpittle);

    void deleteSpittleFromDB(Spittle aSpittle);

}
