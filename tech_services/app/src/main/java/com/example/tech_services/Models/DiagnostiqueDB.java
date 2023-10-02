package com.example.tech_services.Models;

public class DiagnostiqueDB {


    private int id;
    private int projet_id;
    private String probleme;
    private String solution;
    private String statut;

    public DiagnostiqueDB() {
        // Constructeur par défaut requis pour Firebase Realtime Database
    }

    public DiagnostiqueDB(int id, int projet_id, String probleme, String solution, String statut) {
        this.id = id;
        this.projet_id = projet_id;
        this.probleme = probleme;
        this.solution = solution;
        this.statut = statut;
    }

    // Définition des getters et setters pour chaque champ
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getProjet_id() {
        return projet_id;
    }

    public void setProjet_id(int projet_id) {
        this.projet_id = projet_id;
    }


    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }


    public String getSolution() {
        return solution;
    }

    public void setSolution(String nom) {
        this.solution = nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String age) {
        this.statut = statut;
    }
}
