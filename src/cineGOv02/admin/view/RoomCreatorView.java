/*
 * RoomCreatorView.java                                10 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.admin.view;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;

import cineGOv02.admin.controller.RoomCreatorController;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class RoomCreatorView extends JPanel {
    /** TODO commenter le Champ */
    private JPanel plan;
    private JLabel lblSiege;
    private JLabel lblSiegeHand;
    private BufferedImage bufferImage;
    private ImageIcon iconeSiege;
    private ImageIcon iconeSiegeHand;
    private ImageIcon iconeAllee;
    private JRadioButton rdbSiegeNormal;
    private JRadioButton rdbSiegeHand;
    private JLabel labelAlle;
    private JRadioButton rdbAllee;
    private JLabel lblGnrerUnPlan;
    private JLabel lblRanges;
    private JLabel lblSiges;
    private JTextField txtColonnes;
    /** TODO commenter le Champ */
    private JButton btnGenerer;
    /** TODO commenter le Champ */
    private JTextField txtRangees;
    /** TODO commenter le Champ */
    private JScrollPane scrollPane;
    private JButton btnExporter;
    private JButton btnEnregistrer;
    private ImageIcon imagePorte;
    private JLabel labelPorte;
    /** TODO commenter le Champ */
    private JRadioButton rdbPorte;
    
    /**
     * @return le rdbPorte
     */
    public JRadioButton getRdbPorte() {
        return rdbPorte;
    }
    /**
     * @param rdbPorte le rdbPorte to set
     */
    public void setRdbPorte(JRadioButton rdbPorte) {
        this.rdbPorte = rdbPorte;
    }
    public RoomCreatorView() {
        try {
            bufferImage = ImageIO.read(new File("siege.png"));
            iconeSiege = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("siegeHand.png"));
            iconeSiegeHand = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("allee.png"));
            iconeAllee = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("porte.png"));
            imagePorte = new ImageIcon(bufferImage);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.scrollbar);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.controlShadow);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                        .addContainerGap())
                );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                .addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                                .addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                        .addContainerGap())
                );
        
        JLabel lblEditeurDeSalle = new JLabel("Editeur de salle");
        lblEditeurDeSalle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblEditeurDeSalle.setForeground(SystemColor.textHighlight);
        
        JLabel lblAjoutDeSiges = new JLabel("Placement des éléments");
        lblAjoutDeSiges.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        rdbSiegeNormal = new JRadioButton("Siège classqiue");
        rdbSiegeNormal.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        lblSiege = new JLabel("");
        lblSiege.setPreferredSize(new Dimension(44, 44));
        lblSiege.setSize(new Dimension(44, 44));
        lblSiege.setMinimumSize(new Dimension(44, 44));
        lblSiege.setMaximumSize(new Dimension(44, 44));
        lblSiege.setIcon(iconeSiege);
        
        lblSiegeHand = new JLabel("");
        lblSiegeHand.setSize(new Dimension(44, 44));
        lblSiegeHand.setPreferredSize(new Dimension(44, 44));
        lblSiegeHand.setMinimumSize(new Dimension(44, 44));
        lblSiegeHand.setMaximumSize(new Dimension(44, 44));
        lblSiegeHand.setIcon(iconeSiegeHand);
        
        rdbSiegeHand = new JRadioButton("Siège handicapée");
        rdbSiegeHand.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        labelAlle = new JLabel("");
        labelAlle.setBackground(SystemColor.windowBorder);
        labelAlle.setSize(new Dimension(44, 44));
        labelAlle.setPreferredSize(new Dimension(44, 44));
        labelAlle.setMinimumSize(new Dimension(44, 44));
        labelAlle.setMaximumSize(new Dimension(44, 44));
        labelAlle.setIcon(iconeAllee);
        
        rdbAllee = new JRadioButton("Allée");
        rdbAllee.setFont(new Font("Tahoma", Font.PLAIN, 12));
       
        rdbSiegeNormal.setSelected(true);
        
        lblGnrerUnPlan = new JLabel("Générer un plan de salle");
        lblGnrerUnPlan.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        lblRanges = new JLabel("Rangées :");
        lblRanges.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        lblSiges = new JLabel("Colonnes :");
        lblSiges.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        txtRangees = new JTextField();
        txtRangees.setColumns(10);
        
        txtColonnes = new JTextField();
        txtColonnes.setColumns(10);
        
        btnGenerer = new JButton("Générer");
        
        btnExporter = new JButton("Exporter");
        
        btnEnregistrer = new JButton("Enregistrer");
        
        labelPorte = new JLabel("");
        labelPorte.setSize(new Dimension(44, 44));
        labelPorte.setPreferredSize(new Dimension(44, 44));
        labelPorte.setMinimumSize(new Dimension(44, 44));
        labelPorte.setMaximumSize(new Dimension(44, 44));
        labelPorte.setBackground(SystemColor.windowBorder);
        labelPorte.setIcon(imagePorte);
        
        rdbPorte = new JRadioButton("Porte");
        rdbPorte.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdbSiegeNormal);
        btnGroup.add(rdbSiegeHand);
        btnGroup.add(rdbAllee);
        btnGroup.add(rdbPorte);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(65)
                            .addComponent(lblEditeurDeSalle))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(55)
                            .addComponent(lblGnrerUnPlan))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(68)
                            .addComponent(lblRanges)
                            .addGap(6)
                            .addComponent(txtRangees, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(65)
                            .addComponent(lblSiges)
                            .addGap(6)
                            .addComponent(txtColonnes, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(92)
                            .addComponent(btnGenerer))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(55)
                            .addComponent(lblAjoutDeSiges))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(33)
                            .addComponent(lblSiege, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(rdbSiegeNormal))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(33)
                            .addComponent(lblSiegeHand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(rdbSiegeHand, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(33)
                            .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
                                .addGroup(gl_panel.createSequentialGroup()
                                    .addComponent(btnEnregistrer)
                                    .addGap(18)
                                    .addComponent(btnExporter))
                                .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                                    .addGroup(gl_panel.createSequentialGroup()
                                        .addComponent(labelPorte, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18)
                                        .addComponent(rdbPorte, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(gl_panel.createSequentialGroup()
                                        .addComponent(labelAlle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18)
                                        .addComponent(rdbAllee, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))))))
                    .addGap(29))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(6)
                    .addComponent(lblEditeurDeSalle)
                    .addGap(18)
                    .addComponent(lblGnrerUnPlan)
                    .addGap(6)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(7)
                            .addComponent(lblRanges))
                        .addComponent(txtRangees, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(6)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(7)
                            .addComponent(lblSiges))
                        .addComponent(txtColonnes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(6)
                    .addComponent(btnGenerer)
                    .addGap(18)
                    .addComponent(lblAjoutDeSiges)
                    .addGap(17)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSiege, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(11)
                            .addComponent(rdbSiegeNormal)))
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(18)
                            .addComponent(lblSiegeHand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(31)
                            .addComponent(rdbSiegeHand)))
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(18)
                            .addComponent(labelAlle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(32)
                            .addComponent(rdbAllee)))
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(18)
                            .addComponent(labelPorte, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(31)
                            .addComponent(rdbPorte)))
                    .addGap(72)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnEnregistrer)
                        .addComponent(btnExporter))
                    .addGap(167))
        );
        panel.setLayout(gl_panel);

        plan = new JPanel();
        scrollPane = new JScrollPane(plan);
        scrollPane.setWheelScrollingEnabled(false);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)
        );
        gl_panel_1.setVerticalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE)
        );
        panel_1.setLayout(gl_panel_1);
        setLayout(groupLayout);
    }
    /**
     * @return le scrollPane
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }
    /**
     * @param scrollPane le scrollPane to set
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
    /**
     * @return le rdbSiegeNormal
     */
    public JRadioButton getRdbSiegeNormal() {
        return rdbSiegeNormal;
    }
    /**
     * @param rdbSiegeNormal le rdbSiegeNormal to set
     */
    public void setRdbSiegeNormal(JRadioButton rdbSiegeNormal) {
        this.rdbSiegeNormal = rdbSiegeNormal;
    }
    /**
     * @return le rdbSiegeHand
     */
    public JRadioButton getRdbSiegeHand() {
        return rdbSiegeHand;
    }
    /**
     * @param rdbSiegeHand le rdbSiegeHand to set
     */
    public void setRdbSiegeHand(JRadioButton rdbSiegeHand) {
        this.rdbSiegeHand = rdbSiegeHand;
    }
    /**
     * @return le rdbAllee
     */
    public JRadioButton getRdbAllee() {
        return rdbAllee;
    }
    /**
     * @param rdbAllee le rdbAllee to set
     */
    public void setRdbAllee(JRadioButton rdbAllee) {
        this.rdbAllee = rdbAllee;
    }
    /**
     * @return le plan
     */
    public JPanel getPlan() {
        return plan;
    }
    /**
     * @param plan le plan to set
     */
    public void setPlan(JPanel plan) {
        this.plan = plan;
    }
    /**
     * @return le txtColonnes
     */
    public JTextField getTxtColonnes() {
        return txtColonnes;
    }
    /**
     * @param txtColonnes le txtColonnes to set
     */
    public void setTxtColonnes(JTextField txtColonnes) {
        this.txtColonnes = txtColonnes;
    }
    /**
     * @return le txtRangees
     */
    public JTextField getTxtRangees() {
        return txtRangees;
    }
    /**
     * @param txtRangees le txtRangees to set
     */
    public void setTxtRangees(JTextField txtRangees) {
        this.txtRangees = txtRangees;
    }
    /**
     * @return le btnGenerer
     */
    public JButton getBtnGenerer() {
        return btnGenerer;
    }
    /**
     * @param btnGenerer le btnGenerer to set
     */
    public void setBtnGenerer(JButton btnGenerer) {
        this.btnGenerer = btnGenerer;
    }
    /**
     * @return le btnExporter
     */
    public JButton getBtnExporter() {
        return btnExporter;
    }
    /**
     * @param btnExporter le btnExporter to set
     */
    public void setBtnExporter(JButton btnExporter) {
        this.btnExporter = btnExporter;
    }
    /**
     * @return le btnEnregistrer
     */
    public JButton getBtnEnregistrer() {
        return btnEnregistrer;
    }
    /**
     * @param btnEnregistrer le btnEnregistrer to set
     */
    public void setBtnEnregistrer(JButton btnEnregistrer) {
        this.btnEnregistrer = btnEnregistrer;
    }
    /**
     * TODO commenter le role de la Méthode
     * @param roomCreatorController
     */
    public void setController(RoomCreatorController roomCreatorController) {
        btnGenerer.addActionListener(roomCreatorController);
        btnExporter.addActionListener(roomCreatorController);
        btnEnregistrer.addActionListener(roomCreatorController);
        txtColonnes.addKeyListener(roomCreatorController);
        txtRangees.addKeyListener(roomCreatorController);
    }
}
