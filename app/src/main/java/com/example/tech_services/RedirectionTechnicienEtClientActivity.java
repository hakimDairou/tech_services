package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RedirectionTechnicienEtClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirection_technicien_et_client);
        Button createAccountTechnicien = findViewById(R.id.createAccountTechnicienButton);
        Button createAccountClient = findViewById(R.id.createAccountClientButton);



        // Animation pour les boutons
        Animation fadeInButtonsAnimation = new AlphaAnimation(0, 1);
        fadeInButtonsAnimation.setDuration(1000);
        fadeInButtonsAnimation.setStartOffset(500); // Délai de départ pour les boutons
        createAccountTechnicien.startAnimation(fadeInButtonsAnimation);
        createAccountClient.startAnimation(fadeInButtonsAnimation);



        createAccountTechnicien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RedirectionTechnicienEtClientActivity.this, Register.class));
            }
        });

        createAccountClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RedirectionTechnicienEtClientActivity.this, Register_client.class));
            }
        });
    }
}