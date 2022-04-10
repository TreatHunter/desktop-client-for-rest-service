package com.treathunter.rest.clients;

import com.treathunter.rest.entities.WeaponType;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfiguration {

    @Bean
    public ClothClient getClothClient () {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ClothClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ClothClient.class, "http://localhost:8080/clothes");
    }

    @Bean
    public BrandClient getBrandClient () {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BrandClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BrandClient.class, "http://localhost:8080/brands");
    }

    @Bean
    public ClothTypeClient getClothTypeClient () {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(ClothTypeClient.class))
                .logLevel(Logger.Level.FULL)
                .target(ClothTypeClient.class, "http://localhost:8080/clothtypes");
    }

    @Bean
    public WeaponClient getWeaponClient () {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(WeaponClient.class))
                .logLevel(Logger.Level.FULL)
                .target(WeaponClient.class, "http://localhost:8080/weapons");
    }

    @Bean
    public WeaponTypeClient getWeaponTypeClient () {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(WeaponTypeClient.class))
                .logLevel(Logger.Level.FULL)
                .target(WeaponTypeClient.class, "http://localhost:8080/weapontypes");
    }

    @Bean
    public CaliberClient getCaliberClient () {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(CaliberClient.class))
                .logLevel(Logger.Level.FULL)
                .target(CaliberClient.class, "http://localhost:8080/calibers");
    }

    @Bean
    public CartridgeTypeClient getCartridgeTypeClient () {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(CartridgeTypeClient.class))
                .logLevel(Logger.Level.FULL)
                .target(CartridgeTypeClient.class, "http://localhost:8080/cartridgetypes");
    }

    @Bean
    public CartridgeBoxClient getCartridgeBoxClient () {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(CartridgeBoxClient.class))
                .logLevel(Logger.Level.FULL)
                .target(CartridgeBoxClient.class, "http://localhost:8080/cartridgeboxes");
    }

}
