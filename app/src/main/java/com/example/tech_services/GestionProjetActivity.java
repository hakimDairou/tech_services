package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tech_services.databinding.ActivityDetailProjetBinding;
import com.example.tech_services.databinding.ActivityProjetBinding;

public class GestionProjetActivity extends AppCompatActivity {

    ActivityDetailProjetBinding binding;

    private ImageView projectImage;
    private TextView projectName, projectOwner, projectDuration, projectElapsedTime, projectDescription,
            projectTasks, completedTasks;
    private ListView tasksListView;
    private ProgressBar tasksProgressBar;
    private Button devis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_projet);





        Intent intent = this.getIntent();
        if (intent != null){

            // Référencement des éléments de l'interface utilisateur
            projectImage = findViewById(R.id.projectImage);
            projectName = findViewById(R.id.projectName);
            projectOwner = findViewById(R.id.projectOwner);
            projectDuration = findViewById(R.id.projectDuration);
            projectElapsedTime = findViewById(R.id.projectElapsedTime);
            projectDescription = findViewById(R.id.projectDescription);
            projectTasks = findViewById(R.id.projectTasks);
            completedTasks = findViewById(R.id.completedTasks);
            tasksListView = findViewById(R.id.tasksListView);
            tasksProgressBar = findViewById(R.id.tasksProgressBar);

            devis = findViewById(R.id.devis_id);


            devis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(GestionProjetActivity.this, DevisProjetActivity.class));
                }
            });


            int image = intent.getIntExtra("image", R.drawable.item_sbtp1_img);
            String nomClient = intent.getStringExtra("nomClient");
            String nomProjet = intent.getStringExtra("nomprojet");
            String lieu = intent.getStringExtra("lieu");
            String telephone = intent.getStringExtra("telephone");
            String description = intent.getStringExtra("descriptionProjet");
            String temps = intent.getStringExtra("temps");
            String duree = intent.getStringExtra("dureProjet");
            String tempsEcoul = intent.getStringExtra("tempsEcouler");
            String[] projectTasksArray = {"Tâche 1", "Tâche 2", "Tâche 3", "Tâche 4"}; // Remplacer par les tâches réelles
            int completedTasksCount = 2; // Remplacer par le nombre réel de tâches réalisées
            int totalTasksCount = projectTasksArray.length;


        //             Affichage des données du projet dans l'interface utilisateur
            projectOwner.setText(nomClient);
            projectImage.setImageResource(image);
            projectName.setText(nomProjet);
            projectDuration.setText(duree);
            projectElapsedTime.setText(tempsEcoul);
            projectDescription.setText(description);
            projectTasks.setText("Tâches à réaliser (" + (totalTasksCount - completedTasksCount) + ")");
            completedTasks.setText("Tâches réalisées (" + completedTasksCount + "/" + totalTasksCount + ")");
            tasksProgressBar.setMax(totalTasksCount);
            tasksProgressBar.setProgress(completedTasksCount);

            ArrayAdapter<String> tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, projectTasksArray);
            tasksListView.setAdapter(tasksAdapter);
        }


//        // Référencement des éléments de l'interface utilisateur
//        projectImage = findViewById(R.id.projectImage);
//        projectName = findViewById(R.id.projectName);
//        projectOwner = findViewById(R.id.projectOwner);
//        projectDuration = findViewById(R.id.projectDuration);
//        projectElapsedTime = findViewById(R.id.projectElapsedTime);
//        projectDescription = findViewById(R.id.projectDescription);
//        projectTasks = findViewById(R.id.projectTasks);
//        completedTasks = findViewById(R.id.completedTasks);
//        tasksListView = findViewById(R.id.tasksListView);
//        tasksProgressBar = findViewById(R.id.tasksProgressBar);
//
//        // Récupération des données du projet depuis une source de données (par exemple, une API)
//        String projectOwnerName = "John Doe";
//        int projectImageResource = R.drawable.item_sbtp1_img; // Remplacer par l'ID de l'image réelle
//        String projectNameText = "Nom du projet";
//        String projectDurationText = "Durée du projet";
//        String projectElapsedTimeText = "Temps écoulé";
//        String projectDescriptionText = "Description du projet";
//        String[] projectTasksArray = {"Tâche 1", "Tâche 2", "Tâche 3", "Tâche 4"}; // Remplacer par les tâches réelles
//        int completedTasksCount = 2; // Remplacer par le nombre réel de tâches réalisées
//        int totalTasksCount = projectTasksArray.length;
//
//        // Affichage des données du projet dans l'interface utilisateur
//        projectOwner.setText(projectOwnerName);
//        projectImage.setImageResource(projectImageResource);
//        projectName.setText(projectNameText);
//        projectDuration.setText(projectDurationText);
//        projectElapsedTime.setText(projectElapsedTimeText);
//        projectDescription.setText(projectDescriptionText);
//        projectTasks.setText("Tâches à réaliser (" + (totalTasksCount - completedTasksCount) + ")");
//        completedTasks.setText("Tâches réalisées (" + completedTasksCount + "/" + totalTasksCount + ")");
//        tasksProgressBar.setMax(totalTasksCount);
//        tasksProgressBar.setProgress(completedTasksCount);
//
//        ArrayAdapter<String> tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, projectTasksArray);
//        tasksListView.setAdapter(tasksAdapter);

    }
}