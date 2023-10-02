package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class OTPVerification extends AppCompatActivity {

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (s.length() > 0){
                if (selectedETPosition == 0){
                    selectedETPosition = 1;
                    showKeyboard(otpEt2);
                }
                else if (selectedETPosition == 1) {
                    selectedETPosition = 2;
                    showKeyboard(otpEt3);
                }
                else if (selectedETPosition == 2) {
                    selectedETPosition = 3;
                    showKeyboard(otpEt4);
                }
            }
        }
    };
    private EditText otpEt1, otpEt2, otpEt3, otpEt4;
    private TextView resendBtn;

//    true after every 60 seconds
    private boolean resendEnabled = false;

//    resend time in seconds
    private int resendTime = 60;

    private static final int PERMISSION_REQUEST_SEND_SMS = 123;
    private String verificationCode;

    private TextView otpMobile;

    private  int selectedETPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        otpEt1 = findViewById(R.id.otpET1);
        otpEt2 = findViewById(R.id.otpET2);
        otpEt3 = findViewById(R.id.otpET3);
        otpEt4 = findViewById(R.id.otpET4);

        resendBtn = findViewById(R.id.resendBtn);

        final Button verifyBtn = findViewById(R.id.verifyBtn);

        otpMobile = findViewById(R.id.otpMobile);

        //  Getting email and mobile from Register activity trough intent

//        final String getEmail = getIntent().getStringExtra("email");
        final String getMobile = getIntent().getStringExtra("verificationCode");

//        setting email and mobile to TextView

        verificationCode = getMobile;


        otpMobile.setText(getMobile);

        otpEt1.addTextChangedListener(textWatcher);
        otpEt2.addTextChangedListener(textWatcher);
        otpEt3.addTextChangedListener(textWatcher);
        otpEt4.addTextChangedListener(textWatcher);

//        by defaulf open keyboad at otpEt1
        showKeyboard(otpEt1);

//        start resend count down time
        startCountDownTime();

        resendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resendEnabled){
//                    handle your resend code here
                    // Vérifier la permission d'envoyer des SMS
                    if (ContextCompat.checkSelfPermission(OTPVerification.this,
                            android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(OTPVerification.this,
                                new String[]{Manifest.permission.SEND_SMS},
                                PERMISSION_REQUEST_SEND_SMS);
                    } else {
                        // Générer un code de vérification aléatoire
                        verificationCode = generateVerificationCode();

                        // Envoyer le code de vérification par SMS
                        sendVerificationCode();
                    }

//                    start new resend count down time
                    startCountDownTime();
                }
            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String generateOtp = otpEt1.getText().toString()+otpEt2.getText().toString()+otpEt3.getText().toString()+otpEt4.getText().toString();

                if (generateOtp.length() == 4){

//                    handle your otp verification here

                    // Vérifier si le code entré correspond au code de vérification généré
//
                    if (generateOtp.equals(verificationCode)) {
                        Toast.makeText(OTPVerification.this, "Vérification réussie !", Toast.LENGTH_SHORT).show();
                        // Continuer avec d'autres fonctionnalités de l'application

                        Intent intent = new Intent(OTPVerification.this, login.class);

                        startActivity(intent);
                    } else {
                        Toast.makeText(OTPVerification.this, "Code de vérification incorrect.", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });


    }

    private String generateVerificationCode() {
        // Générer un code de vérification aléatoire à 6 chiffres
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }

    private void sendVerificationCode() {
        String phoneNumber = getIntent().getStringExtra("telephone");;
        String message = "Votre code de vérification : " + verificationCode;

        // Vérifier à nouveau la permission d'envoyer des SMS
        if (ContextCompat.checkSelfPermission(OTPVerification.this,
                Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            // Envoyer le SMS
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);

            Toast.makeText(OTPVerification.this, "Code de vérification envoyé avec succès.", Toast.LENGTH_SHORT).show();
        } else {


            Toast.makeText(OTPVerification.this, "Impossible d'envoyer le SMS de vérification.", Toast.LENGTH_SHORT).show();
        }
    }

    private void showKeyboard(EditText otpET){
        otpET.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(otpET, InputMethodManager.SHOW_IMPLICIT);
    }


    private void startCountDownTime(){
        resendEnabled = false;
        resendBtn.setTextColor(Color.parseColor("#99000000"));

        new CountDownTimer(resendTime * 1000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                resendBtn.setText("Renvoyer le code ("+(millisUntilFinished / 1000)+")");
            }

            @Override
            public void onFinish() {

                resendEnabled = true;
                resendBtn.setText("Renvoyer le Code");
                resendBtn.setTextColor(getResources().getColor(R.color.primary));
            }
        }.start();
    }



    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_DEL){
           if (selectedETPosition == 3){
               selectedETPosition = 2;
               showKeyboard(otpEt3);
           }
           else if (selectedETPosition == 2) {
               selectedETPosition = 1;
               showKeyboard(otpEt2);
           } else if (selectedETPosition == 1) {
               selectedETPosition = 0;
               showKeyboard(otpEt1);
           }

           return true;

        }
        else {
            return super.onKeyUp(keyCode, event);
        }

    }
}