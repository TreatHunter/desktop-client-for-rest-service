package com.treathunter.rest.entities;

public class Product {

    private long id;

    private Category category;

    private Brand brand;

    private String name;

    private double price;

    private long barcode;

    private String productParametersJson;

    private String status;

    private String photoUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getProductParametersJson() {
        return productParametersJson;
    }

    public void setProductParametersJson(String productParametersJson) {
        this.productParametersJson = productParametersJson;
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
        return "Product [id=" + id + ", category=" + category + ", brand=" + brand + ", name=" + name + ", price="
                + price + ", barcode=" + barcode + ", productParametersJson=" + productParametersJson + ", status="
                + status + ", photoUrl=" + photoUrl + "]";
    }


}
