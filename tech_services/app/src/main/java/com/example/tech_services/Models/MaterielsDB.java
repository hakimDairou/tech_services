package com.example.tech_services.Models;

public class MaterielsDB {

    private String id;
    private String nom;
    private int prix;

    public MaterielsDB() {
        // Constructeur par défaut requis pour Firebase Realtime Database
    }

    public MaterielsDB(String id, String nom, int prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    // Définition des getters et setters pour chaque champ
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return prix;
    }

    public void setAge(int age) {
        this.prix = age;
    }
}
