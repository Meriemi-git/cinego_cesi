/*
 * ReservationView.java                                31 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;

import cineGOv02.client.controller.ReservationController;
import cineGOv02.common.graphics.ComboType;

import java.awt.Component;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class ReservationView extends JPanel {
    /** TODO commenter le Champ */
    private JLabel lblRetour;
    /** TODO commenter le Champ */
    private JLabel lblTitre;
    /** TODO commenter le Champ */
    private JLabel lblUser;
    /** TODO commenter le Champ */
    private JComboBox cmbJour;
    /** TODO commenter le Champ */
    private ComboType cmb3DVF;
    /** TODO commenter le Champ */
    private ComboType cmbVF;
    /** TODO commenter le Champ */
    private ComboType cmb3DVOST;
    /** TODO commenter le Champ */
    private ComboType cmdVOST;
    /** TODO commenter le Champ */
    private ComboType cmbVO;
    /** TODO commenter le Champ */
    private JComboBox cmbNbPlace;
    /** TODO commenter le Champ */
    private JLabel lblPrix;
    /** TODO commenter le Champ */
    private JButton btnPayer;
    /** TODO commenter le Champ */
    private JLabel lblAffiche;
    /** TODO commenter le Champ */
    private JButton btnConnexion;
    /** TODO commenter le Champ */
    private JLabel lblCompte;
    /** TODO commenter le Champ */
    private JButton btnCompte;
    /** TODO commenter le Champ */
    private JButton btnDeconnexion;
    /** TODO commenter le Champ */
    private JLabel lblCreate;
    /** TODO */
    private JPanel panel_1;
    /** TODO */
    private JLabel lblPlacesLibres;    
    /** TODO */
    private JButton btnChoix;
    private JLabel lblReduction;
    private JLabel lblNoCompte;
    
    /**
     * TODO commenter le role du Constructeur
     */
    public ReservationView() {
        setSize(new Dimension(1024, 720));
        setPreferredSize(new Dimension(1024, 720));
        setMaximumSize(new Dimension(1024, 720));
        setMinimumSize(new Dimension(1024, 720));
        
        JLabel label = new JLabel("CineGO");
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(new Color(0, 128, 255));
        label.setFont(new Font("Tahoma", Font.BOLD, 40));
        
        lblAffiche = new JLabel("");
        lblAffiche.setOpaque(true);
        lblAffiche.setBackground(SystemColor.windowBorder);
        lblAffiche.setForeground(Color.BLACK);
        
        lblRetour = new JLabel("<< Retour au film");
        lblRetour.setForeground(SystemColor.textHighlight);
        lblRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        lblUser = new JLabel("User");
        lblUser.setForeground(SystemColor.textHighlight);
        lblUser.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUser.setVisible(false);
        
        JLabel lblChoisissezVotreSance = new JLabel("Choisissez votre séance");
        lblChoisissezVotreSance.setForeground(Color.LIGHT_GRAY);
        lblChoisissezVotreSance.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        cmbJour = new JComboBox();
        cmbJour.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        JLabel lblNewLabel_1 = new JLabel("Jour");
        lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        JLabel lblHor = new JLabel("Horaires");
        lblHor.setForeground(Color.LIGHT_GRAY);
        lblHor.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        cmb3DVF = new ComboType();
        cmb3DVOST = new ComboType();
        cmbVF = new ComboType();
        cmdVOST = new ComboType();
        cmbVO = new ComboType();
        
        JLabel lblNewLabel_2 = new JLabel("3D VF");
        lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        JLabel lbldVost = new JLabel("3D VOST");
        lbldVost.setFont(new Font("Tahoma", Font.BOLD, 13));
        lbldVost.setForeground(Color.LIGHT_GRAY);
        
        JLabel lblVf = new JLabel("VF");
        lblVf.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVf.setForeground(Color.LIGHT_GRAY);
        
        JLabel lblVost = new JLabel("VOST");
        lblVost.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblVost.setForeground(Color.LIGHT_GRAY);
        lblVost.setHorizontalTextPosition(SwingConstants.CENTER);
        lblVost.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblVo = new JLabel("VO");
        lblVo.setHorizontalTextPosition(SwingConstants.CENTER);
        lblVo.setHorizontalAlignment(SwingConstants.CENTER);
        lblVo.setForeground(Color.LIGHT_GRAY);
        lblVo.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        JLabel lblNombreDePlaces = new JLabel("Nombre de places :");
        lblNombreDePlaces.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNombreDePlaces.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNombreDePlaces.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreDePlaces.setForeground(Color.LIGHT_GRAY);
        
        cmbNbPlace = new JComboBox();
        
        lblTitre = new JLabel("Titre du film (durée : 00H00)");
        lblTitre.setForeground(SystemColor.textHighlight);
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitre.setHorizontalTextPosition(SwingConstants.CENTER);
        lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
        
        JLabel lblp = new JLabel("Prix :");
        lblp.setRequestFocusEnabled(false);
        lblp.setHorizontalTextPosition(SwingConstants.CENTER);
        lblp.setHorizontalAlignment(SwingConstants.LEFT);
        lblp.setForeground(SystemColor.textHighlight);
        lblp.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        lblPrix = new JLabel("0.00 €");
        lblPrix.setForeground(Color.LIGHT_GRAY);
        lblPrix.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        lblReduction = new JLabel("...");
        lblReduction.setRequestFocusEnabled(false);
        lblReduction.setHorizontalTextPosition(SwingConstants.CENTER);
        lblReduction.setHorizontalAlignment(SwingConstants.LEFT);
        lblReduction.setForeground(SystemColor.textHighlight);
        lblReduction.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        
        btnPayer = new JButton("Payez votre place");
        btnPayer.setSize(new Dimension(116, 28));
        btnPayer.setPreferredSize(new Dimension(116, 28));
        btnPayer.setMinimumSize(new Dimension(116, 28));
        btnPayer.setMaximumSize(new Dimension(116, 28));
        btnPayer.setForeground(Color.GRAY);
        btnPayer.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnPayer.setBackground(SystemColor.textHighlight);
        btnPayer.setEnabled(false);
        
        JLabel lblNewLabel_5 = new JLabel("OU");
        lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        btnChoix = new JButton("Choisissez votre place");
        btnChoix.setSize(new Dimension(116, 28));
        btnChoix.setPreferredSize(new Dimension(116, 28));
        btnChoix.setMinimumSize(new Dimension(116, 28));
        btnChoix.setMaximumSize(new Dimension(116, 28));
        btnChoix.setForeground(Color.GRAY);
        btnChoix.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnChoix.setBackground(Color.LIGHT_GRAY);
        btnChoix.setEnabled(false);
        
        JLabel lblMajorationDe = new JLabel("Majoration de 0.25€ sur le prix de la place");
        lblMajorationDe.setForeground(Color.LIGHT_GRAY);
        lblMajorationDe.setFont(new Font("Tahoma", Font.ITALIC, 12));
        
        lblNoCompte = new JLabel("Pas encore de compte ?");
        lblNoCompte.setForeground(Color.LIGHT_GRAY);
        lblNoCompte.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        lblCreate = new JLabel("Créez-en un !");
        lblCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCreate.setForeground(SystemColor.textHighlight);
        
        btnConnexion = new JButton("Connectez-vous");
        btnConnexion.setForeground(SystemColor.textHighlight);
        btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        panel_1 = new JPanel();
        panel_1.setOpaque(false);
        panel_1.setMaximumSize(new Dimension(225, 82));
        panel_1.setMinimumSize(new Dimension(285, 222));
        panel_1.setSize(new Dimension(225, 82));
        panel_1.setPreferredSize(new Dimension(225, 82));
        
        lblPlacesLibres = new JLabel("");
        lblPlacesLibres.setForeground(Color.LIGHT_GRAY);
        lblPlacesLibres.setFont(new Font("Tahoma", Font.BOLD, 13));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(146)
                            .addComponent(lblRetour)
                            .addGap(178)
                            .addComponent(label)
                            .addPreferredGap(ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                            .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(64)
                                    .addComponent(lblAffiche, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(101)
                                    .addComponent(btnConnexion, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(119)
                                    .addComponent(lblNoCompte)))
                            .addGap(35)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(lblChoisissezVotreSance, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(ComponentPlacement.RELATED)
                                    .addComponent(lblUser))
                                .addComponent(lblNewLabel_1)
                                .addComponent(cmbJour, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblHor, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(17)
                                    .addComponent(lblNewLabel_2)
                                    .addGap(90)
                                    .addComponent(lbldVost)
                                    .addGap(101)
                                    .addComponent(lblVf)
                                    .addGap(110)
                                    .addComponent(lblVost)
                                    .addGap(112)
                                    .addComponent(lblVo))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(cmb3DVF, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addGap(60)
                                    .addComponent(cmb3DVOST, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addGap(60)
                                    .addComponent(cmbVF, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addGap(60)
                                    .addComponent(cmdVOST, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                    .addGap(60)
                                    .addComponent(cmbVO, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(lblNombreDePlaces)
                                    .addGap(18)
                                    .addComponent(cmbNbPlace, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addGap(28)
                                    .addComponent(lblPlacesLibres))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(lblp, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18)
                                    .addComponent(lblPrix, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                    .addGap(38)
                                    .addComponent(lblReduction, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(btnPayer, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                                    .addGap(11)
                                    .addComponent(lblNewLabel_5)
                                    .addGap(42)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                            .addGap(6)
                                            .addComponent(lblMajorationDe))
                                        .addComponent(btnChoix, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(156)
                            .addComponent(lblCreate)))
                    .addContainerGap(7, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(5)
                                    .addComponent(label, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(lblRetour)
                            .addPreferredGap(ComponentPlacement.UNRELATED)))
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblAffiche, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(lblTitre)
                            .addGap(33)
                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(lblChoisissezVotreSance)
                                .addComponent(lblUser))
                            .addGap(18)
                            .addComponent(lblNewLabel_1)
                            .addGap(6)
                            .addComponent(cmbJour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(lblHor)
                            .addGap(14)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblNewLabel_2)
                                .addComponent(lbldVost)
                                .addComponent(lblVf)
                                .addComponent(lblVost)
                                .addComponent(lblVo))
                            .addGap(6)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(cmb3DVF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmb3DVOST, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbVF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmdVOST, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbVO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(32)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(4)
                                    .addComponent(lblNombreDePlaces))
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                    .addComponent(cmbNbPlace, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPlacesLibres)))
                            .addGap(69)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(2)
                                    .addComponent(lblp, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblPrix)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(2)
                                    .addComponent(lblReduction)))))
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(39)
                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(btnPayer, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChoix, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNewLabel_5))
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(lblMajorationDe))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(18)
                            .addComponent(btnConnexion, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(lblNoCompte)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(lblCreate)))
                    .addGap(116))
        );
        
        lblCompte = new JLabel("Bienvenue User");
        lblCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblCompte.setForeground(SystemColor.textHighlight);
        lblCompte.setVisible(false);
        
        btnCompte = new JButton("Mon compte");
        btnCompte.setBackground(SystemColor.textHighlight);
        btnCompte.setForeground(Color.WHITE);
        btnCompte.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnDeconnexion.setForeground(SystemColor.textHighlight);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGap(14)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblCompte)
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addComponent(btnCompte)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(btnDeconnexion)))
                    .addGap(1))
        );
        gl_panel_1.setVerticalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGap(19)
                    .addComponent(lblCompte)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnCompte)
                        .addComponent(btnDeconnexion))
                    .addContainerGap(26, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        btnDeconnexion.setVisible(false);
        btnCompte.setVisible(false);
        setLayout(groupLayout);
    }
    
    
    /**
     * @return le lblNoCompte
     */
    public JLabel getLblNoCompte() {
        return lblNoCompte;
    }


    /**
     * @param lblNoCompte le lblNoCompte to set
     */
    public void setLblNoCompte(JLabel lblNoCompte) {
        this.lblNoCompte = lblNoCompte;
    }


    /**
     * @return le lblReduction
     */
    public JLabel getLblReduction() {
        return lblReduction;
    }


    /**
     * @param lblReduction le lblReduction to set
     */
    public void setLblReduction(JLabel lblReduction) {
        this.lblReduction = lblReduction;
    }


    /**
     * @return le btnChoix
     */
    public JButton getBtnChoix() {
        return btnChoix;
    }


    /**
     * @param btnChoix le btnChoix to set
     */
    public void setBtnChoix(JButton btnChoix) {
        this.btnChoix = btnChoix;
    }


    /**
     * @return le lblPlacesLibres
     */
    public JLabel getLblPlacesLibres() {
        return lblPlacesLibres;
    }


    /**
     * @param lblPlacesLibres le lblPlacesLibres to set
     */
    public void setLblPlacesLibres(JLabel lblPlacesLibres) {
        this.lblPlacesLibres = lblPlacesLibres;
    }


    /**
     * @return le lblCreate
     */
    public JLabel getLblCreate() {
        return lblCreate;
    }


    /**
     * @param lblCreate le lblCreate to set
     */
    public void setLblCreate(JLabel lblCreate) {
        this.lblCreate = lblCreate;
    }


    /**
     * TODO commenter le role du Constructeur
     * @param controller 
     */
    public void setController(ReservationController controller) {
        this.lblRetour.addMouseListener(controller); 
        this.lblTitre.addMouseListener(controller); 
        this.lblUser.addMouseListener(controller); 
        this.cmbJour.addActionListener(controller);
        this.cmb3DVF.addActionListener(controller);
        this.cmbVF.addActionListener(controller);
        this.cmb3DVOST.addActionListener(controller);
        this.cmdVOST.addActionListener(controller);
        this.cmbVO.addActionListener(controller);
        this.cmbNbPlace.addActionListener(controller);
        this.lblPrix.addMouseListener(controller); 
        this.btnPayer.addMouseListener(controller); 
        this.lblAffiche.addMouseListener(controller); 
        this.btnConnexion.addActionListener(controller); 
        this.lblCreate.addMouseListener(controller); 
        this.btnCompte.addActionListener(controller); 
        this.btnDeconnexion.addActionListener(controller);
        this.btnPayer.addActionListener(controller);
        this.btnChoix.addActionListener(controller);
    }

    /**
     * @return le lblRetour
     */
    public JLabel getLblRetour() {
        return lblRetour;
    }
    /**
     * @param lblRetour le lblRetour to set
     */
    public void setLblRetour(JLabel lblRetour) {
        this.lblRetour = lblRetour;
    }
    /**
     * @return le lblTitre
     */
    public JLabel getLblTitre() {
        return lblTitre;
    }
    /**
     * @param lblTitre le lblTitre to set
     */
    public void setLblTitre(JLabel lblTitre) {
        this.lblTitre = lblTitre;
    }
    /**
     * @return le lblUser
     */
    public JLabel getLblUser() {
        return lblUser;
    }
    /**
     * @param lblUser le lblUser to set
     */
    public void setLblUser(JLabel lblUser) {
        this.lblUser = lblUser;
    }
    /**
     * @return le cmbJour
     */
    public JComboBox getCmbJour() {
        return cmbJour;
    }
    /**
     * @param cmbJour le cmbJour to set
     */
    public void setCmbJour(JComboBox cmbJour) {
        this.cmbJour = cmbJour;
    }
    /**
     * @return le cmb3DVF
     */
    public ComboType getCmb3DVF() {
        return cmb3DVF;
    }
    /**
     * @param cmb3dvf le cmb3DVF to set
     */
    public void setCmb3DVF(ComboType cmb3dvf) {
        cmb3DVF = cmb3dvf;
    }
    /**
     * @return le cmbVF
     */
    public ComboType getCmbVF() {
        return cmbVF;
    }
    /**
     * @param cmbVF le cmbVF to set
     */
    public void setCmbVF(ComboType cmbVF) {
        this.cmbVF = cmbVF;
    }
    /**
     * @return le cmb3DVOST
     */
    public ComboType getCmb3DVOST() {
        return cmb3DVOST;
    }
    /**
     * @param cmb3dvost le cmb3DVOST to set
     */
    public void setCmb3DVOST(ComboType cmb3dvost) {
        cmb3DVOST = cmb3dvost;
    }
    /**
     * @return le cmdVOST
     */
    public ComboType getCmdVOST() {
        return cmdVOST;
    }
    /**
     * @param cmdVOST le cmdVOST to set
     */
    public void setCmdVOST(ComboType cmdVOST) {
        this.cmdVOST = cmdVOST;
    }
    /**
     * @return le cmbVO
     */
    public JComboBox getCmbVO() {
        return cmbVO;
    }
    /**
     * @param cmbVO le cmbVO to set
     */
    public void setCmbVO(ComboType cmbVO) {
        this.cmbVO = cmbVO;
    }
    /**
     * @return le cmbNbPlace
     */
    public JComboBox getCmbNbPlace() {
        return cmbNbPlace;
    }
    /**
     * @param cmbNbPlace le cmbNbPlace to set
     */
    public void setCmbNbPlace(JComboBox cmbNbPlace) {
        this.cmbNbPlace = cmbNbPlace;
    }
    /**
     * @return le lblPrix
     */
    public JLabel getLblPrix() {
        return lblPrix;
    }
    /**
     * @param lblPrix le lblPrix to set
     */
    public void setLblPrix(JLabel lblPrix) {
        this.lblPrix = lblPrix;
    }
    /**
     * @return le btnPayer
     */
    public JButton getBtnPayer() {
        return btnPayer;
    }
    /**
     * @param btnPayer le btnPayer to set
     */
    public void setBtnPayer(JButton btnPayer) {
        this.btnPayer = btnPayer;
    }
    /**
     * @return le lblAffiche
     */
    public JLabel getLblAffiche() {
        return lblAffiche;
    }
    /**
     * @param lblAffiche le lblAffiche to set
     */
    public void setLblAffiche(JLabel lblAffiche) {
        this.lblAffiche = lblAffiche;
    }
    /**
     * @return le btnConnexion
     */
    public JButton getBtnConnexion() {
        return btnConnexion;
    }


    /**
     * @param btnConnexion le btnConnexion to set
     */
    public void setBtnConnexion(JButton btnConnexion) {
        this.btnConnexion = btnConnexion;
    }


    /**
     * @return le lblCompte
     */
    public JLabel getLblCompte() {
        return lblCompte;
    }


    /**
     * @param lblCompte le lblCompte to set
     */
    public void setLblCompte(JLabel lblCompte) {
        this.lblCompte = lblCompte;
    }


    /**
     * @return le btnCompte
     */
    public JButton getBtnCompte() {
        return btnCompte;
    }


    /**
     * @param btnCompte le btnCompte to set
     */
    public void setBtnCompte(JButton btnCompte) {
        this.btnCompte = btnCompte;
    }


    /**
     * @return le btnDeconnexion
     */
    public JButton getBtnDeconnexion() {
        return btnDeconnexion;
    }


    /**
     * @param btnDeconnexion le btnDeconnexion to set
     */
    public void setBtnDeconnexion(JButton btnDeconnexion) {
        this.btnDeconnexion = btnDeconnexion;
    }
    
    public ArrayList<ComboType> getType(){
        ArrayList<ComboType> list = new ArrayList<ComboType>();
        list.add(cmb3DVF);
        list.add(cmbVF);
        list.add(cmb3DVOST);
        list.add(cmdVOST);
        list.add(cmbVO);
        return list;
        
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, 800, Color.decode("#3b3b3b"), true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                
    } 
}
