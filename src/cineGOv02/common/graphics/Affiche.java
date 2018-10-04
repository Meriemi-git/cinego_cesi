/*
 * Affiche.java                                18 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

import javax.swing.JLabel;

import cineGOv02.common.entity.Film;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class Affiche extends JLabel {
    
    /** TODO commenter le Champ */
    private Film film;

    /**
     * @return le film
     */
    public Film getFilm() {
        return film;
    }

    /**
     * @param film le film to set
     */
    public void setFilm(Film film) {
        this.film = film;
    }
    
    

}
