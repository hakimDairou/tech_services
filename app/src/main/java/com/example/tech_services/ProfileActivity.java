package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profilePicture;
    private EditText profileName;
    private EditText profileEmail;
    private EditText profilePhone;
    private EditText profileSkills;
    private TextView profileRating;
    private Button statusButton;
    private Button saveButton;
    private Button activationButton;
    private boolean isActivated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);


        activationButton = findViewById(R.id.button_activation);

        updateButtonState();


        // Récupérer les vues XML
        profilePicture = findViewById(R.id.profile_picture);
        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);
        profilePhone = findViewById(R.id.profile_phone);
        profileSkills = findViewById(R.id.profile_skills);
        profileRating = findViewById(R.id.profile_rating);
//        statusButton = findViewById(R.id.profile_status_button);
        saveButton = findViewById(R.id.profile_save_button);

        // Définir les détails de l'utilisateur
        profilePicture.setImageResource(R.drawable.baseline_person_24);
        profileName.setText("Marc Donald");
        profileEmail.setText("donald@gmail.com");
        profilePhone.setText("+237 656 789 540");
        profileSkills.setText("DEVELOPPEUR");
        profileRating.setText("Note : " + 8);

//        // Gérer le clic sur le bouton de statut
//        statusButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isActivated) {
//                    statusButton.setText("Désactiver");
//                    isActivated = false;
//                    Toast.makeText(ProfileActivity.this, "Activer avec succès", Toast.LENGTH_SHORT).show();
//                } else {
//                    statusButton.setText("Activer");
//                    isActivated = true;
//                    Toast.makeText(ProfileActivity.this, "Désactiver avec succès", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // Gérer le clic sur le bouton d'enregistrement
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les nouvelles informations
                String newName = profileName.getText().toString();
                String newEmail = profileEmail.getText().toString();
                String newPhone = profilePhone.getText().toString();
                String newSkills = profileSkills.getText().toString();
                String newRating = profileRating.getText().toString();

                // Mettre à jour les informations de l'utilisateur
                // (vous pouvez ajouter ici le code pour enregistrer les informations dans une base de données, par exemple)

                // Afficher un message de succès
                Toast.makeText(ProfileActivity.this, "Informations mises à jour avec succès", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onActivationButtonClick(View view) {
        isActivated = !isActivated;
        updateButtonState();
    }

    private void updateButtonState() {
        if (isActivated) {
            activationButton.setText("Activer");
            activationButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorActive));
            Toast.makeText(ProfileActivity.this, "Activer avec succès", Toast.LENGTH_SHORT).show();
        } else {
            activationButton.setText("Désactiver");
            activationButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.colorInactive));
            Toast.makeText(ProfileActivity.this, "Désactiver avec succès", Toast.LENGTH_SHORT).show();
        }
    }

}