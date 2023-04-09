package com.example.shopping.service.Impl;

import com.example.shopping.model.DTO.ProductDto;
import com.example.shopping.model.Mapper.ProductMapper;
import com.example.shopping.model.Product;
import com.example.shopping.reponsitory.ProductRepository;
import com.example.shopping.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public Page<?> findAll(Pageable pageable) {
    Page<Product> result = productRepository.findAll(pageable);
        return result;
    }

    @Override
    public ProductDto create(ProductDto dto) {
        return mapper.toDto(productRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public ProductDto update(ProductDto dto) {
        dto.setStatus(false);
        return mapper.toDto(productRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public ProductDto delete(ProductDto dto) {
        dto.setStatus(false);
        return mapper.toDto(productRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public com.example.shopping.common.payload.Page<?> fillAll(Pageable pageable) {
        Page<Product> result = productRepository.findAll(pageable);
        return (com.example.shopping.common.payload.Page<?>) result;
    }

    @Override
    public ProductDto findById(Long aLong) {
        return mapper.toDto(productRepository.findById(aLong).orElse(null));
    }
}
