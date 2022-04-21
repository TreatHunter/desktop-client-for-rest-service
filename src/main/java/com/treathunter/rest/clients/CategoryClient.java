package com.treathunter.rest.clients;

import com.treathunter.rest.dto.CategoryDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface CategoryClient {
    @RequestLine("GET /{id}")
    CategoryDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<CategoryDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    CategoryDto create(CategoryDto categoryDto);
}
