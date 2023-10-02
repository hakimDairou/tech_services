package com.example.tech_services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListDataProjet> {
    public ListAdapter(@NonNull Context context, ArrayList<ListDataProjet> dateArrayList) {
        super(context, R.layout.list_item, dateArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View view, @NonNull ViewGroup parent){
        ListDataProjet listDataProjet = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.listImage);
        TextView listName = view.findViewById(R.id.listName);
        TextView listTime = view.findViewById(R.id.listTime);

        listImage.setImageResource(listDataProjet.image);
        listName.setText(listDataProjet.nomProjet);
        listTime.setText(listDataProjet.temps);

        return  view;

    }

}
