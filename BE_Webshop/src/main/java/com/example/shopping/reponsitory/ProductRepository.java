package com.example.shopping.reponsitory;

import com.example.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}