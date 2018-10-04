package Test.hibernate.doa;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import Test.hibernate.entity.Contacts;

/*
 * ContactDAO.java                                19 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public interface ContactDAO {
    /**
     * Ajout d'un contact en BD
     * @param c
     * @throws SQLException 
     */
    public void addContact(Contacts c) throws SQLException;
    
    /**
     * Supprime un contact en BD
     * @param c
     * @throws SQLException
     */
    public void removeContact(Contacts c) throws SQLException;
    
    /**
     * Renoiv la liste des contact depuis la BD
     * @return les contacts
     * @throws SQLException 
     */
    public List<Contacts> listAllContact() throws SQLException;
}
