package com.treathunter.rest.clients;

import com.treathunter.rest.dto.CaliberDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface CaliberClient {
    @RequestLine("GET /{id}")
    CaliberDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<CaliberDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    CaliberDto create(CaliberDto caliberDto);
}
