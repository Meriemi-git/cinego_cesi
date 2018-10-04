/*
 * Genre.java                                21 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

import javax.swing.JLabel;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 */
public class Genre extends JLabel {
    
    /** TODO commenter le Champ */
    private boolean actif = false;
    
    /** TODO commenter le Champ */
    private String genre = "";
    
    /**
     * TODO commenter le role du Constructeur
     * @param text
     */
    public Genre(String text){
        super(text);
    }

    /**
     * @return le actif
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * @param actif le actif to set
     */
    public void setActif(boolean actif) {
        this.actif = actif;
    }

    /**
     * @return le genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre le genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
