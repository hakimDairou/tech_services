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



                TextView redirectionBTN = findViewById(R.id.redirection);

                // Animation pour l'image d'accueil
                Animation fadeInAnimation = new AlphaAnimation(0, 1);
                fadeInAnimation.setDuration(1000);
                logoImageView.startAnimation(fadeInAnimation);





                redirectionBTN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(TechnicienClientAccueilActivity.this, login.class));
                    }
                });



            }
        }