package com.ephraim.me.navigation.recipe;

public class Recipe {
    private String image, tittle;

    public Recipe(){

    }

    public Recipe(String image, String tittle) {
        this.image = image;
        this.tittle = tittle;
    }

    public String getImage() {
        return image;
    }

    public void  setImage(String image) {
        this.image = image;

    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
