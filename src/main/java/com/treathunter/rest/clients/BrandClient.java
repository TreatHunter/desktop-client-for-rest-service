package com.treathunter.rest.clients;

import com.treathunter.rest.dto.BrandDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface  BrandClient {
    @RequestLine("GET /{id}")
    BrandDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<BrandDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(BrandDto brandDto);
}
