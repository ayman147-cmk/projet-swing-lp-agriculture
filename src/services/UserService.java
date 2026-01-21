package services;

import beans.User;
import connection.Connexion;
import dao.IUserDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * @author ayman
 */
public class UserService implements IUserDao {

    private Connexion connexion;

    public UserService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean authenticate(String login, String password) {
        String req = "SELECT * FROM users WHERE username = ? AND password = SHA1(?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println("Erreur Auth: " + ex.getMessage());
        }
        return false;
    }

    public boolean updatePassword(String login, String newPassword) {
        String req = "UPDATE users SET password = SHA1(?) WHERE username = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, newPassword);
            ps.setString(2, login);
            int result = ps.executeUpdate();
            return result > 0; 
        } catch (SQLException ex) {
            System.out.println("Erreur Update Password: " + ex.getMessage());
        }
        return false;
    }

    public void sendActualEmail(String recipientEmail, String newPassword) {
        final String user = "aymansakyoud587@gmail.com"; 
        final String password = "awshovbmmmwudokc"; 

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Récupération de mot de passe - Coopérative");
            message.setText("Bonjour,\n\nVotre mot de passe a été modifié avec succès.\n"
                    + "Votre nouveau mot de passe est : " + newPassword);

            Transport.send(message);
            System.out.println("Email envoyé avec succès !");
        } catch (MessagingException e) {
            System.out.println("Erreur d'envoi d'email : " + e.getMessage());
        }
    }

    @Override
    public boolean addUser(User user) {
        String req = "INSERT INTO users (username, password) VALUES (?, SHA1(?))";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public User findUserByLogin(String login) {
        String req = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}