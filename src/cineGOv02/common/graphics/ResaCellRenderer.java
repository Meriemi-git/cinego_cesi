/*
 * ResaCellRenderer.java                                9 févr. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.common.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;

import cineGOv02.common.entity.Reservation;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class ResaCellRenderer extends JTextPane implements ListCellRenderer {
    private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    private JLabel lab = new JLabel();
    JTextPane pane = new JTextPane();
    private ImageIcon image;
    Calendar cal = Calendar.getInstance();
    /**
     * TODO commenter le role du Constructeur
     */
    public ResaCellRenderer() {
        setOpaque(false);
        this.setLayout(new BorderLayout());
        lab.setOpaque(false);
        pane.setOpaque(false);
    }

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        Reservation resa = (Reservation) value;
        cal.setTime(resa.getSeance().getDebut());
        try {
            BufferedImage buff = ImageIO.read(resa.getSeance().getFilm().getImage().getBinaryStream());
            ImageIcon icon = new ImageIcon(buff);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(67, 90, Image.SCALE_SMOOTH);
            image = new ImageIcon(newImg);
            lab.setIcon(image);
            pane.setText(resa.toString());
            this.add(lab, BorderLayout.WEST);
            this.add(pane, BorderLayout.CENTER);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date today = new Date();
        cal.add(Calendar.HOUR, -24);
        if(today.getTime() < cal.getTimeInMillis()){
            pane.setForeground(SystemColor.textHighlight);
        }else{
            pane.setForeground(Color.BLACK);
        }
        if (isSelected) {
            setForeground(SystemColor.textHighlight);
        } else {
            //setBackground(Color.white);
            setForeground(Color.black);
        }


        return this;
    }
}
