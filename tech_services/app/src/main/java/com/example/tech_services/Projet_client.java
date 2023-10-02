package com.example.tech_services;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Projet_client extends AppCompatActivity {

    ImageView btndashboard,projet,assist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projet_client);

        String[] type = new String[] {"encours", "en attente", "réalisés"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.drop_down_client,
                type
        );

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) AutoCompleteTextView autoCompleteTextView = findViewById(R.id.filtre);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Projet_client.this, autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btndashboard = (ImageView) findViewById(R.id.homeDashboard);
        projet = (ImageView)findViewById(R.id.btnProjet);
        assist = (ImageView)findViewById(R.id.imageView4);

        btndashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Projet_client.this, Dashboard_client.class);
                startActivity(intent);
            }
        });

        projet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Projet_client.this, Projet_client.class);
                startActivity(intent);
            }
        });

        assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Projet_client.this, Assistance_client.class);
                startActivity(intent);
            }
        });
    }
}