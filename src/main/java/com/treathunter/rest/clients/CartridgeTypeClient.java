package com.treathunter.rest.clients;

import com.treathunter.rest.dto.CartridgeTypeDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface CartridgeTypeClient {
    @RequestLine("GET /{id}")
    CartridgeTypeDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<CartridgeTypeDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    CartridgeTypeDto create(CartridgeTypeDto cartridgeTypeDto);
}
