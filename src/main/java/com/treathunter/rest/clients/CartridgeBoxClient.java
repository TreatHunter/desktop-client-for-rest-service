package com.treathunter.rest.clients;

import com.treathunter.rest.dto.CartridgeBoxDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface CartridgeBoxClient {
    @RequestLine("GET /{id}")
    CartridgeBoxDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<CartridgeBoxDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(CartridgeBoxDto cartridgeBoxDto);

    @RequestLine("PUT ?id={id}")
    @Headers("Content-Type: application/json")
    void update(@Param("id") String isbn,CartridgeBoxDto cartridgeBoxDto);

    @RequestLine("DELETE ?id={id}")
    void delete(@Param("id") String isbn);
}
