/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author ayman
 */
public class ProduitAgro {
    private int id;
    private String nom;
    private String type;
    private double prixKg;

    public ProduitAgro(int id, String nom, String type, double prixKg) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.prixKg = prixKg;
    }
public ProduitAgro(String nom, String type, double prixKg) {
    this.nom = nom;
    this.type = type;
    this.prixKg = prixKg;
}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrixKg() { return prixKg; }
    public void setPrixKg(double prixKg) { this.prixKg = prixKg; }

    @Override
    public String toString() {
        return "ProduitAgro{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", prixKg=" + prixKg + '}';
    }
    
    
}
