package com.treathunter;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface  BrandClient {
    @RequestLine("GET /{id}")
    BrandResponseDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<BrandResponseDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(BrandResponseDto brandResponseDto);
}
