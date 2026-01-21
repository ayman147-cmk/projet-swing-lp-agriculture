package services;

import beans.Agriculteur;
import connection.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgriculteurService implements IDao<Agriculteur> {

    private Connexion connexion;

    public AgriculteurService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Agriculteur o) {
        String req = "INSERT INTO agriculteur (nom, commune, contact) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getCommune());
            ps.setString(3, o.getContact());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error Create: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Agriculteur> findAll() {
        List<Agriculteur> agriculteurs = new ArrayList<>();
        String req = "SELECT * FROM agriculteur";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                agriculteurs.add(new Agriculteur(
                    rs.getInt("id"), 
                    rs.getString("nom"), 
                    rs.getString("commune"), 
                    rs.getString("contact")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error FindAll: " + e.getMessage());
        }
        return agriculteurs;
    }

    @Override
    public boolean delete(Agriculteur o) {
        String req = "DELETE FROM agriculteur WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { 
            return false; 
        }
    }

    @Override
    public boolean update(Agriculteur o) {
        String req = "UPDATE agriculteur SET nom=?, commune=?, contact=? WHERE id=?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getCommune());
            ps.setString(3, o.getContact());
            ps.setInt(4, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { 
            return false; 
        }
    }

    @Override
    public Agriculteur findById(int id) {
        String req = "SELECT * FROM agriculteur WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Agriculteur(
                    rs.getInt("id"), 
                    rs.getString("nom"), 
                    rs.getString("commune"), 
                    rs.getString("contact")
                );
            }
        } catch (SQLException e) { }
        return null;
    }
    
    public List<Agriculteur> findByCommune(String commune) {
        List<Agriculteur> agriculteurs = new ArrayList<>();
        String req = "SELECT * FROM agriculteur WHERE commune = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, commune);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                agriculteurs.add(new Agriculteur(
                    rs.getInt("id"), 
                    rs.getString("nom"), 
                    rs.getString("commune"), 
                    rs.getString("contact")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agriculteurs;
    }

    public List<String> findAllCommunes() {
        List<String> communes = new ArrayList<>();
        String req = "SELECT DISTINCT commune FROM agriculteur";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                communes.add(rs.getString("commune"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return communes;
    }
}