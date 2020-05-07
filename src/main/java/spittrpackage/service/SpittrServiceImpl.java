package spittrpackage.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import spittrpackage.domain.*;
import spittrpackage.exceptions.SpittrServiceException;
import spittrpackage.persistence.SpitterRepository;
import spittrpackage.persistence.SpittleRepository;
import java.util.List;

@Service("spittrServiceImpl")
public class SpittrServiceImpl implements SpittrService {

    @Autowired
    private SpitterRepository spitterDao;

    @Autowired
    private SpittleRepository spittleDao;

    public void addSpitter(Spitter aSpitter) throws SpittrServiceException{
        try{
            spitterDao.save(aSpitter);
        }
       catch(DataAccessException ex){
           throw new SpittrServiceException("Exception", ex);
        }
    }

    public Spitter getSpitter(int aSpitterId) throws SpittrServiceException{
        try{
            return spitterDao.getOne(aSpitterId);
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public Spitter getSpitterByUsername(String aUsername) throws SpittrServiceException{
        try{
            return spitterDao.getByUsername(aUsername);
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public List<Spitter> getAllSpitters() throws SpittrServiceException{
        try{
            return spitterDao.findAll();
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void updateSpitter(Spitter aSpitter) throws SpittrServiceException{
        try{
            Spitter temp = spitterDao.getOne(aSpitter.getId());
            temp.setUsername(aSpitter.getUsername());
            spitterDao.save(temp);
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void deleteSpitter(Spitter aSpitter) throws SpittrServiceException{
        try{
            spitterDao.delete(aSpitter);
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void addSpittle(Spittle aSpittle) throws SpittrServiceException{
        try{
            spittleDao.save(aSpittle);
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public Spittle getSpittle(int aSpittleId) throws SpittrServiceException{
        try{
            return spittleDao.getOne(aSpittleId);
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public List<Spittle> getAllSpittles()  throws SpittrServiceException{
        try{
            return spittleDao.findAll();
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void updateSpittle(Spittle aSpittle)  throws SpittrServiceException{
        try{
            Spittle temp = spittleDao.getOne(aSpittle.getId());
            temp.setText(aSpittle.getText());
            spittleDao.save(temp);
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public void deleteSpittle(Spittle aSpittle) throws SpittrServiceException{
        try{
            spittleDao.delete(aSpittle);
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

    public List<Spittle> getSpittersSpittles(Spitter aSpitter) throws SpittrServiceException {
        try{
            return spittleDao.getSpittersSpittlesFromDB(aSpitter.getId());
        }
        catch(DataAccessException ex){
            throw new SpittrServiceException("Exception", ex);
        }
    }

}
