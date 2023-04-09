package com.example.shopping.reponsitory;

import com.example.shopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}