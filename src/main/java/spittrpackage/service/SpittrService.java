package spittrpackage.service;

import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.exceptions.SpittrServiceException;
import java.util.List;

public interface SpittrService {

    void addSpitter(Spitter aSpitter) throws SpittrServiceException;

    void addSpittle(Spittle aSpittle) throws SpittrServiceException;

    Spitter getSpitter(int aSpitterId) throws SpittrServiceException;

    Spittle getSpittle(int aSpittleId) throws SpittrServiceException;

    List<Spittle> getSpittersSpittles(Spitter aSpitter) throws SpittrServiceException;

    List<Spitter> getAllSpitters() throws SpittrServiceException;

    List<Spittle> getAllSpittles() throws SpittrServiceException;

    void updateSpitter(Spitter aSpitter) throws SpittrServiceException;

    void updateSpittle(Spittle aSpittle) throws SpittrServiceException;

    void deleteSpitter(Spitter aSpitter) throws SpittrServiceException;

    void deleteSpittle(Spittle aSpittle) throws SpittrServiceException;

}
