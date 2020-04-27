package spittrpackage;

import spittrpackage.entities.Spitter;
import spittrpackage.entities.Spittle;
import java.util.List;

public interface SpittrService {

    void init();

    void close();

    void addSpitter(Spitter aSpitter);

    void addSpittle(Spittle aSpittle);

    Spitter getSpitter(int aSpitterId);

    Spittle getSpittle(int aSpittleId);

    List<Spittle> getSpittersSpittles(Spitter aSpitter);

    void updateSpitter(Spitter aSpitter);

    void updateSpittle(Spittle aSpittle);

    void deleteSpitter(Spitter aSpitter);

    void deleteSpittle(Spittle aSpittle);

}
