package com.example.tech_services;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class ProjetItemAdapter extends BaseAdapter{

    private Context context;

    private List<ProjetItem> projetItemList;
    private LayoutInflater inflater;

    // Constructeur

    public ProjetItemAdapter(Context context, List<ProjetItem> projetItemList){
        this.context = context;
        this.projetItemList = projetItemList;
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount(){
        return projetItemList.size();
    }

    @Override
    public ProjetItem getItem(int position){
        return projetItemList.get(position);
    }


    @Override
    public long getItemId(int i){
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup){

        view = inflater.inflate(R.layout.adapter_item_projet, null);
        ProjetItem currentItem = getItem(i);
        String itemNom = currentItem.getNom();
        String itemDetail = currentItem.getDetail();
        String itemImage = currentItem.getImage();



        //get image du projet
        ImageView itemImageView = view.findViewById(R.id.item_image_projet);
        String resourceName = "item_" + itemImage + "_img";
        int resId = context.getResources().getIdentifier(resourceName,"drawable", context.getPackageName());
        itemImageView.setImageResource(resId);
        // get nom du projet
        TextView itemNameView = view.findViewById(R.id.item_nom_projet);
        itemNameView.setText(itemNom);


        //get details du proje
        TextView itemDetailView = view.findViewById(R.id.item_detail_projet);
        itemDetailView.setText(itemDetail);


        return view;
    }


}
