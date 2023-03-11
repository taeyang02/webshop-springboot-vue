package com.example.shopping.Reponsitory;

import com.example.shopping.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}