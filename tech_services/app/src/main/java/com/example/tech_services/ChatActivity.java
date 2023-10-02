package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tech_services.Models.Contact;
import com.example.tech_services.Models.MessageDB;

import java.util.ArrayList;
import java.util.List;
public class ChatActivity extends AppCompatActivity {
    private ListView contactListView;
    private ListView messageListView;
    private EditText messageEditText;
    private Button sendButton;

    private List<Contact> contactList;
    private List<MessageDB> messageList;
    private ChatAdapter chatAdapter;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

//        contactListView = findViewById(R.id.list_contacts);
        messageListView = findViewById(R.id.list_messages);
        messageEditText = findViewById(R.id.edit_message);
        sendButton = findViewById(R.id.button_send);
        TextView  nomContact = findViewById(R.id.text_messages);

        String nameContact = getIntent().getStringExtra("selectedName");
        nomContact.setText(nameContact);

        // Créez une liste de messages factice
        messageList = new ArrayList<>();
        messageList.add(new MessageDB("Hello", false));
        messageList.add(new MessageDB("Hi", true));
        messageList.add(new MessageDB("How are you?", false));
        messageList.add(new MessageDB("I'm good, thanks!", true));
//
//        // Initialisez l'adaptateur de la liste de contacts
//        ArrayAdapter<Contact> contactAdapter = new ArrayAdapter<>(this, R.layout.item_contact, contactList);
//        contactListView.setAdapter(contactAdapter);

        // Initialisez l'adaptateur de la liste de messages
        chatAdapter = new ChatAdapter(this, R.layout.item_message_received, messageList);
        messageListView.setAdapter(chatAdapter);



        // Gestion du clic sur le bouton d'envoi
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageContent = messageEditText.getText().toString().trim();
                if (!messageContent.isEmpty()) {
                    // Ajoutez le nouveau message à la liste
                    MessageDB newMessage = new MessageDB(messageContent, true);
                    messageList.add(newMessage);
                    chatAdapter.notifyDataSetChanged();

                    // Effacez le champ de saisie
                    messageEditText.setText("");
                }
            }
        });
    }
}