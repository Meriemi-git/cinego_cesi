/*
 * RoomCreator.java                                23 nov. 2015
 * IUT Info1 2013-2014 Groupe 3
 */
package Test.swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import cineGOv02.common.graphics.SiegeIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class RoomCreator extends JFrame {

    /** TODO commenter le Champ */
    private JPanel contentPane;
    /** TODO commenter le Champ */
    private JTextField nbRangees;
    /** TODO commenter le Champ */
    private JTextField nbSiege;
    /** TODO commenter le Champ */
    private int rangees;
    /** TODO commenter le Champ */
    private int sieges;
    /** TODO commenter le Champ */
    private BufferedImage myPicture;

    /** TODO commenter le Champ */
    private JPanel gridPanel = new JPanel();

    /** TODO commenter le Champ */
    private JPanel infoPanel = new JPanel();

    /** TODO commenter le Champ */
    private SiegeIcon[][] places ;

    /** TODO commenter le Champ */
    private StringBuilder txt = new StringBuilder();

    /** TODO commenter le Champ */
    private JTextArea siegeSelected;
    
    /** TODO commenter le Champ */
    private boolean startSelect = false;
    /**
     * Launch the application.
     * @param args 
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RoomCreator frame = new RoomCreator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RoomCreator() {
        try {
            myPicture = ImageIO.read(new File("siege.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 715, 461);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        infoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        infoPanel.setBounds(0, 11, 207, 410);
        contentPane.add(infoPanel);
        infoPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre de rangées");
        lblNewLabel.setBounds(10, 11, 100, 14);
        infoPanel.add(lblNewLabel);

        nbRangees = new JTextField();
        nbRangees.setBounds(148, 8, 49, 20);
        infoPanel.add(nbRangees);
        nbRangees.setColumns(10);

        JLabel lblNombreDeSiges = new JLabel("Nombre de sièges / rangées");
        lblNombreDeSiges.setBounds(10, 36, 134, 14);
        infoPanel.add(lblNombreDeSiges);

        nbSiege = new JTextField();
        nbSiege.setBounds(148, 33, 49, 20);
        infoPanel.add(nbSiege);
        nbSiege.setColumns(10);

        JButton btnEnvoyer = new JButton("Envoyer");
        btnEnvoyer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                siegeSelected.setText("");
                int rangees = Integer.parseInt(nbRangees.getText());
                int sieges = Integer.parseInt(nbSiege.getText());
                places = new SiegeIcon[sieges][rangees];

                gridPanel.removeAll();

                ImageIcon icone = new ImageIcon(RoomCreator.this.myPicture);

                int iconeWidth = 44;
//                if(rangees >= sieges){
//                    iconeWidth = contentPane.getHeight() / rangees;
//                }else{
//                    iconeWidth = contentPane.getHeight() / rangees;
//                }
//                if(iconeWidth > 45){
//                    iconeWidth = 45;
//                }
                int x = infoPanel.getWidth() 
                        + ((contentPane.getWidth() - infoPanel.getWidth())/2) 
                        - ((sieges * iconeWidth)/2);
                int y = (contentPane.getHeight()/2) 
                        - ((rangees*iconeWidth)/2);
               // icone = new ImageIcon(icone.getImage().getScaledInstance(44, 40, Image.SCALE_DEFAULT));
                gridPanel.setBounds( x, y, rangees*iconeWidth+sieges+1, sieges*iconeWidth+rangees+1);
                gridPanel.setLayout(new GridLayout(sieges,rangees));

                for(int i = 0; i < sieges; i++){
                    for(int j = 0 ; j < rangees ; j++){
                        places[i][j] = new SiegeIcon();
                        places[i][j].setAnX(i);
                        places[i][j].setAnY(j);
                        places[i][j].add(new JLabel(icone));
                        //places[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                        places[i][j].setSize(new Dimension(iconeWidth,iconeWidth)); 
                        places[i][j].addMouseListener(new MouseListenerPerso());
                        gridPanel.add(places[i][j]);
                        //places[i][j].revalidate();
                    }
                }
                JPanel content = new JPanel();
                content.setLayout(new BorderLayout());
                
                JScrollPane scrollPane = new JScrollPane(gridPanel);
                scrollPane.setPreferredSize(new Dimension(300, 200));
                scrollPane.setMaximumSize(new Dimension(300, 200));
                scrollPane.setMinimumSize(new Dimension(300, 200));
                scrollPane.setSize(new Dimension(300, 200));
                content.add(scrollPane, BorderLayout.CENTER);
                contentPane.add(content);
                scrollPane.revalidate();
                gridPanel.revalidate();

            }
        });

        btnEnvoyer.setBounds(10, 62, 89, 23);
        infoPanel.add(btnEnvoyer);      

        siegeSelected = new JTextArea();
        siegeSelected.setEditable(false);
        siegeSelected.setBounds(10, 121, 100, 266);
        infoPanel.add(siegeSelected);

        JLabel lblSiegesSelectionns = new JLabel("Sieges Selectionnés :");
        lblSiegesSelectionns.setBounds(10, 96, 134, 14);
        infoPanel.add(lblSiegesSelectionns);
    }

    /**
     * TODO commenter les responsabilités classe
     * @author Remi
     *
     */
    class MouseListenerPerso implements MouseListener{
        
        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseEntered(MouseEvent e) {
            if(startSelect){
                RoomCreator.this.txt.append("x : " +((SiegeIcon)e.getComponent()).getAnX() 
                        + " y : " + ((SiegeIcon)e.getComponent()).getAnY() + '\n');
                System.out.println("Enterred" + "x : " +((SiegeIcon)e.getComponent()).getAnX() 
                        + " y : " + ((SiegeIcon)e.getComponent()).getAnY());
                ((SiegeIcon)e.getComponent()).setBorder(BorderFactory.createLineBorder(Color.RED));
                Component source=(Component)e.getComponent();
                source.getParent().dispatchEvent(e);
            }
        }

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseExited(MouseEvent e) {
            Component source=(Component)e.getComponent();
            source.getParent().dispatchEvent(e);

        }

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
         */
        @Override
        public void mousePressed(MouseEvent e) {
            startSelect = true;
            System.out.println("Pressed" + "x : " +((SiegeIcon)e.getComponent()).getAnX() 
                    + " y : " + ((SiegeIcon)e.getComponent()).getAnY());
            RoomCreator.this.txt.append("x : " +((SiegeIcon)e.getComponent()).getAnX() 
                    + " y : " + ((SiegeIcon)e.getComponent()).getAnY() + '\n');
            Component source=(Component)e.getComponent();
            source.getParent().dispatchEvent(e);

        }

        /* (non-Javadoc)
         * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            startSelect = false;
            siegeSelected.setText(txt.toString());
            System.out.println("Releassed" + "x : " +((SiegeIcon)e.getComponent()).getAnX() 
                    + " y : " + ((SiegeIcon)e.getComponent()).getAnY());
        }

    }
}
