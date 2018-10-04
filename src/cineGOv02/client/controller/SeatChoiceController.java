/*
 * SeatChoiceController.java                                6 mars 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import cineGOv02.client.view.ReservationView;
import cineGOv02.client.view.SeatChoiceView;
import cineGOv02.common.graphics.EcranIcon;
import cineGOv02.common.graphics.MainApp;
import cineGOv02.common.graphics.SalleIcon;
import cineGOv02.common.graphics.SiegeIcon;
import cineGOv02.common.graphics.WallIcon;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class SeatChoiceController implements ActionListener {
    /** TODO commenter le Champ */
    private MainApp frame;
    /** TODO commenter le Champ */
    private SeatChoiceView seatView;
    /** TODO commenter le Champ */
    private SessionFactory factory;
    /** TODO commenter le Champ */
    private String plan;
    /** TODO commenter le Champ */
    private JPanel[][] panelIcon;
    /** TODO commenter le Champ */
    private static int X;
    /** TODO commenter le Champ */
    private static int Y;
    /** TODO commenter le Champ */
    private static int size = 44;
    /** TODO */
    private ImageIcon selectedIconAllee, selectedIconSiege, selectedIconPorte,
    selectedIconHand, selectedIconEcran,selectedIconMur, iconeSiege, iconeSiegeHand, iconeAllee, iconeEcran, iconePorte, iconeMur = null;
    /** TODO commenter le Champ */
    private BufferedImage bufferImage;
    /** TODO */
    private JPanel grille; 

    /**
     * TODO commenter le role du Constructeur
     * @param frame
     * @param seatView2
     * @param factory
     */
    public SeatChoiceController(MainApp frame, SeatChoiceView seatView2, SessionFactory factory) {
        super();
        this.frame = frame;
        this.seatView = seatView2;
        this.factory = factory;
        plan = frame.getReservation().getSeance().getSalle().getPlanDeSalle();
        try {
            bufferImage = ImageIO.read(new File("siege.png"));
            iconeSiege = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("siegeHand.png"));
            iconeSiegeHand = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("allee.png"));
            iconeAllee = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("ecran.png"));
            iconeEcran = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("porte.png"));
            iconePorte = new ImageIcon(bufferImage);
            bufferImage = ImageIO.read(new File("wall.png"));
            iconeMur = new ImageIcon(bufferImage);
        } catch (IOException e) {}
        loadMap();
    }

    /**
     * TODO commenter le role de la Méthode
     */
    private void loadMap() {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(plan));
            Document doc = db.parse(is);
            Element root = doc.getDocumentElement();
            X = Integer.parseInt(root.getAttribute("colonnes"));
            Y = Integer.parseInt(root.getAttribute("lignes"));
            grille = seatView.getPlan();
            size = 742 / X;
            System.out.println("size: " + size + " x :" + X + " width : " + grille.getWidth());
            grille.removeAll();
            grille.setLayout(new GridLayout(X, Y));
            panelIcon = new JPanel[X][Y];
            NodeList nodes = doc.getElementsByTagName("element");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                int x = Integer.parseInt(element.getAttribute("X"));
                int y = Integer.parseInt(element.getAttribute("Y"));
                System.out.println("x:" + x + "y:" + y);
                String type = element.getAttribute("type");
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.setMinimumSize(new Dimension(size, size));
                panel.setPreferredSize(new Dimension(size, size));
                panel.setMaximumSize(new Dimension(size, size));
                SalleIcon icon = null;
                switch(type){
                case "ecran":
                    icon = new WallIcon();
                    ((WallIcon)icon).setEcran(true);
                    break;
                case "porte":
                    icon = new WallIcon();
                    ((WallIcon) icon).setPorte(true);
                    break;
                case "normal":
                    icon = new SiegeIcon();
                    ((SiegeIcon) icon).setNormal(true);
                    ((SiegeIcon) icon).setHand(false);
                    ((SiegeIcon) icon).setAllee(false);
                    panel.setBackground(Color.DARK_GRAY);
                    break;
                case "hand":
                    icon = new SiegeIcon();
                    ((SiegeIcon) icon).setNormal(false);
                    ((SiegeIcon) icon).setHand(true);
                    ((SiegeIcon) icon).setAllee(false);
                    panel.setBackground(Color.DARK_GRAY);
                    break;
                case "allee":
                    icon = new SiegeIcon();
                    ((SiegeIcon) icon).setNormal(false);
                    ((SiegeIcon) icon).setHand(false);
                    ((SiegeIcon) icon).setAllee(true);
                    panel.setBackground(Color.DARK_GRAY);
                    break;
                }
                panel.add(icon);
                panelIcon[x][y] = panel;
            }

            for(int x = 0 ; x < X ; x++){
                for(int y = 0 ; y < Y ; y++){
                    if(x == 0 || y == 0 || x == X-1 || y == Y-1){
                        if(panelIcon[x][y] == null){
                            JPanel panel = new JPanel();
                            panel.setLayout(new BorderLayout());
                            WallIcon wall = new WallIcon();
                            selectedIconMur = new ImageIcon(iconeMur.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                            wall.setIcon(selectedIconMur);
                            panel.add(wall, BorderLayout.CENTER);
                            panelIcon[x][y] = panel;
                        }else if(((WallIcon)panelIcon[x][y].getComponent(0)).isEcran()){
                            selectedIconEcran = new ImageIcon(iconeEcran.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                            ((WallIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconEcran);
                        }else if(((WallIcon)panelIcon[x][y].getComponent(0)).isPorte()){
                            selectedIconPorte = new ImageIcon(iconePorte.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                            ((WallIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconPorte);
                        }
                    }else{
                        if(!(panelIcon[x][y] == null)){
                            if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isNormal()){
                                selectedIconSiege = new ImageIcon(iconeSiege.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                                ((SiegeIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconSiege); 
                            }else if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isHand()){
                                selectedIconHand = new ImageIcon(iconeSiegeHand.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                                ((SiegeIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconHand); 
                            }else if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isAllee()){
                                selectedIconAllee = new ImageIcon(iconeAllee.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                                ((SiegeIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconAllee); 
                            }
                        }
                    }
                    panelIcon[x][y].revalidate();
                    grille.add(panelIcon[x][y]);
                }
            }
            grille.revalidate();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub  
    }

}
