/*
 * MySQLDataSource.java                                19 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package cineGOv02.common.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class MySQLDataSource {

    /** Sigleton */
    private static MySQLDataSource singleton;

    /** TODO commenter le Champ */
    SessionFactory factory;

    /**
     * Constructeur privé de singleton
     */
    private MySQLDataSource(){ 
        //        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
        //                .configure( "hibernate.cfg.xml" )
        //                .build();
        //
        //            Metadata metadata = new MetadataSources( standardRegistry )
        //                .addAnnotatedClass( Cinema.class )
        //                .addAnnotatedClassName( "cineGOv02.model.entity.Cinema" )
        //                .addResource( "cineGOv02/model/entity/Cinema.hbm.xml" )
        //                .getMetadataBuilder()
        //                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
        //                .build();
        //
        //            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
        //                .build();

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure( "hibernate.cfg.xml" )
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();
        factory = metadata.getSessionFactoryBuilder()
                .build();
    }

    /**
     * Return single instance of singleton and if not exist create this instance
     * @return singleton
     */
    public static MySQLDataSource getInstance(){
        if(singleton == null){
            singleton = new MySQLDataSource();
        }
        return singleton;
    }

    /**
     * Retourne un objet de type connection
     * @return Connection
     */
    public SessionFactory getFactory(){
        return factory;

    }
}
