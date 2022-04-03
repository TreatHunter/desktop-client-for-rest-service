package com.treathunter.rest.clients;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Component;

@Component
public class ClientsContainer {
    private BrandClient brandClient;
    private ClothClient clothClient;
    private ClothTypeClient clothTypeClient;

    public ClientsContainer () {
        clothClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ClothClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ClothClient.class, "http://localhost:8080/clothes");

        brandClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BrandClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BrandClient.class, "http://localhost:8080/brands");

        clothTypeClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ClothTypeClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ClothTypeClient.class, "http://localhost:8080/clothtypes");
    }

    public BrandClient getBrandClient() {
        return brandClient;
    }

    public void setBrandClient(BrandClient brandClient) {
        this.brandClient = brandClient;
    }

    public ClothClient getClothClient() {
        return clothClient;
    }

    public void setClothClient(ClothClient clothClient) {
        this.clothClient = clothClient;
    }

    public ClothTypeClient getClothTypeClient() {
        return clothTypeClient;
    }

    public void setClothTypeClient(ClothTypeClient clothTypeClient) {
        this.clothTypeClient = clothTypeClient;
    }
}
