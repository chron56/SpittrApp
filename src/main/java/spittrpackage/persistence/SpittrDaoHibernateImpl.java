package spittrpackage.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import spittrpackage.domain.Spitter;
import spittrpackage.domain.Spittle;
import java.util.List;
import java.util.ArrayList;

public class SpittrDaoHibernateImpl implements SpittrDao{

    protected SessionFactory sessionFactory;

    public void init(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void close(){
        sessionFactory.close();
    }

    public void addSpitterToDB(Spitter aSpitter){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(aSpitter);
        session.getTransaction().commit();
        session.close();
    }

    public Spitter getSpitterFromDB(int anId){
        Session session = sessionFactory.openSession();
        Spitter aSpitter = session.get(Spitter.class, anId);
        session.close();
        return aSpitter;
    }

    public List<Spittle> getSpittersSpittlesFromDB(Spitter aSpitter){
        return aSpitter.getSpittlesList();
    }

    public List<Spitter> getAllSpittersFromDB() {
        List<Spitter> spitters = new ArrayList<Spitter>();
        Session session = sessionFactory.openSession();
        spitters = session.createQuery("from Spitter").list();
        session.close();
        return spitters;
    }

    public void updateSpitterToDB(Spitter aSpitter){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(aSpitter);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteSpitterFromDB(Spitter aSpitter){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(aSpitter);
        session.getTransaction().commit();
        session.close();
    }

    public void addSpittleToDB(Spittle aSpittle){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(aSpittle);
        session.getTransaction().commit();
        session.close();
    }

    public Spittle getSpittleFromDB(int anId){
        Session session = sessionFactory.openSession();
        Spittle aSpittle = session.get(Spittle.class, anId);
        session.close();
        return aSpittle;
    }

    public List<Spittle> getAllSpittlesFromDB() {
        List<Spittle> spittles = new ArrayList<Spittle>();
        Session session = sessionFactory.openSession();
        spittles = session.createQuery("from Spittle").list();
        session.close();
        return spittles;
    }

    public void updateSpittleToDB(Spittle aSpittle){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(aSpittle);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteSpittleFromDB(Spittle aSpittle){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(aSpittle);
        session.getTransaction().commit();
        session.close();
    }

}
