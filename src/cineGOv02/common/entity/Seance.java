package cineGOv02.common.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
@Table(name="Seance") 
public class Seance {
    
    /** TODO commenter le Champ */
    private int id;
    /** TODO comment */
    private Salle salle;
    /** TODO comment */
    private Film film;
    /** TODO commenter le Champ */
    private Timestamp debut;
    /** TODO commenter le Champ */
    private Timestamp fin;
    
    private boolean VF3D;
    
    private boolean VOST3D;
    
    private boolean VF;
    
    private boolean VOST;
    
    private boolean VO;
    
    private String listeSiege;
    
    private int nbPlacesLibres;
    
    /**
     * TODO commenter le role du Constructeur
     */
    public Seance() {
        super();
    }

    /**
     * TODO commenter le role du Constructeur
     * @param salle
     * @param film
     * @param debut
     * @param fin
     * @param vF3D
     * @param vOST3D
     * @param vF
     * @param vOST
     * @param vO
     * @param listeSiege
     * @param nbPlacesLibres
     */
    public Seance(Salle salle, Film film, Timestamp debut, Timestamp fin, boolean vF3D, boolean vOST3D, boolean vF,
            boolean vOST, boolean vO, String listeSiege, int nbPlacesLibres) {
        super();
        this.salle = salle;
        this.film = film;
        this.debut = debut;
        this.fin = fin;
        VF3D = vF3D;
        VOST3D = vOST3D;
        VF = vF;
        VOST = vOST;
        VO = vO;
        this.listeSiege = listeSiege;
        this.nbPlacesLibres = nbPlacesLibres;
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
     * @return le salle
     */
    @OneToOne
    @JoinColumn(name="salle")
    public Salle getSalle() {
        return salle;
    }
    /**
     * @param salle le salle to set
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    /**
     * @return le film
     */
    @OneToOne
    @JoinColumn(name="film")
    public Film getFilm() {
        return film;
    }
    /**
     * @param film le film to set
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * @return le debut
     */
    @Column(name = "debut", columnDefinition="TIMESTAMP")
    public Timestamp getDebut() {
        return debut;
    }
    /**
     * @param debut le debut to set
     */
    public void setDebut(Timestamp debut) {
        this.debut = debut;
    }
    /**
     * @return le fin
     */
    @Column(name = "fin", columnDefinition="TIMESTAMP")
    public Timestamp getFin() {
        return fin;
    }
    /**
     * @param fin le fin to set
     */
    public void setFin(Timestamp fin) {
        this.fin = fin;
    }
    /**
     * @return le vF3D
     */
    @Column(name = "vf3d")
    public boolean isVF3D() {
        return VF3D;
    }
    /**
     * @param vF3D le vF3D to set
     */
    public void setVF3D(boolean vF3D) {
        VF3D = vF3D;
    }
    /**
     * @return le vOST3D
     */
    @Column(name = "vost3d")
    public boolean isVOST3D() {
        return VOST3D;
    }
    /**
     * @param vOST3D le vOST3D to set
     */
    public void setVOST3D(boolean vOST3D) {
        VOST3D = vOST3D;
    }
    /**
     * @return le vF
     */
    @Column(name = "vf")
    public boolean isVF() {
        return VF;
    }
    /**
     * @param vF le vF to set
     */
    public void setVF(boolean vF) {
        VF = vF;
    }
    /**
     * @return le vOST
     */
    @Column(name = "vost")
    public boolean isVOST() {
        return VOST;
    }
    /**
     * @param vOST le vOST to set
     */
    public void setVOST(boolean vOST) {
        VOST = vOST;
    }
    /**
     * @return le vO
     */
    @Column(name = "vo")
    public boolean isVO() {
        return VO;
    }
    /**
     * @param vO le vO to set
     */
    public void setVO(boolean vO) {
        VO = vO;
    }
    /**
     * @return le listeSiege
     */
    @Column(name = "listeSiege")
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
     * @return le nbPlacesPrises
     */
    @Column(name = "nbPlacesLibres")
    public int getNbPlacesLibres() {
        return nbPlacesLibres;
    }

    /**
     * @param nbPlacesPrises le nbPlacesPrises to set
     */
    public void setNbPlacesLibres(int nbPlacesPrises) {
        this.nbPlacesLibres = nbPlacesPrises;
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String heure = sdf.format(this.getDebut());
        return heure;
        
    }
}
