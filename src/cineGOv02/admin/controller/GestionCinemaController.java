package cineGOv02.admin.controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import cineGOv02.admin.view.AjouterFilmView;
import cineGOv02.admin.view.GestionCinemaView;
import cineGOv02.admin.view.LauncherAdminView;
import cineGOv02.admin.view.PlanningView;
import cineGOv02.common.entity.Cinema;
import cineGOv02.common.entity.Salle;

/**
 * Controller de la vue de gestion des informations des cinémas.
 * Javadoc Done
 * @author hustariz
 */
public class GestionCinemaController implements ActionListener, MouseListener, KeyListener {

	/** TODO commenter le Champ */
	private JFrame frame;

	/** TODO commenter le Champ */
	private GestionCinemaView gestionCinemaView;

	/** TODO commenter le Champ */
	private SessionFactory factory;
	/** TODO Salles allouées au cinéma. */
	private Salle salle;

	/** Cinéma qu'on va pouvoir éditer. */
	private Cinema cinema;
	/** TODO commenter le Champ */
	private static final String MSG_CINEMA_EXIST = "Un cinéma de ce nom éxiste déjà, seuls ses tarifs ont été changé.";
	/** TODO commenter le Champ */
	private static final String MSG_SALLE_EXIST = "Une salle de ce nom éxiste déjà, seuls ses attributs ont été changé.";
	/** TODO commenter le Champ */
	private static final String MSG_CHAMP_VIDE = "Vous n'avez pas renseigné tous les champs.";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_FK_CONSTRAINT ="ERROR: Cannot delete or update a parent row: a foreign key constraint fails.";
	/** TODO commenter le Champ */
	private static final String MSG_ERROR_WRONGTARIF = "Veuillez respecter le format de tarifs : NN.NN (€)!";
	/** TODO commenter le Champ */
	private static final String MSG_SUCCES_SAUVEGARDE = "Votre cinéma a bien été enregistrée dans notre base de donnée!";
	/** TODO commenter le Champ */
	private static final String MSG_SUCCES_SALLE_ADDED = "Votre salle a bien été enregistrée dans notre base de donnée!";
	/** TODO commenter le Champ */
	private static final String MSG_SUCCES_SALLE_DELETED = "Votre salle a bien été supprimée de notre base de donnée!";
	/** TODO commenter le Champ */
	private int nbRangees;
	/** TODO commenter le Champ */
	private int nbSieges;
	/** TODO commenter le Champ */
	private int numeroDeSalle;
	/** TODO commenter le Champ */
	private int placesDisponibles;
	/** TODO commenter le Champ */
	String deleteSalleComboboxResult;
	/** Key typed */
	private static char c;


	/**
	 * TODO commenter le role du Constructeur
	 * @param frame
	 * @param gestionCinemaView 
	 * @param factory 
	 * @param cinema 
	 */
	public GestionCinemaController(JFrame frame, GestionCinemaView gestionCinemaView, SessionFactory factory, Cinema cinema) {
		this.frame = frame;
		this.gestionCinemaView = gestionCinemaView;
		this.factory = factory;
		this.cinema = cinema;
		gestionCinemaView.getLblCinemaNom().setText(cinema.getNom());
		gestionCinemaView.getTxtFieldNomCine().setText(cinema.getNom());
		gestionCinemaView.getTxtFieldTarifNormal().setText(Double.toString(cinema.getTarifNormal()));
		gestionCinemaView.getTxtFieldTarifEtu().setText(Double.toString(cinema.getReductionEtudiant()));
		gestionCinemaView.getTxtFieldTarif3D().setText(Double.toString(cinema.getTarif3D()));
		FillDeleteComboBox();
	}


	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		//Bouton EditPlanning
		if(event.getSource() == gestionCinemaView.getBtnEditPlanning()){
			PlanningView planningView = new PlanningView();
			PlanningController planningController = new PlanningController(frame, planningView, this.factory, cinema);
			planningView.setController(planningController);
			frame.setContentPane(planningView);
			frame.pack();
			frame.setLocationRelativeTo(null); 
		}
		//Bouton sauvegarde info
		else if(event.getSource() == gestionCinemaView.getBtnSaveInfo()){
			if(!gestionCinemaView.getTxtFieldNomCine().getText().equals("")
					&& !gestionCinemaView.getTxtFieldTarifNormal().getText().equals("")
					&& !gestionCinemaView.getTxtFieldTarifEtu().getText().equals("")
					&& !gestionCinemaView.getTxtFieldTarif3D().getText().equals("")){
				Session session = factory.openSession();
				session.getTransaction().begin();
				if(!cinemaExist(gestionCinemaView.getTxtFieldNomCine().getText())){
					//Si le nom de cinema est différent, on sauvegarde un nouveau.
					//Voir algo tarifs ajoutCinemaController.
					if(!(gestionCinemaView.getTxtFieldTarif3D().getText().contains("."))
							|| !(gestionCinemaView.getTxtFieldTarifEtu().getText().contains("."))
							|| !(gestionCinemaView.getTxtFieldTarifNormal().getText().contains("."))){
						JOptionPane.showMessageDialog(gestionCinemaView, MSG_ERROR_WRONGTARIF,"Error", JOptionPane.ERROR_MESSAGE);
					}else{
					cinema.setNom(gestionCinemaView.getTxtFieldNomCine().getText());
					cinema.setTarifNormal(Double.parseDouble(gestionCinemaView.getTxtFieldTarifNormal().getText()));
					cinema.setTarif3D(Double.parseDouble(gestionCinemaView.getTxtFieldTarif3D().getText()));
					cinema.setReductionEtudiant(Double.parseDouble(gestionCinemaView.getTxtFieldTarifEtu().getText()));
					session.flush();
					session.update(cinema);
					session.getTransaction().commit();
					session.close();
					JOptionPane.showMessageDialog(gestionCinemaView, MSG_SUCCES_SAUVEGARDE,"Success", JOptionPane.INFORMATION_MESSAGE);
					gestionCinemaView.getLblCinemaNom().setText(cinema.getNom());
					}
				}else{
					//Sinon on Update les tarifs du cinéma actuel.
					JOptionPane.showMessageDialog(gestionCinemaView, MSG_CINEMA_EXIST,"Information", JOptionPane.INFORMATION_MESSAGE);
					cinema.setTarifNormal(Double.parseDouble(gestionCinemaView.getTxtFieldTarifNormal().getText()));
					cinema.setTarif3D(Double.parseDouble(gestionCinemaView.getTxtFieldTarif3D().getText()));
					cinema.setReductionEtudiant(Double.parseDouble(gestionCinemaView.getTxtFieldTarifEtu().getText()));
					session.flush();
					session.update(cinema);
					session.getTransaction().commit();
					session.close();
				}

			}else{
				JOptionPane.showMessageDialog(gestionCinemaView, MSG_CHAMP_VIDE,"Error", JOptionPane.ERROR_MESSAGE);
			}	
		}
		//Bouton ajouter salle.
		else if(event.getSource() == gestionCinemaView.getBtnAddSalle()){

			if(!gestionCinemaView.getTxtFieldAddSalle().getText().equals("")
					&& !gestionCinemaView.getTextFieldNbSiege().getText().equals("")
					&& !gestionCinemaView.getTextFieldNbRangee().getText().equals("")){
				Session session = factory.openSession();
				session.getTransaction().begin();
				Salle salle = salleExist(Integer.parseInt(gestionCinemaView.getTxtFieldAddSalle().getText()));
				//Create salle
				if(salle == null){
					numeroDeSalle = Integer.parseInt(gestionCinemaView.getTxtFieldAddSalle().getText());
					nbSieges = Integer.parseInt(gestionCinemaView.getTextFieldNbSiege().getText());
					nbRangees = Integer.parseInt(gestionCinemaView.getTextFieldNbRangee().getText());
					placesDisponibles = nbSieges * nbRangees;
					Salle newSalle = new Salle(numeroDeSalle, nbRangees, nbSieges, placesDisponibles, cinema, null);
					session.save(newSalle);
					session.getTransaction().commit();
					session.close();
					FillDeleteComboBox();
					JOptionPane.showMessageDialog(gestionCinemaView, MSG_SUCCES_SALLE_ADDED,"Information", JOptionPane.INFORMATION_MESSAGE);
					gestionCinemaView.getTxtFieldAddSalle().setText("");
					gestionCinemaView.getTextFieldNbRangee().setText("");
					gestionCinemaView.getTextFieldNbSiege().setText("");
				//Update salle
				}else{
					JOptionPane.showMessageDialog(gestionCinemaView, MSG_SALLE_EXIST,"Information", JOptionPane.INFORMATION_MESSAGE);
					nbSieges = Integer.parseInt(gestionCinemaView.getTextFieldNbSiege().getText());
					nbRangees = Integer.parseInt(gestionCinemaView.getTextFieldNbRangee().getText());
					placesDisponibles = nbSieges * nbRangees;
					salle.setNbSieges(nbSieges);
					salle.setNbRangees(nbRangees);
					session.flush();
					session.update(salle);
					session.getTransaction().commit();
					session.close();

				}
			}
			else{
				JOptionPane.showMessageDialog(gestionCinemaView, MSG_CHAMP_VIDE,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		//Bouton Supprimer salle
		else if(event.getSource() == gestionCinemaView.getBtnSupprSalle()){
			deleteSalleComboboxResult = gestionCinemaView.getComboBoxSupprSalle().getSelectedItem().toString();
			numeroDeSalle = Integer.parseInt(deleteSalleComboboxResult);
			try{
				Session session = factory.openSession();
				salle = (Salle) session.createQuery("SELECT sa FROM Salle sa WHERE sa.numeroDeSalle = :numSalle AND sa.cinema = :cinema ")
						.setInteger("numSalle", numeroDeSalle)
						.setEntity("cinema", cinema)
						.uniqueResult();
				session.getTransaction().begin();
				session.delete(salle);
				session.getTransaction().commit();
				session.close();
				JOptionPane.showMessageDialog(gestionCinemaView, MSG_SUCCES_SALLE_DELETED,"Success", JOptionPane.INFORMATION_MESSAGE);
				FillDeleteComboBox();
			}catch (ConstraintViolationException e){
				JOptionPane.showMessageDialog(gestionCinemaView, MSG_ERROR_FK_CONSTRAINT,"Error", JOptionPane.ERROR_MESSAGE);
			}

		}
		//Bouton Ajouter Film
		else if(event.getSource() == gestionCinemaView.getBtnAjouterFilm()){
			AjouterFilmView ajouterFilmView = new AjouterFilmView();
			AjouterFilmController ajouterFilmController = new AjouterFilmController(frame, ajouterFilmView, this.factory, cinema);
			ajouterFilmView.setController(ajouterFilmController);
			frame.setContentPane(ajouterFilmView);
			frame.pack();
			frame.setLocationRelativeTo(null);
		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent event) {

		// TODO Auto-generated method stub
		if(event.getSource() == gestionCinemaView.getLblSlectionnerUnAutre()){
			LauncherAdminView launcherView = new LauncherAdminView();
			LauncherAdminController controller = new LauncherAdminController(frame,launcherView, factory);
			frame.setContentPane(launcherView);
			frame.pack();
			frame.setLocationRelativeTo(null);
		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * TODO commenter le role de la Méthode
	 * @param nomCinema
	 * @return true if cinema already exist.
	 */
	private boolean cinemaExist(String nomCinema) {
		Session session = factory.openSession();
		long nbCinema = (long) session.createQuery("SELECT COUNT(*) FROM Cinema WHERE nom = :nom")
				.setString("nom", nomCinema)
				.uniqueResult();
		session.close();
		return nbCinema > 0 ? true: false;

	}
	/**
	 * TODO commenter le role de la Méthode
	 * @param numSalle
	 * @return true if Salle already exist.
	 */
	private Salle salleExist(int numSalle){
		Session session = factory.openSession();
		Salle salle = (Salle) session.createQuery("SELECT sa FROM Salle sa WHERE sa.numeroDeSalle = :numSalle AND sa.cinema = :cinema ")
				.setInteger("numSalle", numSalle)
				.setEntity("cinema", cinema)
				.uniqueResult();
		session.close();
		return salle;
	}

	/**
	 * TODO commenter le role de la Méthode
	 * @return salle
	 */
	private ArrayList<Integer> getListNumSalle(){
		Session session = factory.openSession();
		ArrayList<Integer> salle = new ArrayList<Integer>(session.createQuery("SELECT sa.numeroDeSalle FROM Salle sa WHERE sa.cinema = :cinema ")
				.setEntity("cinema", cinema)
				.list());
		return salle;
	}

	/**
	 * TODO commenter le role de la Méthode
	 */
	private void FillDeleteComboBox() {
		Session session = factory.openSession();
		ArrayList<Integer> salle = new ArrayList<Integer>(session.createQuery("SELECT sa.numeroDeSalle FROM Salle sa WHERE sa.cinema = :cinema ")
				.setEntity("cinema", cinema)
				.list());
		gestionCinemaView.getComboBoxSupprSalle().removeAllItems();
		for (int i = 0; i < salle.size(); i++){
			gestionCinemaView.getComboBoxSupprSalle().addItem(salle.get(i));
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
		if(event.getSource() == gestionCinemaView.getTxtFieldAddSalle()){
			c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE) || gestionCinemaView.getTxtFieldAddSalle().getText().length()  >= 3 ){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}
		}else if(event.getSource() == gestionCinemaView.getTextFieldNbRangee()){
			c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE) || gestionCinemaView.getTextFieldNbRangee().getText().length() >= 2 ){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}
		}else if(event.getSource() == gestionCinemaView.getTextFieldNbSiege()){
			char c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE) || gestionCinemaView.getTextFieldNbSiege().getText().length()  >= 2 ){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}
		}// Permet de rentrer uniquement des nombres décimaux et de les supprimer.
		else if (event.getSource() == gestionCinemaView.getTxtFieldTarifNormal()) {
			// TODO Auto-generated method stub
			char c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE|| c==KeyEvent.VK_PERIOD) || gestionCinemaView.getTxtFieldTarifNormal().getText().length() >= 5){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}else if(c == KeyEvent.VK_PERIOD && ((JTextField)event.getSource()).getText().contains(".")){
				event.consume();
			}
		}else if(event.getSource() == gestionCinemaView.getTxtFieldTarifEtu()){
			// TODO Auto-generated method stub
			char c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE|| c==KeyEvent.VK_PERIOD) || gestionCinemaView.getTxtFieldTarifEtu().getText().length() >= 5){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}else if(c == KeyEvent.VK_PERIOD && ((JTextField)event.getSource()).getText().contains(".")){
				event.consume();
			}
		}else if(event.getSource() == gestionCinemaView.getTxtFieldTarif3D()){
			// TODO Auto-generated method stub
			char c = event.getKeyChar();
			if(!(Character.isDigit(c) || c==KeyEvent.VK_DELETE|| c==KeyEvent.VK_PERIOD) || gestionCinemaView.getTxtFieldTarif3D().getText().length() >= 5){
				Toolkit.getDefaultToolkit().beep();
				event.consume();
			}else if(c == KeyEvent.VK_PERIOD && ((JTextField)event.getSource()).getText().contains(".")){
				event.consume();
			}
		}

	}

}

