package com.example.shopping.domain.Mapper;

import com.example.shopping.domain.DTO.ProductDTO;
import com.example.shopping.domain.Mapper.Base.IEntityMapper;
import com.example.shopping.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductMapper extends IEntityMapper<ProductDTO, Product> {
}
