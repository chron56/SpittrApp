package spittrpackage.persistence;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import spittrpackage.exceptions.SpittrDaoException;

import java.util.List;
import java.util.ArrayList;

public class SpittrDaoHibernateImpl implements SpittrDao{

    protected SessionFactory sessionFactory;

    public void init() throws SpittrDaoException {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void close() throws SpittrDaoException {
        try{
            sessionFactory.close();
        }
        catch (Exception ex) {
            throw new SpittrDaoException("Exception", ex);
        }

    }

    public void addSpitterToDB(Spitter aSpitter) throws SpittrDaoException {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(aSpitter);
            session.getTransaction().commit();
            session.close();
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public Spitter getSpitterFromDB(int anId) throws SpittrDaoException {
        try{
            Session session = sessionFactory.openSession();
            Spitter aSpitter = session.get(Spitter.class, anId);
            session.close();
            return aSpitter;
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public List<Spittle> getSpittersSpittlesFromDB(Spitter aSpitter) throws SpittrDaoException {
        try{
            return aSpitter.getSpittlesList();
        }
        catch (Exception ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public List<Spitter> getAllSpittersFromDB() throws SpittrDaoException {
        try{
            List<Spitter> spitters = new ArrayList<Spitter>();
            Session session = sessionFactory.openSession();
            spitters = session.createQuery("from Spitter").list();
            session.close();
            return spitters;
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void updateSpitterToDB(Spitter aSpitter) throws SpittrDaoException {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(aSpitter);
            session.getTransaction().commit();
            session.close();
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void deleteSpitterFromDB(Spitter aSpitter) throws SpittrDaoException {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(aSpitter);
            session.getTransaction().commit();
            session.close();
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void addSpittleToDB(Spittle aSpittle) throws SpittrDaoException {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(aSpittle);
            session.getTransaction().commit();
            session.close();
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public Spittle getSpittleFromDB(int anId) throws SpittrDaoException {
        try{
            Session session = sessionFactory.openSession();
            Spittle aSpittle = session.get(Spittle.class, anId);
            session.close();
            return aSpittle;
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public List<Spittle> getAllSpittlesFromDB() throws SpittrDaoException {
        try{
            List<Spittle> spittles = new ArrayList<Spittle>();
            Session session = sessionFactory.openSession();
            spittles = session.createQuery("from Spittle").list();
            session.close();
            return spittles;
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void updateSpittleToDB(Spittle aSpittle) throws SpittrDaoException {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(aSpittle);
            session.getTransaction().commit();
            session.close();
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

    public void deleteSpittleFromDB(Spittle aSpittle) throws SpittrDaoException {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(aSpittle);
            session.getTransaction().commit();
            session.close();
        }
        catch (JDBCException ex) {
            throw new SpittrDaoException("Exception", ex);
        }
    }

}
