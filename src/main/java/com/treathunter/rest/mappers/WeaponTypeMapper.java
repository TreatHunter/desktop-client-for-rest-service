package com.treathunter.rest.mappers;

import com.treathunter.rest.dto.WeaponTypeDto;
import com.treathunter.rest.entities.WeaponType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeaponTypeMapper {
    WeaponType weaponTypeRequestDtoToWeaponType(WeaponTypeDto weaponTypeRequestDto);
    WeaponTypeDto weaponTypeToWeaponTypeResponseDto(WeaponType weaponType);
    List<WeaponType> weaponTypeRequestDtoToWeaponType(List<WeaponTypeDto> weaponTypeRequestDtoList);
    List<WeaponTypeDto> weaponTypeToWeaponTypeResponseDto(List<WeaponType> weaponTypeList);
}
