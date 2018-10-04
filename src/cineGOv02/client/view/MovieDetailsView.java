package cineGOv02.client.view;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import cineGOv02.client.controller.MovieDetailsController;

import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.event.KeyEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class MovieDetailsView extends JPanel{
    /** TODO commenter le Champ */
    private JLabel lblGenre;
    /** TODO commenter le Champ */
    private JLabel lblRealisateur;
    /** TODO commenter le Champ */
    private JLabel labelDate;
    /** TODO commenter le Champ */
    private JLabel lblCasting;
    /** TODO commenter le Champ */
    private JLabel lblDuree;
    /** TODO commenter le Champ */
    private JLabel lblNote;
    /** TODO commenter le Champ */
    private JButton btnReserver;
    /** TODO commenter le Champ */
    private JLabel lblCreate;
    /** TODO commenter le Champ */
    private JButton btnConnexion;
    /** TODO commenter le Champ */
    private JLabel lblAffiche;
    /** TODO*/
    private JLabel lblTitre;
    /** TODO */
    private JTextPane txtSynopsis;
    /** TODO */
    private JLabel lblRetour;
    /** TODO commenter le Champ */
    private JLabel lblCompte;
    /** TODO commenter le Champ */
    private JButton btnCompte;
    /** TODO commenter le Champ */
    private JButton btnDeconnexion;
    private JLabel lblPasEncore;
    private JLabel lblOu;
    private JLabel lblProfiter;
    private JPanel panel;

    /**
     * Create the panel.
     */
    public MovieDetailsView() {
        setMaximumSize(new Dimension(1024, 720));
        setMinimumSize(new Dimension(1024, 720));
        setSize(new Dimension(1024, 720));
        setPreferredSize(new Dimension(1024, 720));

        JLabel label = new JLabel("CineGO");
        label.setForeground(new Color(0, 128, 255));
        label.setFont(new Font("Tahoma", Font.BOLD, 40));

        lblAffiche = new JLabel("");
        
        lblAffiche.setForeground(Color.BLACK);

        lblTitre = new JLabel("Shutter Island ");
        lblTitre.setForeground(SystemColor.textHighlight);
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 25));

        JLabel lblSynopsys = new JLabel("Synopsis");
        lblSynopsys.setForeground(Color.LIGHT_GRAY);
        lblSynopsys.setFont(new Font("Tahoma", Font.BOLD, 18));
        JLabel lblx = new JLabel("Genre");
        lblx.setForeground(Color.LIGHT_GRAY);
        lblx.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblDateDeSortie = new JLabel("Date de sortie");
        lblDateDeSortie.setForeground(Color.LIGHT_GRAY);
        lblDateDeSortie.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lbly = new JLabel("Realisateur");
        lbly.setForeground(Color.LIGHT_GRAY);
        lbly.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblz = new JLabel("Casting");
        lblz.setForeground(Color.LIGHT_GRAY);
        lblz.setFont(new Font("Tahoma", Font.BOLD, 17));

        JLabel lblh = new JLabel("Duree");
        lblh.setForeground(Color.LIGHT_GRAY);
        lblh.setFont(new Font("Tahoma", Font.BOLD, 17));

        lblGenre = new JLabel("Thriller");
        lblGenre.setHorizontalTextPosition(SwingConstants.LEFT);
        lblGenre.setForeground(Color.LIGHT_GRAY);
        lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));

        labelDate = new JLabel("2010-02-18");
        labelDate.setHorizontalTextPosition(SwingConstants.LEFT);
        labelDate.setHorizontalAlignment(SwingConstants.LEFT);
        labelDate.setForeground(Color.LIGHT_GRAY);
        labelDate.setFont(new Font("Tahoma", Font.PLAIN, 15));

        lblRealisateur = new JLabel(" \tDennis Lehane, Laeta Kalogridis");
        lblRealisateur.setHorizontalTextPosition(SwingConstants.LEFT);
        lblRealisateur.setHorizontalAlignment(SwingConstants.LEFT);
        lblRealisateur.setForeground(Color.LIGHT_GRAY);
        lblRealisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblCasting = new JLabel(" Leonardo DiCaprio, Mark Ruffalo, Ben Kingsley,  Emily Mortimer");
        lblCasting.setHorizontalTextPosition(SwingConstants.LEFT);
        lblCasting.setHorizontalAlignment(SwingConstants.LEFT);
        lblCasting.setForeground(Color.LIGHT_GRAY);
        lblCasting.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblDuree = new JLabel("2h18m");
        lblDuree.setHorizontalTextPosition(SwingConstants.LEFT);
        lblDuree.setForeground(Color.LIGHT_GRAY);
        lblDuree.setFont(new Font("Tahoma", Font.PLAIN, 16));

        btnReserver = new JButton("Réservez votre place");
        btnReserver.setSize(new Dimension(116, 28));
        btnReserver.setMaximumSize(new Dimension(116, 28));
        btnReserver.setMinimumSize(new Dimension(116, 28));
        btnReserver.setPreferredSize(new Dimension(116, 28));
        btnReserver.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnReserver.setBackground(SystemColor.textHighlight);
        btnReserver.setForeground(Color.WHITE);

        lblPasEncore = new JLabel("Pas encore de compte ?");
        lblPasEncore.setForeground(new Color(192, 192, 192));
        lblPasEncore.setFont(new Font("Tahoma", Font.PLAIN, 18));

        lblCreate = new JLabel("Créez-en un!");
        lblCreate.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreate.setForeground(SystemColor.textHighlight);
        lblCreate.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblOu = new JLabel("OU");
        lblOu.setForeground(Color.LIGHT_GRAY);
        lblOu.setFont(new Font("Tahoma", Font.BOLD, 16));

        btnConnexion = new JButton("Connectez-vous");
        btnConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnConnexion.setForeground(SystemColor.textHighlight);

        lblProfiter = new JLabel("Pour profitez de tous les avantages clients !");
        lblProfiter.setForeground(Color.LIGHT_GRAY);
        lblProfiter.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JLabel lblNote_1 = new JLabel("Note");
        lblNote_1.setForeground(Color.LIGHT_GRAY);
        lblNote_1.setFont(new Font("Tahoma", Font.BOLD, 18));

        lblNote = new JLabel("7.4");
        lblNote.setForeground(Color.LIGHT_GRAY);
        lblNote.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
//                | UnsupportedLookAndFeelException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        SwingUtilities.updateComponentTreeUI(this);
        txtSynopsis = new JTextPane();
        txtSynopsis.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtSynopsis.setOpaque(false); // added by OP
        txtSynopsis.setBorder(BorderFactory.createEmptyBorder());
        txtSynopsis.setBackground(new Color(0,0,0,0));
        txtSynopsis.setEditable(false);
        txtSynopsis.setForeground(Color.LIGHT_GRAY);
        txtSynopsis.setText("");
        MutableAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(set, 0.55f);
        StyleConstants.setForeground(set, Color.LIGHT_GRAY);
        StyleConstants.setFontFamily(set, "Tahoma");
        StyleConstants.setFontSize(set, 15);
        txtSynopsis.setParagraphAttributes(set, true);
        
        lblRetour = new JLabel("<< Retour à l'accueil");
        lblRetour.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRetour.setForeground(SystemColor.textHighlight);
        
        panel = new JPanel();
        panel.setOpaque(false);
        
        lblCompte = new JLabel("Bienvenue User !");
        lblCompte.setHorizontalTextPosition(SwingConstants.CENTER);
        lblCompte.setHorizontalAlignment(SwingConstants.LEFT);
        lblCompte.setDisplayedMnemonic(KeyEvent.VK_ENTER);
        lblCompte.setForeground(SystemColor.textHighlight);
        lblCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
        
        btnCompte = new JButton("Mon compte");
        btnCompte.setBackground(SystemColor.textHighlight);
        btnCompte.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCompte.setForeground(Color.WHITE);
        
        btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.setForeground(SystemColor.textHighlight);
        btnDeconnexion.setFont(new Font("Tahoma", Font.PLAIN, 12));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(lblCompte, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
                            .addComponent(btnCompte)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(btnDeconnexion)))
                    .addGap(44))
        );
        gl_panel.setVerticalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup()
                    .addGap(18)
                    .addComponent(lblCompte)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnDeconnexion)
                        .addComponent(btnCompte)))
        );
        panel.setLayout(gl_panel);
        btnDeconnexion.setVisible(false);
        btnCompte.setVisible(false);
        lblCompte.setVisible(false);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(104)
                    .addComponent(btnReserver, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(64)
                            .addComponent(lblAffiche, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(196)
                            .addComponent(lblOu))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(104)
                            .addComponent(btnConnexion, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(146)
                            .addComponent(lblRetour)))
                    .addGap(35)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(61)
                                    .addComponent(label))
                                .addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE))
                            .addGap(30)
                            .addComponent(panel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                            .addComponent(lblPasEncore)
                            .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(lblCreate)
                                .addGap(18)
                                .addComponent(lblProfiter, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSynopsys, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSynopsis, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
                            .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(lblx, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(12)
                                .addComponent(lblGenre, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                            .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(lblDateDeSortie, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(12)
                                .addComponent(labelDate, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
                            .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(lbly, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGap(6)
                                .addComponent(lblRealisateur, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
                            .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                    .addComponent(lblz, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblh, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
                                .addGap(6)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                    .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(lblDuree, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                        .addGap(57)
                                        .addComponent(lblNote_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(ComponentPlacement.RELATED)
                                        .addComponent(lblNote, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblCasting, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))))))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(2)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(80)
                            .addComponent(lblRetour))
                        .addComponent(label)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                    .addGap(13)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblAffiche, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(8)
                            .addComponent(lblSynopsys, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addGap(6)
                            .addComponent(txtSynopsis, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblx, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(1)
                                    .addComponent(lblGenre, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                            .addGap(6)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblDateDeSortie, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(1)
                                    .addComponent(labelDate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                            .addGap(6)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lbly, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRealisateur, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                            .addGap(6)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblz, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(1)
                                    .addComponent(lblCasting, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                            .addGroup(groupLayout.createSequentialGroup()
                                .addGap(41)
                                .addComponent(btnReserver, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                            .addGroup(groupLayout.createSequentialGroup()
                                .addGap(8)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNote_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNote, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblDuree, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(lblh, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                    .addGap(6)
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(lblOu)
                            .addGap(6)
                            .addComponent(btnConnexion, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(lblPasEncore)
                            .addGap(4)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(10)
                                    .addComponent(lblCreate))
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addGap(12)
                                    .addComponent(lblProfiter))))))
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                    .addContainerGap(69, Short.MAX_VALUE)
                    .addComponent(lblTitre)
                    .addGap(620))
        );
        setLayout(groupLayout);

    }
    
    /**
     * TODO commenter le role de la Méthode
     * @param controller
     */
    public void setController(MovieDetailsController controller){
         btnReserver.addActionListener(controller);
         lblCreate.addMouseListener(controller);
         btnConnexion.addActionListener(controller);
         lblRetour.addMouseListener(controller);
         btnCompte.addActionListener(controller);
         btnDeconnexion.addActionListener(controller);
    }
    
    /**
     * @return le lblUser
     */
    public JLabel getLblCompte() {
        return lblCompte;
    }

    /**
     * @param lblUser le lblUser to set
     */
    public void setLblCompte(JLabel lblUser) {
        this.lblCompte = lblUser;
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
     * @return le txtSynopsis
     */
    public JTextPane getTxtSynopsis() {
        return txtSynopsis;
    }

    /**
     * @param txtSynopsis le txtSynopsis to set
     */
    public void setTxtSynopsis(JTextPane txtSynopsis) {
        this.txtSynopsis = txtSynopsis;
    }

    /**
     * @return le lblGenre
     */
    public JLabel getLblGenre() {
        return lblGenre;
    }

    /**
     * @param lblGenre le lblGenre to set
     */
    public void setLblGenre(JLabel lblGenre) {
        this.lblGenre = lblGenre;
    }

    /**
     * @return le lblRealisateur
     */
    public JLabel getLblRealisateur() {
        return lblRealisateur;
    }

    /**
     * @param lblRealisateur le lblRealisateur to set
     */
    public void setLblRealisateur(JLabel lblRealisateur) {
        this.lblRealisateur = lblRealisateur;
    }

    /**
     * @return le labelDate
     */
    public JLabel getLabelDate() {
        return labelDate;
    }

    /**
     * @param labelDate le labelDate to set
     */
    public void setLabelDate(JLabel labelDate) {
        this.labelDate = labelDate;
    }

    /**
     * @return le lblCasting
     */
    public JLabel getLblCasting() {
        return lblCasting;
    }

    /**
     * @param lblCasting le lblCasting to set
     */
    public void setLblCasting(JLabel lblCasting) {
        this.lblCasting = lblCasting;
    }

    /**
     * @return le lblDuree
     */
    public JLabel getLblDuree() {
        return lblDuree;
    }

    /**
     * @param lblDuree le lblDuree to set
     */
    public void setLblDuree(JLabel lblDuree) {
        this.lblDuree = lblDuree;
    }

    /**
     * @return le lblNote
     */
    public JLabel getLblNote() {
        return lblNote;
    }

    /**
     * @param lblNote le lblNote to set
     */
    public void setLblNote(JLabel lblNote) {
        this.lblNote = lblNote;
    }

    /**
     * @return le btnCreate
     */
    public JButton getBtnCreate() {
        return btnReserver;
    }

    /**
     * @param btnCreate le btnCreate to set
     */
    public void setBtnCreate(JButton btnCreate) {
        this.btnReserver = btnCreate;
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
     * @return le lblPasEncore
     */
    public JLabel getLblPasEncore() {
        return lblPasEncore;
    }

    /**
     * @param lblPasEncore le lblPasEncore to set
     */
    public void setLblPasEncore(JLabel lblPasEncore) {
        this.lblPasEncore = lblPasEncore;
    }

    /**
     * @return le lblOu
     */
    public JLabel getLblOu() {
        return lblOu;
    }

    /**
     * @param lblOu le lblOu to set
     */
    public void setLblOu(JLabel lblOu) {
        this.lblOu = lblOu;
    }

    /**
     * @return le lblProfiter
     */
    public JLabel getLblProfiter() {
        return lblProfiter;
    }

    /**
     * @param lblProfiter le lblProfiter to set
     */
    public void setLblProfiter(JLabel lblProfiter) {
        this.lblProfiter = lblProfiter;
    }

    /**
     * @return le btnReserver
     */
    public JButton getBtnReserver() {
        return btnReserver;
    }

    /**
     * @param btnReserver le btnReserver to set
     */
    public void setBtnReserver(JButton btnReserver) {
        this.btnReserver = btnReserver;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, 800, Color.decode("#3b3b3b"), true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                
    }   
}
