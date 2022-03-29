package com.treathunter.rest.entities;

public class Brand {

    private long id;

    private String name;

    private String logoUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "Brand [id=" + id + ", name=" + name + ", logoUrl=" + logoUrl + "]";
    }


}
