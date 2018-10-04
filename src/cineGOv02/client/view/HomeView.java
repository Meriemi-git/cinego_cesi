package cineGOv02.client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import cineGOv02.client.controller.HomeController;
import cineGOv02.common.graphics.Affiche;
import cineGOv02.common.graphics.Genre;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;

/**
 * TODO commenter les responsabilités classe
 * @author hustariz
 *
 */
public class HomeView extends JPanel{

    /** police personnalisée. */
    private Font police = new Font("Tahoma", Font.BOLD, 32);
    /** police personnalisée. */
    private Font police2 = new Font("Tahoma", Font.BOLD, 40);
    /** police personnalisée. */
    private Font police3 = new Font("Tahoma", Font.BOLD, 24);
    /** Bouton marche avant affiche de films. */
    private JButton btnNextbutton = new JButton();
    /** Bouton retour arriÃ¨re affiche de films.*/
    private JButton btnBackbutton = new JButton();
    /** Timer */
    private Timer tm;
    
    /** Checkbox pour appliquer le filtre Film du jour */
    JRadioButton rdbtnFilmDuJour;
    /** Choix de la comboBox. */
    private String[] choixCombo = {
            "Les plus vus",
            "Les mieux notés",
            "Ordre Alphabétique",
    };

    /** Affiche de film numero 1 */
    private Affiche affiche1 = new Affiche();
    /** Affiche de film numero 2 */
    private Affiche affiche2 = new Affiche();		
    /** Affiche de film numero 3 */
    private Affiche affiche3 = new Affiche();
    /** Affiche de film numero 4 */
    private Affiche affiche4 = new Affiche();
    /** Affiche de film numero 5 */
    private Affiche affiche5 = new Affiche();
    /** Affiche de film numero 6 */
    private Affiche affiche6 = new Affiche();
    /** textField. */
    private JTextField txtSearch;
    /** textField */
    private JLabel compteur;
    
    /** TODO commenter le Champ */
    private ArrayList<Affiche> listPanel; 
    /** TODO commenter le Champ */
    private Genre grAventure;
    /** TODO commenter le Champ */
    private Genre grComedie;
    /** TODO commenter le Champ */
    private Genre grDocumentaire;
    /** TODO commenter le Champ */
    private Genre grDrame;
    /** TODO commenter le Champ */
    private Genre grFantastique;
    /** TODO commenter le Champ */
    private Genre grHorreur;
    /** TODO commenter le Champ */
    private Genre grSF;
    /** TODO commenter le Champ */
    private Genre grRomance;
    /** TODO commenter le Champ */
    private Genre grThriller;
    /** TODO commenter le Champ */
    private Genre grAction;
    /** TODO commenter le Champ */
    private Genre grAnimation;
    /** TODO commenter le Champ */
    private Genre grAutre;
    /** TODO commenter le Champ */
    private JLabel lblCompte;
    /** TODO commenter le Champ */
    private JButton btnDeconnexion;
    /** TODO commenter le Champ */
    private JButton btnCompte;
    /** TODO commenter le Champ */
    private JButton btnConnexion;
    /**
     * Create the panel.
     */
    public HomeView() {
        setMaximumSize(new Dimension(1024, 768));
        setSize(new Dimension(1024, 728));
        setPreferredSize(new Dimension(1024, 720));
        setMinimumSize(new Dimension(1024, 728));
        listPanel = new ArrayList<Affiche>();
        listPanel.add(affiche1);
        listPanel.add(affiche2);
        listPanel.add(affiche3);
        listPanel.add(affiche4);
        listPanel.add(affiche5);
        listPanel.add(affiche6);
        JLabel lblCinego = new JLabel("CineGO");
        lblCinego.setHorizontalTextPosition(SwingConstants.CENTER);
        lblCinego.setForeground(Color.decode("#0080ff"));
        lblCinego.setFont(police2);

        JLabel lblParMotCl = new JLabel("Par Titre :");
        lblParMotCl.setHorizontalTextPosition(SwingConstants.CENTER);
        lblParMotCl.setHorizontalAlignment(SwingConstants.CENTER);
        lblParMotCl.setFont(police3);
        lblParMotCl.setForeground(Color.decode("#ebeffb"));

        JLabel lblVotreFilm = new JLabel("Votre Film");
        lblVotreFilm.setHorizontalAlignment(SwingConstants.CENTER);
        lblVotreFilm.setForeground(Color.decode("#0080ff"));
        lblVotreFilm.setFont(new Font("Tahoma", Font.BOLD, 28));

        txtSearch = new JTextField();
        txtSearch.setColumns(10);

        JLabel lblParGenre = new JLabel("Par genre");
        lblParGenre.setHorizontalTextPosition(SwingConstants.CENTER);
        lblParGenre.setHorizontalAlignment(SwingConstants.CENTER);
        lblParGenre.setFont(police3);
        lblParGenre.setForeground(Color.decode("#ebeffb"));

        btnConnexion = new JButton("Connexion");
        btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnConnexion.setForeground(SystemColor.textHighlight);
        btnConnexion.setBackground(Color.WHITE);


        btnNextbutton.setSize(18,24);
        setButtonSize(btnNextbutton, "arrow_right.png" );

        btnBackbutton.setSize(18,24);
        setButtonSize(btnBackbutton, "arrow_left.png" );

        compteur = new JLabel();
        compteur.setFont(new Font("SansSerif", Font.PLAIN, 20));
        compteur.setForeground(Color.WHITE);
        compteur.setHorizontalAlignment(SwingConstants.CENTER);
        
        grAventure = new Genre("Aventure");
        grAventure.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grAventure.setGenre("Aventure");
        grAventure.setText("Aventure");
        grAventure.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grAventure.setIconTextGap(0);
        grAventure.setAlignmentY(0.0f);
        grAventure.setHorizontalTextPosition(SwingConstants.CENTER);
        grAventure.setHorizontalAlignment(SwingConstants.CENTER);
        grAventure.setBackground(Color.WHITE);
        grAventure.setOpaque(true);
        grAventure.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        grComedie = new Genre("Comédie");
        grComedie.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grComedie.setGenre("Comédie");
        grComedie.setText("Comédie");
        grComedie.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grComedie.setIconTextGap(0);
        grComedie.setOpaque(true);
        grComedie.setBackground(Color.WHITE);
        grComedie.setHorizontalTextPosition(SwingConstants.CENTER);
        grComedie.setHorizontalAlignment(SwingConstants.CENTER);
        grComedie.setAlignmentY(0.0f);
        
        grDocumentaire = new Genre("Documentaire");
        grDocumentaire.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grDocumentaire.setGenre("Documentaire");
        grDocumentaire.setText("Documentaire");
        grDocumentaire.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grDocumentaire.setHorizontalTextPosition(SwingConstants.CENTER);
        grDocumentaire.setHorizontalAlignment(SwingConstants.CENTER);
        grDocumentaire.setBackground(Color.WHITE);
        grDocumentaire.setOpaque(true);
        
        grDrame = new Genre("Drame");
        grDrame.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grDrame.setGenre("Drame");
        grDrame.setText("Drame");
        grDrame.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grDrame.setBackground(Color.WHITE);
        grDrame.setOpaque(true);
        grDrame.setHorizontalAlignment(SwingConstants.CENTER);
        grDrame.setHorizontalTextPosition(SwingConstants.CENTER);
        
        grFantastique = new Genre("Fantastique");
        grFantastique.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grFantastique.setGenre("Fantastique");
        grFantastique.setText("Fantastique");
        grFantastique.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grFantastique.setOpaque(true);
        grFantastique.setHorizontalTextPosition(SwingConstants.CENTER);
        grFantastique.setHorizontalAlignment(SwingConstants.CENTER);
        grFantastique.setBackground(Color.WHITE);
        
        grHorreur = new Genre("Horreur");
        grHorreur.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grHorreur.setGenre("Horreur");
        grHorreur.setText("Horreur");
        grHorreur.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grHorreur.setBackground(Color.WHITE);
        grHorreur.setHorizontalTextPosition(SwingConstants.CENTER);
        grHorreur.setHorizontalAlignment(SwingConstants.CENTER);
        grHorreur.setOpaque(true);
        
        grSF = new Genre("Science-fiction");
        grSF.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grSF.setGenre("Science-fiction");
        grSF.setText("Science-fiction");
        grSF.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grSF.setBackground(Color.WHITE);
        grSF.setOpaque(true);
        grSF.setHorizontalTextPosition(SwingConstants.CENTER);
        grSF.setHorizontalAlignment(SwingConstants.CENTER);
        
        grRomance = new Genre("Romance");
        grRomance.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grRomance.setText("Romance");
        grRomance.setGenre("Romance");
        grRomance.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grRomance.setOpaque(true);
        grRomance.setHorizontalTextPosition(SwingConstants.CENTER);
        grRomance.setHorizontalAlignment(SwingConstants.CENTER);
        grRomance.setBackground(Color.WHITE);
        
        grThriller = new Genre("Thriller");
        grThriller.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grThriller.setText("Thriller");
        grThriller.setGenre("Thriller");
        grThriller.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grThriller.setBackground(Color.WHITE);
        grThriller.setHorizontalTextPosition(SwingConstants.CENTER);
        grThriller.setHorizontalAlignment(SwingConstants.CENTER);
        grThriller.setOpaque(true);
        
        grAnimation = new Genre("Animation");
        grAnimation.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grAnimation.setText("Animation");
        grAnimation.setGenre("Animation");
        grAnimation.setOpaque(true);
        grAnimation.setIconTextGap(0);
        grAnimation.setHorizontalTextPosition(SwingConstants.CENTER);
        grAnimation.setHorizontalAlignment(SwingConstants.CENTER);
        grAnimation.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grAnimation.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        grAnimation.setBackground(Color.WHITE);
        grAnimation.setAlignmentY(0.0f);
        
        grAction = new Genre("Action");
        grAction.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grAction.setText("Action");
        grAction.setGenre("Action");
        grAction.setOpaque(true);
        grAction.setIconTextGap(0);
        grAction.setHorizontalTextPosition(SwingConstants.CENTER);
        grAction.setHorizontalAlignment(SwingConstants.CENTER);
        grAction.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grAction.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        grAction.setBackground(Color.WHITE);
        grAction.setAlignmentY(0.0f);
        
        grAutre = new Genre("Autre");
        grAutre.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, null, new Color(51, 153, 255), new Color(51, 153, 255)));
        grAutre.setText("Autre");
        grAutre.setGenre("Autre");
        grAutre.setOpaque(true);
        grAutre.setHorizontalTextPosition(SwingConstants.CENTER);
        grAutre.setHorizontalAlignment(SwingConstants.CENTER);
        grAutre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        grAutre.setBackground(Color.WHITE);
        
        lblCompte = new JLabel("Bienvenue doremus");
        lblCompte.setForeground(SystemColor.textHighlight);
        lblCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblCompte.setVisible(false);
        
        btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.setForeground(SystemColor.textHighlight);
        btnDeconnexion.setVisible(false);
        
        btnCompte = new JButton("Mon compte");
        btnCompte.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCompte.setBackground(SystemColor.textHighlight);
        btnCompte.setForeground(Color.WHITE);
        btnCompte.setVisible(false);
        
        rdbtnFilmDuJour = new JRadioButton("Film du jour");
        rdbtnFilmDuJour.setForeground(SystemColor.textHighlight);
        rdbtnFilmDuJour.setFont(new Font("Tahoma", Font.BOLD, 18));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(34)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblVotreFilm, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        					.addGap(211)
        					.addComponent(lblCinego)
        					.addGap(226)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblCompte)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(btnCompte)
        							.addGap(6)
        							.addComponent(btnDeconnexion))))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblParMotCl, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblParGenre, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grAction, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grAnimation, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grAventure, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grComedie, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grDocumentaire, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grDrame, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
        							.addGap(38)
        							.addComponent(affiche1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
        							.addGap(80)
        							.addComponent(affiche2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(grFantastique, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grHorreur, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grSF, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grRomance, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grThriller, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addComponent(grAutre, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addGap(28)
        									.addComponent(rdbtnFilmDuJour))
        								.addComponent(btnConnexion, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
        							.addGap(38)
        							.addComponent(affiche4, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
        							.addGap(79)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(affiche5, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addGap(27)
        									.addComponent(btnBackbutton)
        									.addGap(8)
        									.addComponent(compteur, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(btnNextbutton)))))
        					.addGap(80)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(affiche6, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
        						.addComponent(affiche3, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
        					.addGap(29))))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(1)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(46)
        					.addComponent(lblVotreFilm))
        				.addComponent(lblCinego)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(19)
        					.addComponent(lblCompte)
        					.addGap(6)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(1)
        							.addComponent(btnCompte))
        						.addComponent(btnDeconnexion))))
        			.addGap(6)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblParMotCl)
        					.addGap(6)
        					.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(6)
        					.addComponent(lblParGenre)
        					.addGap(9)
        					.addComponent(grAction, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addGap(1)
        					.addComponent(grAnimation, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addGap(1)
        					.addComponent(grAventure, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addGap(1)
        					.addComponent(grComedie, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addGap(1)
        					.addComponent(grDocumentaire, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addGap(1)
        					.addComponent(grDrame, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(11)
        					.addComponent(affiche1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(11)
        					.addComponent(affiche2, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(11)
        					.addComponent(affiche3, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(1)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(grFantastique, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addGap(1)
        							.addComponent(grHorreur, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addGap(1)
        							.addComponent(grSF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addGap(1)
        							.addComponent(grRomance, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addGap(1)
        							.addComponent(grThriller, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addGap(1)
        							.addComponent(grAutre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(rdbtnFilmDuJour)
        							.addGap(18)
        							.addComponent(btnConnexion, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(15)
        							.addComponent(affiche4, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(15)
        							.addComponent(affiche5, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
        							.addGap(12)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(compteur, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btnBackbutton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btnNextbutton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(affiche6, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)))
        			.addGap(8))
        );
        setLayout(groupLayout);

    }

    
    /**
	 * @return le rdbtnFilmDuJour
	 */
	public JRadioButton getRdbtnFilmDuJour() {
		return rdbtnFilmDuJour;
	}


	/**
	 * @param rdbtnFilmDuJour le rdbtnFilmDuJour to set
	 */
	public void setRdbtnFilmDuJour(JRadioButton rdbtnFilmDuJour) {
		this.rdbtnFilmDuJour = rdbtnFilmDuJour;
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
     * Affiche les images sur le composant pris en argument,
     * tout en le redimenssionnant Ã  la taille du composant.
     * @param affiche 
     * @param blob 
     */
    public void setImageSize(Affiche affiche, Blob blob){
        BufferedImage buff;
        try {
            buff = ImageIO.read(blob.getBinaryStream());
            ImageIcon icon = new ImageIcon(buff);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(affiche.getWidth(), affiche.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);
            affiche.setIcon(newImc);
        } catch (IOException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    /**
     * TODO commenter le role de la Méthode
     * @param filmButton
     * @param imagepath
     */
    public static void setButtonSize(JButton filmButton, String imagepath){
        ImageIcon icon = new ImageIcon(imagepath);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(filmButton.getWidth(), filmButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        filmButton.setIcon(newImc);
    }

    /**
     * @param args TO DO COMMENTER
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new HomeView();

    }

    /**
     * get the textField
     * @return compteur;
     */
    public JLabel getCompteur(){
    	return compteur;
    }
    
    /**
     * set le champ compteur
     * @param textfield
     * @param text
     * @return compteur
     */
    public JLabel setCompteur(JLabel textfield, String text){
    	compteur.setText(text + "/3");
    	return compteur;
    }

    /**
     * @return le btnNextbutton
     */
    public JButton getBtnNextbutton() {
        return btnNextbutton;
    }

    /**
     * @param btnNextbutton le btnNextbutton to set
     */
    public void setBtnNextbutton(JButton btnNextbutton) {
        this.btnNextbutton = btnNextbutton;
    }

    /**
     * @return le btnBackbutton
     */
    public JButton getBtnBackbutton() {
        return btnBackbutton;
    }

    /**
     * @param btnBackbutton le btnBackbutton to set
     */
    public void setBtnBackbutton(JButton btnBackbutton) {
        this.btnBackbutton = btnBackbutton;
    }

    /**
     * @return le tm
     */
    public Timer getTm() {
        return tm;
    }

    /**
     * @param tm le tm to set
     */
    public void setTm(Timer tm) {
        this.tm = tm;
    }

    /**
     * @return le choixCombo
     */
    public String[] getChoixCombo() {
        return choixCombo;
    }

    /**
     * @param choixCombo le choixCombo to set
     */
    public void setChoixCombo(String[] choixCombo) {
        this.choixCombo = choixCombo;
    }

    /**
     * @return le textField
     */
    public JTextField getTextField() {
        return txtSearch;
    }

    /**
     * @param textField le textField to set
     */
    public void setTextField(JTextField textField) {
        this.txtSearch = textField;
    }

    /**
     * @return le compteur
     */
    public JLabel getTextField_1() {
        return compteur;
    }

    /**
     * @param compteur le compteur to set
     */
    public void setTextField_1(JLabel compteur) {
        this.compteur = compteur;
    }

    /**
     * @return le affiche1
     */
    public Affiche getAffiche1() {
        return affiche1;
    }

    /**
     * @param affiche1 le affiche1 to set
     */
    public void setAffiche1(Affiche affiche1) {
        this.affiche1 = affiche1;
    }

    /**
     * @return le affiche2
     */
    public Affiche getAffiche2() {
        return affiche2;
    }

    /**
     * @param affiche2 le affiche2 to set
     */
    public void setAffiche2(Affiche affiche2) {
        this.affiche2 = affiche2;
    }

    /**
     * @return le affiche3
     */
    public Affiche getAffiche3() {
        return affiche3;
    }

    /**
     * @param affiche3 le affiche3 to set
     */
    public void setAffiche3(Affiche affiche3) {
        this.affiche3 = affiche3;
    }

    /**
     * @return le affiche4
     */
    public Affiche getAffiche4() {
        return affiche4;
    }

    /**
     * @param affiche4 le affiche4 to set
     */
    public void setAffiche4(Affiche affiche4) {
        this.affiche4 = affiche4;
    }

    /**
     * @return le affiche5
     */
    public Affiche getAffiche5() {
        return affiche5;
    }

    /**
     * @param affiche5 le affiche5 to set
     */
    public void setAffiche5(Affiche affiche5) {
        this.affiche5 = affiche5;
    }

    /**
     * @return le affiche6
     */
    public Affiche getAffiche6() {
        return affiche6;
    }

    /**
     * @param affiche6 le affiche6 to set
     */
    public void setAffiche6(Affiche affiche6) {
        this.affiche6 = affiche6;
    }

    /**
     * TODO commenter le role de la Méthode
     * @param homeController
     */
    public void setController(HomeController homeController) {
        btnNextbutton.addActionListener(homeController);
        btnBackbutton.addActionListener(homeController);
        btnDeconnexion.addActionListener(homeController);
        btnCompte.addActionListener(homeController);
        btnConnexion.addActionListener(homeController);
        rdbtnFilmDuJour.addActionListener(homeController);
        affiche1.addMouseListener(homeController);
        affiche2.addMouseListener(homeController);
        affiche3.addMouseListener(homeController);
        affiche4.addMouseListener(homeController);
        affiche5.addMouseListener(homeController);
        affiche6.addMouseListener(homeController);
        grAction.addMouseListener(homeController);
        grAnimation.addMouseListener(homeController);
        grAutre.addMouseListener(homeController);
        grComedie.addMouseListener(homeController);
        grHorreur.addMouseListener(homeController);
        grDocumentaire.addMouseListener(homeController);
        grFantastique.addMouseListener(homeController);
        grRomance.addMouseListener(homeController);
        grSF.addMouseListener(homeController);
        grThriller.addMouseListener(homeController);
        grAventure.addMouseListener(homeController);
        grDrame.addMouseListener(homeController);
        txtSearch.getDocument().addDocumentListener(homeController);

        tm = new Timer(10000,homeController);
        //tm.start(); 
        
    }
    
    /**
     * @return le txtSearch
     */
    public JTextField getTxtSearch() {
        return txtSearch;
    }

    /**
     * @param txtSearch le txtSearch to set
     */
    public void setTxtSearch(JTextField txtSearch) {
        this.txtSearch = txtSearch;
    }

    /**
     * @return le listPanel
     */
    public ArrayList<Affiche> getListPanel() {
        return listPanel;
    }

    /**
     * @param listPanel le listPanel to set
     */
    public void setListPanel(ArrayList<Affiche> listPanel) {
        this.listPanel = listPanel;
    }
    
    /**
     * @return le lblSF
     */
    public Genre getLblSF() {
        return grAventure;
    }

    /**
     * @param lblSF le lblSF to set
     */
    public void setLblSF(Genre lblSF) {
        this.grAventure = lblSF;
    }

    /**
     * @return le lblAction
     */
    public Genre getLblAction() {
        return grComedie;
    }

    /**
     * @param lblAction le lblAction to set
     */
    public void setLblAction(Genre lblAction) {
        this.grComedie = lblAction;
    }

    /**
     * @return le lblComedie
     */
    public Genre getLblComedie() {
        return grDocumentaire;
    }

    /**
     * @param lblComedie le lblComedie to set
     */
    public void setLblComedie(Genre lblComedie) {
        this.grDocumentaire = lblComedie;
    }

    /**
     * @return le lblThriller
     */
    public Genre getLblThriller() {
        return grDrame;
    }

    /**
     * @param lblThriller le lblThriller to set
     */
    public void setLblThriller(Genre lblThriller) {
        this.grDrame = lblThriller;
    }

    /**
     * @return le lblDrame
     */
    public Genre getLblDrame() {
        return grFantastique;
    }

    /**
     * @param lblDrame le lblDrame to set
     */
    public void setLblDrame(Genre lblDrame) {
        this.grFantastique = lblDrame;
    }

    /**
     * @return le lblAnimation
     */
    public Genre getLblAnimation() {
        return grHorreur;
    }

    /**
     * @param lblAnimation le lblAnimation to set
     */
    public void setLblAnimation(Genre lblAnimation) {
        this.grHorreur = lblAnimation;
    }

    /**
     * @return le lblHorreur
     */
    public Genre getLblHorreur() {
        return grSF;
    }

    /**
     * @param lblHorreur le lblHorreur to set
     */
    public void setLblHorreur(Genre lblHorreur) {
        this.grSF = lblHorreur;
    }

    /**
     * @return le lblFantastique
     */
    public Genre getLblFantastique() {
        return grRomance;
    }

    /**
     * @param lblFantastique le lblFantastique to set
     */
    public void setLblFantastique(Genre lblFantastique) {
        this.grRomance = lblFantastique;
    }

    /**
     * @return le lblRomance
     */
    public Genre getLblRomance() {
        return grThriller;
    }

    /**
     * @param lblRomance le lblRomance to set
     */
    public void setLblRomance(Genre lblRomance) {
        this.grThriller = lblRomance;
    }
    
    /**
     * TODO commenter le role de la Méthode
     * @return list de genres
     */
    public ArrayList<Genre> getFiltres(){
        return new ArrayList<Genre>(Arrays.asList(grAction,grAnimation,grAutre,
                grAventure,grComedie,grDocumentaire,grDrame,grFantastique,grHorreur,
                grRomance,grSF,grThriller));
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

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, 800, Color.decode("#3b3b3b"), true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                
    }   
}