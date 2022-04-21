package com.treathunter.rest.mappers;


import com.treathunter.rest.dto.OperationDto;
import com.treathunter.rest.entities.Operation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OperationMapper {
    Operation operationRequestDtoToOperation(OperationDto operationRequestDto);
    OperationDto operationToOperationResponseDto(Operation operation);
    List<Operation> operationRequestDtoToOperation(List<OperationDto> operationRequestDtoList);
    List<OperationDto> operationToOperationResponseDto(List<Operation> operationList);
}
