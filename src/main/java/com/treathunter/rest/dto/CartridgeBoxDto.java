package com.treathunter.rest.dto;

import com.treathunter.rest.entities.Brand;
import com.treathunter.rest.entities.CartridgeType;

public class CartridgeBoxDto {
    private long id;

    private CartridgeType cartridgeType;

    private Brand brand;

    private String name;

    private int amountInOneBox;

    private double price;

    private long barcode;

    private String status;

    private String photoUrl;

    public long getId() {
        return id;
    }

    public CartridgeType getCartridgeType() {
        return cartridgeType;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getAmountInOneBox() {
        return amountInOneBox;
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

    public void setCartridgeType(CartridgeType cartridgeType) {
        this.cartridgeType = cartridgeType;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountInOneBox(int amountInOneBox) {
        this.amountInOneBox = amountInOneBox;
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
        return "CartridgeBoxRequestDto{" +
                "id=" + id +
                ", cartridgeType=" + cartridgeType +
                ", brand=" + brand +
                ", name='" + name + '\'' +
                ", amountInOneBox=" + amountInOneBox +
                ", price=" + price +
                ", barcode=" + barcode +
                ", status='" + status + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
