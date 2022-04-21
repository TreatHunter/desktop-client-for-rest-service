package com.treathunter.rest.dto;

import com.treathunter.rest.entities.*;

import java.time.LocalDateTime;
import java.util.List;

public class OperationDto {
    private long id;

    private List<Cloth> clothes;

    private List<Product> products;

    private List<CartridgeBox> cartridgeBoxes;

    private List<Weapon> weapons;

    private List<ProductsArchive> productsArchives;

    private String name;

    private String time;

    private User user;

    public long getId() {
        return id;
    }

    public List<Cloth> getClothes() {
        return clothes;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<CartridgeBox> getCartridgeBoxes() {
        return cartridgeBoxes;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public User getUser() {
        return user;
    }

    public List<ProductsArchive> getProductsArchives() {
        return productsArchives;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClothes(List<Cloth> clothes) {
        this.clothes = clothes;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCartridgeBoxes(List<CartridgeBox> cartridgeBoxes) {
        this.cartridgeBoxes = cartridgeBoxes;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProductsArchives(List<ProductsArchive> productsArchives) {
        this.productsArchives = productsArchives;
    }

    @Override
    public String toString() {
        return "OperationRequestDto{" +
                "id=" + id +
                ", clothes=" + clothes +
                ", products=" + products +
                ", cartridgeBoxes=" + cartridgeBoxes +
                ", weapons=" + weapons +
                ", productsArchives=" + productsArchives +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", user=" + user +
                '}';
    }
}
