package com.example.shopping.domain.mapper.Impl;

import com.example.shopping.domain.dto.AccountRoleDTO;
import com.example.shopping.domain.mapper.IAccountRoleMapper;
import com.example.shopping.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountRoleMapperImpl implements IAccountRoleMapper {
    private final ModelMapper mapper;
    @Override
    public Account toEntity(AccountRoleDTO dto) {
        return mapper.map(dto, Account.class);
    }

    @Override
    public AccountRoleDTO toDto(Account entity) {
        return mapper.map(entity, AccountRoleDTO.class);
    }
}
