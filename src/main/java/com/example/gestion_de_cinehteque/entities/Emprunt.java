package com.example.gestion_de_cinehteque.entities;





import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cd_id", nullable = false)
    private CD cd;

    private int utilisateurId;

    @Temporal(TemporalType.DATE)
    private Date dateEmprunt;

    // Constructeur par défaut
    public Emprunt() {}

    // Constructeur avec paramètres
    public Emprunt(CD cd, int utilisateurId, Date dateEmprunt) {
        this.cd = cd;
        this.utilisateurId = utilisateurId;
        this.dateEmprunt = dateEmprunt;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", cd=" + (cd != null ? cd.getId() : "null") + // Assurez-vous que la méthode getId() existe dans CD
                ", utilisateurId=" + utilisateurId +
                ", dateEmprunt=" + dateEmprunt +
                '}';
    }
}


