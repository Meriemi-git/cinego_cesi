package cineGOv02.admin.view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

import cineGOv02.admin.controller.LauncherAdminController;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;

/**
 * Vue de lancement de l'application admin.
 * Javadoc Done
 * @author Hugo
 */
public class LauncherAdminView extends JPanel {
	
    /** Combobox choix du cinéma */
    private JComboBox<String> cmbCinema;
    /** Bouton valider cinéma */
    private JButton btnValider;
    /** Bouton ajouter cinéma */
    private JButton btnAjouter;
    /**
     *  Vue de lancement de l'application admin.
     */
    public LauncherAdminView() {
        setPreferredSize(new Dimension(450, 300));
        setSize(new Dimension(265, 225));
        setMinimumSize(new Dimension(265, 225));
        
        JLabel lblCinego = new JLabel("Cinego");
        lblCinego.setHorizontalTextPosition(SwingConstants.CENTER);
        lblCinego.setHorizontalAlignment(SwingConstants.CENTER);
        lblCinego.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblCinego.setForeground(SystemColor.textHighlight);
        
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, new Color(0, 0, 0), new Color(0, 0, 0), SystemColor.textHighlight));
        
        JLabel lblSelectionnezLeCinma = new JLabel("Selectionnez le cinéma à afficher");
        lblSelectionnezLeCinma.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSelectionnezLeCinma.setForeground(Color.BLACK);
        lblSelectionnezLeCinma.setHorizontalTextPosition(SwingConstants.CENTER);
        lblSelectionnezLeCinma.setHorizontalAlignment(SwingConstants.CENTER);
        
        cmbCinema = new JComboBox<String>();
        cmbCinema.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        btnValider = new JButton("Valider");
        btnAjouter = new JButton("Ajouter");
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.desktop, new Color(0, 0, 0), new Color(0, 0, 0), SystemColor.textHighlight));
        
        JLabel lblAjouterUnCinma = new JLabel("Ajouter un cinéma");
        lblAjouterUnCinma.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        /** 
         * WindowsBuilder GroupLayout
         */
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(22)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
        					.addGap(10)
        					.addComponent(btnAjouter, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        					.addGap(35))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addComponent(lblAjouterUnCinma)
        					.addContainerGap(15, Short.MAX_VALUE))))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblAjouterUnCinma)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnAjouter, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        			.addGap(8))
        );
        panel_1.setLayout(gl_panel_1);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addComponent(cmbCinema, Alignment.TRAILING, 0, 220, Short.MAX_VALUE)
        				.addGroup(Alignment.TRAILING, gl_panel.createParallelGroup(Alignment.LEADING)
        					.addComponent(lblSelectionnezLeCinma)
        					.addComponent(btnValider, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSelectionnezLeCinma)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(cmbCinema, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnValider, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        panel.setLayout(gl_panel);
        
        JLabel lblOu = new JLabel("OU");
        lblOu.setHorizontalTextPosition(SwingConstants.CENTER);
        lblOu.setHorizontalAlignment(SwingConstants.CENTER);
        lblOu.setForeground(SystemColor.textHighlight);
        lblOu.setFont(new Font("SansSerif", Font.BOLD, 28));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblOu, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(173)
        					.addComponent(lblCinego)))
        			.addContainerGap(16, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(lblCinego)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(77)
        					.addComponent(lblOu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
        			.addGap(39))
        );
        setLayout(groupLayout);
    }
    /**Getters and setters*/
    /**
     * @return le cmbCinema
     */
    public JComboBox<String> getCmbCinema() {
        return cmbCinema;
    }
    /**
     * @param  cmbCinema to set
     */
    public void setCmbCinema(JComboBox<String> cmbCinema) {
        this.cmbCinema = cmbCinema;
    }
    /**
     * @return le btnValider
     */
    public JButton getBtnAjouter() {
    	return btnAjouter;
    }
    /**
     * @param btnAjouter to set
     */
    public void setBtnAjouter(JButton btnAjouter) {
    	this.btnAjouter = btnAjouter;
    }
    /**
     * @return le btnAjouter
     */
    public JButton getBtnValider() {
        return btnValider;
    }
    /**
     * @param btnValider to set
     */
    public void setBtnValider(JButton btnValider) {
        this.btnValider = btnValider;
    }
    /**
     * Methode où l'on va lier les éléments de la vue à leur controller respectif.
     * @param controller spécifique à la vue.
     */
    public void setController(LauncherAdminController controller){
        cmbCinema.addActionListener(controller);
        btnValider.addActionListener(controller);
        btnAjouter.addActionListener(controller);
    }  
}
