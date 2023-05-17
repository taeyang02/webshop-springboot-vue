package com.example.shopping.domain.mapper;

import com.example.shopping.domain.dto.ProductDTO;
import com.example.shopping.domain.mapper.Base.IEntityMapper;
import com.example.shopping.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface IProductMapper extends IEntityMapper<ProductDTO, Product> {
}
