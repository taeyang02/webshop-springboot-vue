package com.example.shopping.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRoleDTO {
    private AccountDTO accountDTO;
    private RoleDTO roleDTO;
}
