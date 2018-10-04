/*
 * LoginController.java                                10 déc. 2015
 * CESI RILA 2015/2017
 */
package cineGOv02.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cineGOv02.client.view.CreateUserView;
import cineGOv02.client.view.LoginUserView;
import cineGOv02.client.view.RecoverPasswdView;
import cineGOv02.common.entity.User;
import cineGOv02.common.graphics.Controller;
import cineGOv02.common.graphics.MainApp;
import cineGOv02.common.util.PasswordUtil;

/**
 * Controleur de la vue LoginView
 * @author Remi
 */
public class LoginController implements MouseListener, ActionListener{
    /** TODO */
    private MainApp frame;
    /** TODO */
    private JDialog dialog;
    /** Vue dont cette classe est le controller */
    private LoginUserView loginView;
    /** Modele dont cette classe est le contrôleur */
    private SessionFactory factory;
    /** TODO */
    private Controller controller;
    /** Message affiché quand les infos de login sont incorrectes */
    public final String MSG_LOGIN_EMPTY = "Veuillez saisir votre login et mot de passe.";


    /**
     * TODO commenter le role du Constructeur
     * @param frame 
     * @param dialog
     * @param loginView 
     * @param factory 
     * @param parent 
     */
    public LoginController(MainApp frame, JDialog dialog, LoginUserView loginView, SessionFactory factory, 
            Controller controller) {
        this.dialog = dialog;
        this.factory = factory;
        this.loginView = loginView;
        this.controller = controller;
        this.frame = frame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getSource() == loginView.getLblMdp()){
            RecoverPasswdView passwdView = new RecoverPasswdView();
            RecoverPasswdController controller = new RecoverPasswdController(dialog,loginView,passwdView, factory);
            passwdView.setController(controller);
            dialog.setContentPane(passwdView);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
        }else if(event.getSource() == loginView.getLblCreate()){
            CreateUserView createView = new CreateUserView();
            CreateUserController createController = new CreateUserController(frame,dialog, createView, factory);
            createView.setController(createController);
            dialog.setContentPane(createView);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == loginView.getBtnEnvoyer()){
            if(!loginView.getMail().getText().equals("") && !loginView.getMdp().getText().equals("")){
                String mail = loginView.getMail().getText();
                String mdp = loginView.getMdp().getText();
                Session session = factory.openSession();
                session.beginTransaction();
                long rep = (long) session.createQuery("SELECT count(*) FROM User WHERE mail = :mail")
                        .setString("mail", mail)
                        .uniqueResult();
                if(rep > 0){
                    String hash = (String) session.createQuery("SELECT motDePasse FROM User WHERE mail = :mail ")
                            .setString( "mail",  mail).uniqueResult();
                    if(PasswordUtil.checkpw(mdp, hash)){
                        User user = (User) session.createQuery("FROM User WHERE mail = :mail AND motDePasse = :hash")
                                .setString("mail", mail)
                                .setString("hash", hash)
                                .uniqueResult();
                        frame.setUser(user);
                        controller.loadUser(user);
                        dialog.dispose();
                    }else{
                        JOptionPane.showMessageDialog(loginView, "Combinaison identifiant / mot de passe incorecte.");
                    }
                }else{
                    JOptionPane.showMessageDialog(dialog, "Aucun compte n'est enregistré avec cette Mail/Identifiant");
                }
                session.getTransaction().commit();
                session.close();
            }else{
                JOptionPane.showMessageDialog(loginView, "Veuillez renseigner votre login / mot de passe...");
            }
        }else if(event.getSource() == loginView.getBtnRetour()){
            dialog.dispose();
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mousePressed(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}
}