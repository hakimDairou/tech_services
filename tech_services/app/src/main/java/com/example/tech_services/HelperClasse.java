package com.example.tech_services;

public class HelperClasse {
    String nom, email, telephone, cni, competence,password;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getPassword() {
        return competence;
    }

    public void setPassword(String competence) {
        this.competence = competence;
    }

    public HelperClasse(String nom, String email, String telephone, String cni, String competence, String password) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.cni = cni;
        this.competence = competence;
        this.password = password;
    }

    public HelperClasse() {
    }
}
