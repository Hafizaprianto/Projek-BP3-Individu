package com.example.projectbp3individu;

public class CartItem {
    private String image;
    private String name;
    private int price;
    private int count;

    public CartItem(String image, String name, int price, int count) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
