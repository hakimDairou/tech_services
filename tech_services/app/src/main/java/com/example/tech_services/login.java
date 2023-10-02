package com.example.tech_services;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class login extends AppCompatActivity {

    EditText usernameEt, passwordET;
    TextView signUpBtnLogin, signInBtnRegister;
    private boolean passwordshowing = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEt = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        signUpBtnLogin = findViewById(R.id.signUpBtnLogin);
        signInBtnRegister = findViewById(R.id.signInBtnRegister);


        passwordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //   pour afficher ou cacher le mot de passe

                if(passwordshowing){
                    passwordshowing = false;

                    passwordET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.eye);
                }
                else {
                    passwordshowing = true;

                    passwordET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordIcon.setImageResource(R.drawable.eyesfermer);
                }

                passwordET.setSelection(passwordET.length());
            }
        });

        signInBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, Register.class));
            }
        });

        signUpBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

//                startActivity(new Intent(login.this, Dashboard.class));

                if (!validateUsername() | !validatePassword()){

                }else {

                    startActivity(new Intent(login.this, Dashboard.class));
//                    // Créez une instance de la classe DatabaseHelper
//                    TechServiceDB dbHelper = new TechServiceDB(this);
//
//                    // Récupérez les informations de connexion depuis votre formulaire
//                    String username = usernameEt.getText().toString();
//                    String password = passwordET.getText().toString();
//
//                    // Vérifiez les informations de connexion en utilisant la méthode checkUser() de DatabaseHelper
//                    boolean isValid = dbHelper.checkUser(username, password);
//
//                    // Faites des actions en fonction du résultat de la vérification
//                    if (isValid) {
//
//                    } else {
//                        // Les informations de connexion sont incorrectes, affichez un message d'erreur ou effectuez une autre action
//                    }


//                    chekUser();
                }
//                startActivity(new Intent(login.this, Dashboard.class));
            }
        });

    }

    public Boolean validateUsername(){
        String val = usernameEt.getText().toString();
        if (val.isEmpty()){
            usernameEt.setError("Vous n'avez pas saisis votre identifiant");
            return false;
        }
        else {
            usernameEt.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = passwordET.getText().toString();
        if (val.isEmpty()){
            passwordET.setError("Vous n'avez pas saisis votre mot de passe");
            return false;
        }
        else {
            passwordET.setError(null);
            return true;
        }
    }

    public void chekUser(){
        String userUsername = usernameEt.getText().toString().trim();
        String userPassword = passwordET.getText().toString().trim();

//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()){
//                    usernameEt.setError(null);
//                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
//
//                    if (passwordFromDB.equals(userPassword)){
//                        usernameEt.setError(null);
//
//                        String nomFromDB = snapshot.child(userUsername).child("nom").getValue(String.class);
//                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
//                        String telephoneFromDB = snapshot.child(userUsername).child("telephone").getValue(String.class);
//                        String cniFromDB = snapshot.child(userUsername).child("cni").getValue(String.class);
//                        String competenceFromDB = snapshot.child(userUsername).child("competence").getValue(String.class);
//
//                        Intent intent = new Intent(login.this, Dashboard.class);
//
//                        intent.putExtra("nom", nomFromDB);
//                        intent.putExtra("email", emailFromDB);
//                        intent.putExtra("telephone", telephoneFromDB);
//                        intent.putExtra("cni", cniFromDB);
//                        intent.putExtra("competence", competenceFromDB);
//
//
//
//                        startActivity(intent);
//
//                    }else {
//                        passwordET.setError("Connexion invalide");
//                        passwordET.requestFocus();
//                    }
//                }else {
//                    usernameEt.setError("L'utilisateur n'éxiste pas");
//                    usernameEt.requestFocus();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
    }





}