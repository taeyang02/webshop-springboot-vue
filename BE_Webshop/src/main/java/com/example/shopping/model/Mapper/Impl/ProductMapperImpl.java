package com.example.shopping.model.Mapper.Impl;

import com.example.shopping.model.DTO.ProductDto;
import com.example.shopping.model.Mapper.ProductMapper;
import com.example.shopping.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductMapperImpl implements ProductMapper {

    private final ModelMapper modelMapper;
    @Override
    public Product toEntity(ProductDto dto) {
        Product entity = modelMapper.map(dto,Product.class);
        return entity;
    }

    @Override
    public ProductDto toDto(Product entity) {
        ProductDto dto = modelMapper.map(entity, ProductDto.class);
        return dto;
    }
}
