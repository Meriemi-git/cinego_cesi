/*
 * ContactDAOImpl.java                                19 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package Test.hibernate.doa;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Test.hibernate.entity.Contacts;
import Test.hibernate.source.MySQLDataSource;

import java.sql.PreparedStatement;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class ContactDAOImpl implements ContactDAO{

    /** Connection à la BD */
    private Connection connexion;

    /**
     * TODO commenter le role du Constructeur
     */
    public ContactDAOImpl() {
        connexion = MySQLDataSource.getInstance().getConnection();   
    }

    /* (non-Javadoc)
     * @see data.dao.ContactDAO#addContact(data.entity.Contact)
     */
    @Override
    public void addContact(Contacts c) throws SQLException {
        if(!exist(c)){
        PreparedStatement rqt = this.connexion.prepareStatement("INSERT INTO contacts" + " VALUES (null,'"
                + c.getFirstname() + "','" + c.getLastname() + "','" + c.getTel() + "','" + c.getEmail() +"');");
        rqt.execute();
        }
    }

    /* (non-Javadoc)
     * @see data.dao.ContactDAO#removeContact(data.entity.Contact)
     */
    @Override
    public void removeContact(Contacts c) throws SQLException {
        if(exist(c)){
        PreparedStatement rqt = this.connexion.prepareStatement("DELETE FROM contacts" + 
                " WHERE firstname ='" + c.getFirstname() + "' AND lastname ='" + c.getLastname() + "';");
        rqt.execute();
        }
    }

    /* (non-Javadoc)
     * @see data.dao.ContactDAO#listAllContact()
     */
    @Override
    public List<Contacts> listAllContact() throws SQLException {
        PreparedStatement rqt;
        rqt = this.connexion.prepareStatement("SELECT * FROM contacts;");
        rqt.execute();
        ResultSet set = rqt.getResultSet();
        ArrayList<Contacts> allContact= new ArrayList<Contacts>();
        String[] attr = new String[5];
        int id= 0;
        while(set.next()){
            id = Integer.parseInt(set.getString(1));
            attr[0] = set.getString(2);
            attr[1] = set.getString(3);
            attr[2] = set.getString(4);
            attr[3] = set.getString(5);
            allContact.add(new Contacts(id,attr));  
        };
        return allContact;
    }
     

    /**
     * Retourne vrai si un contact existe
     * @param c
     * @return true si le contact existe
     * @throws SQLException 
     */
    public boolean exist(Contacts c)throws SQLException{
        PreparedStatement rqt;
        rqt = this.connexion.prepareStatement("SELECT * FROM contacts" + 
                " WHERE firstname ='" + c.getFirstname() + "' AND lastname ='" + c.getLastname() + "';");
        rqt.execute();
        ResultSet set = rqt.getResultSet();
        return set.next();
    }


}
