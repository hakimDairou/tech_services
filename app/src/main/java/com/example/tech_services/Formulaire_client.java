package com.example.tech_services;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Formulaire_client extends AppCompatActivity {

    private static final int REQUEST_IMAGE_GALLERY = 1;
    private static final int REQUEST_IMAGE_CAMERA = 2;

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView imageView;
    private TextView editTextTitle;
    private EditText editTextDescription;
    private Uri imageUri;

    ImageView home,projet,assist;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire_client);

        home = (ImageView)findViewById(R.id.homeDashboard);
        projet = (ImageView)findViewById(R.id.btnProjet);
        assist = (ImageView)findViewById(R.id.imageView4);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulaire_client.this, Dashboard_client.class);
                startActivity(intent);
            }
        });

        projet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulaire_client.this, Projet_client.class);
                startActivity(intent);
            }
        });

        assist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulaire_client.this, Assistance_client.class);
                startActivity(intent);
            }
        });

        editTextTitle = findViewById(R.id.textView39);

        // Récupérez le titre depuis l'intent
        String title = getIntent().getStringExtra("title");

        // Mettez à jour le champ de titre dans le formulaire
        editTextTitle.setText(title);

        imageView = findViewById(R.id.imageView);
        editTextDescription = findViewById(R.id.editTextDescription);
    }



    public void selectImage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Sélectionner une image"), PICK_IMAGE_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void submitForm(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();

        // Faites ce que vous voulez avec les valeurs du titre, de la description et de l'image
        // Par exemple, envoyez-les à un serveur ou effectuez un traitement local

        // Affichez un message pour montrer que le formulaire a été soumis
        Toast.makeText(this, "Formulaire soumis !", Toast.LENGTH_SHORT).show();
    }
}