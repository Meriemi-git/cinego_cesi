/*
 * UserCreationView.java                                30 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.client.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class UserCreationView extends JPanel {
    private JButton btnEnvoyer;
    private JButton btnRetour;
    public UserCreationView() {
        setMaximumSize(new Dimension(285, 275));
        setMinimumSize(new Dimension(285, 275));
        setPreferredSize(new Dimension(285, 275));
        
        JLabel label = new JLabel("CineGO");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(SystemColor.textHighlight);
        label.setFont(new Font("Tahoma", Font.BOLD, 30));
        
        JLabel lblCrezVotreCompte = new JLabel("Créez votre compte");
        lblCrezVotreCompte.setHorizontalAlignment(SwingConstants.CENTER);
        lblCrezVotreCompte.setForeground(Color.WHITE);
        lblCrezVotreCompte.setFont(new Font("Tahoma", Font.PLAIN, 16));
        
        btnRetour = new JButton("Retour");
        btnRetour.setForeground(Color.BLACK);
        
        btnEnvoyer = new JButton("Envoyer");
        btnEnvoyer.setForeground(Color.BLACK);
        btnEnvoyer.setFont(new Font("SansSerif", Font.BOLD, 12));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(87)
                            .addComponent(label))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(74)
                            .addComponent(lblCrezVotreCompte))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(64)
                            .addComponent(btnRetour)
                            .addGap(18)
                            .addComponent(btnEnvoyer)))
                    .addContainerGap(55, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblCrezVotreCompte)
                    .addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnRetour)
                        .addComponent(btnEnvoyer))
                    .addGap(29))
        );
        setLayout(groupLayout);
    }
}
