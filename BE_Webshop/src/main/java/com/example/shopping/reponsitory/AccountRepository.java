package com.example.shopping.reponsitory;

import com.example.shopping.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}