package cineGOv02.admin.controller;


import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cineGOv02.admin.view.AjouterCinemaView;
import cineGOv02.admin.view.GestionCinemaView;
import cineGOv02.admin.view.LauncherAdminView;
import cineGOv02.admin.controller.GestionCinemaController;
import cineGOv02.admin.controller.LauncherAdminController;
import cineGOv02.common.entity.Cinema;


/**
 * Controller de la vue d'ajout de cinéma
 * Javadoc Done
 * @author hustariz
 *
 */
public class AjouterCinemaController implements ActionListener, KeyListener{

	/** Frame principal qu'on fait passer de controller en controller. */
	private JFrame frame;
	/** vue d'ajout de cinéma */
	private AjouterCinemaView ajoutCinemaView;
	/**Générateur de session hibernate */
	private SessionFactory factory;
	/** Message display si le nom de cinéma éxiste déjà. */
	private static final String MSG_CINEMA_EXIST = "Un cinéma de ce nom éxiste déjà dans la base de données.";
	/** Message display en cas d'enregistrement du cinéma dans la base de données. */
	private static final String MSG_SUCCES_SAUVEGARDE = "Votre cinéma a bien été enregistré dans notre base de donnée!";
	/** Message display en cas de champs vides lors de l'enregistrement. */
	private static final String MSG_CHAMP_VIDE = "Vous n'avez pas renseigné tous les champs.";
	/** Message display en cas de format de tarifs non respectés. */
	private static final String MSG_ERROR_WRONGTARIF = "Veuillez respecter le format de tarifs : NN.NN (€)!";

	/**
	 * Initialise la frame, la view associée au controller, la factory.
	 * @param frame
	 * @param ajoutCinemaView
	 * @param factory 
	 */
	public AjouterCinemaController(JFrame frame, AjouterCinemaView ajoutCinemaView, SessionFactory factory) {
		this.frame = frame;
		this.ajoutCinemaView = ajoutCinemaView;
		this.factory = factory;
	}

	/* 
	 * Redéfinition de l'actionListener.
	 */
	@Override // redéfinir une méthode hérité de la classe parente (ou méthode qui implémente une interface).
	public void actionPerformed(ActionEvent event) {
		// Si Bouton Save
		if(event.getSource() == ajoutCinemaView.getSaveButton()){

			//Si tous les champs sont renseignés.
			if(!ajoutCinemaView.getNomField().getText().equals("")
					&& !ajoutCinemaView.getTarifNormField().getText().equals("")
					&& !ajoutCinemaView.getTarifEtuField().getText().equals("")
					&& !ajoutCinemaView.getTarif3DField().getText().equals("")){
				/** On parse la valeur du champ dans le tarif. */
				double tarifNormal = Double.parseDouble(ajoutCinemaView.getTarifNormField().getText());
				/** On parse la valeur du champ dans le tarif. */
				double tarifEtu = Double.parseDouble(ajoutCinemaView.getTarifEtuField().getText());
				/** On parse la valeur du champ dans le tarif. */
				double tarif3D = Double.parseDouble(ajoutCinemaView.getTarif3DField().getText());

				// Si le nom de Cinema est disponible.
				if(!cinemaExist(ajoutCinemaView.getNomField().getText())){
					// Si les champs tarifs ne contiennent pas de . (champs double)
					if(!(ajoutCinemaView.getTarif3DField().getText().contains("."))
							|| !(ajoutCinemaView.getTarifEtuField().getText().contains("."))
							|| !(ajoutCinemaView.getTarifNormField().getText().contains("."))){
						JOptionPane.showMessageDialog(ajoutCinemaView, MSG_ERROR_WRONGTARIF,"Error", JOptionPane.ERROR_MESSAGE);
						//Nom de cinéma disponible et champs tarifs contenant un .
					}else{

						Session session = factory.openSession();
						session.getTransaction().begin();
						Cinema cinema = new Cinema(ajoutCinemaView.getNomField().getText(),
								tarifNormal,
								tarifEtu,
								tarif3D);
						session.save(cinema);
						session.getTransaction().commit();
						session.close();
						JOptionPane.showMessageDialog(ajoutCinemaView, MSG_SUCCES_SAUVEGARDE,"Success", JOptionPane.INFORMATION_MESSAGE);
						GestionCinemaView gestionCinemaView = new GestionCinemaView();
						GestionCinemaController gestionCinemaController = new GestionCinemaController(frame, gestionCinemaView, factory, cinema);
						gestionCinemaView.setController(gestionCinemaController);
						frame.setContentPane(gestionCinemaView);
						frame.pack();
						frame.setLocationRelativeTo(null);
					}
					//Si le nom de Cinéma n'est pas disponible.
				}else{
					ajoutCinemaView.getNomField().setText("");
					JOptionPane.showMessageDialog(ajoutCinemaView, MSG_CINEMA_EXIST,"Error", JOptionPane.ERROR_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(ajoutCinemaView, MSG_CHAMP_VIDE,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		//Bouton annuler, on revient sur le launcher.
		else if(event.getSource() == ajoutCinemaView.getBtnAnnuler()){
			LauncherAdminView launcherView = new LauncherAdminView();
			LauncherAdminController launcherController = new LauncherAdminController(frame,launcherView, factory);
			launcherView.setController(launcherController);
			frame.setContentPane(launcherView);
			frame.pack();
			frame.setLocationRelativeTo(null);
		}
	}

	/**
	 * Méthode qui prend en paramètre nomCinema et return true s'il éxiste dans la base de donnée.
	 * @param nomCinema
	 * @return true if cinema already exist.
	 */
	private boolean cinemaExist(String nomCinema) {
		Session session = factory.openSession();
		long nbCinema = (long) session.createQuery("SELECT COUNT(*) FROM Cinema WHERE nom = :nom")
				.setString("nom", nomCinema)
				.uniqueResult();
		session.close();
		//renvoie true si la condition ternaire est vérifiée.
		return nbCinema > 0 ? true : false;

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
	 * Redéfinition du keyListener.
	 * Force l'utilisateur à ne rentrer que des nombres décimaux.
	 */
	@Override
	public void keyTyped(KeyEvent event) {
		if(event.getSource() == ajoutCinemaView.getTarifNormField()){
			// capture la touche appuyée dans une variable
			char c = event.getKeyChar();
			// Si la touche appyée n'est pas un point ou un chiffre on ne fait rien.
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)
					|| ajoutCinemaView.getTarifNormField().getText().length() >= 5){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			// Si le JTextField contient déjà un point, on ne fait rien.
			}else if(c == KeyEvent.VK_PERIOD && ((JTextField)event.getSource()).getText().contains(".")){
				event.consume();
			}
		}else if(event.getSource() == ajoutCinemaView.getTarif3DField()){
			char c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)
					|| ajoutCinemaView.getTarif3DField().getText().length() >= 5){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}else if(c == KeyEvent.VK_PERIOD && ((JTextField)event.getSource()).getText().contains(".")){
				event.consume();
			}
		}else if(event.getSource() == ajoutCinemaView.getTarifEtuField()){
			char c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)
					|| ajoutCinemaView.getTarifEtuField().getText().length() >= 5){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}else if(c == KeyEvent.VK_PERIOD && ((JTextField)event.getSource()).getText().contains(".")){
				event.consume();
			}
		}
	}
}