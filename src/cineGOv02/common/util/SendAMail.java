/*
 * SendAMail.java                                15 déc. 2015
 * CESI RILA 2015/2017
 */
package cineGOv02.common.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * TODO commenter les responsabilités classe
 * @author Remi
 *
 */
public class SendAMail {
    /**
     * TODO commenter le role de la Méthode
     * @param sender 
     * @param recipient
     * @param recName 
     * @param body 
     * @param subject 
     * @return true or false
     * @throws MessagingException 
     * @throws AddressException 
     */
    public static boolean send(String sender, String recipient, String body, String subject) throws MessagingException{
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage generateMailMessage;

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        //generateMailMessage.addFrom(new Address[]{new InternetAddress(sender)});
        //generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
        generateMailMessage.setSubject(subject);

        generateMailMessage.setContent(body, "text/html");
        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "remi.plantade.pro@gmail.com", "bboqruvrdxwokxkt");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
        return false;

    }


}
