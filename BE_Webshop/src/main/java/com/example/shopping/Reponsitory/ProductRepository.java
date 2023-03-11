package com.example.shopping.Reponsitory;

import com.example.shopping.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}