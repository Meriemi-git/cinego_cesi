package cineGOv02.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hugo
 */
@Entity
@Table(name="Siege")
public class Siege {
    /** TODO commenter le Champ */
    private int id;
    /** TODO commenter le Champ */
    private int numeroPlace;
    /** TODO commenter le Champ */
    private boolean handicap;
    /** TODO commenter le Champ */
    private boolean libre;
    /** TODO commenter le Champ */
    private int x;
    /** TODO commenter le Champ */
    private int y;

    /**
     *  TO DO COMMENTEZ LE ROLE DU CONSTRUCTEUR
     */
    public Siege() { 
    }
    
    /**
     * TODO commenter le role du Constructeur
     * @param numeroPlace
     * @param handicap
     * @param libre
     * @param x
     * @param y
     */
    public Siege(int numeroPlace, boolean handicap, boolean libre, int x, int y) {
        super();
        this.numeroPlace = numeroPlace;
        this.handicap = handicap;
        this.libre = libre;
        this.x = x;
        this.y = y;
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
     * @return the numeroPlace
     */
    @Column (name="numeroPlace")
    public int getNumeroPlace() {
        return numeroPlace;
    }

    /**
     * @param numeroPlace the numeroPlace to set
     */
    public void setNumeroPlace(int numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    /**
     * @return the handicap
     */
    @Column (name="isHandicap")
    public boolean isHandicap() {
        return handicap;
    }

    /**
     * @param handicap the handicap to set
     */
    public void setHandicap(boolean handicap) {
        this.handicap = handicap;
    }

    /**
     * @return the libre
     */
    @Column (name="isLibre")
    public boolean isLibre() {
        return libre;
    }

    /**
     * @param libre the libre to set
     */
    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    /**
     * @return le x
     */
    @Column (name="x")
    public int getX() {
        return x;
    }

    /**
     * @param x le x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return le y
     */
    @Column (name="y")
    public int getY() {
        return y;
    }

    /**
     * @param y le y to set
     */
    public void setY(int y) {
        this.y = y;
    }
}
