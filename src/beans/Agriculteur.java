package beans;

public class Agriculteur {
    private int id;
    private String nom;
    private String commune;
    private String contact;

    public Agriculteur(int id, String nom, String commune, String contact) {
        this.id = id;
        this.nom = nom;
        this.commune = commune;
        this.contact = contact;
    }

    public Agriculteur(String nom, String commune, String contact) {
        this.nom = nom;
        this.commune = commune;
        this.contact = contact;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getCommune() { return commune; }
    public void setCommune(String commune) { this.commune = commune; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}