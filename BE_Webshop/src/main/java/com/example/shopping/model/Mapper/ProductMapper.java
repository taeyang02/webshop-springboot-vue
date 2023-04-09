package com.example.shopping.model.Mapper;

import com.example.shopping.model.DTO.ProductDto;
import com.example.shopping.model.Mapper.Base.IEntityMapper;
import com.example.shopping.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductMapper extends IEntityMapper<ProductDto, Product> {
}
