package com.example.madproject.model;

public class Car {
    private String id;
    private String model;
    private int price;
    private int mileage;
    private String imageUrl;

    public Car(String id, String model, int price, int mileage, String imageUrl) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.mileage = mileage;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getId() { return id; }
    public String getModel() { return model; }
    public int getPrice() { return price; }
    public int getMileage() { return mileage; }
    public String getImageUrl() { return imageUrl; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setModel(String model) { this.model = model; }
    public void setPrice(int price) { this.price = price; }
    public void setMileage(int mileage) { this.mileage = mileage; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}