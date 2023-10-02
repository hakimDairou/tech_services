package com.example.tech_services;

public class ProjetItem {


    private String nom, detail;
    private String image;



    public  ProjetItem(String nom, String detail, String image){
        this.nom = nom;
        this.detail = detail;
        this.image = image;

    }

    public String getNom(){return nom;}

    public String getDetail(){return detail;}

    public String getImage(){return image;}

}
