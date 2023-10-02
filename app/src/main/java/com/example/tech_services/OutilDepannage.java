package com.example.tech_services;

public class OutilDepannage {

    private String designation;
    private int quantite;
    private double prixUnitaire;
    private double montantTotal;

    public OutilDepannage(String designation, int quantite, double prixUnitaire) {
        this.designation = designation;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montantTotal = quantite * prixUnitaire;
    }

    public String getDesignation() {
        return designation;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public double getMontantTotal() {
        return montantTotal;
    }
}
