package com.treathunter.rest.mappers;

import com.treathunter.rest.dto.ProductDto;
import com.treathunter.rest.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product productRequestDtoToProduct(ProductDto productRequestDto);
    ProductDto productToProductResponseDto(Product product);
    List<Product> productRequestDtoToProduct(List<ProductDto> productRequestDtoList);
    List<ProductDto> productToProductResponseDto(List<Product> productList);
}
