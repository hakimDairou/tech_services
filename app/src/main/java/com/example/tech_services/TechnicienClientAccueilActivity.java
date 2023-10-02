package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TechnicienClientAccueilActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technicien_client_accueil);

                ImageView logoImageView = findViewById(R.id.logoImageView);
                TextView welcomeTextView = findViewById(R.id.welcomeTextView);
                Button loginButton = findViewById(R.id.loginButton);
                Button createAccountButton = findViewById(R.id.createAccountButton);

                // Animation pour l'image d'accueil
                Animation fadeInAnimation = new AlphaAnimation(0, 1);
                fadeInAnimation.setDuration(1000);
                logoImageView.startAnimation(fadeInAnimation);

                // Animation pour le texte de bienvenue
                Animation slideUpAnimation = new TranslateAnimation(0, 0, 50, 0);
                slideUpAnimation.setDuration(1000);
                welcomeTextView.startAnimation(slideUpAnimation);

                // Animation pour les boutons
                Animation fadeInButtonsAnimation = new AlphaAnimation(0, 1);
                fadeInButtonsAnimation.setDuration(1000);
                fadeInButtonsAnimation.setStartOffset(500); // Délai de départ pour les boutons
                loginButton.startAnimation(fadeInButtonsAnimation);
                createAccountButton.startAnimation(fadeInButtonsAnimation);

                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(TechnicienClientAccueilActivity.this, login.class));
                    }
                });

                createAccountButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(TechnicienClientAccueilActivity.this, Connexion_client.class));
                    }
                });
            }
        }