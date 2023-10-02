package com.example.tech_services.Models;

public class ProjetDB {

    private int id;
    private int client_id;
    private String image;
    private String nom;
    private String description;
    private String statut;

    public ProjetDB() {
        // Constructeur par défaut requis pour Firebase Realtime Database
    }

    public ProjetDB(int id, int client_id, String image, String nom, String description, String statut) {
        this.id = id;
        this.client_id = client_id;
        this.image = image;
        this.nom = nom;
        this.description = description;
        this.statut = statut;
    }

    // Définition des getters et setters pour chaque champ
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String age) {
        this.statut = statut;
    }
}
