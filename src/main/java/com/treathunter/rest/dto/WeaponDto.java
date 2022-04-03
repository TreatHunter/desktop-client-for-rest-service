package com.treathunter.rest.dto;

import com.treathunter.rest.entities.Brand;
import com.treathunter.rest.entities.Caliber;
import com.treathunter.rest.entities.WeaponType;

public class WeaponDto {
    private long id;

    private WeaponType weaponType;

    private Brand brand;

    private String name;

    private Caliber caliber;

    private double price;

    private long barcode;

    private String status;

    private String photoUrl;

    public long getId() {
        return id;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public Caliber getCaliber() {
        return caliber;
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

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaliber(Caliber caliber) {
        this.caliber = caliber;
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
        return "WeaponRequestDto{" +
                "id=" + id +
                ", weaponType=" + weaponType +
                ", brand=" + brand +
                ", name='" + name + '\'' +
                ", caliber=" + caliber +
                ", price=" + price +
                ", barcode=" + barcode +
                ", status='" + status + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
