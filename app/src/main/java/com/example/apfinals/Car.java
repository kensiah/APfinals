package com.example.apfinals;

public class Car {
    private String brand;
    private String model;
    private String variant;
    private double pricePm;
    private double priceEm;
    private double priceLabuan;
    private double priceLangkawi;

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

    public double getPricePm(){
        return pricePm;
    }

    public void setPricePm(double pricePm){
        this.pricePm = pricePm;
    }

    public double getPriceEm(){
        return priceEm;
    }

    public void setPriceEm(double priceEm){
        this.priceEm = priceEm;
    }

    public double getPriceLabuan(){
        return priceLabuan;
    }

    public void setPriceLabuan(double priceLabuan){
        this.priceLabuan = priceLabuan;
    }

    public double getPriceLangkawi(){
        return priceLangkawi;
    }

    public void setPriceLangkawi(double priceLangkawi){
        this.priceLangkawi = priceLangkawi;
    }
}
