/*
 * Planning.java                                3 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.admin.view;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;

import cineGOv02.admin.controller.PlanningController;
import cineGOv02.common.graphics.Creneau;

import javax.swing.UIManager;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class PlanningView extends JPanel  {
    /** TODO commenter le Champ */
    public final int HEURE_DEBUT = 11;
    /** TODO commenter le Champ */
    private static final long serialVersionUID = 8505192915237014624L;
    /** TODO commenter le Champ */
    private Creneau[] hLundi = new Creneau[13];
    /** TODO commenter le Champ */
    private Creneau[] hMardi = new Creneau[13];
    /** TODO commenter le Champ */
    private Creneau[] hMercredi = new Creneau[13];
    /** TODO commenter le Champ */
    private Creneau[] hJeudi = new Creneau[13];
    /** TODO commenter le Champ */
    private Creneau[] hVendredi = new Creneau[13];
    /** TODO commenter le Champ */
    private Creneau[] hSamedi = new Creneau[13];
    /** TODO commenter le Champ */
    private Creneau[] hDimanche = new Creneau[13];
    /** TODO commenter le Champ */
    private JLabel lblSemaine;
    /** TODO commenter le Champ */
    private JComboBox cmbbSalle;
    /** TODO commenter le Champ */
    private JComboBox cmbbFilm;
    /** TODO commenter le Champ */
    private JRadioButton chckbx3DVF;
    /** TODO commenter le Champ */
    private JRadioButton chckbx3DVOST;
    /** TODO commenter le Champ */
    private JRadioButton chckbxVF;
    /** TODO commenter le Champ */
    private JRadioButton chckbxVOST;
    /** TODO commenter le Champ */
    private JRadioButton chckbxVO;
    /** TODO commenter le Champ */
    private JLabel lblDateLun;
    /** TODO commenter le Champ */
    private JLabel lblDateMar;
    /** TODO commenter le Champ */
    private JLabel lblDateMer;
    /** TODO commenter le Champ */
    private JLabel lblDateJeu;
    /** TODO commenter le Champ */
    private JLabel lblDateVen;
    /** TODO commenter le Champ */
    private JLabel lblDateSam;
    /** TODO commenter le Champ */
    private JLabel lblDateDim;
    /** TODO commenter le Champ */
    private JLabel lblCinema;
    /** TODO commenter le Champ */
    private JButton refresh;
    /** TODO commenter le Champ */
    private JButton btnPrevious;
    /** TODO commenter le Champ */
    private JButton btnNext;
    /** TODO commenter le Champ */
    private JPanel lundi;
    /** TODO commenter le Champ */
    private JPanel mardi;
    /** TODO commenter le Champ */
    private JPanel mercredi;
    /** TODO commenter le Champ */
    private JPanel jeudi;
    /** TODO commenter le Champ */
    private JPanel vendredi;
    /** TODO commenter le Champ */
    private JPanel samedi;
    /** TODO commenter le Champ */
    private JPanel dimanche;
    ButtonGroup typeSeance = new ButtonGroup();

  

    /**
     * Create the frame.
     */
    public PlanningView() {
        this.setAutoscrolls(true);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{119, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 41, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        this.setLayout(gbl_contentPane);

        lblCinema = new JLabel("Gaumont");
        lblCinema.setFont(new Font("Tahoma", Font.BOLD, 16));
        GridBagConstraints gbc_lblCinema = new GridBagConstraints();
        gbc_lblCinema.insets = new Insets(0, 0, 5, 5);
        gbc_lblCinema.gridx = 0;
        gbc_lblCinema.gridy = 0;
        add(lblCinema, gbc_lblCinema);

        lblSemaine = new JLabel();
        lblSemaine.setFont(new Font("Arial", Font.BOLD, 14));
        GridBagConstraints gbc_lblSemaine = new GridBagConstraints();
        gbc_lblSemaine.insets = new Insets(0, 0, 5, 5);
        gbc_lblSemaine.gridx = 5;
        gbc_lblSemaine.gridy = 0;
        this.add(lblSemaine, gbc_lblSemaine);

        btnNext = new JButton(" Suivant ");
        GridBagConstraints gbc_btnNext = new GridBagConstraints();
        gbc_btnNext.insets = new Insets(0, 0, 5, 5);
        gbc_btnNext.gridx = 6;
        gbc_btnNext.gridy = 0;
        add(btnNext, gbc_btnNext);
        

        btnPrevious = new JButton("Précédent");
        GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
        gbc_btnPrevious.insets = new Insets(0, 0, 5, 5);
        gbc_btnPrevious.gridx = 4;
        gbc_btnPrevious.gridy = 0;
        add(btnPrevious, gbc_btnPrevious);
       

        JLabel lblLundi = new JLabel("Lundi");
        GridBagConstraints gbc_lblLundi = new GridBagConstraints();
        gbc_lblLundi.insets = new Insets(0, 0, 5, 5);
        gbc_lblLundi.gridx = 2;
        gbc_lblLundi.gridy = 1;
        this.add(lblLundi, gbc_lblLundi);

        JLabel lblMardi = new JLabel("Mardi");
        GridBagConstraints gbc_lblMardi = new GridBagConstraints();
        gbc_lblMardi.insets = new Insets(0, 0, 5, 5);
        gbc_lblMardi.gridx = 3;
        gbc_lblMardi.gridy = 1;
        this.add(lblMardi, gbc_lblMardi);

        JLabel lblMercredi = new JLabel("Mercredi");
        GridBagConstraints gbc_lblMercredi = new GridBagConstraints();
        gbc_lblMercredi.insets = new Insets(0, 0, 5, 5);
        gbc_lblMercredi.gridx = 4;
        gbc_lblMercredi.gridy = 1;
        this.add(lblMercredi, gbc_lblMercredi);

        JLabel lblJeudi = new JLabel("Jeudi");
        GridBagConstraints gbc_lblJeudi = new GridBagConstraints();
        gbc_lblJeudi.insets = new Insets(0, 0, 5, 5);
        gbc_lblJeudi.gridx = 5;
        gbc_lblJeudi.gridy = 1;
        this.add(lblJeudi, gbc_lblJeudi);

        JLabel lblMercredi_1 = new JLabel("Vendredi");
        GridBagConstraints gbc_lblMercredi_1 = new GridBagConstraints();
        gbc_lblMercredi_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblMercredi_1.gridx = 6;
        gbc_lblMercredi_1.gridy = 1;
        this.add(lblMercredi_1, gbc_lblMercredi_1);

        JLabel lblNewLabel = new JLabel("Samedi");
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 7;
        gbc_lblNewLabel.gridy = 1;
        this.add(lblNewLabel, gbc_lblNewLabel);

        JLabel lblDimanche = new JLabel("Dimanche");
        GridBagConstraints gbc_lblDimanche = new GridBagConstraints();
        gbc_lblDimanche.insets = new Insets(0, 0, 5, 0);
        gbc_lblDimanche.gridx = 8;
        gbc_lblDimanche.gridy = 1;
        this.add(lblDimanche, gbc_lblDimanche);

        lblDateLun = new JLabel("01/01");
        lblDateLun.setFont(new Font("SansSerif", Font.BOLD, 12));
        GridBagConstraints gbc_lblDateLun = new GridBagConstraints();
        gbc_lblDateLun.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateLun.gridx = 2;
        gbc_lblDateLun.gridy = 2;
        add(lblDateLun, gbc_lblDateLun);

        lblDateMar = new JLabel("01/01");
        lblDateMar.setFont(new Font("SansSerif", Font.BOLD, 12));
        GridBagConstraints gbc_lblDateMar = new GridBagConstraints();
        gbc_lblDateMar.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateMar.gridx = 3;
        gbc_lblDateMar.gridy = 2;
        add(lblDateMar, gbc_lblDateMar);

        lblDateMer = new JLabel("01/01");
        lblDateMer.setFont(new Font("SansSerif", Font.BOLD, 12));
        GridBagConstraints gbc_lblDateMer = new GridBagConstraints();
        gbc_lblDateMer.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateMer.gridx = 4;
        gbc_lblDateMer.gridy = 2;
        add(lblDateMer, gbc_lblDateMer);

        lblDateJeu = new JLabel("01/01");
        lblDateJeu.setFont(new Font("SansSerif", Font.BOLD, 12));
        GridBagConstraints gbc_lblDateJeu = new GridBagConstraints();
        gbc_lblDateJeu.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateJeu.gridx = 5;
        gbc_lblDateJeu.gridy = 2;
        add(lblDateJeu, gbc_lblDateJeu);

        lblDateVen = new JLabel("01/01");
        lblDateVen.setFont(new Font("SansSerif", Font.BOLD, 12));
        GridBagConstraints gbc_lblDateVen = new GridBagConstraints();
        gbc_lblDateVen.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateVen.gridx = 6;
        gbc_lblDateVen.gridy = 2;
        add(lblDateVen, gbc_lblDateVen);

        lblDateSam = new JLabel("01/01");
        lblDateSam.setFont(new Font("SansSerif", Font.BOLD, 12));
        GridBagConstraints gbc_lblDateSam = new GridBagConstraints();
        gbc_lblDateSam.insets = new Insets(0, 0, 5, 5);
        gbc_lblDateSam.gridx = 7;
        gbc_lblDateSam.gridy = 2;
        add(lblDateSam, gbc_lblDateSam);

        lblDateDim = new JLabel("01/01");
        lblDateDim.setFont(new Font("SansSerif", Font.BOLD, 12));
        GridBagConstraints gbc_lblDateDim = new GridBagConstraints();
        gbc_lblDateDim.insets = new Insets(0, 0, 5, 0);
        gbc_lblDateDim.gridx = 8;
        gbc_lblDateDim.gridy = 2;
        add(lblDateDim, gbc_lblDateDim);

        JPanel infos = new JPanel();
        infos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Planning des salles", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
        GridBagConstraints gbc_infos = new GridBagConstraints();
        gbc_infos.insets = new Insets(0, 0, 0, 5);
        gbc_infos.fill = GridBagConstraints.BOTH;
        gbc_infos.gridx = 0;
        gbc_infos.gridy = 3;
        this.add(infos, gbc_infos);

        JLabel lblSelectionnezLaSalle = new JLabel("Selectionnez la salle");
        cmbbSalle = new JComboBox();
        

        JLabel lblSelectionnezLeFilm = new JLabel("Selectionnez le film");
        cmbbFilm = new JComboBox();
        
        chckbx3DVF = new JRadioButton("Séance 3D");
        chckbx3DVF.setMargin(new Insets(2, 0, 2, 2));
        chckbx3DVF.setSelected(true);
        chckbx3DVOST = new JRadioButton("Séance 3D VOST");
        chckbx3DVOST.setMargin(new Insets(2, 0, 2, 2));
        chckbxVF = new JRadioButton("Séance VF");
        chckbxVF.setMargin(new Insets(2, 0, 2, 2));
        chckbxVO = new JRadioButton("Séance VO");
        chckbxVO.setMargin(new Insets(2, 0, 2, 2));
        chckbxVOST = new JRadioButton("Séance VOST");
        chckbxVOST.setMargin(new Insets(2, 0, 2, 2));
        typeSeance.add(chckbx3DVF);
        typeSeance.add(chckbx3DVOST);
        typeSeance.add(chckbxVF);
        typeSeance.add(chckbxVO);
        typeSeance.add(chckbxVOST);
        

        
        

        GroupLayout gl_infos = new GroupLayout(infos);
        gl_infos.setHorizontalGroup(
                gl_infos.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_infos.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gl_infos.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblSelectionnezLaSalle, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(lblSelectionnezLeFilm, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(cmbbFilm, Alignment.TRAILING, 0, 119, Short.MAX_VALUE)
                                .addComponent(chckbx3DVF)
                                .addComponent(chckbx3DVOST)
                                .addComponent(chckbxVF)
                                .addComponent(chckbxVOST)
                                .addComponent(chckbxVO)
                                .addComponent(cmbbSalle, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                );
        gl_infos.setVerticalGroup(
                gl_infos.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_infos.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSelectionnezLaSalle)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(cmbbSalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(lblSelectionnezLeFilm)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(cmbbFilm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18)
                        .addComponent(chckbx3DVF)
                        .addComponent(chckbx3DVOST)
                        .addComponent(chckbxVF)
                        .addComponent(chckbxVOST)
                        .addComponent(chckbxVO)
                        .addContainerGap(111, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED))
                );
        infos.setLayout(gl_infos);

        JPanel horaires = new JPanel();
        GridBagConstraints gbc_horaires = new GridBagConstraints();
        gbc_horaires.insets = new Insets(0, 0, 0, 5);
        gbc_horaires.fill = GridBagConstraints.VERTICAL;
        gbc_horaires.gridx = 1;
        gbc_horaires.gridy = 3;
        setHoraire(horaires);
        this.add(horaires, gbc_horaires);

        lundi = new JPanel();
        lundi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagConstraints gbc_lundi = new GridBagConstraints();
        gbc_lundi.insets = new Insets(0, 0, 0, 5);
        gbc_lundi.gridx = 2;
        gbc_lundi.gridy = 3;
        setPanelList(lundi,hLundi);
        this.add(lundi, gbc_lundi);

        mardi = new JPanel();
        mardi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagConstraints gbc_mardi = new GridBagConstraints();
        gbc_mardi.insets = new Insets(0, 0, 0, 5);
        gbc_mardi.gridx = 3;
        gbc_mardi.gridy = 3;
        setPanelList(mardi,hMardi);
        this.add(mardi, gbc_mardi);

        mercredi = new JPanel();
        mercredi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagConstraints gbc_mercredi = new GridBagConstraints();
        gbc_mercredi.insets = new Insets(0, 0, 0, 5);
        gbc_mercredi.gridx = 4;
        gbc_mercredi.gridy = 3;
        setPanelList(mercredi,hMercredi);
        this.add(mercredi, gbc_mercredi);

        jeudi = new JPanel();
        jeudi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagConstraints gbc_jeudi = new GridBagConstraints();
        gbc_jeudi.insets = new Insets(0, 0, 0, 5);
        gbc_jeudi.gridx = 5;
        gbc_jeudi.gridy = 3;
        setPanelList(jeudi,hJeudi);
        this.add(jeudi, gbc_jeudi);

        vendredi = new JPanel();
        vendredi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagConstraints gbc_vendredi = new GridBagConstraints();
        gbc_vendredi.insets = new Insets(0, 0, 0, 5);
        gbc_vendredi.gridx = 6;
        gbc_vendredi.gridy = 3;
        setPanelList(vendredi,hVendredi);
        this.add(vendredi, gbc_vendredi);

        samedi = new JPanel();
        samedi.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagConstraints gbc_samedi = new GridBagConstraints();
        gbc_samedi.insets = new Insets(0, 0, 0, 5);
        gbc_samedi.gridx = 7;
        gbc_samedi.gridy = 3;
        setPanelList(samedi,hSamedi);
        this.add(samedi, gbc_samedi);

        dimanche = new JPanel();
        dimanche.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        GridBagConstraints gbc_dimanche = new GridBagConstraints();
        gbc_dimanche.gridx = 8;
        gbc_dimanche.gridy = 3;
        setPanelList(dimanche,hDimanche);
        this.add(dimanche, gbc_dimanche);
    }

    /**
     * TODO commenter le role de la Méthode
     * @param panel 
     */
    private static void setHoraire(JPanel panel){
        panel.setLayout(new GridBagLayout());
        for(int i = 0; i < 13 ; i++){
            GridBagConstraints gbHeure = new GridBagConstraints();
            gbHeure.fill = GridBagConstraints.BOTH;
            gbHeure.gridx = 0;
            gbHeure.gridy = i;
            JPanel subPan = new JPanel();
            //JLabel heure = new JLabel(i<18?(i+7)+"h":(i-17)+"h");
            JLabel heure = new JLabel((i+11)+"h");
            subPan.add(heure);
            panel.add(subPan, gbHeure);
        }
    }

    /**
     * TODO commenter le role de la Méthode
     * @param jour 
     * @param creneaux 
     */
    private void setPanelList(JPanel jour, Creneau[] creneaux) { 
        jour.setLayout(new GridBagLayout());
        for(int i = 0 ; i < creneaux.length; i++){
            GridBagConstraints gbCreneaux = new GridBagConstraints();
            gbCreneaux.fill = GridBagConstraints.BOTH;
            gbCreneaux.gridx = 0;
            gbCreneaux.gridy = i;
            creneaux[i] = new Creneau();
            creneaux[i].setHeure(i+11);
            creneaux[i].setJour(creneaux);
            creneaux[i].setPreferredSize(new Dimension(110, 26));
            creneaux[i].setMinimumSize(new Dimension(110, 26));
            creneaux[i].setBorder(new LineBorder(Color.GRAY));
            creneaux[i].setBackground(new Color(191,205,219));
            //creneaux[i].addMouseListener(controller);
            jour.add(creneaux[i],gbCreneaux);
        } 
    }
    /**
     * Remet à zero l'affichage des séance sur le planning
     * ************** DEPRECATED *************************
     */
    public void resetPanel(){
        //        lundi.removeAll();
        loopOnDay(lundi,hLundi);
        lundi.revalidate();
        //        mardi.removeAll();       
        loopOnDay(mardi,hMardi);
        mardi.revalidate();
        //        mercredi.removeAll(); 
        loopOnDay(mercredi,hMercredi);
        mercredi.revalidate();
        //        jeudi.removeAll();
        loopOnDay(jeudi,hJeudi);
        jeudi.revalidate();
        //        vendredi.removeAll();
        loopOnDay(vendredi,hVendredi);
        vendredi.revalidate();
        //        samedi.removeAll();
        loopOnDay(samedi,hSamedi);
        samedi.revalidate();
        //        dimanche.removeAll();
        loopOnDay(dimanche,hDimanche);
        dimanche.revalidate();    
    }

    /**
     * Permet le rafraichissement de l'affichage des créneaux
     * @param jour
     * @param creneaux
     */
    private static void loopOnDay(JPanel jour, Creneau[] creneaux){
        for(int i = 0 ; i < creneaux.length; i++){
            creneaux[i].setFilm("");
            creneaux[i].setSeance(null);
            creneaux[i].setBackground(new Color(92,92,98));
        }
    }
    /**
     * @param lblSemaine le lblSemaine to set
     */
    public void setLblSemaine(JLabel lblSemaine) {
        this.lblSemaine = lblSemaine;
    }

    /**
     * @return le hLundi
     */
    public Creneau[] gethLundi() {
        return hLundi;
    }

    /**
     * @param hLundi le hLundi to set
     */
    public void sethLundi(Creneau[] hLundi) {
        this.hLundi = hLundi;
    }

    /**
     * @return le hMardi
     */
    public Creneau[] gethMardi() {
        return hMardi;
    }

    /**
     * @param hMardi le hMardi to set
     */
    public void sethMardi(Creneau[] hMardi) {
        this.hMardi = hMardi;
    }

    /**
     * @return le hMercredi
     */
    public Creneau[] gethMercredi() {
        return hMercredi;
    }

    /**
     * @param hMercredi le hMercredi to set
     */
    public void sethMercredi(Creneau[] hMercredi) {
        this.hMercredi = hMercredi;
    }

    /**
     * @return le hJeudi
     */
    public Creneau[] gethJeudi() {
        return hJeudi;
    }

    /**
     * @param hJeudi le hJeudi to set
     */
    public void sethJeudi(Creneau[] hJeudi) {
        this.hJeudi = hJeudi;
    }

    /**
     * @return le hVendredi
     */
    public Creneau[] gethVendredi() {
        return hVendredi;
    }

    /**
     * @param hVendredi le hVendredi to set
     */
    public void sethVendredi(Creneau[] hVendredi) {
        this.hVendredi = hVendredi;
    }

    /**
     * @return le hSamedi
     */
    public Creneau[] gethSamedi() {
        return hSamedi;
    }

    /**
     * @param hSamedi le hSamedi to set
     */
    public void sethSamedi(Creneau[] hSamedi) {
        this.hSamedi = hSamedi;
    }

    /**
     * @return le hDimanche
     */
    public Creneau[] gethDimanche() {
        return hDimanche;
    }

    /**
     * @param hDimanche le hDimanche to set
     */
    public void sethDimanche(Creneau[] hDimanche) {
        this.hDimanche = hDimanche;
    }

    /**
     * @return le lblSemaine
     */
    public JLabel getLblSemaine() {
        return lblSemaine;
    }

    /**
     * @return le cmbbSalle
     */
    public JComboBox getCmbbSalle() {
        return cmbbSalle;
    }

    /**
     * @param cmbbSalle le cmbbSalle to set
     */
    public void setCmbbSalle(JComboBox cmbbSalle) {
        this.cmbbSalle = cmbbSalle;
    }

    /**
     * @return le cmbbFilm
     */
    public JComboBox getCmbbFilm() {
        return cmbbFilm;
    }

    /**
     * @param cmbbFilm le cmbbFilm to set
     */
    public void setCmbbFilm(JComboBox cmbbFilm) {
        this.cmbbFilm = cmbbFilm;
    }

    /**
     * @return le lblDateLun
     */
    public JLabel getLblDateLun() {
        return lblDateLun;
    }

    /**
     * @param lblDateLun le lblDateLun to set
     */
    public void setLblDateLun(JLabel lblDateLun) {
        this.lblDateLun = lblDateLun;
    }

    /**
     * @return le lblDateMar
     */
    public JLabel getLblDateMar() {
        return lblDateMar;
    }

    /**
     * @param lblDateMar le lblDateMar to set
     */
    public void setLblDateMar(JLabel lblDateMar) {
        this.lblDateMar = lblDateMar;
    }

    /**
     * @return le lblDateMer
     */
    public JLabel getLblDateMer() {
        return lblDateMer;
    }

    /**
     * @param lblDateMer le lblDateMer to set
     */
    public void setLblDateMer(JLabel lblDateMer) {
        this.lblDateMer = lblDateMer;
    }

    /**
     * @return le lblDateJeu
     */
    public JLabel getLblDateJeu() {
        return lblDateJeu;
    }

    /**
     * @param lblDateJeu le lblDateJeu to set
     */
    public void setLblDateJeu(JLabel lblDateJeu) {
        this.lblDateJeu = lblDateJeu;
    }

    /**
     * @return le lblDateVen
     */
    public JLabel getLblDateVen() {
        return lblDateVen;
    }

    /**
     * @param lblDateVen le lblDateVen to set
     */
    public void setLblDateVen(JLabel lblDateVen) {
        this.lblDateVen = lblDateVen;
    }

    /**
     * @return le lblDateSam
     */
    public JLabel getLblDateSam() {
        return lblDateSam;
    }

    /**
     * @param lblDateSam le lblDateSam to set
     */
    public void setLblDateSam(JLabel lblDateSam) {
        this.lblDateSam = lblDateSam;
    }

    /**
     * @return le lblDateDim
     */
    public JLabel getLblDateDim() {
        return lblDateDim;
    }

    /**
     * @param lblDateDim le lblDateDim to set
     */
    public void setLblDateDim(JLabel lblDateDim) {
        this.lblDateDim = lblDateDim;
    }

    /**
     * @return le lblCinema
     */
    public JLabel getLblCinema() {
        return lblCinema;
    }

    /**
     * @param lblCinema le lblCinema to set
     */
    public void setLblCinema(JLabel lblCinema) {
        this.lblCinema = lblCinema;
    }

    /**
     * @return le refresh
     */
    public JButton getRefresh() {
        return refresh;
    }

    /**
     * @param refresh le refresh to set
     */
    public void setRefresh(JButton refresh) {
        this.refresh = refresh;
    }

    /**
     * @return le btnPrevious
     */
    public JButton getBtnPrevious() {
        return btnPrevious;
    }

    /**
     * @param btnPrevious le btnPrevious to set
     */
    public void setBtnPrevious(JButton btnPrevious) {
        this.btnPrevious = btnPrevious;
    }

    /**
     * @return le btnNext
     */
    public JButton getBtnNext() {
        return btnNext;
    }

    /**
     * @param btnNext le btnNext to set
     */
    public void setBtnNext(JButton btnNext) {
        this.btnNext = btnNext;
    }
    /**
     * @return le chckbx3DVF
     */
    public JRadioButton getChckbx3DVF() {
        return chckbx3DVF;
    }

    /**
     * @return le chckbx3DVOST
     */
    public JRadioButton getChckbx3DVOST() {
        return chckbx3DVOST;
    }

    /**
     * @return le chckbxVF
     */
    public JRadioButton getChckbxVF() {
        return chckbxVF;
    }

    /**
     * @return le chckbxVOST
     */
    public JRadioButton getChckbxVOST() {
        return chckbxVOST;
    }

    /**
     * @return le chckbxVO
     */
    public JRadioButton getChckbxVO() {
        return chckbxVO;
    }
    /**
     * Retourne un tableau contenant les labels 
     * pour la date des jours de la semaine
     * @return un tableau contenant tous les labels
     */
    public ArrayList<JLabel> getLblDate(){
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        labels.add(this.lblDateLun);
        labels.add(this.lblDateMar);
        labels.add(this.lblDateMer);
        labels.add(this.lblDateJeu);
        labels.add(this.lblDateVen);
        labels.add(this.lblDateSam);
        labels.add(this.lblDateDim);
        return labels;

    }

    /**
     * @param controller le controller to set
     */
    public void setController(PlanningController controller) {
        btnNext.addActionListener(controller);
        cmbbSalle.addActionListener(controller);
        btnPrevious.addActionListener(controller);
        cmbbFilm.addActionListener(controller);
        chckbx3DVF.addActionListener(controller);
        for(int i = 0 ; i < 13 ; i++){
            hLundi[i].addMouseListener(controller);
            hMardi[i].addMouseListener(controller);
            hMercredi[i].addMouseListener(controller);
            hJeudi[i].addMouseListener(controller);
            hVendredi[i].addMouseListener(controller);
            hSamedi[i].addMouseListener(controller);
            hDimanche[i].addMouseListener(controller);
        }
    }

}
