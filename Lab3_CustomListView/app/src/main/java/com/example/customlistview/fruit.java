package com.example.customlistview;

public class fruit {
    private String fruitName;
    private String description;
    private int image;

    public fruit(String fruitName, String description, int image) {
        this.fruitName = fruitName;
        this.description = description;
        this.image = image;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}