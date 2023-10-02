package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;



public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);





        // Récupérer la version de l'application
        String versionName = "1.0.0";
        try {
            versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        String descriptionApp = "Lorem Ipsum Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,lor when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,lor when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, ";
        // Récupérer la vue de description de l'application
        TextView descriptionTextView = findViewById(R.id.description_text_view);
        descriptionTextView.setText(descriptionApp);

        // Récupérer la vue de version de l'application
        TextView versionTextView = findViewById(R.id.version_text_view);
        versionTextView.setText("Version " + versionName);
    }


}