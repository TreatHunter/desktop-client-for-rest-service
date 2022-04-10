package com.treathunter.rest.services;

import com.treathunter.rest.clients.*;
import com.treathunter.rest.dto.BrandDto;
import com.treathunter.rest.dto.CaliberDto;
import com.treathunter.rest.dto.WeaponTypeDto;
import com.treathunter.rest.entities.Brand;
import com.treathunter.rest.entities.Caliber;
import com.treathunter.rest.entities.Weapon;
import com.treathunter.rest.entities.WeaponType;
import com.treathunter.rest.mappers.BrandMapper;
import com.treathunter.rest.mappers.CaliberMapper;
import com.treathunter.rest.mappers.WeaponMapper;
import com.treathunter.rest.mappers.WeaponTypeMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class WeaponsService {
    private final WeaponMapper weaponMapper;
    private final WeaponTypeMapper weaponTypeMapper;
    private final CaliberMapper caliberMapper;
    private final BrandMapper brandMapper;

    private final WeaponClient weaponClient;
    private final WeaponTypeClient weaponTypeClient;
    private final CaliberClient caliberClient;
    private final BrandClient brandClient;

    public WeaponsService(WeaponMapper weaponMapper, WeaponTypeMapper weaponTypeMapper, CaliberMapper caliberMapper, BrandMapper brandMapper, WeaponClient weaponClient, WeaponTypeClient weaponTypeClient, CaliberClient caliberClient, BrandClient brandClient) {
        this.weaponMapper = weaponMapper;
        this.weaponTypeMapper = weaponTypeMapper;
        this.caliberMapper = caliberMapper;
        this.brandMapper = brandMapper;

        this.weaponClient = weaponClient;
        this.weaponTypeClient = weaponTypeClient;
        this.caliberClient = caliberClient;
        this.brandClient = brandClient;
    }

    public List<Weapon> getAllWeapons () {
        return weaponMapper.weaponRequestDtoToWeapon(weaponClient.findAll());
    }

    public List<WeaponType> getAllWeaponTypes () {
        return weaponTypeMapper.weaponTypeRequestDtoToWeaponType(weaponTypeClient.findAll());
    }

    public List<Caliber> getAllCalibers () {
        return caliberMapper.caliberRequestDtoToCaliber(caliberClient.findAll());
    }

    public List<Brand> getAllBrands () {
        return brandMapper.brandRequestDtoToBrand(brandClient.findAll());
    }

    public Weapon getWeaponById (String id) {
        return weaponMapper.weaponRequestDtoToWeapon(weaponClient.findById(id));
    }

    public void deleteWeapon (String id) {
        weaponClient.delete(id);
    }

    public void addWeapon (Weapon weapon) {
        if (0l == weapon.getBrand().getId()) {
            BrandDto savedBrandDto = brandClient.create(brandMapper.brandToBrandResponseDto(weapon.getBrand()));
            weapon.setBrand(brandMapper.brandRequestDtoToBrand(savedBrandDto));
        }
        if (0l == weapon.getWeaponType().getId()) {
            WeaponTypeDto savedWeaponTypeDto = weaponTypeClient.create(weaponTypeMapper.weaponTypeToWeaponTypeResponseDto(weapon.getWeaponType()));
            weapon.setWeaponType(weaponTypeMapper.weaponTypeRequestDtoToWeaponType(savedWeaponTypeDto));
        }
        if (0l == weapon.getCaliber().getId()) {
            CaliberDto savedCaliberDto = caliberClient.create(caliberMapper.caliberToCaliberResponseDto(weapon.getCaliber()));
            weapon.setCaliber(caliberMapper.caliberRequestDtoToCaliber(savedCaliberDto));
        }
        weaponClient.create(weaponMapper.weaponToWeaponResponseDto(weapon));
    }

    public void updateWeapon (String id, Weapon weapon) {
        if (0l == weapon.getBrand().getId()) {
            BrandDto savedBrandDto = brandClient.create(brandMapper.brandToBrandResponseDto(weapon.getBrand()));
            weapon.setBrand(brandMapper.brandRequestDtoToBrand(savedBrandDto));
        }
        if (0l == weapon.getWeaponType().getId()) {
            WeaponTypeDto savedWeaponTypeDto = weaponTypeClient.create(weaponTypeMapper.weaponTypeToWeaponTypeResponseDto(weapon.getWeaponType()));
            weapon.setWeaponType(weaponTypeMapper.weaponTypeRequestDtoToWeaponType(savedWeaponTypeDto));
        }
        if (0l == weapon.getCaliber().getId()) {
            CaliberDto savedCaliberDto = caliberClient.create(caliberMapper.caliberToCaliberResponseDto(weapon.getCaliber()));
            weapon.setCaliber(caliberMapper.caliberRequestDtoToCaliber(savedCaliberDto));
        }
        weaponClient.update(id, weaponMapper.weaponToWeaponResponseDto(weapon));
    }

}
