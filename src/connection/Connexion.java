package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ayman
 */
public class Connexion {
    private static Connexion instance;
    private Connection cn = null;
   
    private final String url = "jdbc:mysql://localhost:3306/cooperative_db?useSSL=false&serverTimezone=UTC";
    private final String login = "root";
    private final String password = "";

    private Connexion() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introuvable");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion : " + ex.getMessage());
        }
    }

    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    public Connection getCn() {
        return cn;
    }
}