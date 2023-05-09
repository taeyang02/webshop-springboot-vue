package com.example.shopping.service.Impl;

import com.example.shopping.Utils.GetPage;
import com.example.shopping.common.payload.Page;
import com.example.shopping.domain.DTO.AccountDTO;
import com.example.shopping.domain.Mapper.IAccountMapper;
import com.example.shopping.domain.model.Account;
import com.example.shopping.domain.model.Role;
import com.example.shopping.reponsitory.AccountRepository;
import com.example.shopping.reponsitory.RoleRepository;
import com.example.shopping.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final IAccountMapper mapper;
    private final GetPage getPage;
    @Override
    public AccountDTO create(AccountDTO dto) {
        Account account = mapper.toEntity(dto);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("can't find this role")));
        account.setRoles(roles);
        return mapper.toDto(accountRepository.save(account));
    }

    @Override
    public AccountDTO update(AccountDTO dto) {
        return mapper.toDto(accountRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public AccountDTO delete(AccountDTO dto) {
        dto.setStatus(false);
        return mapper.toDto(accountRepository.save(mapper.toEntity(dto)));
    }

    @Override
    public Page<?> fillAll(Pageable pageable) {
        org.springframework.data.domain.Page<Account> page = accountRepository.findAll(pageable);
        return getPage.convertPage(page, AccountDTO.class);
    }

    @Override
    public AccountDTO findById(Long aLong) {
        return mapper.toDto(accountRepository.findById(aLong).orElseThrow(() -> new RuntimeException("Can't find ur user")));
    }
}
