package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.tech_services.databinding.ActivityDetailProjetBinding;

public class DetailProjetActivity extends AppCompatActivity {

    ActivityDetailProjetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailProjetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){
            int image = intent.getIntExtra("image", R.drawable.item_sbtp1_img);
            String nomClient = intent.getStringExtra("nomClient");
            String nomProjet = intent.getStringExtra("nomProjet");
            String lieu = intent.getStringExtra("lieu");
            String telephone = intent.getStringExtra("telephone");
            String description = intent.getStringExtra("descriptionProjet");
            String temps = intent.getStringExtra("temps");

            binding.nomduProjet.setText(nomProjet);
            binding.detailImage.setImageResource(image);
            binding.nomduClient.setText(nomClient);
            binding.lieu.setText(lieu);
            binding.telephone.setText(telephone);
            binding.descriptionProjet.setText(description);
        }
    }
}