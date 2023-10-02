package com.example.tech_services;

import static androidx.core.app.ActivityCompat.finishAffinity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LogoutActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    // Effectuer les opérations de déconnexion
        logout();
}

    private void logout() {
            // Effectuez ici les opérations de déconnexion, comme la suppression des informations d'identification, la réinitialisation des préférences, etc.

            // Bloquer le retour vers la page précédente et fermer toutes les activités
            finishAffinity();

    // Rediriger vers l'écran de connexion ou autre
    Intent intent = new Intent(LogoutActivity.this, login.class);
    startActivity(intent);
    finish();
}

        // ...
}
