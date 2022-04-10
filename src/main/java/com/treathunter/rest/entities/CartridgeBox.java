package com.treathunter.rest.entities;

public class CartridgeBox {

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

    public void setId(long id) {
        this.id = id;
    }

    public CartridgeType getCartridgeType() {
        return cartridgeType;
    }

    public void setCartridgeType(CartridgeType cartridgeType) {
        this.cartridgeType = cartridgeType;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountInOneBox() {
        return amountInOneBox;
    }

    public void setAmountInOneBox(int amountInOneBox) {
        this.amountInOneBox = amountInOneBox;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "CartridgeBox [id=" + id + ", cartridgeType=" + cartridgeType + ", brand=" + brand + ", name=" + name
                + ", amountInOneBox=" + amountInOneBox + ", price=" + price + ", barcode=" + barcode + ", status="
                + status + ", photoUrl=" + photoUrl + "]";
    }


}
