package com.example.tech_services;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Assistance_client extends AppCompatActivity {

    TextView accessms,profil;
    ImageView home,projet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance_client);

        home = (ImageView)findViewById(R.id.homeDashboard);
        projet = (ImageView)findViewById(R.id.btnProjet);
        accessms = (TextView) findViewById(R.id.SmsAssist);
        profil = (TextView)findViewById(R.id.profilAssist);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Assistance_client.this, Dashboard_client.class);
                startActivity(intent);
            }
        });

        projet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Assistance_client.this, Projet_client.class);
                startActivity(intent);
            }
        });

        accessms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Assistance_client.this, Messagerie_client.class);
                startActivity(intent);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Assistance_client.this, Profil_client.class);
                startActivity(intent);
            }
        });

        // Associez le bouton à une variable
        TextView openModalButton = findViewById(R.id.avisAssist);

        // Ajoutez un écouteur d'événements au bouton
        openModalButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // Créez une instance de Dialog
                Dialog modalDialog = new Dialog(Assistance_client.this);
                // Définissez le contenu de la modal en utilisant le fichier de mise en page XML
                modalDialog.setContentView(R.layout.activity_avis_client);

                // Récupérez les éléments de la modal
                TextView modalTitle = modalDialog.findViewById(R.id.modalTitle);
                EditText modalTextArea = modalDialog.findViewById(R.id.modalTextArea);
                Button modalButton = modalDialog.findViewById(R.id.modalButton);

                // Définissez le texte du titre de la modal
                modalTitle.setText("Laissez un Avis");

                // Ajoutez un écouteur d'événements au bouton de la modal
                modalButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Fermez la modal
                        Toast.makeText(Assistance_client.this, "Avis Envoyé", Toast.LENGTH_SHORT).show();
                        modalDialog.dismiss();
                    }
                });

                // Affichez la modal
                modalDialog.show();
            }
        });
    }
}