package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;



import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Register extends AppCompatActivity {

    EditText nomET, emailET, telephoneET, competenceET, cniET, passwordET;
    TextView signInBtnLogin;
    AppCompatButton signUpBtnRegister;
//    FirebaseDatabase database;
//    DatabaseReference reference;

    private String verificationCode;

    private static final int PERMISSION_REQUEST_SEND_SMS = 123;

    private static final String TAG = "SmsSender";
    private static final String API_KEY = "TXJKTVBjeUF5TXk9YmhHSE5HbHg=";
    private static final String FROM = "TechServices";
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nomET = findViewById(R.id.nomET);
        emailET = findViewById(R.id.emailET);
        telephoneET = findViewById(R.id.mobileET);
        competenceET = findViewById(R.id.competenceET);
        cniET = findViewById(R.id.cniET);
        passwordET = findViewById(R.id.passwordET);

        signUpBtnRegister = findViewById(R.id.signUpBtn);
        signInBtnLogin = findViewById(R.id.signInBtn);


        signInBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, login.class));
            }
        });

        signUpBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("users");
//                database = FirebaseDatabase.getInstance();
//                reference = database.getReference("users");

                String nom = nomET.getText().toString();
                String email = emailET.getText().toString();
                String telephone = telephoneET.getText().toString();
                String competence = competenceET.getText().toString();
                String cni = cniET.getText().toString();
                String password = passwordET.getText().toString();



//                final String getMobileTxt = telephone.getText().toString();

//                final String getEmailTxt = email.getText().toString();



                // Vérifier la permission d'envoyer des SMS

                if (!validatenom() | !validatePassword() | !validateEmail() | !validateTelephone() | !validateCompetence() | !validateCNI()){

                }else {

//                    if (ContextCompat.checkSelfPermission(Register.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
//                        ActivityCompat.requestPermissions(Register.this, new String[]{Manifest.permission.SEND_SMS},PERMISSION_REQUEST_SEND_SMS);
//                    }
//                    else {
                        // Générer un code de vérification aléatoire
                        verificationCode = generateVerificationCode();

                        // Envoyer le code de vérification par SMS
                        sendVerificationCode();

                            // Initialisez la référence à la base de données
                        mDatabase = FirebaseDatabase.getInstance().getReference("https://techservice-5a46b-default-rtdb.asia-southeast1.firebasedatabase.app/");

                        // Données à envoyer


                        // Créez un objet Map pour stocker les données
                        Map<String, Object> userData = new HashMap<>();
                        userData.put("nom", nom);
                        userData.put("email", email);
                        userData.put("telephone", telephone);
                        userData.put("competence", competence);
                        userData.put("cni", cni);
                        userData.put("password", password);

                        // Envoi des données à la base de données
                        mDatabase.child("techniciens").push().setValue(userData)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Log.d(TAG, "Données envoyées avec succès !");
                                        } else {
                                            Log.e(TAG, "Erreur lors de l'envoi des données.", task.getException());
                                        }
                                    }
                                });



////    mak                    HelperClasse helperClasse = new HelperClasse(nom, email,telephone,competence,cni,password);
//////                        reference.child(nom).setValue(helperClasse);
//////
//////                        Toast.makeText(Register.this, "Votre enregistrement a été effectué avec succès !", Toast.LENGTH_SHORT).show();
////                        // Créez une instance de la classe DatabaseHelper
////                        TechServiceDB dbHelper = new TechServiceDB(this);
////
////                        // Récupérez les informations de connexion depuis votre formulaire
////
////
////                        // Vérifiez les informations de connexion en utilisant la méthode checkUser() de DatabaseHelper
////                        dbHelper.insertUser(nom, password, email, telephone, competence, cni);
////                        Toast.eText(Register.this, "Votre enregistrement a été effectué avec succès !", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(Register.this, OTPVerification.class);
//                        intent.putExtra("telephone", telephone);
////                    intent.putExtra("verificationCode", verificationCode);
//
//                        startActivity(intent);

                    }
                }




//            }
        });




    }



    private String generateVerificationCode() {
        // Générer un code de vérification aléatoire à 6 chiffres
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }











    public static void sendSms(String destination, String sms) {
        try {
            URL url = new URL("https://app.techsoft-web-agency.com/sms/api");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            String requestBody = "action=send-sms&api_key=" + API_KEY + "&to=" + destination + "&from=" + FROM + "&sms=" + sms;

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
            outputStream.close();

            int responseCode = connection.getResponseCode();
            Log.d(TAG, "Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            Log.d(TAG, "SMS sent successfully: " + response.toString());
        } catch (Exception e) {
            Log.e(TAG, "Error sending SMS: " + e.getMessage());
        }
    }












    private void sendVerificationCode() {
        String phoneNumber = telephoneET.getText().toString();
        String message = "Votre code de vérification : " + verificationCode;

//        // Vérifier à nouveau la permission d'envoyer des SMS
//        if (ContextCompat.checkSelfPermission(Register.this,
//                Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
//            // Envoyer le SMS
//            SmsManager smsManager = SmsManager.getDefault();
//            smsManager.sendTextMessage(phoneNumber, null, message, null, null);


            sendSms(phoneNumber,message);
            Toast.makeText(Register.this, "Code de vérification envoyé avec succès.", Toast.LENGTH_SHORT).show();
//        } else {
//
//
//            Toast.makeText(Register.this, "Impossible d'envoyer le SMS de vérification.", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_SEND_SMS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission accordée, envoyer le code de vérification
                verificationCode = generateVerificationCode();
                sendVerificationCode();
            } else {
                Toast.makeText(Register.this, "Permission refusée pour envoyer des SMS.", Toast.LENGTH_SHORT).show();
            }
        }
    }



    public Boolean validatenom(){
        String val = nomET.getText().toString();
        if (val.isEmpty()){
            nomET.setError("champ obligatoire");
            return false;
        }
        else {
            nomET.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = passwordET.getText().toString();
        if (val.isEmpty()){
            passwordET.setError("champ obligatoire");
            return false;
        }
        else {
            passwordET.setError(null);
            return true;
        }
    }


    public Boolean validateEmail(){
        String val = emailET.getText().toString();
        if (val.isEmpty()){
            emailET.setError("champ obligatoire");
            return false;
        }
        else {
            emailET.setError(null);
            return true;
        }
    }

    public Boolean validateTelephone(){
        String val = telephoneET.getText().toString();
        if (val.isEmpty()){
            telephoneET.setError("champ obligatoire");
            return false;
        }
        else {
            telephoneET.setError(null);
            return true;
        }
    }



    public Boolean validateCompetence(){
        String val = competenceET.getText().toString();
        if (val.isEmpty()){
            competenceET.setError("champ obligatoire");
            return false;
        }
        else {
            competenceET.setError(null);
            return true;
        }
    }

    public Boolean validateCNI(){
        String val = cniET.getText().toString();
        if (val.isEmpty()){
            cniET.setError("champ obligatoire");
            return false;
        }
        else {
            cniET.setError(null);
            return true;
        }
    }




}