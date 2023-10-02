package com.example.tech_services;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_library);
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_library, container, false);
        List<ProjetItem> ProjetItemList =new ArrayList<>();

        // ADD des donnees
        ProjetItemList.add(new ProjetItem("Braza", "Depannage d'une machine electronique","2"));
        ProjetItemList.add(new ProjetItem("ALaw", "Depannage d'une machine mecanique", "3"));
        ProjetItemList.add(new ProjetItem("Brou", "Depannage d'une machine industriel", "5"));
        ProjetItemList.add(new ProjetItem("TAb", "Depannage d'un pc", "1"));
        ProjetItemList.add(new ProjetItem("Akld", "Depannage d'un micro", "6"));
        ProjetItemList.add(new ProjetItem("Akld", "Depannage d'un micro", "7"));

        //RECUPERER des donnees

        ListView projetListView = findViewById(R.id.projet_list_view);

        projetListView.setAdapter(new ProjetItemAdapter(this, ProjetItemList));

    }
}