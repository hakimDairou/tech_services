package com.example.tech_services.Models;

public class TechnicienDB {


    private int id;
    private String nom;
    private String email;
    private int age;
    private String telephone;
    private String cni;
    private String competence;


    private String password;
    private String statut;
    public TechnicienDB() {
        // Constructeur par défaut requis pour Firebase Realtime Database
    }

    public TechnicienDB(int id, int age, String nom, String competence, String email,String telephone, String cni, String password, String statut) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.competence = competence;
        this.email = email;
        this.telephone = telephone;
        this.cni = cni;
        this.password = password;
        this.statut = statut;
    }

    // Définition des getters et setters pour chaque champ
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

}
