package com.treathunter.rest.clients;

import com.treathunter.rest.dto.CaliberDto;
import com.treathunter.rest.dto.WeaponTypeDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface WeaponTypeClient {
    @RequestLine("GET /{id}")
    WeaponTypeDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<WeaponTypeDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    WeaponTypeDto create(WeaponTypeDto weaponTypeDto);
}
