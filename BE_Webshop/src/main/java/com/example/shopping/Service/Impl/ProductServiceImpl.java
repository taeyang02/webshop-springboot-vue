package com.example.shopping.Service.Impl;

import com.example.shopping.Model.Product;
import com.example.shopping.Reponsitory.ProductRepository;
import com.example.shopping.Service.IProductService;
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

    @Override
    public Page<?> findAll(Pageable pageable) {
    Page<Product> result = productRepository.findAll(pageable);
        return result;
    }

    @Override
    public List<Product> findAllById(Iterable<Long> longs) {
        return productRepository.findAllById(longs);
    }

    @Override
    public <S extends Product> S save(S entity) {
        return productRepository.save(entity);
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return productRepository.findOne(example);
    }

}
