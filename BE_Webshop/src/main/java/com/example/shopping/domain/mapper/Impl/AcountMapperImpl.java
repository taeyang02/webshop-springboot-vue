package com.example.shopping.domain.mapper.Impl;

import com.example.shopping.domain.dto.AccountDTO;
import com.example.shopping.domain.mapper.IAccountMapper;
import com.example.shopping.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class AcountMapperImpl implements IAccountMapper {
    private final ModelMapper mapper;

    @Override
    public Account toEntity(AccountDTO dto) {
        return mapper.map(dto, Account.class);
    }

    @Override
    public AccountDTO toDto(Account entity) {
        return mapper.map(entity, AccountDTO.class);
    }
}
