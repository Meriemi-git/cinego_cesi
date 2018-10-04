/*
 * AjouterFilmController.java                                19 févr. 2016
 * IUT Info1 2013-2014 Groupe 3
 */
package cineGOv02.admin.controller;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import cineGOv02.admin.view.AjouterFilmView;
import cineGOv02.admin.view.GestionCinemaView;
import cineGOv02.common.entity.Cinema;
import cineGOv02.common.entity.Film;


/**
 * TODO commenter les responsabilités classe
 * @author hustariz
 *
 */
public class AjouterFilmController implements ActionListener, KeyListener{

	/** TODO commenter le Champ */
	private JFrame frame;

	/** TODO commenter le Champ */
	private AjouterFilmView ajouterFilmView;

	/** TODO commenter le Champ */
	private SessionFactory factory;

	/** Cinéma qu'on va pouvoir éditer. */
	private Cinema cinema;
	/** Couleur du film dans le planning en hexa */
	private int hexColor;
	/** TODO commenter le Champ */
	private static Film film;
	/** TODO commenter le Champ */
	private static String titre;
	/** Synospis */
	private static String overview;
	/***/
	private static String genre;
	/** Date de sortie */
	private static Date releaseDate;
	/** Durée */
	private static int runTime = 0;
	/** Note */
	private static double rate;
	/***/
	private static String realisateur;
	/***/
	private static String casting = null;
	/***/
	private static java.sql.Date dateSortie = null;
	/** Poster au format Blob*/
	private static Color color;
	
	/** TODO commenter le Champ */
	private static String couleur;

	/** TODO commenter le Champ */
	private static final String MSG_ERROR_IMAGEFORMAT_EXCEPTION ="Veuillez renseigner le chemin vers une image VALIDE pour votre film!";

	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NOHTMLCOLOR = "Veuillez générer une couleur pour le planning!";

	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NOTITLE = "Veuillez renseigner un titre pour votre film!";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NOOVERVIEW = "Veuillez renseigner un synopsys pour votre film!";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NOCASTING = "Veuillez renseigner un casting pour votre film!";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NOGENRE = "Veuillez renseigner un genre pour votre film!";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NOREALISATEUR = "Veuillez renseigner un realisateur pour votre film!";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NODATESORTIE = "Veuillez renseigner une date de sortie pour votre film!";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NORUNTIME = "Veuillez renseigner une durée pour votre film!";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_NORATING = "Veuillez renseigner une note pour votre film!";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_WRONGRATING = "Veuillez respecter le format de rating : N.N (/10)!";
	/** TODO commenter le Champ */
	private static final String MSG_SUCCES_SAUVEGARDE = "Votre film a bien été enregistré dans notre base de donnée!";

	/** TODO commenter le Champ */
	private static java.sql.Date dateAjout;

	/** Poster au format Blob*/
	private static Blob blob = null;

	/** TODO commenter le Champ */
	URL imageURL;
	/** TODO commenter le Champ */
	BufferedImage originalImage;
	/** TODO commenter le Champ */
	ByteArrayOutputStream baos=new ByteArrayOutputStream();
	/** TODO commenter le Champ */
	byte[] imageInByte;
	/**
	 * TODO commenter le role du Constructeur
	 * @param frame
	 * @param ajouterFilmView
	 * @param factory
	 * @param cinema
	 */
	public AjouterFilmController(JFrame frame, AjouterFilmView ajouterFilmView, SessionFactory factory, Cinema cinema) {
		this.frame = frame;
		this.ajouterFilmView = ajouterFilmView;
		this.factory = factory;
		this.cinema = cinema;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == ajouterFilmView.getBtnAnnuler()){
			GestionCinemaView gestionCinemaView = new GestionCinemaView();
			GestionCinemaController gestionCinemaController = new GestionCinemaController(frame, gestionCinemaView, factory, cinema);
			gestionCinemaView.setController(gestionCinemaController);
			frame.setContentPane(gestionCinemaView);
			frame.pack();
			frame.setLocationRelativeTo(null);
			couleur = null;
		}
		else if(event.getSource() == ajouterFilmView.getBtnSauvegarder()){
			/** on sauvegarde tous les champs et on gère les exception éventuellements 
			 * Film film = new Film(idMovie,titre, runTime, genre, realisateur, date, today, casting,  overview, rate, blob, couleurs);
               filmList.add(film);*/

			// Obtient la date
			try {
				releaseDate = ajouterFilmView.getDateChooser().getDate();
				dateSortie = new java.sql.Date(releaseDate.getTime());
				System.out.println("Date Sortie :" + dateSortie);
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NODATESORTIE, "Error", JOptionPane.ERROR_MESSAGE);
			}



			//Obtention de l'image à partir de l'URL et convertion en type java.SQL.blob
			try {
				imageURL = new URL("file:///" + ajouterFilmView.getTxtFieldUrlImage().getText());
				originalImage = ImageIO.read(imageURL);
				// TODO checker la taille de l'image < 100Ko + try catch et JOption pane pour erreur format
				ImageIO.write(originalImage, "jpg", baos );
				baos.flush();
				imageInByte = baos.toByteArray();
				blob = new javax.sql.rowset.serial.SerialBlob(imageInByte);
				//Persist - in this case to a file
				FileOutputStream fos = new FileOutputStream("myImage.jpg");
				baos.writeTo(fos);
				fos.close();
			} catch (IOException | SQLException | java.lang.IllegalArgumentException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_IMAGEFORMAT_EXCEPTION,"Error", JOptionPane.ERROR_MESSAGE);

			}

			titre = ajouterFilmView.getTxtFieldTitre().getText();
			System.out.println(titre);
			overview = ajouterFilmView.getTxtAreaSyno().getText();
			System.out.println(overview);
			casting = ajouterFilmView.getTxtFieldCasting().getText();
			System.out.println(casting);
			genre = ajouterFilmView.getTxtFieldGenre().getText();
			System.out.println(genre);
			realisateur = ajouterFilmView.getTxtFieldRealisateur().getText();
			System.out.println(realisateur);

			if ((ajouterFilmView.getTxtFieldDuree().getText()).equals("")){
				ajouterFilmView.getTxtFieldDuree().setText("0");
			}
			runTime = Integer.parseInt(ajouterFilmView.getTxtFieldDuree().getText());
			System.out.println(runTime);

			if ((ajouterFilmView.getTxtFieldNote().getText()).equals("")){
				ajouterFilmView.getTxtFieldNote().setText("0");
			}
			rate = Double.parseDouble(ajouterFilmView.getTxtFieldNote().getText());
			System.out.println(rate);
			dateAjout = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			System.out.println("Date ajout :" + dateAjout);
			System.out.println(couleur);


			if (couleur == null || hexColor == 0){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NOHTMLCOLOR,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(titre.equals("")){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NOTITLE,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(overview.equals("")){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NOOVERVIEW,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(casting.equals("")){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NOCASTING,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(genre.equals("")){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NOGENRE,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(realisateur.equals("")){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NOREALISATEUR,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(runTime == 0){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NORUNTIME,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(rate == 0){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NORATING,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(!(ajouterFilmView.getTxtFieldNote().getText().contains("."))){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_WRONGRATING,"Error", JOptionPane.ERROR_MESSAGE);
			}else if(dateSortie == null){
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_ERROR_NODATESORTIE, "Error", JOptionPane.ERROR_MESSAGE);
			}else if(ajouterFilmView.getTxtFieldUrlImage().getText().equals("")){
				
			}
			else{
			
				Session session = factory.openSession();
				session.getTransaction().begin();
				film = new Film(0, titre, runTime, genre, realisateur, dateSortie, dateAjout, casting,  overview, rate, blob, couleur);
				session.save(film);
				session.getTransaction().commit();
				session.close();
				JOptionPane.showMessageDialog(ajouterFilmView, MSG_SUCCES_SAUVEGARDE,"Success", JOptionPane.INFORMATION_MESSAGE);
			}

		}
		else if (event.getSource() == ajouterFilmView.getBtnPalette()){
			/** Algorithme de génértion aléatoire de couleur donc on créer une variable qu'on va remplir aléatoirement avec 6 chiffres ou lettres mélangées.
			 * On affichera après le résultat dans un jlabel à côté du champ, que l'admin puisse voir à quoi correspon cette couleur 
			 * Ajouter une icone stylé*/
			Random rand = new Random();
			hexColor = rand.nextInt(0xFFFFFF);
			color = generatePastelColor();
			ajouterFilmView.getPnlColor().setBackground(color);
			couleur = Integer.toString(color.getRGB());
			//String unsignedCouleur = couleur.replaceAll("-", "");
			//System.out.println(unsignedCouleur);
			//ajouterFilmView.getPnlColor().setBackground(color.decode(unsignedCouleur));
			//Donnez la fonction a Rémi pour qu'ils prennent en compte le - devant la couleur dans le planning pour les films.
		}
		else if(event.getSource() == ajouterFilmView.getBtnParcourir()){
			/** Fonction qui ouvre une fenêtre "Parcourir dans l'ordinateur".
			 * Ajouter une icone stylé */
			JFileChooser browser = new JFileChooser();
			browser.showOpenDialog(null);
			File file = browser.getSelectedFile();
			String filename = file.getAbsolutePath();
			ajouterFilmView.getTxtFieldUrlImage().setText(filename);

		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * Permet de rentrer uniquement des entiers et de les supprimer. 
	 */
	@Override
	public void keyTyped(KeyEvent event) {
		if(event.getSource() == ajouterFilmView.getTxtFieldDuree()){
			char c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE) || ajouterFilmView.getTxtFieldDuree().getText().length() >= 3){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}
			// Permet de rentrer uniquement des nombres décimaux et de les supprimer.
		} else if(event.getSource() == ajouterFilmView.getTxtFieldNote()) {
			// TODO Auto-generated method stub
			char c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE || c==KeyEvent.VK_PERIOD) || ajouterFilmView.getTxtFieldNote().getText().length() >= 3){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}else if(c == KeyEvent.VK_PERIOD && ((JTextField)event.getSource()).getText().contains(".")){
				event.consume();
			}
		}

	}
	/**
	 * TODO commenter le role de la Méthode
	 * @return color
	 */
	public Color generatePastelColor() {
		Random random = new Random();
		// Will produce only bright / light colours:
		float red = (float) (random.nextFloat() / 2 + 0.5);
		float green = (float) (random.nextFloat() / 2 + 0.5);
		float blue = (float) (random.nextFloat() / 2 + 0.5);
		Color color = new Color(red, green, blue);
		return color;
	}
}
