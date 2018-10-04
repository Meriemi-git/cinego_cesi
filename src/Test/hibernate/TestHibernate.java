package Test.hibernate;
/*
 * TestHibernate.java                                21 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */


import java.io.Serializable;
import java.sql.SQLException;

import Test.hibernate.doa.ContactImplHibernate;
import Test.hibernate.entity.Adresse;
import Test.hibernate.entity.Contacts;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class TestHibernate {

    /**
     * TODO commenter le role de la Méthode
     * @param args
     */
    public static void main(String[] args) {
        ContactImplHibernate daoHi = new ContactImplHibernate();
        Adresse adresse = new Adresse("Rue de la touffe", 12000, "Rodez");
        Contacts test2 = new Contacts("Michel", "Paul", adresse);

        try {
            daoHi.addContact(test2);
            System.out.println("Id : " + test2.getId());
            daoHi.listAllContact();
            daoHi.removeContact(test2);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
