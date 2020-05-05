package spittrpackage.persistence;

import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.exceptions.SpittrDaoException;
import java.util.List;

public interface SpittrDao {

    void init() throws SpittrDaoException;

    void close() throws SpittrDaoException;

    void addSpitterToDB(Spitter aSpitter) throws SpittrDaoException;

    Spitter getSpitterFromDB(int anId) throws SpittrDaoException;

    List<Spittle> getSpittersSpittlesFromDB(Spitter aSpitter) throws SpittrDaoException;

    List<Spitter> getAllSpittersFromDB() throws SpittrDaoException;

    void updateSpitterToDB(Spitter aSpitter) throws SpittrDaoException;

    void deleteSpitterFromDB(Spitter aSpitter) throws SpittrDaoException;

    void addSpittleToDB(Spittle aSpittle) throws SpittrDaoException;

    Spittle getSpittleFromDB(int anId) throws SpittrDaoException;

    List<Spittle> getAllSpittlesFromDB() throws SpittrDaoException;

    void updateSpittleToDB(Spittle aSpittle) throws SpittrDaoException;

    void deleteSpittleFromDB(Spittle aSpittle)throws SpittrDaoException;

}
