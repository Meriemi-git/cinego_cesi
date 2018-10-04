/*
 * Adresse.java                                22 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package Test.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
@Entity
@Table(name="adresses")  
public class Adresse {

    /** TODO commenter le Champ */
    private int id;
    /** TODO commenter le Champ */
    private String street;
    /** TODO commenter le Champ */
    private int postalCode;
    /** TODO commenter le Champ */
    private String city;
    
    /**
     * TODO commenter le role du Constructeur
     */
    public Adresse(){       
    }
    
    /**
     * TODO commenter le role du Constructeur
     * @param street
     * @param postalcode
     * @param city
     */
    public Adresse(String street, int postalcode, String city){
        this.street = street;
        this.postalCode = postalcode;
        this.city = city;
    }
    /**
     * @return le id
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * @param id le id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return le street
     */
    @Column (name="street")
    public String getStreet() {
        return street;
    }

    /**
     * @param street le street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return le postalCode
     */
    @Column (name="postalCode")
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode le postalCode to set
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return le city
     */
    @Column (name="city_name")
    public String getCity() {
        return city;
    }

    /**
     * @param city le city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    
}
