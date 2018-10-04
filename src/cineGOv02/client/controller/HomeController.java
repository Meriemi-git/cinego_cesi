	package cineGOv02.client.controller;
	
	import cineGOv02.client.view.HomeView;
	import cineGOv02.client.view.LoginUserView;
	import cineGOv02.client.view.MovieDetailsView;
	import cineGOv02.client.view.UserView;
	import cineGOv02.common.entity.Cinema;
	import cineGOv02.common.entity.Film;
	import cineGOv02.common.entity.User;
	import cineGOv02.common.graphics.Affiche;
	import cineGOv02.common.graphics.Controller;
	import cineGOv02.common.graphics.Genre;
	import cineGOv02.common.graphics.MainApp;
	
	import java.awt.Color;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.image.BufferedImage;
	import java.io.IOException;
	import java.sql.Blob;
	import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
	import javax.swing.ImageIcon;
	import javax.swing.JDialog;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.event.DocumentEvent;
	import javax.swing.event.DocumentListener;
	import javax.swing.text.BadLocationException;
	import javax.swing.text.Document;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;

	
	/**
	 * TODO commenter les responsabilités classe
	 * @author hustariz
	 */
	public class HomeController implements ActionListener, MouseListener, DocumentListener, Controller{
	
	    /** TODO commenter le Champ */
	    private ArrayList<Film> listeFilm;
	    /** TODO commenter le Champ */
	    private ArrayList<Film> listeFilmsDuJour;
	    /** TODO commenter le Champ */
	    private ArrayList<Film> results;
	    /** TODO commenter le Champ */
	    private SessionFactory factory;
	    /**  Variables affichéees dans textField_1(compteur) de la View.*/
	    private int compteurPage = 1;
	    /** Instance de la View */
	    private HomeView homeView;
	    /** Mainframe de l'application */
	    private MainApp frame;
	    /** Cinema sélectionné au chargement de l'appli */
	    private Cinema cinema;
	    
	    private Calendar calendar;
        private Timestamp debut, fin;
	
	    /**
	     * Constructeur du controller
	     * @param frame 
	     * @param homeView
	     * @param factory 
	     * @param homeModel
	     */
	    public HomeController(MainApp frame, HomeView homeView, SessionFactory factory){
	        this.frame = frame;
	        this.homeView = homeView;
	        this.factory = factory;
	        this.cinema = frame.getCinema();
	        getFilm(cinema);
	        
	        // On initialise la liste des films
	        this.results = (ArrayList<Film>) listeFilm.clone();
	        initListFilm(results);
	        int nbPage = results.size()/6;
	        nbPage = results.size() % 6 == 0 ? results.size()/6 : nbPage+1;
	        homeView.getCompteur().setText("1/" + nbPage);
	        if(frame.getUser() != null){
	            homeView.getLblCompte().setText("Bienvenue " + frame.getUser().getPrenom());
	            homeView.getLblCompte().setVisible(true);
	            homeView.getBtnCompte().setVisible(true);
	            homeView.getBtnDeconnexion().setVisible(true);
	        }else{
	            homeView.getLblCompte().setText("");
	            homeView.getLblCompte().setVisible(false);
	            homeView.getBtnCompte().setVisible(false);
	            homeView.getBtnDeconnexion().setVisible(false);
	        }
	    }
	
	    /* (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
	    @Override
	    public void actionPerformed(ActionEvent event) {
	        if(event.getSource() == homeView.getBtnBackbutton()){
	            previousPage();
	        }else if(event.getSource() == homeView.getBtnNextbutton() 
	                || event.getSource() == homeView.getTm()){
	            nextPage();
	        }else if(event.getSource() == homeView.getBtnDeconnexion()){
	            frame.setUser(null);
	            loadUser(null);
	        }else if(event.getSource() == homeView.getBtnConnexion()){
	            LoginUserView loginView = new LoginUserView();
	            JDialog dialog = new JDialog(frame,"Connection",true);
	            LoginController controller = new LoginController(frame, dialog, loginView, factory, this);
	            loginView.setController(controller);
	            dialog.setContentPane(loginView);
	            dialog.pack();
	            dialog.setLocationRelativeTo(null);
	            dialog.setVisible(true);
	            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        }else if(event.getSource() == homeView.getBtnCompte()){
	            UserView userView = new UserView();
	            JDialog dialog = new JDialog(frame,"Mon compte",true);
	            UserViewController controller = new UserViewController(frame,dialog,userView,factory,this);
	            userView.setController(controller);
	            dialog.setContentPane(userView);
	            dialog.pack();
	            dialog.setLocationRelativeTo(null);
	            dialog.setVisible(true);
	            dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        }else if(event.getSource() == homeView.getRdbtnFilmDuJour()){
	        	if(homeView.getRdbtnFilmDuJour().isSelected()==true){
	        	calendar = Calendar.getInstance();
	        	debut = new Timestamp(calendar.getTime().getTime());
	        	calendar.add(Calendar.DATE, 1);
	        	calendar.set(Calendar.HOUR_OF_DAY, 00);
	            calendar.set(Calendar.MINUTE, 59);
	            fin = new Timestamp(calendar.getTime().getTime());
	            
	        	System.out.println("RADIOBUTTON");
	        	Session session = factory.openSession();
	            session.getTransaction().begin();
	            listeFilmsDuJour = new ArrayList<Film>(session.createQuery(""
	                  + "SELECT DISTINCT se.film FROM Seance se JOIN se.salle.cinema WHERE se.salle.cinema = :cinema AND se.debut > :debut AND se.fin < :fin")
	                  .setEntity("cinema", cinema).setTimestamp("debut", debut).setTimestamp("fin", fin).list());
	            session.getTransaction().commit();
	            session.close();
	            initListFilm(listeFilmsDuJour);
	          
	             
	             
	             
	        	}else{
		        	calendar = Calendar.getInstance();
		        	debut = new Timestamp(calendar.getTime().getTime());
	        		System.out.println("RADIOBUTTOFF");
	                Session session = factory.openSession();
	                session.getTransaction().begin();
	                listeFilm = new ArrayList<Film>(session.createQuery(""
		                     + "SELECT DISTINCT se.film FROM Seance se JOIN se.salle.cinema WHERE se.salle.cinema = :cinema AND se.debut > :debut")
		                     .setEntity("cinema", cinema).setTimestamp("debut", debut).list());
	                session.getTransaction().commit();
	                session.close();
	                initListFilm(listeFilm);
	        		
	        	}
	        }
	    }
	
	    /**
	     * TODO commenter le role de la Méthode
	     * @param cinema 
	     */
	    private void getFilm(Cinema cinema) {
        	calendar = Calendar.getInstance();
        	debut = new Timestamp(calendar.getTime().getTime());
	        Session session = factory.openSession();
	        session.getTransaction().begin();
	        listeFilm = new ArrayList<Film>(session.createQuery(""
                    + "SELECT DISTINCT se.film FROM Seance se JOIN se.salle.cinema WHERE se.salle.cinema = :cinema AND se.debut > :debut")
                    .setEntity("cinema", cinema).setTimestamp("debut", debut).list());
	        session.getTransaction().commit();
	        session.close();
	    }
	
	    /**
	     * TODO commenter le role de la Méthode
	     * @param liste
	     */
	    public void initListFilm(ArrayList<Film> liste){
	        for(int i = 0; i < 6 ; i++){
	            if(i < liste.size()){
	                this.homeView.getListPanel().get(i).setSize(200, 270);
	                this.homeView.setImageSize(homeView.getListPanel().get(i), liste.get(i).getImage());
	                this.homeView.getListPanel().get(i).setFilm(liste.get(i));  
	                this.homeView.getListPanel().get(i).revalidate();
	            }else{
	                homeView.getListPanel().get(i).setFilm(null);
	                homeView.getListPanel().get(i).setOpaque(false);
	                homeView.getListPanel().get(i).setIcon(null);
	                homeView.getListPanel().get(i).revalidate();
	            }
	        }
	    }
	
	    @Override
	    public void mouseClicked(MouseEvent event) {}
	    @Override
	    public void mouseReleased(MouseEvent arg0) {}
	
	    /* (non-Javadoc)
	     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	     */
	    @Override
	    public void mouseEntered(MouseEvent event) {
	        if(event.getSource() instanceof Genre
	                && !((Genre)event.getSource()).isActif()){
	            ((Genre)event.getSource()).setBackground(Color.decode("#0067ce"));
	            ((Genre)event.getSource()).setForeground(Color.WHITE);
	        }
	    }
	    /* (non-Javadoc)
	     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	     */
	    @Override
	    public void mouseExited(MouseEvent event) {
	        if(event.getSource() instanceof Genre 
	                && !((Genre)event.getSource()).isActif()){
	            ((JLabel)event.getSource()).setBackground(Color.WHITE);
	            ((JLabel)event.getSource()).setForeground(Color.BLACK);
	        }
	    }
	
	    /* (non-Javadoc)
	     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	     */
	    @Override
	    public void mousePressed(MouseEvent event) {
	        if(event.getSource() == homeView.getAffiche1()){
	            afficherDetails(homeView.getAffiche1().getFilm());
	        }else if(event.getSource() == homeView.getAffiche2()){
	            afficherDetails(homeView.getAffiche2().getFilm());
	        }else if(event.getSource() == homeView.getAffiche3()){
	            afficherDetails(homeView.getAffiche3().getFilm());
	        }else if(event.getSource() == homeView.getAffiche4()){
	            afficherDetails(homeView.getAffiche4().getFilm());
	        }else if(event.getSource() == homeView.getAffiche5()){
	            afficherDetails(homeView.getAffiche5().getFilm());
	        }else if(event.getSource() == homeView.getAffiche6()){
	            afficherDetails(homeView.getAffiche6().getFilm());
	        }else if(event.getSource() instanceof Genre){
	            if(!((Genre)event.getSource()).isActif()){
	                ((Genre)event.getSource()).setBackground(Color.decode("#0067ce"));
	                ((Genre)event.getSource()).setForeground(Color.WHITE);
	                ((Genre)event.getSource()).setActif(true);
	            }else{
	                ((Genre)event.getSource()).setBackground(Color.WHITE);
	                ((Genre)event.getSource()).setForeground(Color.BLACK);
	                ((Genre)event.getSource()).setActif(false);
	            }
	            System.out.println("filtre actif : " +((Genre)event.getSource()).isActif());
	            filterByGenre();
	        }
	    }
	
	    /**
	     * TODO commenter le role de la Méthode
	     * @param event 
	     */
	    private void filterByGenre() {
	        ArrayList<Film> temp = (ArrayList<Film>) results.clone();
	        boolean aucunFiltre = true;
	        for (Genre genre : homeView.getFiltres()) {
	            if(genre.isActif()){
	                aucunFiltre = false;
	            }
	        }
	        if(aucunFiltre){
	            if(homeView.getTxtSearch().getText().length() == 0 || results.size() == 0){
	                results = (ArrayList<Film>) listeFilm.clone();
	                System.out.println("ok");
	            }
	            initListFilm(results);
	        }else{
	            for (int i = 0 ; i < results.size() ; i++) {
	                boolean okGenre = false;
	                for (int y = 0 ; y < homeView.getFiltres().size() ; y++ ) { 
	                    if(homeView.getFiltres().get(y).isActif() && results.get(i).getGenre().equals(homeView.getFiltres().get(y).getGenre())){
	                        okGenre = true;
	                    }
	                }
	                if(!okGenre){
	                    temp.remove(results.get(i));
	                }
	            }
	            results = new ArrayList<>(temp);
	            initListFilm(results);
	
	
	        }
	    }
	
	    /**
	     * TODO commenter le role de la Méthode
	     * @param film
	     */
	    private void afficherDetails(Film film) {
	        if(film != null){
	            MovieDetailsView detailsView = new MovieDetailsView();
	            frame.setFilm(film);
	            MovieDetailsController controller = new MovieDetailsController(frame, detailsView, factory);
	            detailsView.setController(controller);
	            controller.loadUser(frame.getUser());
	            frame.setContentPane(detailsView);
	            frame.pack();
	            frame.setLocationRelativeTo(null);
	        }
	    }
	
	    /**
	     * TODO commenter le role de la Méthode
	     */
	    private void nextPage() {
	        // On récupère la position du premier élément
	        int thisPos = results.indexOf(homeView.getListPanel().get(0).getFilm());
	        // On détermine la position du prochaine premier élément à afficher
	        // Si thisPos + 6 est > que la size alors on affichera l'élément 0;
	        int nextPos = thisPos + 6 > results.size() - 1 ? 0 : thisPos + 6;
	        //On détermine le nombre d'item à affcher.
	        int nbItemToShow = results.size() - nextPos < 6 ? results.size() - nextPos : 6;
	        // On itère pour chacun des 6 emplacement de film, soit pour afficher un film 
	        // soit pour réinitialiser le panel
	        for(int i = 0; i < 6 ; i++){
	            if(i < nbItemToShow){
	                homeView.getListPanel().get(i).setOpaque(false);
	                homeView.getListPanel().get(i).setSize(200, 270);
	                setImageSize(homeView.getListPanel().get(i), results.get(nextPos).getImage());
	                homeView.getListPanel().get(i).setFilm(results.get(nextPos));
	            }else{
	                homeView.getListPanel().get(i).setIcon(null);
	                homeView.getListPanel().get(i).revalidate();
	            } 
	            nextPos++;
	        }
	        int nbPage = (int)results.size()/6;
	        if(results.size()%6==0){
	            compteurPage = compteurPage+1 >  results.size()/6 ? 1 : compteurPage +1;
	        }else{
	            compteurPage = compteurPage+1 >  results.size()/6 + 1 ? 1 : compteurPage +1;
	            nbPage++;
	        }
	        homeView.getCompteur().setText( compteurPage  + "/" + nbPage);
	        homeView.getTm().stop(); 
	    }
	
	    /**
	     * TODO commenter le role de la Méthode
	     */
	    private void previousPage() {
	        // On récupère la position du premier élément
	        int thisPos = results.indexOf(homeView.getListPanel().get(0).getFilm());
	        // On détermine si on va avoir une page non vide et on récupère le nb d'item pour cette page
	        int offset = results.size() % 6; 
	        // On détermine l'index de début du prochainn groupe de 6 film a afficher 
	        int prevPos = thisPos - 6 >= 0 ? thisPos - 6 : results.size() - 6 + (6 - offset);
	        // On calcule le nombre d'item à afficher
	        int nbItemToShow;
	        if(offset == 0){
	            nbItemToShow = 6;
	        }else{
	            if(results.size() - prevPos > 6){
	                nbItemToShow = 6;
	            }else{
	                nbItemToShow = offset;
	            }
	        }
	        for(int i = 0; i < 6 ; i++){
	            if(i < nbItemToShow){
	                homeView.getListPanel().get(i).setOpaque(false);
	                homeView.getListPanel().get(i).setSize(200, 270);
	                setImageSize(homeView.getListPanel().get(i), results.get(prevPos).getImage());
	                homeView.getListPanel().get(i).setFilm(results.get(prevPos));
	            }else{
	                homeView.getListPanel().get(i).setIcon(null);
	                homeView.getListPanel().get(i).revalidate();
	            } 
	            prevPos++;
	        }
	        int nbPage = (int)results.size()/6;
	        if(results.size()%6==0){
	            compteurPage = compteurPage-1 < 1 ? results.size()/6 : compteurPage-1;
	        }else{
	            compteurPage = compteurPage-1 < 1 ? results.size()/6 + 1 : compteurPage-1;
	            nbPage++;
	        }
	        homeView.getCompteur().setText( compteurPage + "/" + nbPage);
	        homeView.getTm().stop();  
	    }
	
	    /**
	     * TODO commenter le role de la Méthode
	     * @param affiche
	     * @param blob
	     */
	    public void setImageSize(Affiche affiche, Blob blob){
	        BufferedImage buff;
	        try {
	            buff = ImageIO.read(blob.getBinaryStream());
	            ImageIcon icon = new ImageIcon(buff);
	            Image img = icon.getImage();
	            Image newImg = img.getScaledInstance(affiche.getWidth(), affiche.getHeight(), Image.SCALE_SMOOTH);
	            ImageIcon newImc = new ImageIcon(newImg);
	            affiche.setIcon(null);
	            affiche.setIcon(newImc);
	            affiche.revalidate();
	        } catch (IOException | SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	
	    @Override
	    public void changedUpdate(DocumentEvent e) {}
	
	    /* (non-Javadoc)
	     * @see javax.swing.event.DocumentListener#insertUpdate(javax.swing.event.DocumentEvent)
	     */
	    @Override
	    public void insertUpdate(DocumentEvent d) {
	        Document doc = d.getDocument();
	
	        try {
	            searchFromString(doc.getText(0, doc.getLength()).toLowerCase());
	        } catch (BadLocationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	
	    /* (non-Javadoc)
	     * @see javax.swing.event.DocumentListener#removeUpdate(javax.swing.event.DocumentEvent)
	     */
	    @Override
	    public void removeUpdate(DocumentEvent d) {
	        Document doc = d.getDocument();
	        try {
	            searchFromString(doc.getText(0, doc.getLength()).toLowerCase());
	        } catch (BadLocationException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	
	    /**
	     * TODO commenter le role de la Méthode
	     * @param text
	     * @param remove 
	     */
	    private void searchFromString(String text) {
	        // Si aucun caractère n'est saisi on cahrge la liste en entier
	        if(text.length() == 0){
	            results = new ArrayList<>(listeFilm);
	            filterByGenre();
	        }else{
	            // Si on vient d'ajouter ou de supprimer un caractère dans le champ 
	            // on met à jour la liste des films results
	            for(Film film : listeFilm){
	                // On vérifie que la taille du texte saisie soit bien inférieure 
	                // ou égale à la taille du titre afin de les comparer
	                String token = text.length() > film.getTitre().length() ? text.substring(0,film.getTitre().length()) : text;
	                if(film.getTitre().substring(0, token.length()).toLowerCase().equals(token)){
	                    if(!results.contains(film)){
	                        results.add(film);
	                    }
	                }else{
	                    if(results.contains(film)){
	                        results.remove(film);
	                    }
	                }
	            }
	            filterByGenre();
	        }    
	    }
	    
	    @Override
	    public void loadUser(User user){
	        if(user != null){
	            homeView.getLblCompte().setText("Bienvenue " + user.getPrenom());
	            homeView.getLblCompte().setVisible(true);
	            homeView.getBtnCompte().setVisible(true);
	            homeView.getBtnDeconnexion().setVisible(true);
	            homeView.getBtnConnexion().setVisible(false);
	        }else{
	            homeView.getLblCompte().setText("");
	            homeView.getLblCompte().setVisible(false);
	            homeView.getBtnCompte().setVisible(false);
	            homeView.getBtnDeconnexion().setVisible(false);
	            homeView.getBtnConnexion().setVisible(true);
	        }
	        
	    }
	}
	
	
