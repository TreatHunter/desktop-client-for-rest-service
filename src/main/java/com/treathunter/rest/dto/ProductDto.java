package com.treathunter.rest.dto;

import com.treathunter.rest.entities.Brand;
import com.treathunter.rest.entities.Category;

public class ProductDto {
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

    public Category getCategory() {
        return category;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public long getBarcode() {
        return barcode;
    }

    public String getProductParametersJson() {
        return productParametersJson;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public void setProductParametersJson(String productParametersJson) {
        this.productParametersJson = productParametersJson;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "id=" + id +
                ", category=" + category +
                ", brand=" + brand +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", barcode=" + barcode +
                ", productParametersJson='" + productParametersJson + '\'' +
                ", status='" + status + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
