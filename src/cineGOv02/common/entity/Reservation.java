package cineGOv02.common.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Hugo
 *
 */
@Entity
@Table(name="Reservation")
public class Reservation
{
    /** TODO commenter le Champ */
    private int id;
    /** TODO commenter le Champ */
    private double prix;
    /** TODO commenter le Champ */
    private User user;
    /** TODO commenter le Champ */
    private String listeSiege;
    /** TODO commenter le Champ */
    private Seance seance;
    /** TODO commenter le Champ */
    private int nbPlace;
    /** TODO */
    private Timestamp dateResa;
    

    /**
     *  TO DO COMMENTEZ LE ROLE DU CONSTRUCTEUR
     */
    public Reservation(){  
    }

    /**
     * TODO commenter le role du Constructeur
     * @param prix
     * @param client
     * @param listeSiege
     * @param seance
     * @param nbPlace
     * @param dateResa
     */
    public Reservation(double prix, User user, String listeSiege, Seance seance, int nbPlace, Timestamp dateResa) {
        super();
        this.prix = prix;
        this.user = user;
        this.listeSiege = listeSiege;
        this.seance = seance;
        this.nbPlace = nbPlace;
        this.dateResa = dateResa;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the prix
     */
    @Column (name="prix")
    public double getPrix() {
        return prix;
    }
    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }
    /**
     * @return the client
     */
    @OneToOne
    @JoinColumn(name="user")
    public User getUser() {
        return user;
    }
    /**
     * @param client the client to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * @return the siege
     */
    @Column (name="listeSiege")
    public String getListeSiege() {
        return listeSiege;
    }
    /**
     * @param listeSiege le listeSiege to set
     */
    public void setListeSiege(String listeSiege) {
        this.listeSiege = listeSiege;
    }

    /**
     * @return the seance
     */
    @OneToOne
    @JoinColumn(name="seance",nullable = false)
    public Seance getSeance() {
        return seance;
    }
    
    /**
     * @param seance the seance to set
     */
    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    /**
     * @return le nbPlace
     */
    @Column (name="nbPlace")
    public int getNbPlace() {
        return nbPlace;
    }

    /**
     * @param nbPlace le nbPlace to set
     */
    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    /**
     * @return le dateResa
     */
    @Column (name="dateResa", columnDefinition="TIMESTAMP")
    public java.sql.Timestamp getDateResa() {
        return dateResa;
    }

    /**
     * @param dateResa le dateResa to set
     */
    public void setDateResa(java.sql.Timestamp dateResa) {
        this.dateResa = dateResa;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String titreFilm = this.seance.getFilm().getTitre();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String heureSeance = sdf.format(new Date(this.seance.getDebut().getTime()));
        return titreFilm + '\n' + heureSeance + '\n' + "Places : " + this.nbPlace + " Prix : " + this.prix;
    }
    
}
