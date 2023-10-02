package com.example.tech_services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Profil_client extends AppCompatActivity {

    ImageView home,projet,assist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_client);

        home = (ImageView)findViewById(R.id.homeDashboard);
        projet = (ImageView)findViewById(R.id.btnProjet);
        assist = (ImageView)findViewById(R.id.imageView4);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profil_client.this, Dashboard_client.class);
                startActivity(intent);
            }
        });

        projet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profil_client.this, Projet_client.class);
                startActivity(intent);
            }
        });

        assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profil_client.this, Assistance_client.class);
                startActivity(intent);
            }
        });


    }
}