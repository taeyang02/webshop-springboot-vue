package com.example.shopping.Reponsitory;

import com.example.shopping.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}