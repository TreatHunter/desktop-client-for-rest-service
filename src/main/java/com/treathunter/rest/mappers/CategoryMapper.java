package com.treathunter.rest.mappers;

import com.treathunter.rest.dto.CategoryDto;
import com.treathunter.rest.entities.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category categoryRequestDtoToCategory(CategoryDto categoryRequestDto);
    CategoryDto categoryToCategoryResponseDto(Category category);
    List<Category> categoryRequestDtoToCategory(List<CategoryDto> categoryRequestDtoList);
    List<CategoryDto> categoryToCategoryResponseDto(List<Category> categoryList);
}
