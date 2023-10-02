package com.example.tech_services.Models;

public class TachesDB {


    private int id;
    private int projet_id;
    private int num_tache;
    private String nom;
    private String statut;

    public TachesDB() {
        // Constructeur par défaut requis pour Firebase Realtime Database
    }

    public TachesDB(int id, int projet_id, int num_tache, String nom, String statut) {
        this.id = id;
        this.projet_id = projet_id;
        this.num_tache = num_tache;
        this.nom = nom;
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


    public int getNum_tache() {
        return num_tache;
    }

    public void setNum_tache(int num_tache) {
        this.num_tache = num_tache;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String age) {
        this.statut = statut;
    }
}
