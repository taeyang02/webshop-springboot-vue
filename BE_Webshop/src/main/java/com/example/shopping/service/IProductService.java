package com.example.shopping.service;

import com.example.shopping.model.DTO.ProductDto;
import com.example.shopping.model.Product;
import com.example.shopping.service.BaseService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService extends BaseService<ProductDto, Long> {
    Page<?> findAll(Pageable pageable);
}
