package com.ephraim.me.navigation.recipe;

public class Market {
    private String image, tittle;

    public Market(){

    }

    public Market(String image, String tittle) {
        this.image = image;
        this.tittle = tittle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
