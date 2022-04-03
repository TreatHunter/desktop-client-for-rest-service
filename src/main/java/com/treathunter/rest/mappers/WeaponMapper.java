package com.treathunter.rest.mappers;

import com.treathunter.rest.dto.WeaponDto;
import com.treathunter.rest.entities.Weapon;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeaponMapper {
    Weapon weaponRequestDtoToWeapon(WeaponDto weaponRequestDto);
    WeaponDto weaponToWeaponResponseDto(Weapon weapon);
    List<Weapon> weaponRequestDtoToWeapon(List<WeaponDto> weaponRequestDtoList);
    List<WeaponDto> weaponToWeaponResponseDto(List<Weapon> weaponList);
}
