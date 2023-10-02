package com.example.tech_services;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tech_services.Models.MessageDB;
import com.google.firebase.database.annotations.Nullable;

import java.util.List;
public class ChatAdapter extends ArrayAdapter<MessageDB> {
    private Context context;
    private int resource;
    private List<MessageDB> messages;

    public ChatAdapter(Context context, int resource, List<MessageDB> messages) {
        super(context, resource, messages);
        this.context = context;
        this.resource = resource;
        this.messages = messages;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource, parent, false);
        }

        MessageDB message = messages.get(position);

        TextView messageTextView = view.findViewById(R.id.text_message_received);
        if (message.isSent()) {
            view = LayoutInflater.from(context).inflate(R.layout.item_message_sent, parent, false);
            messageTextView = view.findViewById(R.id.text_message_sent);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_message_received, parent, false);
            messageTextView = view.findViewById(R.id.text_message_received);
        }

        messageTextView.setText(message.getContent());

        return view;
    }
}