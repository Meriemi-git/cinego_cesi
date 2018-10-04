/*
 * MainApp.java                                28 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

import javax.swing.JFrame;

import cineGOv02.common.entity.Cinema;
import cineGOv02.common.entity.Film;
import cineGOv02.common.entity.Reservation;
import cineGOv02.common.entity.User;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class MainApp extends JFrame {
    /** TODO commenter le Champ */
    private Cinema cinema;
    /** TODO commenter le Champ */
    private User user;
    /** TODO commenter le Champ */
    private Reservation reservation;
    
    /** TODO commenter le Champ */
    private Film film;
    /**
     * @return le cinema
     */
    public Cinema getCinema() {
        return cinema;
    }
    /**
     * @param cinema le cinema to set
     */
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    /**
     * @return le user
     */
    public User getUser() {
        return user;
    }
    /**
     * @param user le user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * @return le reservation
     */
    public Reservation getReservation() {
        return reservation;
    }
    /**
     * @param reservation le reservation to set
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
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
