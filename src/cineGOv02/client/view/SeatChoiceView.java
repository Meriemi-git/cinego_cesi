/*
 * RoomCreatorView.java                                10 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.view;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;

import cineGOv02.admin.controller.RoomCreatorController;
import cineGOv02.client.controller.SeatChoiceController;

import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class SeatChoiceView extends JPanel implements ActionListener {
    /** TODO */
    private SeatChoiceController controller;
    /** TODO commenter le Champ */
    private JPanel plan;
    /** TODO commenter le Champ */
    private JLabel lblSiegeNormal;
    /** TODO commenter le Champ */
    private BufferedImage bufferImage;
    /** TODO commenter le Champ */
    private ImageIcon iconeSiege;
    /** TODO commenter le Champ */
    private ImageIcon iconeSiegeHand;
    /** TODO commenter le Champ */
    private ImageIcon iconeSiegeOccupe;
    /** TODO commenter le Champ */
    private JRadioButton rdbProche;
    /** TODO commenter le Champ */
    private JRadioButton rdbLoin;
    /** TODO commenter le Champ */
    private JLabel lblSiegeHand;
    /** TODO commenter le Champ */
    private JLabel lblInfos;
    /** TODO commenter le Champ */
    private JScrollPane scrollPane;
    /** TODO commenter le Champ */
    private JButton btnPlacer;
    /** TODO commenter le Champ */
    private JLabel lblSiegeOccupe;
    /** TODO commenter le Champ */
    private JRadioButton rdbMilieu;
    /** TODO commenter le Champ */
    private JTextArea txtrSelectionnezSurLe;
    /** TODO commenter le Champ */
    private JLabel lblNewLabel;
    /** TODO commenter le Champ */
    private JTextField txtNbPlaceHand;
    /** TODO commenter le Champ */
    private JLabel lblPlacementAutomatique;
    /** TODO commenter le Champ */
    private JLabel lblLgende;
    /** TODO commenter le Champ */
    private JLabel lblNewLabel_1;
    /** TODO commenter le Champ */
    private JLabel lblSigeHandicap;
    /** TODO commenter le Champ */
    private JLabel lblSigeOccup;
    /** TODO commenter le Champ */
    private JCheckBox chckbxPlcmtAuto;
    /** TODO commenter le Champ */
    private JLabel lblNbPlace;
    /** TODO commenter le Champ */
    private JLabel lblNewLabel_2;
    /** TODO commenter le Champ */
    private JButton btnReinit;
    /** TODO commenter le Champ */
    private JButton btnAnnuler;
    /** TODO commenter le Champ */
    private JButton btnConfirmer;
    
    
    public SeatChoiceView() {
        setBackground(Color.BLACK);
        try {
            bufferImage = ImageIO.read(new File("siege.png"));
            iconeSiege = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("siegeHand.png"));
            iconeSiegeHand = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("siegeOccupe.png"));
            iconeSiegeOccupe = new ImageIcon(bufferImage);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

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
        
        JLabel lblEditeurDeSalle = new JLabel("CineGO");
        lblEditeurDeSalle.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblEditeurDeSalle.setForeground(SystemColor.textHighlight);
        
        rdbProche = new JRadioButton("Près de l'écran");
        rdbProche.setEnabled(false);
        rdbProche.setForeground(Color.WHITE);
        rdbProche.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        lblSiegeNormal = new JLabel("");
        lblSiegeNormal.setSize(new Dimension(44, 44));
        lblSiegeNormal.setPreferredSize(new Dimension(44, 44));
        lblSiegeNormal.setMinimumSize(new Dimension(44, 44));
        lblSiegeNormal.setMaximumSize(new Dimension(44, 44));
        lblSiegeNormal.setIcon(iconeSiege);
        
        rdbLoin = new JRadioButton("Loin de l'écran");
        rdbLoin.setEnabled(false);
        rdbLoin.setForeground(Color.WHITE);
        rdbLoin.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        lblSiegeHand = new JLabel("");
        lblSiegeHand.setBackground(SystemColor.windowBorder);
        lblSiegeHand.setSize(new Dimension(44, 44));
        lblSiegeHand.setPreferredSize(new Dimension(44, 44));
        lblSiegeHand.setMinimumSize(new Dimension(44, 44));
        lblSiegeHand.setMaximumSize(new Dimension(44, 44));
        lblSiegeHand.setIcon(iconeSiegeHand);
       
        rdbProche.setSelected(true);
        
        lblInfos = new JLabel("Informations");
        lblInfos.setForeground(SystemColor.textHighlight);
        lblInfos.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        btnPlacer = new JButton("Placement");
        btnPlacer.setEnabled(false);
        btnPlacer.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnPlacer.setForeground(SystemColor.textHighlight);
        
        lblSiegeOccupe = new JLabel("");
        lblSiegeOccupe.setSize(new Dimension(44, 44));
        lblSiegeOccupe.setPreferredSize(new Dimension(44, 44));
        lblSiegeOccupe.setMinimumSize(new Dimension(44, 44));
        lblSiegeOccupe.setMaximumSize(new Dimension(44, 44));
        lblSiegeOccupe.setBackground(SystemColor.windowBorder);
        lblSiegeOccupe.setIcon(iconeSiegeOccupe);
        
        rdbMilieu = new JRadioButton("Au milieu");
        rdbMilieu.setEnabled(false);
        rdbMilieu.setForeground(Color.WHITE);
        rdbMilieu.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdbProche);
        btnGroup.add(rdbLoin);
        btnGroup.add(rdbMilieu);
        
        txtrSelectionnezSurLe = new JTextArea();
        txtrSelectionnezSurLe.setBorder(null);
        txtrSelectionnezSurLe.setForeground(Color.WHITE);
        txtrSelectionnezSurLe.setBackground(Color.BLACK);
        txtrSelectionnezSurLe.setText("Selectionnez sur le plan l'emplacement\r\n des places que vous avez réservé. \r\nVous pouvez également opter \r\npour un placement automatique.");
        
        JLabel lblPlacement = new JLabel("Placement manuel");
        lblPlacement.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlacement.setForeground(SystemColor.textHighlight);
        lblPlacement.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        JLabel lblPlacesRestantes = new JLabel("Places restantes :");
        lblPlacesRestantes.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPlacesRestantes.setForeground(Color.WHITE);
        
        lblNbPlace = new JLabel("0");
        lblNbPlace.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNbPlace.setForeground(Color.WHITE);
        
        chckbxPlcmtAuto = new JCheckBox("Activer le placement automatique");
        chckbxPlcmtAuto.setForeground(Color.WHITE);
        chckbxPlcmtAuto.addActionListener(this);
        
        lblNewLabel = new JLabel("Places handicapées :");
        lblNewLabel.setForeground(Color.WHITE);
        
        txtNbPlaceHand = new JTextField();
        txtNbPlaceHand.setEnabled(false);
        txtNbPlaceHand.setColumns(10);
        
        lblPlacementAutomatique = new JLabel("Placement automatique");
        lblPlacementAutomatique.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlacementAutomatique.setForeground(SystemColor.textHighlight);
        lblPlacementAutomatique.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        lblLgende = new JLabel("Légende");
        lblLgende.setHorizontalAlignment(SwingConstants.CENTER);
        lblLgende.setForeground(SystemColor.textHighlight);
        lblLgende.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        lblNewLabel_1 = new JLabel("Siège normal");
        lblNewLabel_1.setForeground(Color.WHITE);
        
        lblSigeHandicap = new JLabel("Siège handicapé");
        lblSigeHandicap.setForeground(Color.WHITE);
        
        lblSigeOccup = new JLabel("Siège occupé");
        lblSigeOccup.setForeground(Color.WHITE);
        
        lblNewLabel_2 = new JLabel("_________________________________");
        lblNewLabel_2.setForeground(SystemColor.textHighlight);
        
        btnAnnuler = new JButton("Annuler");
        btnAnnuler.setForeground(SystemColor.textHighlight);
        btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAnnuler.setEnabled(false);
        
        btnConfirmer = new JButton("Confirmer");
        btnConfirmer.setForeground(SystemColor.textHighlight);
        btnConfirmer.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnConfirmer.setEnabled(false);
        
        btnReinit = new JButton("Réinitialiser");
        btnReinit.setForeground(SystemColor.textHighlight);
        btnReinit.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnReinit.setEnabled(false);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(70)
                    .addComponent(lblEditeurDeSalle))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(85)
                    .addComponent(lblInfos))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(21)
                    .addComponent(txtrSelectionnezSurLe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(64)
                    .addComponent(lblPlacement, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(6)
                    .addComponent(lblNewLabel)
                    .addGap(12)
                    .addComponent(txtNbPlaceHand, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rdbMilieu, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                    .addGap(15)
                    .addComponent(btnPlacer))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(13)
                    .addComponent(lblNewLabel_2))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(13)
                    .addComponent(btnAnnuler, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                    .addGap(49)
                    .addComponent(btnConfirmer, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(61)
                    .addComponent(lblLgende, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(6)
                    .addComponent(lblSiegeNormal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblNewLabel_1))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(6)
                    .addComponent(lblSiegeHand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblSigeHandicap, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(6)
                    .addComponent(lblSiegeOccupe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblSigeOccup, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                    .addGap(246))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(38)
                    .addComponent(lblPlacementAutomatique, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(6)
                    .addComponent(lblPlacesRestantes)
                    .addGap(12)
                    .addComponent(lblNbPlace, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(73)
                    .addComponent(btnReinit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(224))
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chckbxPlcmtAuto)
                    .addContainerGap(199, Short.MAX_VALUE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rdbProche)
                    .addContainerGap(300, Short.MAX_VALUE))
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rdbLoin, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(270, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addComponent(lblEditeurDeSalle)
                    .addGap(6)
                    .addComponent(lblInfos)
                    .addGap(6)
                    .addComponent(txtrSelectionnezSurLe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lblPlacement)
                    .addGap(6)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblPlacesRestantes)
                        .addComponent(lblNbPlace))
                    .addGap(12)
                    .addComponent(btnReinit, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addGap(19)
                    .addComponent(lblPlacementAutomatique)
                    .addGap(18)
                    .addComponent(chckbxPlcmtAuto)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(6)
                            .addComponent(lblNewLabel))
                        .addComponent(txtNbPlaceHand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(rdbProche)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(rdbLoin)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(22)
                            .addComponent(btnPlacer))
                        .addGroup(gl_panel.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(rdbMilieu)))
                    .addGap(10)
                    .addComponent(lblNewLabel_2)
                    .addGap(12)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnAnnuler)
                        .addComponent(btnConfirmer))
                    .addGap(12)
                    .addComponent(lblLgende)
                    .addGap(12)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSiegeNormal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(15)
                            .addComponent(lblNewLabel_1)))
                    .addGap(12)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSiegeHand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(15)
                            .addComponent(lblSigeHandicap)))
                    .addGap(12)
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSiegeOccupe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_panel.createSequentialGroup()
                            .addGap(15)
                            .addComponent(lblSigeOccup))))
        );
        panel.setLayout(gl_panel);

        plan = new JPanel();
        plan.setBackground(Color.DARK_GRAY);
        scrollPane = new JScrollPane(plan);
        scrollPane.setAlignmentY(0.0f);
        scrollPane.setAlignmentX(0.0f);
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
        System.out.println("view : " + scrollPane.getWidth());
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
        return rdbProche;
    }
    /**
     * @param rdbSiegeNormal le rdbSiegeNormal to set
     */
    public void setRdbSiegeNormal(JRadioButton rdbSiegeNormal) {
        this.rdbProche = rdbSiegeNormal;
    }
    /**
     * @return le rdbSiegeHand
     */
    public JRadioButton getRdbSiegeHand() {
        return rdbLoin;
    }
    /**
     * @param rdbSiegeHand le rdbSiegeHand to set
     */
    public void setRdbSiegeHand(JRadioButton rdbSiegeHand) {
        this.rdbLoin = rdbSiegeHand;
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
     * @return le btnEnregistrer
     */
    public JButton getBtnEnregistrer() {
        return btnPlacer;
    }
    /**
     * @param btnEnregistrer le btnEnregistrer to set
     */
    public void setBtnEnregistrer(JButton btnEnregistrer) {
        this.btnPlacer = btnEnregistrer;
    }
    /**
     * @return le rdbProche
     */
    public JRadioButton getRdbProche() {
        return rdbProche;
    }
    /**
     * @return le rdbLoin
     */
    public JRadioButton getRdbLoin() {
        return rdbLoin;
    }
    /**
     * @return le btnPlacer
     */
    public JButton getBtnPlacer() {
        return btnPlacer;
    }
    /**
     * @return le rdbMilieu
     */
    public JRadioButton getRdbMilieu() {
        return rdbMilieu;
    }
    /**
     * @return le txtNbPlaceHand
     */
    public JTextField getTxtNbPlaceHand() {
        return txtNbPlaceHand;
    }
    /**
     * @return le lblNbPlace
     */
    public JLabel getLblNbPlace() {
        return lblNbPlace;
    }
    /**
     * @return le btnReinit
     */
    public JButton getBtnReinit() {
        return btnReinit;
    }
    /**
     * @return le btnAnnuler
     */
    public JButton getBtnAnnuler() {
        return btnAnnuler;
    }
    /**
     * @return le btnConfirmer
     */
    public JButton getBtnConfirmer() {
        return btnConfirmer;
    }
    /**
     * TODO commenter le role de la Méthode
     * @param roomCreatorController
     */
    public void setController(SeatChoiceController seatChoiceController) {
        btnPlacer.addActionListener(seatChoiceController);
        btnAnnuler.addActionListener(seatChoiceController);
        btnConfirmer.addActionListener(seatChoiceController);
        btnReinit.addActionListener(seatChoiceController);
    }
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == chckbxPlcmtAuto){
            if(chckbxPlcmtAuto.isSelected()){
                txtNbPlaceHand.setEnabled(true);
                rdbLoin.setEnabled(true);
                rdbMilieu.setEnabled(true);
                rdbProche.setEnabled(true);
            }else if(!chckbxPlcmtAuto.isSelected()){
                txtNbPlaceHand.setEnabled(false);
                rdbLoin.setEnabled(false);
                rdbMilieu.setEnabled(false);
                rdbProche.setEnabled(false);
            }
        }
        
    }
}
