package com.example.tech_services.Models;

public class NotesDB {


    private int id;
    private int technicien_id;
    private int client_id;
    private int note;
    private String statut;

    public NotesDB() {
        // Constructeur par défaut requis pour Firebase Realtime Database
    }

    public NotesDB(int id, int technicien_id, int client_id, String statut, int note) {
        this.id = id;
        this.technicien_id = technicien_id;
        this.client_id = client_id;
        this.note = note;
        this.statut = statut;
    }

    // Définition des getters et setters pour chaque champ
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTechnicien_id() {
        return technicien_id;
    }

    public void setTechnicien_id(int technicien_id) {
        this.technicien_id = technicien_id;
    }


    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }


    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
