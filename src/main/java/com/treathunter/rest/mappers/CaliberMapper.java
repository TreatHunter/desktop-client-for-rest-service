package com.treathunter.rest.mappers;

import com.treathunter.rest.dto.CaliberDto;
import com.treathunter.rest.entities.Caliber;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaliberMapper {
    Caliber caliberRequestDtoToCaliber (CaliberDto caliberRequestDto);
    CaliberDto caliberToCaliberResponseDto(Caliber caliber);
    List<Caliber> caliberRequestDtoToCaliber (List<CaliberDto> caliberRequestDtoList);
    List<CaliberDto> caliberToCaliberResponseDto(List<Caliber> caliberList);
}
