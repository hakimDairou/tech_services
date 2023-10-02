package com.example.tech_services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;

    private String[] contactNames = {"Marc", "Donald", "Junior", "Frank"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = (String) parent.getItemAtPosition(position);
                openChatPage(selectedName);
            }
        });
    }

    private void openChatPage(String selectedName) {
        Intent chatIntent = new Intent(this, ChatActivity.class);
        chatIntent.putExtra("selectedName", selectedName);
        startActivity(chatIntent);
    }
}

