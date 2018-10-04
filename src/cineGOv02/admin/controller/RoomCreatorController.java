/*
 * RoomCreatorController.java                                11 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.admin.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import cineGOv02.admin.view.RoomCreatorView;
import cineGOv02.common.entity.Salle;
import cineGOv02.common.graphics.EcranIcon;
import cineGOv02.common.graphics.SalleIcon;
import cineGOv02.common.graphics.SiegeIcon;
import cineGOv02.common.graphics.WallIcon;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class RoomCreatorController implements MouseListener, ActionListener, KeyListener{

    /** TODO commenter le Champ */
    private static RoomCreatorView roomView;
    /** TODO commenter le Champ */
    private JPanel[][] panelIcon;
    /** TODO commenter le Champ */
    private BufferedImage bufferImage;
    /** TODO commenter le Champ */
    private static int X;
    /** TODO commenter le Champ */
    private static int Y;
    /** TODO commenter le Champ */
    private static int size = 44;
    /** TODO commenter le Champ */
    private JFrame frame;
    /** TODO commenter le Champ */
    private boolean ajout, suppr, normal, hand, allee;
    /** TODO commenter le Champ */      
    private ImageIcon selectedIcon, selectedIconAllee, selectedIconSiege, selectedIconPorte,
    selectedIconHand, selectedIconEcran, iconeSiege, iconeSiegeHand, iconeAllee, iconeEcran, iconePorte = null;

    private final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

    private DocumentBuilder builder = null;

    private Salle salle;

    private DOMSource XMLsource;

    private String XMLText;

    private SessionFactory factory;


    /**
     * TODO commenter le role du Constructeur
     * @param frame
     * @param factory 
     */
    public RoomCreatorController(JFrame frame, SessionFactory factory){
        this.factory = factory;
        Session session = factory.openSession();
        session.getTransaction().begin();
        salle = (Salle) session.createQuery("FROM Salle WHERE id = :id")
                .setInteger("id", 1).uniqueResult();
        session.close();
        this.frame = frame;
        roomView = new RoomCreatorView();
        roomView.setController(this);
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
        } catch (IOException e) {}

        frame.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent event) {
                if(panelIcon.length > 0){
                    if(event.getWheelRotation() < 0 && size < 80 ){
                        size++;
                    }else if(size > roomView.getScrollPane().getWidth() / X){
                        size--;
                    }
                    for(int x = 0 ; x < X ; x++){
                        for(int y = 0 ; y < Y ; y++){  
                            panelIcon[x][y].setMinimumSize(new Dimension(size, size));
                            panelIcon[x][y].setPreferredSize(new Dimension(size, size));
                            panelIcon[x][y].setMaximumSize(new Dimension(size, size));
                            if(panelIcon[x][y].getComponent(0) instanceof SiegeIcon && ((SalleIcon)panelIcon[x][y].getComponent(0)).isSet()){
                                if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isNormal()){
                                    selectedIconSiege = new ImageIcon(iconeSiege.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                                    ((SiegeIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconSiege);
                                }else if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isHand()){
                                    selectedIconHand = new ImageIcon(iconeSiegeHand.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                                    ((SiegeIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconHand);
                                }else if (((SiegeIcon)panelIcon[x][y].getComponent(0)).isAllee()){
                                    selectedIconAllee = new ImageIcon(iconeAllee.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                                    ((SiegeIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconAllee);
                                }
                                ((SiegeIcon)panelIcon[x][y].getComponent(0)).revalidate();
                            }else if(panelIcon[x][y].getComponent(0) instanceof WallIcon){
                                if(((WallIcon) panelIcon[x][y].getComponent(0)).isEcran()){
                                    selectedIconEcran = new ImageIcon(iconeEcran.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                                    ((WallIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconEcran);
                                }else if(((WallIcon) panelIcon[x][y].getComponent(0)).isEcran()){
                                    selectedIconEcran = new ImageIcon(iconeEcran.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                                    ((WallIcon)panelIcon[x][y].getComponent(0)).setIcon(selectedIconEcran);
                                }
                            }
                            panelIcon[x][y].revalidate();
                        }
                    }
                }
            }
        });
    }

    /**
     * TODO commenter le role de la Méthode
     */
    private void generationPlan() {
        Thread t = new Thread(){
            public void run(){
                panelIcon = new JPanel[X][Y];
                JPanel plan = roomView.getPlan();
                size = plan.getWidth() / X;
                System.out.println("plan size" + plan.getWidth());
                plan.removeAll();
                plan.setLayout(new GridLayout(X, Y));
                for(int x = 0 ; x < X ;x++){
                    for(int y = 0 ; y < Y ; y++){
                        if(x == 0 || x == X-1 || y == 0 || y == Y-1){
                            generateWallIcon(plan,panelIcon,x,y);
                        }else{
                            generateSiegeIcon(plan,panelIcon,x,y);
                        }
                    }
                } 
                int largeur = Y / 3 + (Y % 3 == 0 ? 0 : 1);
                int debut = (Y / 2) - (largeur / 2);
                for (int i = debut; i < debut+largeur; i++){
                    WallIcon ecran = new WallIcon();
                    selectedIconEcran = new ImageIcon(iconeEcran.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH));
                    ecran.setIcon(selectedIconEcran);
                    panelIcon[0][i].removeAll();
                    ecran.setEcran(true);
                    panelIcon[0][i].add(ecran);
                    panelIcon[0][i].revalidate();

                }
            }
        };t.start();
    }

    /**
     * TODO commenter le role de la Méthode
     * @param panelIcon2
     * @param x2
     * @param y2
     */
    private void generateWallIcon(JPanel plan, JPanel[][] panelIcon, int x, int y) {
        panelIcon[x][y] = new JPanel();
        panelIcon[x][y].setMinimumSize(new Dimension(size, size));
        panelIcon[x][y].setPreferredSize(new Dimension(size, size));
        panelIcon[x][y].setMaximumSize(new Dimension(size, size));
        panelIcon[x][y].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelIcon[x][y].setLayout(new BorderLayout());
        WallIcon wall = new WallIcon();
        wall.setBounds(0, 0, 0, 0);
        wall.setAnX(x);
        wall.setAnY(y);
        panelIcon[x][y].addMouseListener(this);
        panelIcon[x][y].setBorder(null);
        panelIcon[x][y].setBackground(Color.GRAY);
        //siege.setIcon(icone);
        panelIcon[x][y].add(wall, BorderLayout.CENTER);
        plan.add(panelIcon[x][y]);
        panelIcon[x][y].revalidate();
    }

    /**
     * TODO commenter le role de la Méthode
     * @param panelIcon2
     * @param x2
     * @param y2
     */
    private void generateSiegeIcon(JPanel plan, JPanel[][] panelIcon, int x, int y) {
        panelIcon[x][y] = new JPanel();
        panelIcon[x][y].setMinimumSize(new Dimension(size, size));
        panelIcon[x][y].setPreferredSize(new Dimension(size, size));
        panelIcon[x][y].setMaximumSize(new Dimension(size, size));
        panelIcon[x][y].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        panelIcon[x][y].setLayout(new BorderLayout());
        SiegeIcon siege = new SiegeIcon();
        siege.setBounds(0, 0, 0, 0);
        siege.setAnX(x);
        siege.setAnY(y);
        panelIcon[x][y].addMouseListener(this);
        //siege.setIcon(icone);
        panelIcon[x][y].add(siege, BorderLayout.CENTER);
        plan.add(panelIcon[x][y]);
        panelIcon[x][y].revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent event) {}

    @Override
    public void mouseEntered(MouseEvent event) {
        if(((SalleIcon)((JPanel)event.getSource()).getComponent(0)) instanceof SiegeIcon){
            normal = false;
            hand = false;
            allee= false;
            if(ajout){
                ((JPanel)event.getSource()).setBorder(null);
                ImageIcon icon = null;
                if(roomView.getRdbSiegeNormal().isSelected()){
                    normal = true;
                    icon = new ImageIcon(iconeSiege.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setNormal(normal);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setHand(hand);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setAllee(allee);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setSet(true);
                    ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(icon);
                    ((JPanel)event.getSource()).setBorder(null);
                    ((JPanel)event.getSource()).getComponent(0).revalidate();
                }else if(roomView.getRdbSiegeHand().isSelected()){
                    hand = true;
                    icon = new ImageIcon(iconeSiegeHand.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setNormal(normal);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setHand(hand);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setAllee(allee);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setSet(true);
                    ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(icon);
                    ((JPanel)event.getSource()).setBorder(null);
                    ((JPanel)event.getSource()).getComponent(0).revalidate();
                }else if (roomView.getRdbAllee().isSelected()){
                    allee = true;
                    icon = new ImageIcon(iconeAllee.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setNormal(normal);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setHand(hand);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setAllee(allee);
                    ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setSet(true);
                    ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(icon);
                    ((JPanel)event.getSource()).setBorder(null);
                    ((JPanel)event.getSource()).getComponent(0).revalidate();
                }
            }else if(suppr){
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setNormal(normal);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setHand(hand);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setAllee(allee);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setSet(false);
                ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(null);
                ((JPanel)event.getSource()).setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                ((JPanel)event.getSource()).getComponent(0).revalidate();
            }
        }else if(((SalleIcon)((JPanel)event.getSource()).getComponent(0)) instanceof WallIcon){
            if(ajout){
                ((JPanel)event.getSource()).setBorder(null);
                ImageIcon icon = null;
                if(roomView.getRdbPorte().isSelected()){
                    icon = new ImageIcon(iconePorte.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
                    ((WallIcon)((JPanel)event.getSource()).getComponent(0)).setPorte(true);
                    ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(icon);
                    ((JPanel)event.getSource()).setBorder(null);
                    ((JPanel)event.getSource()).getComponent(0).revalidate();
                }
            }else if(suppr){
                ((WallIcon)((JPanel)event.getSource()).getComponent(0)).setPorte(false);
                ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(null);
                ((JPanel)event.getSource()).getComponent(0).revalidate();
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent event) {
        if(((SalleIcon)((JPanel)event.getSource()).getComponent(0)) instanceof SiegeIcon){
            normal = false;
            hand = false;
            allee= false;
            if(SwingUtilities.isLeftMouseButton(event)){
                ajout = true;
                ((JPanel)event.getSource()).setBorder(null);
                ImageIcon icone = null;
                if(roomView.getRdbSiegeNormal().isSelected()){
                    normal = true;
                    icone = new ImageIcon(iconeSiege.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
                }else if(roomView.getRdbSiegeHand().isSelected()){
                    hand = true;
                    icone = new ImageIcon(iconeSiegeHand.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
                }else if (roomView.getRdbAllee().isSelected()){
                    allee = true;
                    icone = new ImageIcon(iconeAllee.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
                }
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setSet(true);
                ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(icone);
                ((JPanel)event.getSource()).setBorder(null);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setNormal(normal);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setHand(hand);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setAllee(allee);
                ((JPanel)event.getSource()).getComponent(0).revalidate();
            }else if(SwingUtilities.isRightMouseButton(event)){
                suppr = true;
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setNormal(normal);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setHand(hand);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setAllee(allee);
                ((SiegeIcon)((JPanel)event.getSource()).getComponent(0)).setSet(false);
                ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(null);
                ((JPanel)event.getSource()).setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                ((JPanel)event.getSource()).getComponent(0).revalidate();
            }
        }else if(((SalleIcon)((JPanel)event.getSource()).getComponent(0)) instanceof WallIcon){
            if(SwingUtilities.isLeftMouseButton(event)){
                ajout = true;
                ((JPanel)event.getSource()).setBorder(null);
                ImageIcon icone = null;
                if(roomView.getRdbPorte().isSelected()){
                    icone = new ImageIcon(iconePorte.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
                    ((WallIcon)((JPanel)event.getSource()).getComponent(0)).setPorte(true);
                    ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(icone);
                    ((JPanel)event.getSource()).setBorder(null);
                    ((JPanel)event.getSource()).getComponent(0).revalidate();
                }
            }else if(SwingUtilities.isRightMouseButton(event)){
                suppr = true;
                ((WallIcon)((JPanel)event.getSource()).getComponent(0)).setPorte(false);
                ((JLabel) ((JPanel)event.getSource()).getComponent(0)).setIcon(null);
                ((JPanel)event.getSource()).setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                ((JPanel)event.getSource()).getComponent(0).revalidate();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ajout = false;
        suppr = false;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == roomView.getBtnGenerer()){
            if(!roomView.getTxtColonnes().getText().equals("")
                    && !roomView.getTxtRangees().getText().equals("")){ 
                int x = Integer.parseInt(roomView.getTxtRangees().getText());
                int y =  Integer.parseInt(roomView.getTxtColonnes().getText());
                if(x > 0 && y > 0){
                    Y = x + 2;
                    X = y + 2;
                    generationPlan();
                }else{
                    JOptionPane.showInternalMessageDialog(roomView, "Les dimensions de la salle ne peuvent être nulle", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                }

            }       
        }else if(event.getSource() == roomView.getBtnExporter()){
            genererXML();
            exportXMLFile();
        }else if(event.getSource() == roomView.getBtnEnregistrer()){
            genererXML();
            enregistrerPlan();
        }
    }

    /**
     * TODO commenter le role de la Méthode
     */
    private void enregistrerPlan() {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(XMLsource, new StreamResult(sw));
            XMLText = sw.toString();
            salle.setPlanDeSalle(XMLText);
            Session session = factory.openSession();
            session.getTransaction().begin();
            session.update(salle);
            session.getTransaction().commit();
            session.close();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO commenter le role de la Méthode
     */
    private void genererXML() {
        try {
            builder = documentFactory.newDocumentBuilder();
            Document document= builder.newDocument();
            final Element racine = document.createElement("plan");
            Comment commentaire = document.createComment("Representation d'un plan de salle au format XML");
            racine.setAttribute("lignes", Y+"");
            racine.setAttribute("colonnes", X+"");
            document.appendChild(racine);
            document.appendChild(commentaire);
            for(int x = 0 ; x < panelIcon.length; x++){
                for(int y = 0; y < panelIcon[x].length; y++){
                    if(panelIcon[x][y].getComponent(0) instanceof WallIcon) {
                        Element element = document.createElement("element");
                        element.setAttribute("X", x+"");
                        element.setAttribute("Y", y+"");
                        if(((WallIcon) panelIcon[x][y].getComponent(0)).isEcran()){
                            element.setAttribute("type", "ecran");  
                            racine.appendChild(element);
                        }else if(((WallIcon) panelIcon[x][y].getComponent(0)).isPorte()){
                            element.setAttribute("type", "porte");
                            racine.appendChild(element);
                        }         
                    }else if(panelIcon[x][y].getComponent(0) instanceof SiegeIcon){
                        Element element = document.createElement("element");
                        element.setAttribute("X", x+"");
                        element.setAttribute("Y", y+"");
                        if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isSet()){
                            if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isAllee()){
                                element.setAttribute("type", "allee");
                            }else if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isHand()){
                                element.setAttribute("type", "hand");
                            }else if(((SiegeIcon)panelIcon[x][y].getComponent(0)).isNormal()){
                                element.setAttribute("type", "normal");
                            }
                        }
                        racine.appendChild(element);
                    }
                }
            }
            XMLsource = new DOMSource(document);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * TODO commenter le role de la Méthode
     */
    public void exportXMLFile(){
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer;
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StreamResult xmlFile = new StreamResult(new File("plan.xml"));
            transformer.transform(XMLsource, xmlFile);
            System.out.println("export ok");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return le roomView
     */
    public RoomCreatorView getRoomView() {
        return roomView;
    }

    /**
     * @param roomView le roomView to set
     */
    public static void setRoomView(RoomCreatorView roomView) {
        RoomCreatorController.roomView = roomView;
    }

    /**
     * @return le frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @param frame le frame to set
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void keyPressed(KeyEvent event) {}
    @Override
    public void keyReleased(KeyEvent event) {  }

    @Override
    public void keyTyped(KeyEvent event) {
        char c = event.getKeyChar();
        if(!Character.isDigit(c) || ((JTextField) event.getSource()).getText().length() > 1){
            event.consume();
        }
    }
}
