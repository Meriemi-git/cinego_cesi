/*
 * HibernateDataSource.java                                21 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package Test.hibernate.source;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.StandardSessionFactoryServiceInitiators;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class HibernateDataSource {
    
    /** TODO commenter le Champ */
    private static HibernateDataSource singleton;
    
    /** TODO commenter le Champ */
    private static SessionFactory sessionFactory;
    /** TODO commenter le Champ */
    private static StandardServiceRegistry registry;
    
    /**
     * TODO commenter le role du Constructeur
     */
    private HibernateDataSource() {     
    }
    
    /**
     * TODO commenter le role de la Méthode
     * @return xxdf
     */
    public static HibernateDataSource getInsctance(){
        if(singleton == null){
            singleton = new HibernateDataSource();
        }
        return singleton;
    }
    
    /**
     * TODO commenter le role de la Méthode
     * @return test
     */
    public SessionFactory getFactory(){
        registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
        sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }catch(Exception e){
            StandardServiceRegistryBuilder.destroy( registry );
        }
        return sessionFactory;
    }
    
    
}
