/*
 * ReservationController.java                                31 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import cineGOv02.client.view.HomeView;
import cineGOv02.client.view.LoginUserView;
import cineGOv02.client.view.MovieDetailsView;
import cineGOv02.client.view.ReservationView;
import cineGOv02.client.view.SeatChoiceView;
import cineGOv02.client.view.UserView;
import cineGOv02.common.entity.Film;
import cineGOv02.common.entity.Reservation;
import cineGOv02.common.entity.Seance;
import cineGOv02.common.entity.User;
import cineGOv02.common.graphics.ComboType;
import cineGOv02.common.graphics.Controller;
import cineGOv02.common.graphics.MainApp;
import cineGOv02.common.util.SendAMail;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class ReservationController implements Controller, ActionListener, MouseListener{
    /** TODO */
    private MainApp frame;
    /** TODO */
    private ReservationView reservationView;
    /** TODO */
    private SessionFactory factory;
    /** TODO */
    private Film film;
    /** TODO */
    private List<Seance> seances;
    /** TODO */
    private ArrayList<ArrayList<Seance>> seances_by_day; 
    /** TODO */
    private ArrayList<Seance> seances_by_type;
    /** TODO */
    private static final String[] JOURS = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi",
            "Vendredi","Samedi"};
    /** TODO */
    private static final String[] MOIS = {"Janvier","Février","Mars","Avril","Mai","Juin"
            ,"Juillet","Aout","Septembre","Octobre","Novembre","Décembre"};
    /** TODO */
    public static final int MAX_RESA = 10;
    /** TODO */
    private Seance selectedSeance;

    private double prixTotal;
    /**
     * TODO commenter le role du Constructeur
     * @param frame
     * @param reservationView
     * @param factory
     */
    public ReservationController(MainApp frame, ReservationView reservationView, SessionFactory factory){
        this.frame = frame;
        this.reservationView = reservationView;
        this.factory = factory;
        this.film = frame.getFilm();
        loadInfo();
        loadSeance();
        if(seances.size()>0){
            sortByDay();
            dispatchbyType();
        }
    }

    /**
     * TODO commenter le role de la Méthode
     */
    public void loadInfo(){
        setImageSize(reservationView.getLblAffiche(), film.getImage());
        this.reservationView.getLblTitre().setText(film.getTitre() + "( durée : " 
                + (int)film.getDuree()/60 + "h" + film.getDuree()%60 + ")");
        loadUser(frame.getUser());
    }

    /**
     * TODO commenter le role de la Méthode
     */
    private void loadSeance() {
        Calendar calendar = Calendar.getInstance();
        Timestamp debut = new Timestamp(calendar.getTime().getTime());
        Session session = factory.openSession();
        session.getTransaction().begin();

        Query query = session.createQuery("SELECT se FROM Seance se "
                + "JOIN se.salle.cinema "
                + "WHERE se.salle.cinema = :cinema "
                + "AND se.film = :film "
                + "AND se.debut > :debut "
                + "ORDER BY se.debut")
                .setEntity("cinema", frame.getCinema())
                .setEntity("film", frame.getFilm())
                .setTimestamp("debut", debut);
        seances = new ArrayList<Seance>(query.list());
        session.getTransaction().commit();
        session.close();
    }

    /**
     * TODO commenter le role de la Méthode
     */
    private void sortByDay() {
        seances_by_day = new ArrayList<ArrayList<Seance>>();
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        System.out.println(cal.getFirstDayOfWeek());
        int day = 0, month = 0, cpt = 0;
        for (Seance seance : seances) {
            // Chargement du jour et du mois
            cal.setTimeInMillis(seances.get(cpt).getDebut().getTime());
            int day_temp = cal.get(Calendar.DAY_OF_MONTH);
            int month_temp = cal.get(Calendar.MONTH);
            Date debut_temp = seance.getDebut();
            if(month != month_temp || day != day_temp){
                month = month_temp;
                day = day_temp;
                seances_by_day.add(new ArrayList<Seance>());
                String jour =  JOURS[((cal.get(Calendar.DAY_OF_WEEK))-1)];
                String numero = cal.get(Calendar.DAY_OF_MONTH) + "";
                String mois = MOIS[cal.get(Calendar.MONTH)];
                reservationView.getCmbJour().addItem(jour + " " + numero + " " + mois);
            }
            seances_by_day.get(seances_by_day.size()-1).add(seances.get(cpt));
            cpt++;
        } 
    }

    /**
     * TODO commenter le role de la Méthode
     */
    private void dispatchbyType() {
        int index = reservationView.getCmbJour().getSelectedIndex();
        reservationView.getCmb3DVF().removeAllItems();
        reservationView.getCmb3DVOST().removeAllItems();
        reservationView.getCmbVF().removeAllItems();
        reservationView.getCmdVOST().removeAllItems();
        reservationView.getCmbVO().removeAllItems();
        Date debut = new Date();
        for (Seance seance : seances_by_day.get(index)) {
            Date date_temp = seance.getDebut();
            if(date_temp.getTime() != debut.getTime()){
                debut = date_temp;
                if(seance.isVF3D()){
                    reservationView.getCmb3DVF().addItem(seance);
                    reservationView.getCmb3DVF().setSelectedIndex(-1);
                }
                if(seance.isVOST3D()){
                    reservationView.getCmb3DVOST().addItem(seance);
                    reservationView.getCmb3DVOST().setSelectedIndex(-1);
                }
                if(seance.isVF()){
                    reservationView.getCmbVF().addItem(seance);
                    reservationView.getCmbVF().setSelectedIndex(-1);
                }
                if(seance.isVOST()){
                    reservationView.getCmdVOST().addItem(seance);
                    reservationView.getCmdVOST().setSelectedIndex(-1);
                }
                if(seance.isVO()){
                    reservationView.getCmbVO().addItem(seance);
                    reservationView.getCmbVO().setSelectedIndex(-1);
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent event) {
        if(event.getSource() == reservationView.getLblRetour()){
            MovieDetailsView detailsView = new MovieDetailsView();
            MovieDetailsController controller = new MovieDetailsController(frame, detailsView, factory);
            detailsView.setController(controller);
            controller.loadUser(frame.getUser());
            frame.setContentPane(detailsView);
            frame.pack();
            frame.setLocationRelativeTo(null);
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == reservationView.getBtnConnexion()){
            LoginUserView loginView = new LoginUserView();
            JDialog dialog = new JDialog(frame,"Connection",true);
            LoginController controller = new LoginController(frame, dialog, loginView, factory, this);
            loginView.setController(controller);
            dialog.setContentPane(loginView);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }else if(event.getSource() == reservationView.getBtnDeconnexion()){
            frame.setUser(null);
            loadUser(null);
        }else if(event.getSource() == reservationView.getCmbJour()){
            // On supprime le listener pour éviter de propager des évènements en 
            // chaine lors de l'ajout des séances dans les différentes combobox
            for (ComboType combo : reservationView.getType()) {
                combo.removeActionListener(this);
            }
            reservationView.getBtnPayer().setEnabled(false);
            reservationView.getBtnPayer().setForeground(Color.GRAY);
            reservationView.getBtnChoix().setEnabled(false);
            reservationView.getBtnChoix().setForeground(Color.GRAY);
            dispatchbyType();
            for (ComboType combo : reservationView.getType()) {
                combo.addActionListener(this);
            }
        }else if(event.getSource() instanceof ComboType){
            for (ComboType combo : reservationView.getType()) {  
                if(combo != event.getSource()){
                    combo.removeActionListener(this);
                    combo.setSelectedIndex(-1);
                    combo.addActionListener(this);
                }
            }
            if(((ComboType)event.getSource()).getSelectedIndex() != -1){
                selectedSeance = (Seance) ((JComboBox)event.getSource()).getSelectedItem();
                reservationView.getCmbNbPlace().removeActionListener(this);
                getEmptySeat(selectedSeance);
                reservationView.getCmbNbPlace().addActionListener(this);
            }
            calculPrix(reservationView.getCmbNbPlace());
            reservationView.getBtnPayer().setEnabled(true);
            reservationView.getBtnPayer().setForeground(Color.WHITE);
            reservationView.getBtnChoix().setEnabled(true);
            reservationView.getBtnChoix().setForeground(SystemColor.textHighlight);
        }else if(event.getSource() == reservationView.getBtnPayer()){
            recapPaiement(creerResa());
        }else if(event.getSource() == reservationView.getCmbNbPlace()){
            calculPrix((JComboBox)event.getSource());
        }else if(event.getSource() == reservationView.getBtnCompte()){
            UserView userView = new UserView();
            JDialog dialog = new JDialog(frame,"Mon compte",true);
            UserViewController controller = new UserViewController(frame,dialog,userView,factory,this);
            userView.setController(controller);
            dialog.setContentPane(userView);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }else if(event.getSource() == reservationView.getBtnChoix()){
            frame.setReservation(creerResa());
            SeatChoiceView seatView = new SeatChoiceView();
            SeatChoiceController controller = new SeatChoiceController(frame, seatView, factory);
            seatView.setController(controller);
            frame.setContentPane(seatView);
            frame.pack();
            frame.setLocationRelativeTo(null);
        }
    }

    /**
     * TODO commenter le role de la Méthode
     * @param source
     */
    private void getEmptySeat(Seance selectedSeance) {
        Timestamp debut = selectedSeance.getDebut();
        Session session = factory.openSession();
        session.getTransaction().begin();
        seances_by_type = new ArrayList<Seance>(session.createQuery("SELECT se FROM Seance se JOIN se.salle.cinema "
                + "WHERE se.salle.cinema = :cinema "
                + "AND se.film = :film "
                + "AND se.debut = :debut "
                + "AND se.VF = :vf "
                + "AND se.VF3D = :vf3d "
                + "AND se.VOST3D = :vost3d "
                + "AND se.VOST = :vost "
                + "AND se.VO = :vo")
                .setEntity("cinema", frame.getCinema())
                .setEntity("film", frame.getFilm())
                .setTimestamp("debut", debut)
                .setBoolean("vf", selectedSeance.isVF())
                .setBoolean("vo", selectedSeance.isVO())
                .setBoolean("vost", selectedSeance.isVOST())
                .setBoolean("vf3d", selectedSeance.isVF3D())
                .setBoolean("vost3d", selectedSeance.isVOST3D())
                .list());
        session.getTransaction().commit();
        session.close();
        int maxBySalle = 0;
        int total = 0;
        if(seances_by_type.size() > 0){
            for (Seance seance : seances_by_type) {
                maxBySalle = seance.getNbPlacesLibres() > maxBySalle ? seance.getNbPlacesLibres() : maxBySalle;
                total += seance.getNbPlacesLibres();
            }
        }
        reservationView.getLblPlacesLibres().setText(total + " places libres");
        reservationView.getCmbNbPlace().removeAllItems();
        for(int i = 1 ; i <= MAX_RESA && i <= maxBySalle ; i++){
            reservationView.getCmbNbPlace().addItem(i);
        }
    }

    /* (non-Javadoc)
     * @see cineGOv02.controller.Controller#loadUser(cineGOv02.model.entity.User)
     */
    @Override
    public void loadUser(User user) {
        if(user != null){
            reservationView.getLblNoCompte().setVisible(false);
            reservationView.getBtnConnexion().setVisible(false);
            reservationView.getLblUser().setVisible(true);
            reservationView.getLblUser().setText(user.getPrenom());
            reservationView.getLblCreate().setVisible(false);
            reservationView.getLblCompte().setText("Bienvenue " + user.getPrenom());
            reservationView.getLblCompte().setVisible(true);
            reservationView.getBtnCompte().setVisible(true);
            reservationView.getBtnDeconnexion().setVisible(true);
        }else{
            reservationView.getLblNoCompte().setVisible(true);
            reservationView.getBtnConnexion().setVisible(true);
            reservationView.getLblCreate().setVisible(true);
            reservationView.getLblUser().setVisible(false);
            reservationView.getLblCompte().setText("");
            reservationView.getLblCompte().setVisible(false);
            reservationView.getBtnCompte().setVisible(false);
            reservationView.getBtnDeconnexion().setVisible(false);
        }
    }
    
    /**
     * TODO commenter le role de la Méthode
     * @return
     */
    public Reservation creerResa(){
        String film = frame.getFilm().getTitre();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String heure = sdf.format(selectedSeance.getDebut());
        int numSalle = selectedSeance.getSalle().getNumeroDeSalle();
        int nbPlace = reservationView.getCmbNbPlace().getSelectedIndex()+1;
        selectedSeance.setNbPlacesLibres(selectedSeance.getNbPlacesLibres() - nbPlace);
        java.sql.Timestamp dateResa = new java.sql.Timestamp((new java.util.Date()).getTime());
        return new Reservation(prixTotal, frame.getUser(), null, selectedSeance, nbPlace, dateResa);
    }

    /**
     * TODO commenter le role de la Méthode
     */
    private void recapPaiement(Reservation resa) {
        Thread update = new Thread(){
            public void run(){
                Session session = factory.openSession();
                session.getTransaction().begin();
                session.save(resa);
                session.update(selectedSeance);
                session.getTransaction().commit();
                session.close();
            }
        };update.start();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String heure = sdf.format(selectedSeance.getDebut());
        int numSalle = selectedSeance.getSalle().getNumeroDeSalle();
        int nbPlace = reservationView.getCmbNbPlace().getSelectedIndex()+1;
        String body = "<strong>Bonjour " + (frame.getUser() != null ? frame.getUser().getPrenom() : "")   + "</strong>, <br /><br />"
                + "<strong>Voici un récapitulatif de votre commande :</strong><br/><br/>"
                + "<ul><li>Tire du film : <strong>" + film + "</strong></li>"               
                + "<li>Heure de la séance : <strong> " + heure + "</strong></li>"
                + "<li>Nombre de place : <strong>" + nbPlace + "</strong></li>"
                + "<li>Salle : <strong>" + numSalle + "</strong></li>"
                + "<li>Salle : <strong>" + prixTotal + "</strong></li></ul><br /><br />"
                + "<span style=\"font-style:italic;\">"
                + "Votre reservation est modifiable et ce jusqu'à 24h avant le début de la séance.</span><br /><br />"
                + "<strong>Toute l'équipe de CineGO vous souhaite un bon film !</strong><br /><br />"
                + "Amicalement,<br />"
                + "L'équipe de CinéGO";
        if(frame.getUser() != null){
            String subject = "Confirmation de votre commande CineGO.";
            JOptionPane.showMessageDialog(reservationView, "Votre paiment a été accepté un mail récapitulatif vous a étét envoyé", "Information paiement", JOptionPane.INFORMATION_MESSAGE);
            Thread sendMail = new Thread(){
                public void run(){
                    try {
                        SendAMail.send("remi.plantade.pro@gmail.com", frame.getUser().getMail(), body, subject);
                    } catch (MessagingException e) {
                        JOptionPane.showMessageDialog(frame, "Erreur lors de l'envoie du mail, vérifiez vos paramètre de connexion", "Echec", JOptionPane.ERROR_MESSAGE);
                    }
                }
            };sendMail.start();
        }else{
            JTextPane pane = new JTextPane();
            pane.setBackground(new Color(220,219,31));
            pane.setContentType("text/html");
            pane.setText(body);
            JOptionPane.showMessageDialog(reservationView,pane ,"Information paiement", JOptionPane.INFORMATION_MESSAGE); 
        }
    }

    /**
     * TODO commenter le role de la Méthode
     * @param source
     */
    private void calculPrix(JComboBox source) {
        System.out.println(selectedSeance.getDebut() + selectedSeance.getFilm().getTitre());
        if(selectedSeance.isVF() || selectedSeance.isVO() || selectedSeance.isVOST()){
            prixTotal = frame.getCinema().getTarifNormal();
        }else if(selectedSeance.isVF3D() || selectedSeance.isVOST3D()){
            prixTotal = frame.getCinema().getTarif3D();
        }
        if(frame.getUser() != null && frame.getUser().isEtudiant()){
            prixTotal = prixTotal - (prixTotal * frame.getCinema().getReductionEtudiant());
        }
        prixTotal = prixTotal * (source.getSelectedIndex()+1);
        System.out.println("Prix " + prixTotal);
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        nf.setMaximumFractionDigits(2);
        prixTotal = Double.valueOf(nf.format(prixTotal));
        if(frame.getUser() != null){
            double avoir = frame.getUser().getAvoir();
            if(avoir > 0){
                reservationView.getLblReduction().setText(" après application d'un avoir de " + avoir +"€");
            }
            prixTotal = prixTotal - avoir;
            if(prixTotal <= 0){
                frame.getUser().setAvoir(Math.abs(prixTotal));
                prixTotal = 0;
            }
        }
        reservationView.getLblPrix().setText(prixTotal + "");
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
    public void mouseClicked(MouseEvent arg0) {}
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}
}
