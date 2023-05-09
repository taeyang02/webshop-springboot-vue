package com.example.shopping.service;

import com.example.shopping.domain.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends BaseService<ProductDTO, Long> {
    Page<?> findAll(Pageable pageable);
}
