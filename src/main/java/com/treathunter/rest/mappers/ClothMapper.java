package com.treathunter.rest.mappers;

import com.treathunter.rest.dto.ClothDto;
import com.treathunter.rest.entities.Cloth;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClothMapper {
    Cloth clothRequestDtoToCloth(ClothDto clothRequestDto);
    ClothDto clothToClothResponseDto(Cloth cloth);
    List<Cloth> clothRequestDtoToCloth(List<ClothDto> clothRequestDtoList);
    List<ClothDto> clothToClothResponseDto(List<Cloth> clothList);
}

