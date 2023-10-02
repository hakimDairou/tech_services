package com.example.tech_services;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NotifactionProjetFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifaction_projet, container, false);
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_notifaction_projet, container, false);


        List<ProjetItem> ProjetItemList = new ArrayList<>();

        // ADD des donnees

        ProjetItemList.add(new ProjetItem("Braza", "Depannage d'une machine electronique","2"));
        ProjetItemList.add(new ProjetItem("ALaw", "Depannage d'une machine mecanique", "3"));
        ProjetItemList.add(new ProjetItem("Brou", "Depannage d'une machine industriel", "5"));
        ProjetItemList.add(new ProjetItem("TAb", "Depannage d'un pc", "1"));
        ProjetItemList.add(new ProjetItem("Akld", "Depannage d'un micro", "6"));
        ProjetItemList.add(new ProjetItem("Akld", "Depannage d'un micro", "7"));

        //RECUPERER des donnees

//        ListView projetListView = findViewById(R.id.projet_list_view);

//        return projetListView.setAdapter(new ProjetItemAdapter(this, ProjetItemList));

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}