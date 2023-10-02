package com.example.tech_services;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class Register_client extends AppCompatActivity {

    TextView loginSignin;
    Button btnSign;
    String verificationCode;
    EditText phoneSignin,mailSignin,nameSignin,lieuSignin;



    private static final int PERMISSION_REQUEST_SEND_SMS = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);

        loginSignin = (TextView) findViewById(R.id.loginSignin);
        btnSign = (Button) findViewById(R.id.btnRegister);
        phoneSignin = (EditText) findViewById(R.id.telRegister);
        mailSignin = (EditText) findViewById(R.id.mailRegister);
        lieuSignin = (EditText) findViewById(R.id.placeRegister);
        nameSignin = (EditText) findViewById(R.id.nameRegister);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nom = nameSignin.getText().toString();
                String mail = mailSignin.getText().toString();
                String tel = phoneSignin.getText().toString();
                String place = lieuSignin.getText().toString();

                // Vérifier la permission d'envoyer des SMS
                if (ContextCompat.checkSelfPermission(Register_client.this,
                        Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Register_client.this,
                            new String[]{Manifest.permission.SEND_SMS},
                            PERMISSION_REQUEST_SEND_SMS);
                } else {

                    if (!valid(nom,mail,tel,place)){

                    }
                    else {
                        // Générer un code de vérification aléatoire
                        verificationCode = generateVerificationCode();

                        // Envoyer le code de vérification par SMS
                        sendVerificationCode();
                    }

                }
            }
        });
        loginSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register_client.this, Connexion_client.class);
                startActivity(intent);
            }
        });

    }

    public boolean valid(String nom, String mail, String tel, String place){
        if (nom.length()==0){
            nameSignin.requestFocus();
            nameSignin.setError("Le champ ne peut pas être vide");
            return false;
        }
        else if(!nom.matches("[a-zA-Z]+")) {
            nameSignin.requestFocus();
            nameSignin.setError("entrer seulement des caractères alphabétiques");
            return false;
        }
        else if (mail.length() ==0) {
            mailSignin.requestFocus();
            mailSignin.setError("Le champ ne peut pas être vide");
            return false;
        }
        else if (tel.length()==0) {
            phoneSignin.requestFocus();
            phoneSignin.setError("Le champ ne peut pas être vide");
            return false;
        } else if (place.length()==0) {
            lieuSignin.requestFocus();
            lieuSignin.setError("Le champ ne peut pas être vide");
        }
        return true;
    }

    private String generateVerificationCode(){
        // Générer un code de vérification aléatoire à 6 chiffres
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }
    private void sendVerificationCode() {
        String phoneNumber = phoneSignin.getText().toString();
        String message = "Votre code de vérification : " + verificationCode;

        // Vérifier à nouveau la permission d'envoyer des SMS
        if (ContextCompat.checkSelfPermission(Register_client.this,
                Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            // Envoyer le SMS
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);

            Toast.makeText(Register_client.this, "Code de vérification envoyé avec succès.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Register_client.this, "Impossible d'envoyer le SMS de vérification.", Toast.LENGTH_SHORT).show();
        }
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_SEND_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission accordée, envoyer le code de vérification
                verificationCode = generateVerificationCode();
                sendVerificationCode();
            } else {
                Toast.makeText(Register_client.this, "Permission refusée pour envoyer des SMS.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}