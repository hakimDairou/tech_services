package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verification_client extends AppCompatActivity {

    Button btnVerif;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_client);

            btnVerif = (Button) findViewById(R.id.btnVerif);

            btnVerif.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Verification_client.this, Connexion_client.class);
                    startActivity(intent);
                }
            });
        }
    }