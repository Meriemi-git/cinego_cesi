/*
 * LauncherView.java                                19 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import cineGOv02.client.controller.LauncherController;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 */
public class LauncherView extends JPanel {
    /** TODO commenter le Champ */
    private JComboBox<String> cmbCinema;
    /** TODO commenter le Champ */
    private JButton btnValider;
    /**
     * TODO commenter le role du Constructeur
     */
    public LauncherView() {
        setPreferredSize(new Dimension(265, 225));
        setSize(new Dimension(265, 225));
        setMinimumSize(new Dimension(265, 225));
        
        JLabel lblCinego = new JLabel("Cinego");
        lblCinego.setHorizontalTextPosition(SwingConstants.CENTER);
        lblCinego.setHorizontalAlignment(SwingConstants.CENTER);
        lblCinego.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblCinego.setForeground(SystemColor.textHighlight);
        
        JLabel lblSelectionnezLeCinma = new JLabel("Selectionnez le cinéma à afficher");
        lblSelectionnezLeCinma.setForeground(Color.WHITE);
        lblSelectionnezLeCinma.setHorizontalTextPosition(SwingConstants.CENTER);
        lblSelectionnezLeCinma.setHorizontalAlignment(SwingConstants.CENTER);
        
        cmbCinema = new JComboBox<String>();
        
        btnValider = new JButton("Valider");
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(82)
                            .addComponent(lblCinego))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(42)
                            .addComponent(lblSelectionnezLeCinma))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(99)
                            .addComponent(btnValider))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(60)
                            .addComponent(cmbCinema, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(43, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(19)
                    .addComponent(lblCinego)
                    .addGap(12)
                    .addComponent(lblSelectionnezLeCinma)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(cmbCinema, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnValider))
        );
        setLayout(groupLayout);
    }
    /**
     * @return le cmbCinema
     */
    public JComboBox<String> getCmbCinema() {
        return cmbCinema;
    }
    /**
     * @param cmbCinema le cmbCinema to set
     */
    public void setCmbCinema(JComboBox<String> cmbCinema) {
        this.cmbCinema = cmbCinema;
    }
    /**
     * @return le btnValider
     */
    public JButton getBtnValider() {
        return btnValider;
    }
    /**
     * @param btnValider le btnValider to set
     */
    public void setBtnValider(JButton btnValider) {
        this.btnValider = btnValider;
    }
    /**
     * TODO commenter le role de la Méthode
     * @param controller
     */
    public void setController(LauncherController controller){
        cmbCinema.addActionListener(controller);
        btnValider.addActionListener(controller);
    }
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.black, 0, this.getHeight(), Color.decode("#3b3b3b"), true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                
    }   
}
