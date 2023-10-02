package com.example.tech_services;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {

    // Déclaration des variables nécessaires
    private EditText messageInput;
    private RecyclerView chatRecyclerView;
    private ChatAdapter chatAdapter;
    private List<String> chatMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_client);

        // Récupérer le nom du contact à partir des extras de l'intent
//        String contactName = getIntent().getStringExtra("contactName");

        // Utiliser le nom du contact pour initialiser la conversation
        // Par exemple, vous pouvez afficher le nom du contact dans une TextView
//        TextView contactNameTextView = findViewById(R.id.textView36);
//        contactNameTextView.setText(contactName);

        // Initialisation des variables
//        messageInput = findViewById(R.id.message_input);
//        Button sendButton = findViewById(R.id.send_button);
//        chatRecyclerView = findViewById(R.id.chat_recycler_view);
//        chatMessages = new ArrayList<>();
//
//        // Configuration de l'adaptateur pour le RecyclerView
//        chatAdapter = new ChatAdapter(chatMessages);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        chatRecyclerView.setLayoutManager(layoutManager);
//        chatRecyclerView.setAdapter(chatAdapter);

        // Gestion de l'événement du bouton d'envoi
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String message = messageInput.getText().toString().trim();
//                if (!message.isEmpty()) {
//                    sendMessage(message);
//                    messageInput.setText("");
//                }
//            }
//        });
    }

//    // Méthode pour envoyer un message
//    @SuppressLint("NotifyDataSetChanged")
//    private void sendMessage(String message) {
//        chatMessages.add(message);
//        chatAdapter.notifyDataSetChanged();
//        chatRecyclerView.scrollToPosition(chatMessages.size() - 1);
//    }
    }