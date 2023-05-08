package com.example.shopping.reponsitory;

import com.example.shopping.domain.model.AccountRole;
import com.example.shopping.domain.model.AccountRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole, AccountRoleId> {
}