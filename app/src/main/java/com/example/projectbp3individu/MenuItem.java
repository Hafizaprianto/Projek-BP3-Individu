package com.example.projectbp3individu;

public class MenuItem {
    private String image; // Nama resource gambar
    private String name;  // Nama menu
    private int price;    // Harga menu
    private String description; // Deskripsi menu

    public MenuItem(String image, String name, int price, String description) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


