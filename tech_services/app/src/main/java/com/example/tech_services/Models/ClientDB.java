package com.example.tech_services.Models;

public class ClientDB {

    private String id;
    private String nom;
    private int age;

    public ClientDB() {
        // Constructeur par défaut requis pour Firebase Realtime Database
    }

    public ClientDB(String id, String nom, int age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
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
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
