package com.example.shopping.Service;

import com.example.shopping.Model.Product;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    List<Product> findAllById(Iterable<Long> longs);

    <S extends Product> S save(S entity);

    <S extends Product> Optional<S> findOne(Example<S> example);
}
