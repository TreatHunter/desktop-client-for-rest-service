package com.treathunter.rest.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class Operation {

    private long id;

    private Set<Cloth> clothes = new HashSet<Cloth>();

    private Set<Product> products = new HashSet<Product>();

    private Set<CartridgeBox> cartridgeBoxes = new HashSet<CartridgeBox>();

    private Set<Weapon> weapons = new HashSet<Weapon>();

    private Set<ProductsArchive> productsArchives = new HashSet<>();

    private String name;

    private String time;

    private User user;

    public long getId() {
        return id;
    }

    public Set<Cloth> getClothes() {
        return clothes;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Set<CartridgeBox> getCartridgeBoxes() {
        return cartridgeBoxes;
    }

    public Set<Weapon> getWeapons() {
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

    public Set<ProductsArchive> getProductsArchives() {
        return productsArchives;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClothes(Set<Cloth> clothes) {
        this.clothes = clothes;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void setCartridgeBoxes(Set<CartridgeBox> cartridgeBoxes) {
        this.cartridgeBoxes = cartridgeBoxes;
    }

    public void setWeapons(Set<Weapon> weapons) {
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

    public void setProductsArchives(Set<ProductsArchive> productsArchives) {
        this.productsArchives = productsArchives;
    }

    @Override
    public String toString() {
        return "Operation{" +
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


