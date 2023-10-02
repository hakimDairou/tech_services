package com.example.tech_services;

import android.widget.ImageView;

public class ListDataProjet {
    String   temps, nomProjet, dureProjet, delaisConsommer, budget, budgetConsommer, nomClient, lieu, telephone, descriptionProjet, tempsEcouler;
    int image;


    public ListDataProjet( String nomProjet, int image, String nomClient, String telephone, String descriptionProjet, String lieu, String temps,String dureProjet, String tempsEcouler) {

        this.nomProjet = nomProjet;
        this.image = image;
        this.nomClient = nomClient;
        this.telephone = telephone;
        this.descriptionProjet = descriptionProjet;
        this.lieu = lieu;
        this.temps = temps;
        this.dureProjet = dureProjet;
        this.tempsEcouler =tempsEcouler;
    }
}
