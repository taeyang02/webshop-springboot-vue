package com.example.shopping.Reponsitory;

import com.example.shopping.Model.AccountRole;
import com.example.shopping.Model.AccountRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole, AccountRoleId> {
}