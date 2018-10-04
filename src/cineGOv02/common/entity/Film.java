package cineGOv02.common.entity;

import java.sql.Blob;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Hugo
 *
 */
@Entity
@Table(name="Film") 
public class Film {
    /** TODO commenter le Champ */
    private int id;
    /** TODO commenter le Champ */
    private int idTMDB;
    /** TODO commenter le Champ */
    private String titre;
    /** TODO commenter le Champ */
    private Integer duree;
    /** TODO commenter le Champ */
    private String genre;
    /** TODO commenter le Champ */
    private String realisateur;
    /** TODO commenter le Champ */
    private java.sql.Date dateSortie;
    /** TODO */
    private java.sql.Date dateAjout;
    /** TODO commenter le Champ */
    private String casting;
    /** TODO commenter le Champ */
    private String synopsis;
    /** TODO commenter le Champ */
    private Double note;
    /** TODO commenter le Champ */
    private Blob image;
    /** TODO commenter le Champ */
    private String htlmColor;

    /**
     *  TO DO COMMENTEZ LE ROLE DU CONSTRUCTEUR
     */
    public Film() {
    }

    /**
     * TODO commenter le role du Constructeur
     * @param idTMDB
     * @param titre
     * @param duree
     * @param genre
     * @param realisateur
     * @param dateSortie
     * @param dateAjout
     * @param casting
     * @param synopsis
     * @param note
     * @param image
     * @param htlmColor
     */
    public Film(int idTMDB, String titre, Integer duree, String genre, String realisateur, Date dateSortie,
            Date dateAjout, String casting, String synopsis, Double note, Blob image, String htlmColor) {
        super();
        this.idTMDB = idTMDB;
        this.titre = titre;
        this.duree = duree;
        this.genre = genre;
        this.realisateur = realisateur;
        this.dateSortie = dateSortie;
        this.dateAjout = dateAjout;
        this.casting = casting;
        this.synopsis = synopsis;
        this.note = note;
        this.image = image;
        this.htlmColor = htlmColor;
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
     * @return le idTMDB
     */
    @Column (name="idTMDB")
    public int getIdTMDB() {
        return idTMDB;
    }

    /**
     * @param idTMDB le idTMDB to set
     */
    public void setIdTMDB(int idTMDB) {
        this.idTMDB = idTMDB;
    }

    /**
     * @return the informations
     */
    @Column (name="titre")
    public String getTitre() {
        return titre;
    }
    /**
     * @param informations the informations to set
     */
    public void setTitre(String informations) {
        this.titre = informations;
    }

    /**
     * @return the duree
     */
    @Column (name="duree")
    public int getDuree() {
        return duree;
    }
    /**
     * @param duree the duree to set
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * @return le genre
     */
    @Column (name="genre")
    public String getGenre() {
        return genre;
    }
    /**
     * @param genre le genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return le realisateur
     */
    @Column (name="realisateur")
    public String getRealisateur() {
        return realisateur;
    }
    /**
     * @param realisateur le realisateur to set
     */
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    /**
     * @return le dateSortie
     */
    @Column (name="dateSortie")
    public java.sql.Date getDateSortie() {
        return dateSortie;
    }
    /**
     * @param dateSortie le dateSortie to set
     */
    public void setDateSortie(java.sql.Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    /**
     * @return le casting
     */
    @Column (name="casting")
    public String getCasting() {
        return casting;
    }
    /**
     * @param casting le casting to set
     */
    public void setCasting(String casting) {
        this.casting = casting;
    }
    /**
     * @return le synopsis
     */
    @Column (name="synopsis")
    public String getSynopsis() {
        return synopsis;
    }
    /**
     * @param synopsis le synopsis to set
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * @return le note
     */
    @Column (name="note")
    public Double getNote() {
        return note;
    }
    /**
     * @param note le note to set
     */
    public void setNote(Double note) {
        this.note = note;
    }

    /**
     * @return le afficheURL
     */
    @Column (name="image")
    public Blob getImage() {
        return image;
    }

    /**
     * @param afficheURL le afficheURL to set
     */
    public void setImage(Blob image) {
        this.image = image;
    }

    /**
     * @return le htlmColor
     */
    @Column (name="htmlColor")
    public String getHtlmColor() {
        return htlmColor;
    }

    /**
     * @param htlmColor le htlmColor to set
     */
    public void setHtlmColor(String htlmColor) {
        this.htlmColor = htlmColor;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Film && this.getIdTMDB() == ((Film)obj).getIdTMDB();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Film cloned = new Film();
        cloned.setCasting(this.casting);
        cloned.setDateSortie(this.dateSortie);
        cloned.setDuree(this.duree);
        cloned.setGenre(this.genre);
        cloned.setHtlmColor(this.htlmColor);
        cloned.setId(this.getId());
        cloned.setIdTMDB(this.idTMDB);
        cloned.setImage(this.image);
        cloned.setNote(this.note);
        cloned.setRealisateur(this.realisateur);
        cloned.setSynopsis(this.synopsis);
        cloned.setTitre(this.titre);   
        return cloned;
    }

    /**
     * @return le dateAjout
     */
    @Column (name="dateAjout")
    public java.sql.Date getDateAjout() {
        return dateAjout;
    }

    /**
     * @param dateAjout le dateAjout to set
     */
    public void setDateAjout(java.sql.Date dateAjout) {
        this.dateAjout = dateAjout;
    }
    
    
    
    
}
