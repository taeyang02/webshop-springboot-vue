package com.example.shopping.Reponsitory;

import com.example.shopping.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}