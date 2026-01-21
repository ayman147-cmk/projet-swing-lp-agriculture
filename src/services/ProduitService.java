package services;

import beans.ProduitAgro;
import connection.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitService implements IDao<ProduitAgro> {

    private Connexion connexion;

    public ProduitService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(ProduitAgro o) {
        String req = "INSERT INTO produitagro VALUES (null, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getType());
            ps.setDouble(3, o.getPrixKg());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<ProduitAgro> findAll() {
        List<ProduitAgro> produits = new ArrayList<>();
        String req = "SELECT * FROM produitagro";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                produits.add(new ProduitAgro(rs.getInt("id"), rs.getString("nom"), rs.getString("type"), rs.getDouble("prixKg")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return produits;
    }

    @Override
    public boolean delete(ProduitAgro o) {
        String req = "DELETE FROM produitagro WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public boolean update(ProduitAgro o) {
        String req = "UPDATE produitagro SET nom=?, type=?, prixKg=? WHERE id=?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getType());
            ps.setDouble(3, o.getPrixKg());
            ps.setInt(4, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { return false; }
    }

    @Override
    public ProduitAgro findById(int id) {
        String req = "SELECT * FROM produitagro WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ProduitAgro(rs.getInt("id"), rs.getString("nom"), rs.getString("type"), rs.getDouble("prixKg"));
            }
        } catch (SQLException e) { }
        return null;
    }
}