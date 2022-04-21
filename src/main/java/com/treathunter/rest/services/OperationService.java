package com.treathunter.rest.services;

import com.treathunter.rest.clients.CategoryClient;
import com.treathunter.rest.clients.OperationClient;
import com.treathunter.rest.dto.CartridgeBoxDto;
import com.treathunter.rest.dto.ClothDto;
import com.treathunter.rest.dto.ProductDto;
import com.treathunter.rest.dto.WeaponDto;
import com.treathunter.rest.entities.*;
import com.treathunter.rest.mappers.CategoryMapper;
import com.treathunter.rest.mappers.ClothMapper;
import com.treathunter.rest.mappers.OperationMapper;
import com.treathunter.rest.mappers.WeaponMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    private final OperationMapper operationMapper;
    private final CategoryMapper categoryMapper;
    private final ClothMapper clothMapper;
    private final WeaponMapper weaponMapper;


    private final OperationClient operationClient;
    private final CategoryClient categoryClient;

    public OperationService(OperationMapper operationMapper, CategoryMapper categoryMapper, ClothMapper clothMapper, WeaponMapper weaponMapper, OperationClient operationClient, CategoryClient categoryClient) {
        this.operationMapper = operationMapper;
        this.categoryMapper = categoryMapper;
        this.clothMapper = clothMapper;
        this.weaponMapper = weaponMapper;
        this.operationClient = operationClient;
        this.categoryClient = categoryClient;
    }

    public List<Operation> getOperations() {
        operationClient.findAll();
        return operationMapper.operationRequestDtoToOperation(operationClient.findAll());
    }

    public List<Category> getCategories() {
        return categoryMapper.categoryRequestDtoToCategory(categoryClient.findAll());
    }

    public void addBoughtOperationForCloth (Cloth cloth){
        operationClient.addBoughtOperationForCloth(clothMapper.clothToClothResponseDto(cloth));
    }

    public void addBoughtOperationForWeapon (Weapon weapon){
        operationClient.addBoughtOperationForWeapon(weaponMapper.weaponToWeaponResponseDto(weapon));
    }

    public void addBoughtOperationForCartridgeBox (CartridgeBox cartridgeBox){

    }

    public void addBoughtOperationForProduct (Product product){

    }
}
