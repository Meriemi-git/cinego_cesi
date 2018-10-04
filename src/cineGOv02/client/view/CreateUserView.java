/*
 * CreateUser.java                                11 déc. 2015
 * CESI RILA 2015/2017
 */
package cineGOv02.client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cineGOv02.client.controller.CreateUserController;
import cineGOv02.common.util.EmailVerifier;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 */
public class CreateUserView extends JPanel {
    /** TODO commenter le Champ */
    private JTextField txtNom;
    /** TODO commenter le Champ */
    private JTextField txtPrenom;
    /** TODO commenter le Champ */
    private JFormattedTextField txtMail;

    /** TODO commenter le Champ */
    private JButton btnEnvoyer;

    /** TODO commenter le Champ */
    private JButton btnRetour;
    /** TODO */
    private JCheckBox chckbxEtudiant;

    /**
     * TODO commenter le role du Constructeur
     * @param model
     */
    public CreateUserView() {
        this.setSize(new Dimension(285, 300));

        JLabel lblPrenom = new JLabel("Prenom *");
        lblPrenom.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrenom.setForeground(Color.WHITE);
        lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 12));

        txtNom = new JTextField();
        txtNom.setColumns(10);

        txtPrenom = new JTextField();
        txtPrenom.setColumns(10);

        JLabel lblMail = new JLabel(" Mail *");
        lblMail.setForeground(Color.WHITE);
        lblMail.setHorizontalAlignment(SwingConstants.CENTER);
        lblMail.setFont(new Font("Tahoma", Font.PLAIN, 12));

        txtMail = new JFormattedTextField();
        txtMail.setColumns(10);
        EmailVerifier emailVerifier = new EmailVerifier();
        txtMail.setInputVerifier(emailVerifier);

        btnEnvoyer = new JButton("Envoyer");
        btnEnvoyer.setFont(new Font("Arial", Font.BOLD, 13));

        btnRetour = new JButton("Retour");
        btnRetour.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel lblVotre = new JLabel("Nom *");
        lblVotre.setHorizontalAlignment(SwingConstants.CENTER);
        lblVotre.setForeground(Color.WHITE);
        lblVotre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        JLabel label = new JLabel("CineGO");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(SystemColor.textHighlight);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        
        JLabel label_1 = new JLabel("Créez votre compte");
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setForeground(Color.WHITE);
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        JLabel lblLezChampMarqus = new JLabel("Les champs marqués d'une * sont obligatoires");
        lblLezChampMarqus.setFont(new Font("Tahoma", Font.ITALIC, 10));
        lblLezChampMarqus.setForeground(Color.WHITE);
        lblLezChampMarqus.setHorizontalAlignment(SwingConstants.CENTER);
        
        chckbxEtudiant = new JCheckBox("Etudiant ?");
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(87)
                            .addComponent(label))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(123)
                            .addComponent(lblVotre, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(72)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNom, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_1)))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(60)
                            .addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(btnEnvoyer, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(111)
                            .addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(118)
                            .addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(40)
                            .addComponent(lblLezChampMarqus))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(104)
                            .addComponent(chckbxEtudiant)))
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(label_1)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblVotre, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(txtNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                    .addGap(1)
                    .addComponent(txtPrenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblMail)
                    .addGap(4)
                    .addComponent(txtMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(chckbxEtudiant)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblLezChampMarqus)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEnvoyer, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                    .addGap(37))
        );
        setLayout(groupLayout);
    }
    /**
     * TODO commenter le role de la Méthode
     * @param controller
     */
    public void setController(CreateUserController controller){
        btnEnvoyer.addActionListener(controller);
        btnRetour.addActionListener(controller);
    }

    /**
     * @return le txtNom
     */
    public JTextField getTxtNom() {
        return txtNom;
    }

    /**
     * @return le txtPrenom
     */
    public JTextField getTxtPrenom() {
        return txtPrenom;
    }

    /**
     * @return le textMail
     */
    public JTextField getTxtMail() {
        return txtMail;
    }

    /**
     * @return le btnEnvoyer
     */
    public JButton getBtnEnvoyer() {
        return btnEnvoyer;
    }

    /**
     * @return le btnRetour
     */
    public JButton getBtnRetour() {
        return btnRetour;
    }
    /**
     * @return le chckbxEtudiant
     */
    public JCheckBox getChckbxEtudiant() {
        return chckbxEtudiant;
    }
    /**
     * @param chckbxEtudiant le chckbxEtudiant to set
     */
    public void setChckbxEtudiant(JCheckBox chckbxEtudiant) {
        this.chckbxEtudiant = chckbxEtudiant;
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, this.getHeight(), Color.decode("#3b3b3b"), true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                
    } 
}
