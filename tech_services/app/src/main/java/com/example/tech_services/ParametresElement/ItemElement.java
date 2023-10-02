package com.example.tech_services.ParametresElement;

public class ItemElement {
    private String name;
    private int iconResId;

    public ItemElement(String name, int iconResId) {
        this.name = name;
        this.iconResId = iconResId;
    }

    public String getName() {
        return name;
    }

    public int getIconResId() {
        return iconResId;
    }
}
