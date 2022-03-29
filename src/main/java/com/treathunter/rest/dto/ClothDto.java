package com.treathunter.rest.dto;

import com.treathunter.rest.entities.Brand;
import com.treathunter.rest.entities.ClothType;

public class ClothDto {

    private long id;


    private ClothType clothType;


    private Brand brand;


    private String name;


    private String size;


    private double price;


    private long barcode;


    private String status;


    private String photoUrl;

    public long getId() {
        return id;
    }

    public ClothType getClothType() {
        return clothType;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getStatus() {
        return status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClothType(ClothType clothType) {
        this.clothType = clothType;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "ClothResponseDto{" +
                "id=" + id +
                ", clothType=" + clothType +
                ", brand=" + brand +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", barcode=" + barcode +
                ", status='" + status + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
