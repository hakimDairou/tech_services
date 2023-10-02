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

public class ListAdapterProjetAccepter  extends ArrayAdapter<ListDataProjet> {

    public ListAdapterProjetAccepter(@NonNull Context context, ArrayList<ListDataProjet> dateArrayList) {
        super(context, R.layout.adapter_item_projet, dateArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View view, @NonNull ViewGroup parent){
        ListDataProjet listDataProjet = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item_projet, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.item_image_projet);
        TextView listName = view.findViewById(R.id.item_detail_projet);
        TextView listOption = view.findViewById(R.id.item_nom_projet);

        listImage.setImageResource(listDataProjet.image);
        listName.setText(listDataProjet.nomProjet);
        listOption.setText(listDataProjet.temps);

        return  view;

    }

}
