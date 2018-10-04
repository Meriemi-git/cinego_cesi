/*
 * Login.java                                11 déc. 2015
 * CESI RILA 2015/2017
 */
package cineGOv02.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;

import cineGOv02.client.controller.LoginController;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 */
public class LoginUserView extends JPanel {

    /** TODO commenter le Champ */
    private JTextField txtMail;
    /** TODO commenter le Champ */
    private JPasswordField txtMdp;
    /** TODO commenter le Champ */
    private JLabel lblMdp;
    /** TODO commenter le Champ */
    private JLabel lblCreate;
    /** TODO commenter le Champ */
    private JButton btnEnvoyer;
    /** TODO commenter le Champ */
    private JButton btnRetour;
    
    /**
     * Panel de connection pour un utilisateur
     * @param model 
     */
    public LoginUserView(){
        setMaximumSize(new Dimension(285, 275));
        setMinimumSize(new Dimension(285, 275));
        setPreferredSize(new Dimension(285, 275));
        this.setSize(new Dimension(285, 305));
        
        JLabel lblBienvenue = new JLabel("CineGO");
        lblBienvenue.setForeground(SystemColor.textHighlight);
        lblBienvenue.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblBienvenue.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblConnect = new JLabel("Connectez-vous");
        lblConnect.setForeground(Color.WHITE);
        lblConnect.setHorizontalAlignment(SwingConstants.CENTER);
        lblConnect.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblIdentifiant = new JLabel("Identifiant");
        lblIdentifiant.setForeground(Color.WHITE);
        lblIdentifiant.setHorizontalAlignment(SwingConstants.CENTER);
        lblIdentifiant.setFont(new Font("Arial", Font.BOLD, 13));

        txtMail = new JTextField("d0r3mu5@gmail.com");
        txtMail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtMail.setColumns(10);

        JLabel lblMotDePasse = new JLabel("Mot de passe");
        lblMotDePasse.setForeground(Color.WHITE);
        lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
        lblMotDePasse.setFont(new Font("Arial", Font.BOLD, 13));

        txtMdp = new JPasswordField("bA2Xruzq1D");
        txtMdp.setColumns(10);

        lblMdp = new JLabel("Mot de passe perdu ?");
        lblMdp.setFont(new Font("Arial", Font.PLAIN, 12));
        lblMdp.setHorizontalAlignment(SwingConstants.CENTER);
        
        lblMdp.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
        lblMdp.setForeground(SystemColor.textHighlight);

        btnEnvoyer = new JButton("Envoyer");
        btnEnvoyer.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnEnvoyer.setForeground(Color.BLACK);

        JLabel lblcpt = new JLabel("Pas de compte ?");
        lblcpt.setForeground(Color.WHITE);
        lblcpt.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblcpt.setBackground(new Color(240, 240, 240));

        lblCreate = new JLabel("Créez-en un !");
        
        lblCreate.setForeground(SystemColor.textHighlight);
        lblCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        btnRetour = new JButton("Retour");
        btnRetour.setForeground(Color.BLACK);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                            .addGap(98)
                            .addComponent(lblIdentifiant, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                            .addGap(81)
                            .addComponent(lblConnect, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                            .addGap(39)
                            .addComponent(lblcpt, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                            .addGap(10)
                            .addComponent(lblCreate))
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                            .addGap(34)
                            .addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(btnEnvoyer, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                            .addGap(75)
                            .addComponent(lblMdp, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                            .addGap(53)
                            .addComponent(lblBienvenue, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
                    .addGap(35))
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                    .addGap(89)
                    .addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(94, Short.MAX_VALUE))
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                    .addGap(44)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(txtMail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                        .addComponent(txtMdp, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                    .addGap(44))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblBienvenue, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lblConnect, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lblIdentifiant, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addGap(2)
                    .addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(lblMotDePasse, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addGap(3)
                    .addComponent(txtMdp, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblMdp, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnEnvoyer, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblcpt, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCreate, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                    .addGap(13))
        );
        setLayout(groupLayout);

    }
    /**
     * @return le btnRetour
     */
    public JButton getBtnRetour() {
        return btnRetour;
    }
    /**
     * @param btnRetour le btnRetour to set
     */
    public void setBtnRetour(JButton btnRetour) {
        this.btnRetour = btnRetour;
    }
    /**
     * TODO commenter le role de la Méthode
     * @param controller
     */
    public void setController(LoginController controller){
        lblCreate.addMouseListener(controller);
        btnEnvoyer.addActionListener(controller);
        lblMdp.addMouseListener(controller);
        btnRetour.addActionListener(controller);
    }

    /**
     * @return le txtMDP
     */
    public JTextField getMail() {
        return txtMail;
    }
    /**
     * @return le txtMDP
     */
    public JTextField getMdp() {
        return txtMdp;
    }
    /**
     * @return le lblMdp
     */
    public JLabel getLblMdp() {
        return lblMdp;
    }

    /**
     * @return le lblCreate
     */
    public JLabel getLblCreate() {
        return lblCreate;
    }
    /**
     * @return le btnEnvoyer
     */
    public JButton getBtnEnvoyer() {
        return btnEnvoyer;
    } 
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, this.getHeight(), Color.decode("#3b3b3b"), true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                
    }    
}
