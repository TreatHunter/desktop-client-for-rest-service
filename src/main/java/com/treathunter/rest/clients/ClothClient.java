package com.treathunter.rest.clients;

import com.treathunter.rest.dto.ClothDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;;

import java.util.List;

public interface ClothClient {
    @RequestLine("GET /{id}")
    ClothDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<ClothDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(ClothDto clothDto);
}
