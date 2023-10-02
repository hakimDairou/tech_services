package com.example.tech_services;// MainActivity.java

import android.app.Activity;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tech_services.R;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DevisProjetActivity extends Activity {

        private Button btnOpenModal;
        private RelativeLayout modal;
        private AutoCompleteTextView actvCategorie;
        private EditText etNomProduit;
        private EditText etPrixProduit;
        private Button btnEnregistrer;
        private Button btnAnnuler;

        private String[] categories = {"Électronique", "Vêtements", "Alimentation", "Maison", "Beauté"};
        private Spinner productSpinner;
        private AutoCompleteTextView searchAutoCompleteTextView;
        private List<String> productList;
        private ArrayAdapter<String> productAdapter;

        private Button downloadButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_devis_projet);

                btnOpenModal = findViewById(R.id.btn_open_modal);
                modal = findViewById(R.id.modal);
//        actvCategorie = findViewById(R.id.actv_categorie);
                etNomProduit = findViewById(R.id.et_nom_produit);
                etPrixProduit = findViewById(R.id.et_prix_produit);
                btnEnregistrer = findViewById(R.id.btn_enregistrer);
                btnAnnuler = findViewById(R.id.btn_annuler);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, categories);
//        actvCategorie.setAdapter(adapter);

                btnOpenModal.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                openModal();
                        }
                });

                btnEnregistrer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                enregistrerProduit();
                        }
                });

                btnAnnuler.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                closeModal();
                        }
                });





//        du nouveau
                // Récupérer les références des éléments de la mise en page
                productSpinner = findViewById(R.id.productSpinner);
                searchAutoCompleteTextView = findViewById(R.id.searchAutoCompleteTextView);

                // Créer une liste d'options pour le champ de sélection
                productList = new ArrayList<>(Arrays.asList("Pioche", "Marteau", "Clou", "Courant electrique"));

                // Créer un adaptateur pour le champ de sélection
                productAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, productList);
                productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                productSpinner.setAdapter(productAdapter);

                // Créer un adaptateur pour le champ de recherche
                ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, productList);
                searchAutoCompleteTextView.setAdapter(autoCompleteAdapter);

                // Gérer la sélection d'un produit dans le champ de recherche
                searchAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                                String selectedProduct = (String) adapterView.getItemAtPosition(position);
                                int productIndex = productList.indexOf(selectedProduct);
                                productSpinner.setSelection(productIndex);
                        }
                });

                // Gérer l'action de soumission du formulaire
                Button submitButton = findViewById(R.id.submitButton);
//        TextView desig_tv = findViewById(R.id.text_designation);
//        TextView qt_tv = findViewById(R.id.text_quantite);
//        TextView pu_tv = findViewById(R.id.text_prix_unitaire);
//        TextView pt_tv = findViewById(R.id.text_montant_total);

                OutilDepannage[] produits = new OutilDepannage[3];
                produits[0] = new OutilDepannage("Pioche", 3, 5000.00);
                produits[1] = new OutilDepannage("Marteau", 2, 700.50);
                produits[2] = new OutilDepannage("Clou", 100, 70.50);



                TableLayout tableLayout = findViewById(R.id.tableLayout);

                // Ajouter les en-têtes de colonnes
                TableRow headerRow = new TableRow(this);
                headerRow.setBackgroundColor(Color.parseColor("#F6A425"));
                headerRow.addView(createTextView("Désignation", true));
                headerRow.addView(createTextView("Qt", true));
                headerRow.addView(createTextView("P U ", true));
                headerRow.addView(createTextView("Montant T", true));
                tableLayout.addView(headerRow);

                double montantTotalGlobal = 0.0;

                // Ajouter les données des produits
                for (OutilDepannage produit : produits) {
                        TableRow row = new TableRow(this);
                        row.addView(createTextView(produit.getDesignation(), false));
                        row.addView(createTextView(String.valueOf(produit.getQuantite()), false));
                        row.addView(createTextView(String.valueOf(produit.getPrixUnitaire()), false));
                        row.addView(createTextView(String.valueOf(produit.getMontantTotal()), false));

                        tableLayout.addView(row);

                        montantTotalGlobal += produit.getMontantTotal();

                }

                // Ajouter la ligne du montant total global
                TableRow totalRow = new TableRow(this);
                totalRow.setBackgroundColor(Color.parseColor("#D81B60"));
                totalRow.addView(createTextView("Net à payer", true));
                totalRow.addView(createTextView("", true));
                totalRow.addView(createTextView("", true));
                totalRow.addView(createTextView(String.valueOf(montantTotalGlobal), true));
                tableLayout.addView(totalRow);

//        downloadButton = findViewById(R.id.downloadButton);
//        RelativeLayout relativeLayoutTableau = findViewById(R.id.monTableau);
//        downloadButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                convertRelativeLayoutToPDF(relativeLayoutTableau);
//            }
//        });

                submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                String selectedProduct = productSpinner.getSelectedItem().toString();
                                Toast.makeText(DevisProjetActivity.this, "Produit sélectionné : " + selectedProduct, Toast.LENGTH_SHORT).show();


                        }



                });
//        fin nouveau


        }

        private void convertRelativeLayoutToPDF(RelativeLayout relativeLayout) {
                // Créer un nouveau document PDF
                PdfDocument document = new PdfDocument();

                // Créer une page PDF
                PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(relativeLayout.getWidth(), relativeLayout.getHeight(), 1).create();
                PdfDocument.Page page = document.startPage(pageInfo);

                // Dessiner le [RelativeLayout sur la page PDF
                Canvas canvas = page.getCanvas();
                relativeLayout.draw(canvas);

                // Terminer la page PDF
                document.finishPage(page);

                // Enregistrer le document PDF
                String directoryPath = Environment.getExternalStorageDirectory().getPath() + "/PDFs/";
                File directory = new File(directoryPath);
                if (!directory.exists()) {
                        directory.mkdirs();
                }
                String filePath = directoryPath + "RelativeLayout.pdf";
                File file = new File(filePath);
                try {
                        document.writeTo(new FileOutputStream(file));
                        Toast.makeText(this, "RelativeLayout converti en PDF avec succès !", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Erreur lors de la conversion en PDF.", Toast.LENGTH_SHORT).show();
                }

                // Fermer le document PDF
                document.close();
        }

        private TextView createTextView(String text, boolean isHeader) {
                TextView textView = new TextView(this);
                textView.setText(text);
                textView.setPadding(10, 10, 10, 10);
                textView.setTextColor(Color.parseColor("#000000"));

                if (isHeader) {
                        textView.setTextSize(18);
                        textView.setBackgroundColor(Color.parseColor("#D81B60"));
                } else {
                        textView.setTextSize(16);
                        textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }

                return textView;
        }


        private void openModal() {
                modal.setVisibility(View.VISIBLE);
        }

        private void closeModal() {
                modal.setVisibility(View.GONE);
        }

        private void enregistrerProduit() {
                String nomProduit = etNomProduit.getText().toString().trim();
                String prixProduit = etPrixProduit.getText().toString().trim();
                String categorieProduit = actvCategorie.getText().toString().trim();

                if (nomProduit.isEmpty() || prixProduit.isEmpty() || categorieProduit.isEmpty()) {
                        Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                        // Effectuer le traitement d'enregistrement du produit ici
                        Toast.makeText(this, "Produit enregistré : " + nomProduit + ", Catégorie : " + categorieProduit, Toast.LENGTH_SHORT).show();
                        closeModal();
                }
        }
}