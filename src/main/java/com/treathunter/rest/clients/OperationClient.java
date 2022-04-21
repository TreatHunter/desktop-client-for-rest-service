package com.treathunter.rest.clients;

import com.treathunter.rest.dto.*;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

public interface OperationClient {
    @RequestLine("GET")
    List<OperationDto> findAll ();

    @RequestLine("POST /addBoughtOperationForCloth")
    @Headers("Content-Type: application/json")
    OperationDto addBoughtOperationForCloth (ClothDto clothDto);

    @RequestLine("POST /addBoughtOperationForWeapon")
    @Headers("Content-Type: application/json")
    OperationDto addBoughtOperationForWeapon (WeaponDto weaponDto);

    @RequestLine("POST /addBoughtOperationForCartridgeBox")
    @Headers("Content-Type: application/json")
    OperationDto addBoughtOperationForCartridgeBox (CartridgeBoxDto cartridgeBoxDto);

    @RequestLine("POST /addBoughtOperationForProduct")
    @Headers("Content-Type: application/json")
    OperationDto addBoughtOperationForProduct (ProductDto productDto);
}
