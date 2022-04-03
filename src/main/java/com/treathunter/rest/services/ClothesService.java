package com.treathunter.rest.services;

import com.treathunter.rest.clients.BrandClient;
import com.treathunter.rest.clients.ClientsContainer;
import com.treathunter.rest.clients.ClothClient;
import com.treathunter.rest.clients.ClothTypeClient;
import com.treathunter.rest.dto.BrandDto;
import com.treathunter.rest.dto.ClothDto;
import com.treathunter.rest.dto.ClothTypeDto;
import com.treathunter.rest.entities.Brand;
import com.treathunter.rest.entities.Cloth;
import com.treathunter.rest.entities.ClothType;
import com.treathunter.rest.mappers.BrandMapper;
import com.treathunter.rest.mappers.ClothMapper;
import com.treathunter.rest.mappers.ClothTypeMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClothesService {
    private final ClientsContainer clientsContainer;
    private final ClothTypeMapper clothTypeMapper;
    private final BrandMapper brandMapper;
    private final ClothMapper clothMapper;

    private ClothClient clothClient;
    private BrandClient brandClient;
    private ClothTypeClient clothTypeClient;

    public ClothesService(ClothTypeMapper clothTypeMapper, BrandMapper brandMapper, ClientsContainer clientsContainer, ClothMapper clothMapper) {
        this.clothTypeMapper = clothTypeMapper;
        this.brandMapper = brandMapper;
        this.clientsContainer = clientsContainer;
        this.clothMapper = clothMapper;

        clothClient = clientsContainer.getClothClient();
        brandClient = clientsContainer.getBrandClient();
        clothTypeClient = clientsContainer.getClothTypeClient();
    }

    public List<Cloth> getAllClothes() {
        return clothMapper.clothRequestDtoToCloth(clothClient.findAll());
    }

    public List<Brand> getAllBrands() {
        return brandMapper.brandRequestDtoToBrand(brandClient.findAll());
    }

    public List<ClothType> getAllClothTypes() {
        return clothTypeMapper.clothTypeRequestDtoToClothType(clothTypeClient.findAll());
    }

    public void addCloth (Cloth cloth) {
        if(0l == cloth.getBrand().getId()){
            BrandDto savedBrandDto = brandClient.create(brandMapper.brandToBrandResponseDto(cloth.getBrand()));
            cloth.setBrand(brandMapper.brandRequestDtoToBrand(savedBrandDto));
        }
        if(0l == cloth.getClothType().getId()){
            ClothTypeDto savedClothTypeDto = clothTypeClient.create(clothTypeMapper.clothTypeToClothTypeResponseDto(cloth.getClothType()));
            cloth.setClothType(clothTypeMapper.clothTypeRequestDtoToClothType(savedClothTypeDto));
        }
        clothClient.create(clothMapper.clothToClothResponseDto(cloth));
    }

    public void deleteCloth (String id){
        clothClient.delete(id);
    }

    public void updateCloth(String id, Cloth cloth) {
        if(0l == cloth.getBrand().getId()) {
            BrandDto savedBrandDto = brandClient.create(brandMapper.brandToBrandResponseDto(cloth.getBrand()));
            cloth.setBrand(brandMapper.brandRequestDtoToBrand(savedBrandDto));
        }
        if(0l == cloth.getClothType().getId()) {
            ClothTypeDto savedClothTypeDto = clothTypeClient.create(clothTypeMapper.clothTypeToClothTypeResponseDto(cloth.getClothType()));
            cloth.setClothType(clothTypeMapper.clothTypeRequestDtoToClothType(savedClothTypeDto));
        }
        clothClient.update(id, clothMapper.clothToClothResponseDto(cloth));
    }

    public Cloth getClothById(String id) {
        return clothMapper.clothRequestDtoToCloth(clothClient.findById(id));
    }
}
