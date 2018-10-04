package cineGOv02.admin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cineGOv02.admin.view.AjouterCinemaView;
import cineGOv02.admin.view.GestionCinemaView;
import cineGOv02.admin.view.LauncherAdminView;
import cineGOv02.common.entity.Cinema;
import cineGOv02.common.graphics.MainApp;

/**
 * Controller de la vue de lancement de l'application admin
 * Javadoc Done
 * @author Hugo
 */
public class LauncherAdminController implements ActionListener{
    /** Frame principale que l'on fait passer de controller en controller. */
    private JFrame frame;
    /**Vue de lancement de l'application admin */
    private LauncherAdminView launcherAdminView;
    /**Générateur de session hibernate*/
    private SessionFactory factory;
    
    /** Tableau d'objet cinéma */
    private ArrayList<Cinema> cinema;
    
    /**
     * Initialise la frame, la view associée au controller, la factory.
     * @param frame
     * @param launcherAdminView 
     * @param launcherView
     * @param factory
     */
    public LauncherAdminController(JFrame frame, LauncherAdminView launcherAdminView, SessionFactory factory) {
        super();
        this.frame = frame;
        this.launcherAdminView = launcherAdminView;
        this.factory = factory;
        this.launcherAdminView.setController(this);
        Session session = this.factory.openSession();
        session.getTransaction().begin();
        cinema = new ArrayList<Cinema>(session.createQuery("FROM Cinema").list());
        for(int i = 0 ; i < cinema.size() ; i++){
            this.launcherAdminView.getCmbCinema().addItem(cinema.get(i).getNom());
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
    	//Bouton Valider
        if(event.getSource() == launcherAdminView.getBtnValider()){
        	Cinema cinema = this.cinema.get(launcherAdminView.getCmbCinema().getSelectedIndex());
        	GestionCinemaView gestionCinemaView = new GestionCinemaView();
        	GestionCinemaController gestionCinemaController = new GestionCinemaController(frame, gestionCinemaView, this.factory, cinema);
        	gestionCinemaView.setController(gestionCinemaController);
        	frame.setContentPane(gestionCinemaView);
        	frame.pack();
        	frame.setLocationRelativeTo(null);
        	
        }
        //Bouton Ajouter
        else if(event.getSource() == launcherAdminView.getBtnAjouter()){
        	AjouterCinemaView ajoutCinemaView = new AjouterCinemaView();
        	AjouterCinemaController ajoutCinemaController = new AjouterCinemaController(frame, ajoutCinemaView, this.factory);
        	ajoutCinemaView.setController(ajoutCinemaController);
        	frame.setContentPane(ajoutCinemaView);
        	frame.pack();
        	frame.setLocationRelativeTo(null);
        }
    }
}
