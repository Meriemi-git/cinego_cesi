/*
 * Contact.java                                19 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package Test.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
@Entity
@Table(name="contacts")  
public class Contacts {

    /** TODO commenter le Champ */
    
    private int id;
    /** TODO commenter le Champ */
    private String lastname;
    /** TODO commenter le Champ */
    private String firstname;
    /** TODO commenter le Champ */
    private String tel;
    /** TODO commenter le Champ */
    private String email;
    /** TODO commenter le Champ */
    private String street;
    /** TODO commenter le Champ */
    private String postalCode;
    
    /** TODO commenter le Champ */
    private String city;
    
    /** TODO commenter le Champ */
    private String Birthday;
    
    /** TODO commenter le Champ */
    private Adresse addresse;
    /**
     * Créé un contact
     * @param nom
     * @param prenom
     * @param adresse 
     */
    public Contacts(String nom, String prenom, Adresse adresse){
        this.lastname = nom;
        this.firstname = prenom;
        this.Birthday="01.01.0001";
        this.city="Rodz";
        this.email="trux@machin.qqch";
        this.postalCode="12340";
        this.tel="123456";
        this.street="rue de bidule";
        this.addresse = addresse;
    }
    
    /**
     * Créé un contact
     * @param infos 
     */
    public Contacts(String[] infos){
        this.firstname = infos[0];
        this.lastname = infos[1];
        this.tel = infos[2];
        this.email = infos[3];
    }
    /**
     * Créé un contact
     * @param id 
     * @param infos 
     */
    public Contacts(int id, String[] infos){
        this.id = id;
        this.firstname = infos[0];
        this.lastname = infos[1];
        this.tel = infos[2];
        this.email = infos[3];
    }
    
    /**
     * TODO commenter le role du Constructeur
     */
    public Contacts() {
        // TODO Auto-generated constructor stub
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
     * @return le firstName
     */
    @Column (name="firstName")
    public String getFirstname() {
        return firstname;
    }
    /**
     * @param firstName le firstName to set
     */
    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }
    /**
     * @return le tel
     */
    @Column (name="tel")
    public String getTel() {
        return tel;
    }
    /**
     * @param tel le tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }
    /**
     * @return le email
     */
    @Column (name="email")
    public String getEmail() {
        return email;
    }
    /**
     * @param email le email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode le postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return le city
     */
    @Column (name="city")
    public String getCity() {
        return city;
    }

    /**
     * @param city le city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return le birthday
     */
    @Column (name="birthday")
    public String getBirthday() {
        return Birthday;
    }

    /**
     * @param birthday le birthday to set
     */
    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    /**
     * @return le lastname
     */
    @Column (name="lastname")
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname le lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return le addresse
     */
    @OneToOne
    @JoinColumn(name="adresses")
    public Adresse getAddresse() {
        return addresse;
    }

    /**
     * @param addresse le addresse to set
     */
    public void setAddresse(Adresse addresse) {
        this.addresse = addresse;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {       
        return "Employé : " + this.id + "-- " + this.lastname + " -- " 
        + this.firstname;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Contacts
                && ((Contacts) obj).getFirstname().equals(this.getFirstname())
                && ((Contacts) obj).getLastname().equals(this.getLastname())
                && ((Contacts) obj).getTel().equals(this.getTel())
                && ((Contacts) obj).getEmail().equals(this.getEmail())
                && ((Contacts) obj).getStreet().equals(this.getStreet())
                && ((Contacts) obj).getPostalCode().equals(this.getPostalCode())
                && ((Contacts) obj).getCity().equals(this.getCity())
                && ((Contacts) obj).getBirthday().equals(this.getBirthday());
    }
    
}
