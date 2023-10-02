package com.example.tech_services;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Connexion_client extends AppCompatActivity {

    TextView signinLogin;
    Button btnLogin;
    EditText nameLogin, passwordLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_client);

        signinLogin = (TextView) findViewById(R.id.signinLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        nameLogin = (EditText) findViewById(R.id.nameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);

        signinLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Connexion_client.this, Register_client.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                String name = nameLogin.getText().toString();
                String password = passwordLogin.getText().toString();
                
                if (!validation(name,password)){

                }
                else {
                    Intent intent = new Intent(Connexion_client.this, Dashboard_client.class);
                    startActivity(intent);
                }

            }
        });
    }

    private Boolean validation(String name, String password) {
        if (name.length()==0){
            nameLogin.requestFocus();
            nameLogin.setError("Le champ ne peut pas être vide");
            return false;
        }
        else if(!name.matches("[a-zA-Z]+")) {
            nameLogin.requestFocus();
            nameLogin.setError("entrer seulement des caractères alphabétiques");
            return false;
        }
            else if (password.length() ==0) {
            passwordLogin.requestFocus();
            passwordLogin.setError("Le champ ne peut pas être vide");
            return false;
       }
            else if (!password.matches("[0-9]+")) {
            passwordLogin.requestFocus();
            passwordLogin.setError("entrer seulement des caractères numériques");
            return false;
        }
        return true;
    }
}