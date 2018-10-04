/*
 * RecoverPasswordView.java                                13 déc. 2015
 * CESI RILA 2015/2017
 */
package cineGOv02.client.view;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.SwingConstants;

import cineGOv02.client.controller.RecoverPasswdController;
import cineGOv02.common.util.EmailVerifier;

import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class RecoverPasswdView extends JPanel {
    /** TODO commenter le Champ */
    private JButton btnEnvoyer;
    /** TODO commenter le Champ */
    private JButton btnRetour;
    /** TODO commenter le Champ */
    private JFormattedTextField txtMail;
    /** TODO commenter le Champ */
    public static final String MAIL_NOT_FOUND = "Aucun compte associé à cette mail";
    /** TODO commenter le Champ */
    public static final String MSG_RECOVER_MAIL = "Un email contenant votre mot"
            + " de passe vous as été envoyé.";

    /**
     * TODO commenter le role du Constructeur
     * @param model
     */
    public RecoverPasswdView(){
        setMinimumSize(new Dimension(285, 275));
        setPreferredSize(new Dimension(285, 275));
        this.setSize(new Dimension(285, 275));

        JLabel lblSaisissezVotreEmail = new JLabel("Pour retrouver votre mot de passe");
        lblSaisissezVotreEmail.setForeground(Color.WHITE);
        lblSaisissezVotreEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblSaisissezVotreEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblVeuillezRenseignerVotre = new JLabel("veuillez renseigner votre email.");
        lblVeuillezRenseignerVotre.setForeground(Color.WHITE);
        lblVeuillezRenseignerVotre.setHorizontalAlignment(SwingConstants.CENTER);
        lblVeuillezRenseignerVotre.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblVotreMail = new JLabel("Saisissez votre mail ");
        lblVotreMail.setForeground(Color.WHITE);
        lblVotreMail.setHorizontalAlignment(SwingConstants.CENTER);
        lblVotreMail.setFont(new Font("Arial", Font.BOLD, 13));

        txtMail = new JFormattedTextField("d0r3mu5@gmail.com");
        txtMail.setHorizontalAlignment(SwingConstants.CENTER);
        txtMail.setFont(new Font("SansSerif", Font.PLAIN, 13));
        EmailVerifier emailVerifier = new EmailVerifier();
        txtMail.setInputVerifier(emailVerifier);

        btnEnvoyer = new JButton("Envoyer");
        btnEnvoyer.setFont(new Font("Arial", Font.BOLD, 12));

        btnRetour = new JButton("Retour");
        btnRetour.setFont(new Font("Arial", Font.PLAIN, 12));

        JLabel label = new JLabel("CineGO");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(SystemColor.textHighlight);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(53)
                            .addComponent(label, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(13)
                            .addComponent(lblVeuillezRenseignerVotre, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(13)
                            .addComponent(lblSaisissezVotreEmail, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(72)
                            .addComponent(lblVotreMail, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(52)
                            .addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(45)
                            .addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addGap(25)
                            .addComponent(btnEnvoyer, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(13, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(12)
                    .addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblSaisissezVotreEmail, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblVeuillezRenseignerVotre, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addGap(22)
                    .addComponent(lblVotreMail, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addGap(37)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnEnvoyer, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(41))
        );
        setLayout(groupLayout);
    }

    /**
     * TODO commenter le role de la Méthode
     */
    public void setController(RecoverPasswdController controller){
        btnEnvoyer.addActionListener(controller);
        btnRetour.addActionListener(controller);
    }

    /**
     * @return le btnEnvoyer
     */
    public JButton getBtnEnvoyer() {
        return btnEnvoyer;
    }

    /**
     * @return le txtMail
     */
    public JFormattedTextField getTxtMail() {
        return txtMail;
    }
    
    /**
     * @return le btnRetour
     */
    public JButton getBtnRetour() {
        return btnRetour;
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, this.getHeight(), Color.decode("#3b3b3b"), true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                
    }  
}
