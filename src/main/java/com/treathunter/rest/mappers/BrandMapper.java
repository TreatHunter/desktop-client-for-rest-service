package com.treathunter.rest.mappers;

import com.treathunter.rest.dto.BrandDto;
import com.treathunter.rest.entities.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand brandRequestDtoToBrand(BrandDto brandRequestDto);
    BrandDto brandToBrandResponseDto(Brand brand);
    List<Brand> brandRequestDtoToBrand(List<BrandDto> brandRequestDtoList);
    List<BrandDto> brandToBrandResponseDto(List<Brand> brandList);
}
