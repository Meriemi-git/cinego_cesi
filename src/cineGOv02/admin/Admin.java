/*
 * Admin.java                                21 janv. 2016
 * CESI RILA 2015/2017
 */
package cineGOv02.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.hibernate.SessionFactory;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;


import cineGOv02.admin.controller.LauncherAdminController;
import cineGOv02.admin.view.LauncherAdminView;
import cineGOv02.common.hibernate.MySQLDataSource;

/**
 * TODO commenter les responsabilités classe
 * @author Hugo
 *
 */
public class Admin {
    /** TODO commenter le Champ */
    private static SessionFactory factory;

    /** TODO commenter le Champ */
    private static Object blocker = new Object();
    /**
     * TODO commenter le role de la Méthode
     * @param args
     */
    public static void main(String[] args) {
        JPanel load = new JPanel();
        JLabel circle = new JLabel(new ImageIcon("ajax-loader-admin.gif"));
        load.setLayout(new BorderLayout());
        load.add(circle,BorderLayout.CENTER);
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(265,250));
        frame.setContentPane(load);
        frame.pack();
        frame.setLocationRelativeTo(null);

        Thread t = new Thread() {
            public void run() { 
                synchronized (blocker) {
                    factory = MySQLDataSource.getInstance().getFactory(); 
                }    
            }
        };
        t.start();  
        //Look and Feel Nimbus
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
        }   
        
        frame.setTitle("Admin");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LauncherAdminView launcherView = new LauncherAdminView();
        synchronized (blocker) {
            LauncherAdminController controller = new LauncherAdminController(frame,launcherView, factory);
            frame.setContentPane(launcherView);
            frame.pack();
            frame.setLocationRelativeTo(null);
        }
    }

}
