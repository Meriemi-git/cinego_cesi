/*
 * CaontactImplHibernate.java                                21 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package Test.hibernate.doa;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.infinispan.notifications.cachelistener.event.Event;

import Test.hibernate.entity.Contacts;
import Test.hibernate.source.HibernateDataSource;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class ContactImplHibernate implements ContactDAO{

    /** Variable d'appel des méthodes hibernate */
    HibernateDataSource dataExchange;

    /** TODO commenter le Champ */
    private SessionFactory factory;

    /**
     * TODO commenter le role du Constructeur
     */
    public ContactImplHibernate() {
        this.dataExchange = HibernateDataSource.getInsctance();
        this.factory = this.dataExchange.getFactory();
    }

    /* (non-Javadoc)
     * @see Test.hibernate.ContactDAO#addContact(Test.hibernate.Contacts)
     */
    @Override
    public void addContact(Contacts c) throws SQLException {
        Session session =null;
        try{
            session = factory.openSession();
        }catch(Exception e){
            System.err.println("Failed to create sessionFactory object."+ e);
            //throw new ExceptionInInitializerError(e);
        }
        session.getTransaction().begin();
        session.saveOrUpdate(c);
        session.getTransaction().commit();
        session.close();
    }

    /* (non-Javadoc)
     * @see Test.hibernate.ContactDAO#removeContact(Test.hibernate.Contacts)
     */
    @Override
    public void removeContact(Contacts c) throws SQLException {
        Session session =null;
        try{
            session = factory.openSession();
        }catch(Exception e){
            System.err.println("Failed to create sessionFactory object."+ e);
            //throw new ExceptionInInitializerError(e);
        }
        
        Query q = session.createQuery("from Contacts where id= :ID");
        q.setString("ID", ""+c.getId());
        Contacts e = (Contacts) q.uniqueResult();
        session.beginTransaction();
        session.delete(e);
        session.getTransaction().commit();
        session.close(); 
        c = null;
    }

    /* (non-Javadoc)
     * @see Test.hibernate.ContactDAO#listAllContact()
     */
    @Override
    public List<Contacts> listAllContact() throws SQLException {
        Session session = null;
        try{
            session = factory.openSession();
        }catch(Exception e){
            System.err.println("Failed to create sessionFactory object."+ e);
            //throw new ExceptionInInitializerError(e);
        }
        session.beginTransaction();
        Query q = session.createQuery("from Contacts");

        List page = q.list();
        for (Object object : page) {
            System.out.println(object.toString());
        }
        session.getTransaction().commit();
        session.close();
        return page;
    }



}
