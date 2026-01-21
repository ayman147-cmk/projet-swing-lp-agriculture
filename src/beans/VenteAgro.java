/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.sql.Date;

/**
 *
 * @author ayman
 */
public class VenteAgro {
    
    private int id;
    private String produit;
    private String agriculteur;
    private Date date;
    private double quantite;

    public VenteAgro(int id, String produit, String agriculteur, Date date, double quantite) {
        this.id = id;
        this.produit = produit;
        this.agriculteur = agriculteur;
        this.date = date;
        this.quantite = quantite;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProduit() { return produit; }
    public void setProduit(String produit) { this.produit = produit; }

    public String getAgriculteur() { return agriculteur; }
    public void setAgriculteur(String agriculteur) { this.agriculteur = agriculteur; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getQuantite() { return quantite; }
    public void setQuantite(double quantite) { this.quantite = quantite; }
}
    

