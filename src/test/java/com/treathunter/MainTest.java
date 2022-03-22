package com.treathunter;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    @Test
    public void test1() throws Exception {
        BrandClient brandClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(BrandClient.class))
                .logLevel(Logger.Level.FULL)
                .target(BrandClient.class, "http://localhost:8080/brands");
        List<BrandResponseDto> brandResponseDtoList = brandClient.findAll().stream()
                .peek((System.out::println))
                .collect(Collectors.toList());
        System.out.println(brandResponseDtoList);
        assertTrue( 1 == 1);
    }
}
