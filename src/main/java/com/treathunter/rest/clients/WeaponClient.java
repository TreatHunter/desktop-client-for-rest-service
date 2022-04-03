package com.treathunter.rest.clients;

import com.treathunter.rest.dto.WeaponDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface WeaponClient {
    @RequestLine("GET /{id}")
    WeaponDto findById(@Param("id") String isbn);

    @RequestLine("GET")
    List<WeaponDto> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(WeaponDto weaponDto);

    @RequestLine("PUT ?id={id}")
    @Headers("Content-Type: application/json")
    void update(@Param("id") String isbn,WeaponDto weaponDto);

    @RequestLine("DELETE ?id={id}")
    void delete(@Param("id") String isbn);
}
