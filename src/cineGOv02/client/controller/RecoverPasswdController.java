/*
 * RecoverPasswordController.java                                13 déc. 2015
 * CESI RILA 2015/2017
 */
package cineGOv02.client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cineGOv02.client.view.LoginUserView;
import cineGOv02.client.view.RecoverPasswdView;
import cineGOv02.common.entity.User;
import cineGOv02.common.util.EmailVerifier;
import cineGOv02.common.util.PasswordUtil;
import cineGOv02.common.util.SendAMail;

/**
 * Controlleur associé à la vue RecoverPasswordView.
 * Permet d'agir en fonction des évènements déclenchés par la vue et d'apeller 
 * les fonctions du modèle correspondantes.
 * @author Remi
 *
 */
public class RecoverPasswdController implements ActionListener{
    /** Vue dont cette classe est le controller */
    private RecoverPasswdView passwdView;
    /** TODO */
    private JDialog dialog;
    /** TODO */
    private SessionFactory factory;
    /** TODO */
    private LoginUserView loginView;

    /**
     * Constructeur du controller permettant de définir la vue et le modèle associé.
     * @param dialog 
     * @param loginView 
     * @param passwdView 
     * @param factory 
     */
    public RecoverPasswdController(JDialog dialog, LoginUserView loginView, RecoverPasswdView passwdView, SessionFactory factory) {
        this.dialog = dialog;
        this.factory = factory;
        this.passwdView = passwdView;
        this.loginView = loginView;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        // Si l'utilisateur clique sur le bouton "Envoyer"
        if(event.getSource() == passwdView.getBtnEnvoyer()){
            System.out.println(event);
            JFormattedTextField mailField = (JFormattedTextField) passwdView.getTxtMail();
            EmailVerifier verifier = new EmailVerifier();
            String mail = mailField.getText();
            // On désactive les widget de saisie le temps de la vérification
            passwdView.getBtnEnvoyer().setEnabled(false);
            passwdView.getTxtMail().setEditable(false);
          
            // On lance un nouveau thread pour éviter de freezer l'interface
            Thread t = new Thread() {
                public void run() {
                    User user = userExist(mail);
                    if(verifier.verify(mailField)){
                        if(user != null){
                            // Si le mail est valide syntaxiquement
                            Session session = factory.openSession();
                            session.beginTransaction();
                            // On génrère un nouveau mot de passe
                            String password = PasswordUtil.genPassword();
                            // On génère le hash correspondant
                            String hash = PasswordUtil.hashpw(password, PasswordUtil.gensalt(12));
                            // On met à jour le mot de passe en BD en y stockant le hash
                            String hqlUpdate =
                                    "update User u set u.motDePasse = :newPasswd where u.mail = :mail " ;
                            session.createQuery( hqlUpdate )
                            .setString( "newPasswd",  hash)
                            .setString( "mail", mail )
                            .executeUpdate();
                            session.getTransaction().commit();
                            session.close();
                            // On cré le texte pour le corp du mail
                            String body = "Bonjour " + user.getPrenom() + "<br /><br />Vous recevez ce message car vous avez demandé la réinitialisation"
                                    + " de votre mot de passe.<br /><br />Le voici : <strong>" + password + "</strong><br /><br />"
                                    + "Amicalement, l'équipe de CineGo.";
                            // On envoit le mail
                            Thread sendMail = new Thread(){
                                public void run(){
                                    try {
                                        SendAMail.send("remi.plantade.pro@gmail.com", mail, body,"Réinitialisation de votre mot de passe CineGO");
                                    } catch (MessagingException e) {
                                        JOptionPane.showMessageDialog(dialog, "Erreur lors de l'envoie du mail, vérifiez vos paramètre de connexion", "Echec", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            };sendMail.start();
                            
                            // On réouvre la fenètre de connexion
                            dialog.setContentPane(loginView);
                            dialog.pack();
                            dialog.setLocationRelativeTo(null);
                            JOptionPane.showMessageDialog(dialog,
                                    "Votre mot de passe a bien été réinitialisé \net envoyé sur votre adresse mail",
                                    "Réinitialisation",
                                    JOptionPane.INFORMATION_MESSAGE);
                            passwdView.getBtnEnvoyer().setEnabled(true);
                            passwdView.getTxtMail().setEditable(true);
                        }else{
                            // Si le mail ne correspond à aucun compte connu
                            JOptionPane.showMessageDialog(dialog,
                                    "Aucun compte enregistré avec cette adresse email.",
                                    "Erreur", 
                                    JOptionPane.ERROR_MESSAGE);
                            passwdView.getBtnEnvoyer().setEnabled(true);
                            passwdView.getTxtMail().setEditable(true);
                        }
                    }
                }
            }; t.start();
        }else if(event.getSource() == passwdView.getBtnRetour()){
            // Si l'utilisateur clique sur le bouton "Retour"
            dialog.setContentPane(loginView);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
        }  
    }

    /**
     * Retourne l'user correspondant à cette mail si il existe
     * @param mail Mail saisie 
     * @return l'user correspondant à la mail ou rien si la mail n'est pas présente en BD
     */
    public User userExist(String mail){
        Session session = factory.openSession();
        session.beginTransaction();
        User user = (User) session.createQuery("from User where mail = '"+ mail +"'").uniqueResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
