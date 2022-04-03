package com.treathunter.rest.clients;


import com.treathunter.rest.dto.ClothTypeDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface ClothTypeClient {
    @RequestLine("GET /{id}")
    ClothTypeDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<ClothTypeDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    ClothTypeDto create(ClothTypeDto clothTypeDtoDto);
}
