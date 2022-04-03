package com.treathunter.rest.mappers;

import com.treathunter.rest.dto.ClothTypeDto;
import com.treathunter.rest.entities.ClothType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClothTypeMapper {
    ClothType clothTypeRequestDtoToClothType(ClothTypeDto clothTypeRequestDto);
    ClothTypeDto clothTypeToClothTypeResponseDto(ClothType clothType);
    List<ClothType> clothTypeRequestDtoToClothType(List<ClothTypeDto> clothTypeRequestDtoList);
    List<ClothTypeDto> clothTypeToClothTypeResponseDto(List<ClothType> clothTypeList);
}
