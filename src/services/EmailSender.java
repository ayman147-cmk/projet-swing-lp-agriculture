package services;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void sendEmail(String toEmail, String newPassword) {
        final String username = "votre.email@uca.ac.ma"; 
        final String password = "votre_mot_de_passe"; 

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            
            message.setSubject("Coopérative Agricole - Réinitialisation de mot de passe");
            message.setText("Bonjour,\n\n"
                    + "Votre nouveau mot de passe temporaire est : " + newPassword
                    + "\n\nCordialement.");

            Transport.send(message);
            System.out.println("Email envoyé avec succès !");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur : " + e.getMessage());
        }
    }
}