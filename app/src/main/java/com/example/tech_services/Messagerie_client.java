package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Messagerie_client extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    List<String> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie_client);


        // Initialisez la ListView
        listView = findViewById(R.id.listView);

        // Créez une liste de contacts
        contacts = new ArrayList<>();
        contacts.add("Arnauld Kodo");
        contacts.add("Marc Baliaba");
        contacts.add("Midrel Mekam");

        // Initialisez l'adaptateur avec la liste de contacts
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);

        // Associez l'adaptateur à la ListView
        listView.setAdapter(adapter);

        // Ajoutez un écouteur de clic à la ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedContact = (String) parent.getItemAtPosition(position);
                openChatActivity(selectedContact);
            }
        });

    }
    private void openChatActivity(String contactName) {
        Intent intent = new Intent(this, Chat.class);
        intent.putExtra("contactName", contactName);
        startActivity(intent);
    }
}