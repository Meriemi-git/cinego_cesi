/*
 * AjouterCinemaView.java                                28 janv. 2016
 * IUT Info1 2013-2014 Groupe 3
 */
package cineGOv02.admin.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;

import cineGOv02.admin.controller.AjouterCinemaController;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * Vue où l'on va ajouter un cinéma et renseigner ses champs tarifs.
 * Javadoc Done
 * @author hustariz
 *
 */
public class AjouterCinemaView extends JPanel {
	/** Champ nom du cinéma. */
	private JTextField nomField;
	/** Champ tarif du cinéma. */
	private JTextField tarifNormField;
	/** Champ tarif étudiant du cinéma. */
	private JTextField tarifEtuField;
	/** Champ tarif 3d du cinéma */
	private JTextField tarif3DField;

	/** Bouton save */
	private JButton saveButton;
	/** Bouton annulé*/
	private JButton btnAnnuler;

	/**
	 * Vue d'ajout de cinéma.
	 */
	public AjouterCinemaView() {

		JLabel lblCinego = new JLabel("Cinego");
		lblCinego.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCinego.setHorizontalAlignment(SwingConstants.CENTER);
		lblCinego.setForeground(SystemColor.textHighlight);
		lblCinego.setFont(new Font("SansSerif", Font.BOLD, 30));

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, new Color(0, 0, 0), new Color(0, 0, 0), SystemColor.textHighlight));

		JLabel lblAjouterUnCinma = new JLabel("Ajouter un cinéma");
		lblAjouterUnCinma.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnAnnuler = new JButton("Annuler");
		saveButton = new JButton("Sauvegarder");

		JLabel label_2 = new JLabel("Nom");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));

		nomField = new JTextField();
		nomField.setColumns(10);

		JLabel label_3 = new JLabel("Tarif normal");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));

		tarifNormField = new JTextField();
		tarifNormField.setColumns(10);

		JLabel label_4 = new JLabel("Tarif étudiant");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));

		tarifEtuField = new JTextField();
		tarifEtuField.setColumns(10);

		JLabel label_5 = new JLabel("Tarif 3D");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 14));

		tarif3DField = new JTextField();
		tarif3DField.setColumns(10);

	     /** 
         * WindowsBuilder GroupLayout
         */
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(14)
							.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
							.addComponent(nomField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addComponent(tarifNormField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
							.addComponent(tarifEtuField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
							.addComponent(tarif3DField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
					.addGap(57))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(102, Short.MAX_VALUE)
					.addComponent(lblAjouterUnCinma)
					.addGap(99))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAjouterUnCinma)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(nomField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(tarifNormField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(tarifEtuField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(tarif3DField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(175)
							.addComponent(lblCinego)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCinego)
					.addGap(11)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}

	/**Getters and setters*/
	/**
	 * @return le nomField
	 */
	public JTextField getNomField() {
		return nomField;
	}

	/**
	 * @param nomField le nomField to set
	 */
	public void setNomField(JTextField nomField) {
		this.nomField = nomField;
	}

	/**
	 * @return le tarifNormField
	 */
	public JTextField getTarifNormField() {
		return tarifNormField;
	}

	/**
	 * @param tarifNormField le tarifNormField to set
	 */
	public void setTarifNormField(JTextField tarifNormField) {
		this.tarifNormField = tarifNormField;
	}

	/**
	 * @return le tarifEtuField
	 */
	public JTextField getTarifEtuField() {
		return tarifEtuField;
	}


	/**
	 * @param tarifEtuField le tarifEtuField to set
	 */
	public void setTarifEtuField(JTextField tarifEtuField) {
		this.tarifEtuField = tarifEtuField;
	}


	/**
	 * @return le tarif3DField
	 */
	public JTextField getTarif3DField() {
		return tarif3DField;
	}


	/**
	 * @param tarif3dField le tarif3DField to set
	 */
	public void setTarif3DField(JTextField tarif3dField) {
		tarif3DField = tarif3dField;
	}


	/**
	 * @return le saveButton
	 */
	public JButton getSaveButton() {
		return saveButton;
	}

	/**
	 * @param saveButton le saveButton to set
	 */
	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
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
     * Methode où l'on va lier les éléments de la vue à leur controller respectif.
     * @param controller spécifique à la vue.
	 */
	public void setController(AjouterCinemaController controller) {
		saveButton.addActionListener(controller);
		btnAnnuler.addActionListener(controller);
		tarifNormField.addKeyListener(controller);
		tarifEtuField.addKeyListener(controller);
		tarif3DField.addKeyListener(controller);	
	}

}

