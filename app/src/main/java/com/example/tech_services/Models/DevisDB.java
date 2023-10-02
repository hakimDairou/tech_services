package com.example.tech_services.Models;

public class DevisDB {


    private int id;
    private int projetId;
    private String designation;
    private int prixUnitaire;
    private int quantite;
    private int montantTotal;
    private String statut;



    public DevisDB() {
        // Constructeur par défaut requis pour Firebase Realtime Database

    }

    public DevisDB(int id,int projetId, String designation, int prixUnitaire, int quantite, int montantTotal, String statut) {
        this.id = id;
        this.projetId = projetId;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.montantTotal = montantTotal;
        this.statut = statut;
    }

    // Définition des getters et setters pour chaque champ
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

    public int getProjetId() {
        return projetId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }



    public int getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }



    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(int montantTotal) {
        this.montantTotal = montantTotal;
    }
}
