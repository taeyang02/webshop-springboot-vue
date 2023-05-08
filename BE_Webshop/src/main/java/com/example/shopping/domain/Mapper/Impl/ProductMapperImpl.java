package com.example.shopping.domain.Mapper.Impl;

import com.example.shopping.domain.DTO.ProductDTO;
import com.example.shopping.domain.Mapper.ProductMapper;
import com.example.shopping.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductMapperImpl implements ProductMapper {

    private final ModelMapper modelMapper;
    @Override
    public Product toEntity(ProductDTO dto) {
        Product entity = modelMapper.map(dto,Product.class);
        return entity;
    }

    @Override
    public ProductDTO toDto(Product entity) {
        ProductDTO dto = modelMapper.map(entity, ProductDTO.class);
        return dto;
    }
}
