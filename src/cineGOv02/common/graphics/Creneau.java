/*
 * Creneau.java                                16 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import cineGOv02.common.entity.Seance;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 */
public class Creneau extends JPanel {
    /** Titre du film Contenu dans ce panel */
    private JLabel film;
    /** Heure ou indice de ce JPanel */
    private int heure;
    /** Seance programmées à cet horaire */
    private Seance seance;
    /** TODO commenter le Champ */
    private Creneau[] jour;
    
    /**
     * TODO commenter le role du Constructeur
     */
    public Creneau(){
        this.film = new JLabel();
        this.add(film);
    }

    /**
     * @return le film
     */
    public JLabel getFilm() {
        return film;
    }

    /**
     * @param film le film to set
     */
    public void setFilm(String film) {
        this.film.setText(film);
    }

    /**
     * @return le heure
     */
    public int getHeure() {
        return heure;
    }

    /**
     * @param heure le heure to set
     */
    public void setHeure(int heure) {
        this.heure = heure;
    }

    /**
     * @return le seance
     */
    public Seance getSeance() {
        return seance;
    }

    /**
     * @param seance le seance to set
     */
    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    /**
     * @return le jour
     */
    public Creneau[] getJour() {
        return jour;
    }

    /**
     * @param jour le jour to set
     */
    public void setJour(Creneau[] jour) {
        this.jour = jour;
    }
    
}
