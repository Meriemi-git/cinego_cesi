/*
 * UserView.java                                8 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import cineGOv02.client.controller.UserViewController;

import javax.swing.JButton;
import javax.swing.JList;
import java.awt.SystemColor;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class UserView extends JPanel {
    private JLabel lblNom;
    private JLabel lblPrenom;
    private JList listResa;
    private JButton btnDconnexion;
    private JButton btnModifier;
    private JLabel lblSuppression;
    private JLabel lblMail;
    private JLabel lblAvoir;
    public UserView() {
        
        JLabel label = new JLabel("CineGO");
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(new Color(0, 128, 255));
        label.setFont(new Font("Tahoma", Font.BOLD, 40));
        
        JLabel dfds = new JLabel("Nom :");
        dfds.setForeground(Color.LIGHT_GRAY);
        
        JLabel lbl2 = new JLabel("Prenom :");
        lbl2.setForeground(Color.LIGHT_GRAY);
        
        JLabel lbl3 = new JLabel("Mail :");
        lbl3.setForeground(Color.LIGHT_GRAY);
        
        lblNom = new JLabel("New label");
        lblNom.setForeground(Color.LIGHT_GRAY);
        
        lblPrenom = new JLabel("New label");
        lblPrenom.setForeground(Color.LIGHT_GRAY);
        
        lblMail = new JLabel("New label");
        lblMail.setForeground(Color.LIGHT_GRAY);
        
        JLabel lblInformations = new JLabel("Vos informations");
        lblInformations.setForeground(SystemColor.textHighlight);
        lblInformations.setHorizontalAlignment(SwingConstants.CENTER);
        lblInformations.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        btnModifier = new JButton("Modifier");
        listResa = new JList();
        listResa.setBackground(Color.DARK_GRAY);
        listResa.setOpaque(false);
        JScrollPane scroll = new JScrollPane(listResa);
        scroll.setOpaque(false);
        scroll.setBackground(new Color(0f,0f,0f,0f));
       
        
        JLabel lblMotDePasse = new JLabel("Mot de passe :");
        lblMotDePasse.setForeground(Color.LIGHT_GRAY);
        
        JLabel label_4 = new JLabel("***********");
        label_4.setForeground(Color.LIGHT_GRAY);
        
        JLabel lblVosRservations = new JLabel("Vos réservations");
        lblVosRservations.setHorizontalAlignment(SwingConstants.CENTER);
        lblVosRservations.setForeground(SystemColor.textHighlight);
        lblVosRservations.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        btnDconnexion = new JButton("Déconnexion");
        
        JLabel lblSiVousSouhaitez = new JLabel("Si vous souhaitez supprimer votre compte,");
        lblSiVousSouhaitez.setForeground(Color.LIGHT_GRAY);
        
        lblSuppression = new JLabel("cliquez-ici");
        lblSuppression.setForeground(SystemColor.textHighlight);
        
        JLabel lblNewLabel = new JLabel("Avoir :");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setForeground(Color.LIGHT_GRAY);
        
        lblAvoir = new JLabel("");
        lblAvoir.setForeground(SystemColor.textHighlight);
        lblAvoir.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(0)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(104)
                            .addComponent(lblInformations))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(72)
                            .addComponent(dfds)
                            .addGap(70)
                            .addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(87)
                            .addComponent(label))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(46)
                            .addComponent(lblSiVousSouhaitez))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(134)
                            .addComponent(lblSuppression))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(74)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lbl3)
                                .addComponent(lbl2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                            .addGap(39)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblPrenom, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addComponent(lblMail, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(74)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblMotDePasse)
                                .addComponent(lblNewLabel))
                            .addGap(22)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblAvoir)
                                .addComponent(label_4, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
                    .addGap(18))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(112)
                    .addComponent(btnDconnexion)
                    .addContainerGap(113, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(104)
                    .addComponent(lblVosRservations, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(104, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(127)
                    .addComponent(btnModifier)
                    .addContainerGap(127, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(5)
                    .addComponent(label)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblInformations)
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(dfds)
                        .addComponent(lblNom))
                    .addGap(9)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lbl2)
                        .addComponent(lblPrenom))
                    .addGap(12)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lbl3)
                        .addComponent(lblMail))
                    .addGap(12)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblMotDePasse)
                        .addComponent(label_4))
                    .addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblNewLabel)
                        .addComponent(lblAvoir))
                    .addGap(18)
                    .addComponent(btnModifier)
                    .addGap(12)
                    .addComponent(lblVosRservations, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(scroll, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(btnDconnexion)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblSiVousSouhaitez)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblSuppression)
                    .addContainerGap())
        );
        setLayout(groupLayout);
    }
    
    /**
     * TODO commenter le role de la Méthode
     * @param controller
     */
    public void setController(UserViewController controller){
        btnDconnexion.addActionListener(controller);
        btnModifier.addActionListener(controller);
        lblSuppression.addMouseListener(controller);
    }
    /**
     * @return le lblNom
     */
    public JLabel getLblNom() {
        return lblNom;
    }
    /**
     * @param lblNom le lblNom to set
     */
    public void setLblNom(JLabel lblNom) {
        this.lblNom = lblNom;
    }
    /**
     * @return le lblPrenom
     */
    public JLabel getLblPrenom() {
        return lblPrenom;
    }
    /**
     * @param lblPrenom le lblPrenom to set
     */
    public void setLblPrenom(JLabel lblPrenom) {
        this.lblPrenom = lblPrenom;
    }
    /**
     * @return le listResa
     */
    public JList getListResa() {
        return listResa;
    }
    /**
     * @param listResa le listResa to set
     */
    public void setListResa(JList listResa) {
        this.listResa = listResa;
    }
    /**
     * @return le btnDconnexion
     */
    public JButton getBtnDconnexion() {
        return btnDconnexion;
    }
    /**
     * @param btnDconnexion le btnDconnexion to set
     */
    public void setBtnDconnexion(JButton btnDconnexion) {
        this.btnDconnexion = btnDconnexion;
    }
    /**
     * @return le btnModifier
     */
    public JButton getBtnModifier() {
        return btnModifier;
    }
    /**
     * @param btnModifier le btnModifier to set
     */
    public void setBtnModifier(JButton btnModifier) {
        this.btnModifier = btnModifier;
    }
    /**
     * @return le lblSuppression
     */
    public JLabel getLblSuppression() {
        return lblSuppression;
    }
    /**
     * @param lblSuppression le lblSuppression to set
     */
    public void setLblSuppression(JLabel lblSuppression) {
        this.lblSuppression = lblSuppression;
    }
    /**
     * @return le lblMail
     */
    public JLabel getLblMail() {
        return lblMail;
    }

    /**
     * @param lblMail le lblMail to set
     */
    public void setLblMail(JLabel lblMail) {
        this.lblMail = lblMail;
    }

    /**
     * @return le lblAvoir
     */
    public JLabel getLblAvoir() {
        return lblAvoir;
    }

    /**
     * @param lblAvoir le lblAvoir to set
     */
    public void setLblAvoir(JLabel lblAvoir) {
        this.lblAvoir = lblAvoir;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, 800, Color.decode("#3b3b3b"), true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                
    }   
}
