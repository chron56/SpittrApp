package spittrpackage.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.exceptions.SpittrDaoException;
import spittrpackage.exceptions.SpittrServiceException;
import spittrpackage.persistence.SpittrDao;


import java.util.List;

@Service("spittrServiceImpl")
public class SpittrServiceImpl implements SpittrService {

    @Autowired
    @Qualifier("spittrDaoHibernateImpl")
    private SpittrDao mydao;

    public void addSpitter(Spitter aSpitter) throws SpittrServiceException {
        try{
            mydao.init();
            mydao.addSpitterToDB(aSpitter);
            mydao.close();
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void addSpittle(Spittle aSpittle) throws SpittrServiceException {
        try{
            mydao.init();
            mydao.addSpittleToDB(aSpittle);
            mydao.close();
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public Spitter getSpitter(int aSpitterId) throws SpittrServiceException {
        try{
            mydao.init();
            Spitter spitter = mydao.getSpitterFromDB(aSpitterId);
            mydao.close();
            return spitter;
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public Spittle getSpittle(int aSpittleId) throws SpittrServiceException {
        try{
            mydao.init();
            Spittle spittle = mydao.getSpittleFromDB(aSpittleId);
            mydao.close();
            return spittle;
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public List<Spitter> getAllSpitters() throws SpittrServiceException {
        try{
            mydao.init();
            List<Spitter> spitters = mydao.getAllSpittersFromDB();
            mydao.close();
            return spitters;
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public List<Spittle> getAllSpittles() throws SpittrServiceException{
        try{
            mydao.init();
            List<Spittle> spittles = mydao.getAllSpittlesFromDB();
            mydao.close();
            return spittles;
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public List<Spittle> getSpittersSpittles(Spitter aSpitter) throws SpittrServiceException {
        try{
            mydao.init();
            List<Spittle> spittles = mydao.getSpittersSpittlesFromDB(aSpitter);
            mydao.close();
            return spittles;
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void updateSpitter(Spitter aSpitter) throws SpittrServiceException {
       try{
           mydao.init();
           mydao.updateSpitterToDB(aSpitter);
           mydao.close();
       }
       catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
       }
    }

    public void updateSpittle(Spittle aSpittle) throws SpittrServiceException {
        try{
            mydao.init();
            mydao.updateSpittleToDB(aSpittle);
            mydao.close();
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void deleteSpitter(Spitter aSpitter) throws SpittrServiceException {
        try{
            mydao.init();
            mydao.deleteSpitterFromDB(aSpitter);
            mydao.close();
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void deleteSpittle(Spittle aSpittle)throws SpittrServiceException {
        try{
            mydao.init();
            mydao.deleteSpittleFromDB(aSpittle);
            mydao.close();
        }
        catch(SpittrDaoException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

}
