package com.example.apfinals;

import android.graphics.drawable.Drawable;

public class Car {
    private String brand;
    private String model;
    private String variant;
    private String pricePm;
    private String priceEm;
    private String priceLabuan;
    private String priceLangkawi;
    private Drawable picture;

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getVariant(){
        return variant;
    }

    public void setVariant(String variant){
        this.variant = variant;
    }

    public String getPricePm(){
        return pricePm;
    }

    public void setPricePm(String pricePm){
        this.pricePm = pricePm;
    }

    public String getPriceEm(){
        return priceEm;
    }

    public void setPriceEm(String priceEm){
        this.priceEm = priceEm;
    }

    public String getPriceLabuan(){
        return priceLabuan;
    }

    public void setPriceLabuan(String priceLabuan){
        this.priceLabuan = priceLabuan;
    }

    public String getPriceLangkawi(){
        return priceLangkawi;
    }

    public void setPriceLangkawi(String priceLangkawi){
        this.priceLangkawi = priceLangkawi;
    }
}
