/*
 * LauncherController.java                                19 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cineGOv02.client.view.HomeView;
import cineGOv02.client.view.LauncherView;
import cineGOv02.common.entity.Cinema;
import cineGOv02.common.graphics.MainApp;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class LauncherController implements ActionListener{
    /** TODO */
    private MainApp frame;
    /** TODO */
    private LauncherView launcherView;
    /** TODO */
    private SessionFactory factory;
    
    /** TODO commenter le Champ */
    private ArrayList<Cinema> cinema;
    
    /**
     * TODO commenter le role du Constructeur
     * @param frame
     * @param launcherView
     * @param factory
     */
    public LauncherController(MainApp frame, LauncherView launcherView, SessionFactory factory) {
        super();
        this.frame = frame;
        this.launcherView = launcherView;
        this.factory = factory;
        this.launcherView.setController(this);
        Session session = this.factory.openSession();
        session.getTransaction().begin();
        cinema = new ArrayList<Cinema>(session.createQuery("FROM Cinema").list());
        for(int i = 0 ; i < cinema.size() ; i++){
            this.launcherView.getCmbCinema().addItem(cinema.get(i).getNom());
        }
        session.getTransaction().commit();
        session.close();
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == launcherView.getBtnValider()){
            Cinema cinema = this.cinema.get(launcherView.getCmbCinema().getSelectedIndex());
            frame.setCinema(cinema);
            HomeView homeView = new HomeView();
            HomeController homeController = new HomeController(frame, homeView, this.factory);
            homeView.setController(homeController);
            frame.setContentPane(homeView);
            frame.pack();
            frame.setLocationRelativeTo(null);
        }
    }
}
