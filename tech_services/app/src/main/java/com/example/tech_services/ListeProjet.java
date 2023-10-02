package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.tech_services.databinding.ActivityListeProjetBinding;

import java.util.ArrayList;

public class ListeProjet extends AppCompatActivity {

    ActivityListeProjetBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListDataProjet> dataArrayList = new ArrayList<>();
    ListDataProjet listDataProjet ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListeProjetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int [] imageList= {R.drawable.item_sbtp1_img, R.drawable.item_sbtp2_img, R.drawable.item_sbtp3_img, R.drawable.item_sbtp4_img, R.drawable.item_sbtp5_img, R.drawable.item_sbtp6_img, R.drawable.item_sbtp7_img};
        String [] nomClientList= {"Marc Donald", "Arnauld", "Rostand", "Midrel", "Arnold", "Christian", "Joel"};
        String [] telephoneList= {"656548247", "658947145", "677485124", "698547521", "652544892", "680475165", "699547415"};
        String [] lieuList= {"Bonamoussadi", "Deido", "Bonadjo", "Akwa", "Bonapriso", "Yassa", "Bependa"};
        String [] descriptionProjetList= {
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, ",
                "but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                "t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable ",
                "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci veli",
                "There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain",
                "BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.",
                "structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."
        };

        String [] nomProjetList= {"Casa", "Deido", "Bonadjo", "Akwa", "BMD", "Sahel", "HDC"};
        String [] tempsList= {"42 min", "8 min", "10 min", "57 min", "49 min", "64 min", "38 min"};


        String [] dureProjet = {"7 jous", "12 jous", "27 jous", "3 jous", "17 jous", "21 jous", "2 jous"};
        String [] tempsEcouler = {"2 jous", "10 jous", "20 jous", "2 jous", "13 jous", "3 jous", "1 jous"};


        for (int i = 0 ; i < imageList.length; i++){
            listDataProjet = new ListDataProjet(nomProjetList[i],imageList[i],nomClientList[i],telephoneList[i],descriptionProjetList[i],lieuList[i],tempsList[i],dureProjet[i],tempsEcouler[i]);
            dataArrayList.add(listDataProjet);
        }
        listAdapter = new ListAdapter(ListeProjet.this, dataArrayList);
        binding.Listview.setAdapter(listAdapter);
        binding.Listview.setClickable(true);


        binding.Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(ListeProjet.this, DetailProjetActivity.class);
                intent.putExtra("nomprojet",nomProjetList[i]);
                intent.putExtra("image",imageList[i]);
                intent.putExtra("nomClient",nomClientList[i]);
                intent.putExtra("lieu",lieuList[i]);
                intent.putExtra("telephone",telephoneList[i]);
                intent.putExtra("descriptionProjet",descriptionProjetList[i]);
                intent.putExtra("temps",tempsList[i]);
                startActivity(intent);
            }
        });
    }
}