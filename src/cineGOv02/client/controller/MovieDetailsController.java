/*
 * MovieDetailsController.java                                19 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.hibernate.SessionFactory;

import cineGOv02.client.view.HomeView;
import cineGOv02.client.view.LoginUserView;
import cineGOv02.client.view.MovieDetailsView;
import cineGOv02.client.view.ReservationView;
import cineGOv02.client.view.UserView;
import cineGOv02.common.entity.Cinema;
import cineGOv02.common.entity.Film;
import cineGOv02.common.entity.User;
import cineGOv02.common.graphics.Controller;
import cineGOv02.common.graphics.MainApp;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class MovieDetailsController implements MouseListener, ActionListener, Controller{
    /** TODO */
    private MainApp frame;
    /** TODO */
    private MovieDetailsView detailsView;
    /** TODO */
    private Film film;
    /** TODO */
    private SessionFactory factory;
    /** TODO */
    private Cinema cinema;


    /**
     * TODO commenter le role du Constructeur
     * @param frame
     * @param detailsView 
     * @param film 
     * @param factory 
     */
    public MovieDetailsController(MainApp frame, MovieDetailsView detailsView, SessionFactory factory) {
        super();
        this.frame = frame;
        this.detailsView = detailsView;
        this.film = frame.getFilm();
        this.factory = factory;
        loadInfoCinema(film);
    }

    /**
     * TODO commenter le role de la Méthode
     * @param film 
     */
    private void loadInfoCinema(Film film) {
        detailsView.getLblTitre().setText(film.getTitre());
        detailsView.getTxtSynopsis().setText(film.getSynopsis());
        detailsView.getLblGenre().setText(film.getGenre());
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        detailsView.getLabelDate().setText(df.format(film.getDateSortie()));
        detailsView.getLblRealisateur().setText(film.getRealisateur());
        detailsView.getLblCasting().setText(film.getCasting());
        String duree = (film.getDuree() / 60) + "h" + (film.getDuree() % 60);
        detailsView.getLblDuree().setText(duree);
        setImageSize(detailsView.getLblAffiche(), film.getImage());
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == detailsView.getBtnConnexion()){
            LoginUserView loginView = new LoginUserView();
            JDialog dialog = new JDialog(frame,"Connection",true);
            LoginController controller = new LoginController(frame, dialog, loginView, factory, this);
            loginView.setController(controller);
            dialog.setContentPane(loginView);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }else if(event.getSource() == detailsView.getBtnDeconnexion()){
            frame.setUser(null);
            loadUser(null);
        }else if(event.getSource() == detailsView.getBtnReserver()){
            // Clic sur le bouton dse réservation
            ReservationView reservationView = new ReservationView();
            ReservationController controller = new ReservationController(frame, reservationView, factory);
            reservationView.setController(controller);
            frame.setContentPane(reservationView);
            frame.pack();
            frame.setLocationRelativeTo(null);
        }else if(event.getSource() == detailsView.getBtnCompte()){
            UserView userView = new UserView();
            JDialog dialog = new JDialog(frame,"Mon compte",true);
            UserViewController controller = new UserViewController(frame,dialog,userView,factory,this);
            userView.setController(controller);
            dialog.setContentPane(userView);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent event) {
        if(event.getSource() == detailsView.getLblRetour()){
            HomeView homeView = new HomeView();
            HomeController controller = new HomeController(frame, homeView, factory);
            homeView.setController(controller);
            frame.setContentPane(homeView);
            frame.pack();
            frame.setLocationRelativeTo(null);
        }  
    }

    /**
     * TODO commenter le role de la Méthode
     * @param affiche
     * @param blob
     */
    public static void setImageSize(JLabel affiche, Blob blob){
        BufferedImage buff;
        try {
            buff = ImageIO.read(blob.getBinaryStream());
            ImageIcon icon = new ImageIcon(buff);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);
            affiche.setIcon(null);
            affiche.setIcon(newImc);
            affiche.revalidate();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadUser(User user){
        if(user != null){
            detailsView.getBtnConnexion().setVisible(false);
            detailsView.getLblOu().setVisible(false);
            detailsView.getLblProfiter().setVisible(false);
            detailsView.getLblPasEncore().setVisible(false);
            detailsView.getLblCreate().setVisible(false);
            detailsView.getLblCompte().setText("Bienvenue " + user.getPrenom());
            detailsView.getLblCompte().setVisible(true);
            detailsView.getBtnCompte().setVisible(true);
            detailsView.getBtnDeconnexion().setVisible(true);
        }else{
            detailsView.getBtnConnexion().setVisible(true);
            detailsView.getLblOu().setVisible(true);
            detailsView.getLblProfiter().setVisible(true);
            detailsView.getLblPasEncore().setVisible(true);
            detailsView.getLblCreate().setVisible(true);
            detailsView.getLblCompte().setText("");
            detailsView.getLblCompte().setVisible(false);
            detailsView.getBtnCompte().setVisible(false);
            detailsView.getBtnDeconnexion().setVisible(false);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
}
