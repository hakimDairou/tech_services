package com.example.tech_services;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard_client extends AppCompatActivity {

    ImageView btnprojet, notif, imageView4;
    TextView depanDashboard, constDashboard;
    PopupWindow popupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_client);

        notif = (ImageView)findViewById(R.id.notifProfil);
        imageView4 = (ImageView)findViewById(R.id.imageView4);


        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup();
            }
        });

        depanDashboard = (TextView)findViewById(R.id.depanDashboard);
        btnprojet = (ImageView) findViewById(R.id.btnProjet);

        btnprojet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard_client.this, Projet_client.class);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard_client.this, Assistance_client.class);
                startActivity(intent);
            }
        });

        depanDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard_client.this, Details_Service_client.class);
                startActivity(intent);
            }
        });
    }
    private void showPopup(){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.activity_notif_client, null);
        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(notif, Gravity.CENTER, 0, 0);
    };
}