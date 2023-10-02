package com.example.tech_services.Models;

public class MessageDB {
    private String content;
    private boolean isSent;

    public MessageDB(String content, boolean isSent) {
        this.content = content;
        this.isSent = isSent;
    }

    public String getContent() {
        return content;
    }

    public boolean isSent() {
        return isSent;
    }
}
