/*
 * AjouterFilmView.java                                19 févr. 2016
 * IUT Info1 2013-2014 Groupe 3
 */
package cineGOv02.admin.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;

import cineGOv02.admin.controller.AjouterFilmController;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

/**
 * TODO commenter les responsabilités classe
 * @author hustariz
 *
 */
public class AjouterFilmView extends JPanel {
	/** TODO commenter le Champ */
	private JTextField txtFieldTitre;
	/** TODO commenter le Champ */	
	private JTextArea txtAreaSyno;
	/** TODO commenter le Champ */
	private JTextField txtFieldGenre;
	/** TODO commenter le Champ */
	private JTextField txtFieldRealisateur;
	/** TODO commenter le Champ */
	private JTextField txtFieldCasting;
	/** TODO commenter le Champ */
	private JTextField txtFieldDuree;
	/** TODO commenter le Champ */
	private JTextField txtFieldNote;
	/** TODO commenter le Champ */
	private JTextField txtFieldUrlImage;
	/** TODO commenter le Champ */
	private JPanel pnlColor;
	/** TODO commenter le Champ */
	JDateChooser dateChooser;
	
	/** TODO commenter le Champ */
	private JButton btnAnnuler;
	/** TODO commenter le Champ */
	private JButton btnSauvegarder;
	/** TODO commenter le Champ */
	private JButton btnPalette;
	/** TODO commenter le Champ */
	private JButton btnParcourir;
	/**
	 * TODO commenter le role du Constructeur
	 */
	public AjouterFilmView() {
		
		JLabel label = new JLabel("Cinego");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, new Color(0, 0, 0), new Color(0, 0, 0), SystemColor.textHighlight));
		
		btnAnnuler = new JButton("Annuler");
		
		btnSauvegarder = new JButton("Sauvegarder");
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtFieldTitre = new JTextField();
		txtFieldTitre.setText("Le Super Film d'Action");
		txtFieldTitre.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFieldTitre.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldTitre.setColumns(10);
		
		JLabel lblSynopsis = new JLabel("Synopsis");
		lblSynopsis.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtFieldGenre = new JTextField();
		txtFieldGenre.setText("Action, Science-Fiction");
		txtFieldGenre.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFieldGenre.setHorizontalAlignment(SwingConstants.LEFT);
		txtFieldGenre.setColumns(10);
		
		JLabel lblRealisateur = new JLabel("Realisateur");
		lblRealisateur.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(175)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)))
					.addGap(47))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel lblCasting = new JLabel("Casting");
		lblCasting.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtFieldCasting = new JTextField();
		txtFieldCasting.setText("Bruce Willis, Milla Jovovich");
		txtFieldCasting.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFieldCasting.setHorizontalAlignment(SwingConstants.LEFT);
		txtFieldCasting.setColumns(10);
		
		JLabel lblDateDeSortie = new JLabel("Date de sortie");
		lblDateDeSortie.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblDure = new JLabel("Durée (mn)");
		lblDure.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtFieldDuree = new JTextField();
		txtFieldDuree.setText("127");
		txtFieldDuree.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFieldDuree.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldDuree.setColumns(10);
		
		JLabel lblNote = new JLabel("Note (/10)");
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtFieldNote = new JTextField();
		txtFieldNote.setText("8.4");
		txtFieldNote.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFieldNote.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldNote.setColumns(10);
		
		JLabel lblCouleurPlanning = new JLabel("Couleur Planning");
		lblCouleurPlanning.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblImagepath = new JLabel("Image Path");
		lblImagepath.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnPalette = new JButton("Générer");
		
		btnParcourir = new JButton("Parcourir");
		
		txtFieldUrlImage = new JTextField();
		txtFieldUrlImage.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldUrlImage.setColumns(10);
		
		txtAreaSyno = new JTextArea();
		txtAreaSyno.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		txtAreaSyno.setLineWrap(true);
		txtAreaSyno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		

		JScrollPane SynoScrollPane = new JScrollPane(txtAreaSyno);
		SynoScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		SynoScrollPane.setPreferredSize(new Dimension(100, 100));
		
		txtFieldRealisateur = new JTextField();
		txtFieldRealisateur.setText("Luc Besson");
		txtFieldRealisateur.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtFieldRealisateur.setHorizontalAlignment(SwingConstants.LEFT);
		txtFieldRealisateur.setColumns(10);
		
		pnlColor = new JPanel();
		pnlColor.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		dateChooser = new JDateChooser();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblTitre)
							.addGap(60)
							.addComponent(txtFieldTitre, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblSynopsis)
							.addGap(31)
							.addComponent(SynoScrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblCasting)
							.addGap(40)
							.addComponent(txtFieldCasting, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblGenre)
							.addGap(51)
							.addComponent(txtFieldGenre, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblRealisateur)
							.addGap(63)
							.addComponent(txtFieldRealisateur, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblImagepath, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(txtFieldUrlImage, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(58)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(btnSauvegarder, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblDateDeSortie)
									.addGap(43)
									.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblDure)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtFieldDuree, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNote)
									.addGap(123)
									.addComponent(txtFieldNote, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(lblCouleurPlanning, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(62)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlColor, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPalette, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(217)
							.addComponent(btnParcourir, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitre)
						.addComponent(txtFieldTitre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(35)
							.addComponent(lblSynopsis))
						.addComponent(SynoScrollPane, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCasting)
						.addComponent(txtFieldCasting, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblGenre))
						.addComponent(txtFieldGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRealisateur)
						.addComponent(txtFieldRealisateur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateDeSortie)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDure)
						.addComponent(txtFieldDuree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNote)
						.addComponent(txtFieldNote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCouleurPlanning)
						.addComponent(pnlColor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(47)
							.addComponent(lblImagepath))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(btnPalette, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(txtFieldUrlImage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnParcourir, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAnnuler, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSauvegarder, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	
	/**Getters and setters*/
	/**
	 * @return le pnlColor
	 */
	public JPanel getPnlColor() {
		return pnlColor;
	}


	/**
	 * @param pnlColor le pnlColor to set
	 */
	public void setPnlColor(JPanel pnlColor) {
		this.pnlColor = pnlColor;
	}


	/**
	 * TODO commenter le role de la Méthode
	 * @return yo
	 */
	public JTextArea getTxtAreaSyno() {
		return txtAreaSyno;
	}


	/**
	 * TODO commenter le role de la Méthode
	 * @param txtAreaSyno
	 */
	public void setTxtAreaSyno(JTextArea txtAreaSyno) {
		this.txtAreaSyno = txtAreaSyno;
	}


	/**
	 * @return le btnAnnuler
	 */
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}


	/**
	 * @param btnAnnuler le btnAnnuler to set
	 */
	public void setBtnAnnuler(JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}


	/**
	 * @return le btnSauvegarder
	 */
	public JButton getBtnSauvegarder() {
		return btnSauvegarder;
	}


	/**
	 * @param btnSauvegarder le btnSauvegarder to set
	 */
	public void setBtnSauvegarder(JButton btnSauvegarder) {
		this.btnSauvegarder = btnSauvegarder;
	}


	/**
	 * @return le btnPalette
	 */
	public JButton getBtnPalette() {
		return btnPalette;
	}


	/**
	 * @param btnPalette le btnPalette to set
	 */
	public void setBtnPalette(JButton btnPalette) {
		this.btnPalette = btnPalette;
	}


	/**
	 * @return le btnParcourir
	 */
	public JButton getBtnParcourir() {
		return btnParcourir;
	}


	/**
	 * @param btnParcourir le btnParcourir to set
	 */
	public void setBtnParcourir(JButton btnParcourir) {
		this.btnParcourir = btnParcourir;
	}


	/**
	 * @return le txtFieldTitre
	 */
	public JTextField getTxtFieldTitre() {
		return txtFieldTitre;
	}


	/**
	 * @param txtFieldTitre le txtFieldTitre to set
	 */
	public void setTxtFieldTitre(JTextField txtFieldTitre) {
		this.txtFieldTitre = txtFieldTitre;
	}

	/**
	 * @return le txtFieldGenre
	 */
	public JTextField getTxtFieldGenre() {
		return txtFieldGenre;
	}


	/**
	 * @param txtFieldGenre le txtFieldGenre to set
	 */
	public void setTxtFieldGenre(JTextField txtFieldGenre) {
		this.txtFieldGenre = txtFieldGenre;
	}


	/**
	 * @return le txtFieldRealisateur
	 */
	public JTextField getTxtFieldRealisateur() {
		return txtFieldRealisateur;
	}


	/**
	 * @param txtFieldRealisateur le txtFieldRealisateur to set
	 */
	public void setTxtFieldRealisateur(JTextField txtFieldRealisateur) {
		this.txtFieldRealisateur = txtFieldRealisateur;
	}


	/**
	 * @return le txtFieldCasting
	 */
	public JTextField getTxtFieldCasting() {
		return txtFieldCasting;
	}


	/**
	 * @param txtFieldCasting le txtFieldCasting to set
	 */
	public void setTxtFieldCasting(JTextField txtFieldCasting) {
		this.txtFieldCasting = txtFieldCasting;
	}


	/**
	 * @return le dateChooser
	 */
	public JDateChooser getDateChooser() {
		return dateChooser;
	}


	/**
	 * @param dateChooser le dateChooser to set
	 */
	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}


	/**
	 * @return le txtFieldDuree
	 */
	public JTextField getTxtFieldDuree() {
		return txtFieldDuree;
	}


	/**
	 * @param txtFieldDuree le txtFieldDuree to set
	 */
	public void setTxtFieldDuree(JTextField txtFieldDuree) {
		this.txtFieldDuree = txtFieldDuree;
	}


	/**
	 * @return le txtFieldNote
	 */
	public JTextField getTxtFieldNote() {
		return txtFieldNote;
	}


	/**
	 * @param txtFieldNote le txtFieldNote to set
	 */
	public void setTxtFieldNote(JTextField txtFieldNote) {
		this.txtFieldNote = txtFieldNote;
	}


	/**
	 * @return le txtFieldUrlImage
	 */
	public JTextField getTxtFieldUrlImage() {
		return txtFieldUrlImage;
	}


	/**
	 * @param txtFieldUrlImage le txtFieldUrlImage to set
	 */
	public void setTxtFieldUrlImage(JTextField txtFieldUrlImage) {
		this.txtFieldUrlImage = txtFieldUrlImage;
	}
	
	/**
     * Methode où l'on va lier les éléments de la vue à leur controller respectif.
     * @param controller spécifique à la vue.
	 */
	public void setController(AjouterFilmController controller) {
		btnAnnuler.addActionListener(controller);
		btnSauvegarder.addActionListener(controller);
		btnPalette.addActionListener(controller);
		btnParcourir.addActionListener(controller);
		txtFieldNote.addKeyListener(controller);
		txtFieldDuree.addKeyListener(controller);
	}
}
