package com.example.tech_services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Details_devis_client extends AppCompatActivity {

    ImageView home,projet,assist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_devis_client);

        home = (ImageView)findViewById(R.id.homeDashboard);
        projet = (ImageView)findViewById(R.id.btnProjet);
        assist = (ImageView)findViewById(R.id.imageView4);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details_devis_client.this, Dashboard_client.class);
                startActivity(intent);
            }
        });

        projet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details_devis_client.this, Projet_client.class);
                startActivity(intent);
            }
        });

        assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details_devis_client.this, Assistance_client.class);
                startActivity(intent);
            }
        });

        TableLayout tableLayout = findViewById(R.id.table_devis); // Récupérer la référence du TableLayout depuis le fichier XML

// Créer un tableau de données
        String[][] data = {
                {"[John Doe]", "[25]", "[Paris]"},
                {"[Jane Smith]", "[32]", "[New York]"},
                // Ajouter davantage de données ici
        };

// Parcourir les données et créer dynamiquement les lignes TableRow
        for (String[] datum : data) {
            TableRow tableRow = new TableRow(this);

            // Parcourir les colonies de chaque ligne de données
            for (String s : datum) {
                TextView textView = new TextView(this);
                textView.setText(s);
                textView.setPadding(8, 8, 8, 8);

                tableRow.addView(textView); // Ajouter la TextView à la ligne TableRow
            }

            tableLayout.addView(tableRow); // Ajouter la ligne TableRow au TableLayout
        }
    }
}