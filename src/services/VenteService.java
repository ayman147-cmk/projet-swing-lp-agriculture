package services;

import beans.VenteAgro;
import connection.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap; 
import java.util.Map;      

public class VenteService implements IDao<VenteAgro> {

    private Connexion connexion;

    public VenteService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(VenteAgro o) {
        String req = "INSERT INTO venteagro (id_produit, id_agri, date_vente, quantite) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, Integer.parseInt(o.getProduit())); 
            ps.setInt(2, Integer.parseInt(o.getAgriculteur())); 
            ps.setDate(3, o.getDate()); 
            ps.setDouble(4, o.getQuantite());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Map<String, Double> getQuantitesParProduit() {
        Map<String, Double> stats = new HashMap<>();
        String req = "SELECT p.nom, SUM(v.quantite) as total_qte " +
                     "FROM venteagro v " +
                     "JOIN produitagro p ON v.id_produit = p.id " +
                     "GROUP BY p.nom";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                stats.put(rs.getString("nom"), rs.getDouble("total_qte"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }

    @Override
    public List<VenteAgro> findAll() {
        List<VenteAgro> ventes = new ArrayList<>();
        String req = "SELECT v.id, p.nom as produit, a.nom as agriculteur, v.date_vente, v.quantite " +
                     "FROM venteagro v " +
                     "JOIN produitagro p ON v.id_produit = p.id " +
                     "JOIN agriculteur a ON v.id_agri = a.id";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ventes.add(new VenteAgro(
                    rs.getInt("id"), 
                    rs.getString("produit"), 
                    rs.getString("agriculteur"), 
                    rs.getDate("date_vente"), 
                    rs.getDouble("quantite")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventes;
    }

    @Override
    public boolean update(VenteAgro o) {
        String req = "UPDATE venteagro SET id_produit = ?, id_agri = ?, date_vente = ?, quantite = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, Integer.parseInt(o.getProduit()));
            ps.setInt(2, Integer.parseInt(o.getAgriculteur()));
            ps.setDate(3, new java.sql.Date(o.getDate().getTime()));
            ps.setDouble(4, o.getQuantite());
            ps.setInt(5, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(VenteAgro o) {
        String req = "DELETE FROM venteagro WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public VenteAgro findById(int id) {
        String req = "SELECT * FROM venteagro WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new VenteAgro(rs.getInt("id"), rs.getString("id_produit"), rs.getString("id_agri"), rs.getDate("date_vente"), rs.getDouble("quantite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public double estimerRevenus() {
        double total = 0;
        String req = "SELECT SUM(v.quantite * p.prixKg) as total FROM venteagro v JOIN produitagro p ON v.id_produit = p.id";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { total = rs.getDouble("total"); }
        } catch (SQLException e) { e.printStackTrace(); }
        return total;
    }
}