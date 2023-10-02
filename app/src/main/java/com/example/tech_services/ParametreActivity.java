package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tech_services.ParametresElement.ItemAdapterElement;
import com.example.tech_services.ParametresElement.ItemElement;

import java.util.ArrayList;
import java.util.List;

public class ParametreActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<ItemElement> itemList;
    private ItemAdapterElement adapters;
    private String[] contactNames = {"Profile", "Chat", "Apropos", "Déconnexion"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);


        listView = findViewById(R.id.listViewparametre);
        itemList = new ArrayList<>();

        // Ajoutez des éléments à la liste avec des noms et des icônes
        itemList.add(new ItemElement("Profile", R.drawable.baseline_person_24));
        itemList.add(new ItemElement("Chat", R.drawable.baseline_message_24));
        itemList.add(new ItemElement("Apropos", R.drawable.baseline_info_24));
        itemList.add(new ItemElement("Déconnexion", R.drawable.baseline_exit_to_app_24));

        adapters = new ItemAdapterElement(this, itemList);
        listView.setAdapter(adapters);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemElement selectedItemElement = adapters.getItem(position);
//                String elements = (String) parent.getItemAtPosition(position);
//                openChatPage(selectedItemElement);


                if (selectedItemElement.getName() == "Profile"){
                    Intent chatIntent = new Intent(ParametreActivity.this, ProfileActivity.class);

                    startActivity(chatIntent);
                }
                else if (selectedItemElement.getName() == "Chat"){
                    Intent chatIntent = new Intent(ParametreActivity.this, ContactActivity.class);
                    startActivity(chatIntent);
                }
                else if (selectedItemElement.getName() == "Apropos"){
                    Intent chatIntent = new Intent(ParametreActivity.this, AboutActivity.class);
                    startActivity(chatIntent);
                }
                else if (selectedItemElement.getName() == "Déconnexion"){
                    Intent chatIntent = new Intent(ParametreActivity.this, login.class);
                    startActivity(chatIntent);
                    finishAffinity();

                }
            }
        });
    }
//    private ItemElement selectedItemElement = adapters.getItem(position);
//    private void openChatPage(String itemList) {
//
//        // Obtenez l'élément sélectionné dans la liste
//
//
//        // Obtenez le nom de l'élément sélectionné
//                String itemName = selectedItem.getName();
//
//
//        if (itemList.getName == "Profile"){
//            Intent chatIntent = new Intent(this, ProfileActivity.class);
//
//            startActivity(chatIntent);
//        }
//        else if (elements == "Chat"){
//            Intent chatIntent = new Intent(this, ContactActivity.class);
//            startActivity(chatIntent);
//        }
//        else if (elements == "Apropos"){
//            Intent chatIntent = new Intent(this, ProfileActivity.class);
//            startActivity(chatIntent);
//        }
//        else if (elements == "Déconnexion"){
//            Intent chatIntent = new Intent(this, login.class);
//            startActivity(chatIntent);
//
//        }
//
//
//    }
}