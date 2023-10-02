package com.example.tech_services;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Details_Service_client extends AppCompatActivity {
    ListView listview;
    List<String> list;
    ArrayAdapter<String> arrayAdapter;

    ImageView home,projet,assist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_service_client);

        home = (ImageView)findViewById(R.id.homeDashboard);
        projet = (ImageView)findViewById(R.id.btnProjet);
        assist = (ImageView)findViewById(R.id.imageView4);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details_Service_client.this, Dashboard_client.class);
                startActivity(intent);
            }
        });

        projet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details_Service_client.this, Projet_client.class);
                startActivity(intent);
            }
        });

        assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details_Service_client.this, Assistance_client.class);
                startActivity(intent);
            }
        });


        listview = findViewById(R.id.listDetails);

        list = new ArrayList<>();
        list.add("Plomberie");
        list.add("Carrelage");
        list.add("Electronique");
        list.add("Electricite");
        list.add("Plomberie");
        list.add("Carrelage");
        list.add("Electronique");
        list.add("Electricite");
        list.add("Plomberie");
        list.add("Carrelage");
        list.add("Electronique");
        list.add("Electricite");
        list.add("Plomberie");
        list.add("Carrelage");
        list.add("Electronique");
        list.add("Electricite");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = (String) parent.getItemAtPosition(position);

                // Ouvrez le formulaire en passant le titre à l'intent
                Intent intent = new Intent(Details_Service_client.this, Formulaire_client.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

    }
}