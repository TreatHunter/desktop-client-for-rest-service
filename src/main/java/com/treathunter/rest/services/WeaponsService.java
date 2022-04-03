package com.treathunter.rest.services;

import com.treathunter.rest.clients.*;
import com.treathunter.rest.dto.BrandDto;
import com.treathunter.rest.dto.ClothTypeDto;
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
    private final ClientsContainer clientsContainer;
    private final WeaponMapper weaponMapper;
    private final WeaponTypeMapper weaponTypeMapper;
    private final CaliberMapper caliberMapper;
    private final BrandMapper brandMapper;

    private WeaponClient weaponClient;
    private WeaponTypeClient weaponTypeClient;
    private CaliberClient caliberClient;
    private BrandClient brandClient;

    public WeaponsService(ClientsContainer clientsContainer, WeaponMapper weaponMapper, WeaponTypeMapper weaponTypeMapper, CaliberMapper caliberMapper, BrandMapper brandMapper) {
        this.clientsContainer = clientsContainer;
        this.weaponMapper = weaponMapper;
        this.weaponTypeMapper = weaponTypeMapper;
        this.caliberMapper = caliberMapper;
        this.brandMapper = brandMapper;

        this.weaponClient = clientsContainer.getWeaponClient();
        this.weaponTypeClient = clientsContainer.getWeaponTypeClient();
        this.caliberClient = clientsContainer.getCaliberClient();
        this.brandClient = clientsContainer.getBrandClient();
    }

    public List<Weapon> getAllWeapons() {
        return weaponMapper.weaponRequestDtoToWeapon(weaponClient.findAll());
    }

    public List<WeaponType> getAllWeaponTypes() {
        return weaponTypeMapper.weaponTypeRequestDtoToWeaponType(weaponTypeClient.findAll());
    }

    public List<Caliber> getAllCalibers() {
        return caliberMapper.caliberRequestDtoToCaliber(caliberClient.findAll());
    }

    public Weapon getWeaponById (String id) {
        return weaponMapper.weaponRequestDtoToWeapon(weaponClient.findById(id));
    }

    public void deleteWeapon (String id) {
        weaponClient.delete(id);
    }
}
