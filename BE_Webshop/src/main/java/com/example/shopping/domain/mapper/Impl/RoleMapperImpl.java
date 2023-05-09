package com.example.shopping.domain.mapper.Impl;

import com.example.shopping.domain.dto.RoleDTO;
import com.example.shopping.domain.mapper.IRoleMapper;
import com.example.shopping.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class RoleMapperImpl implements IRoleMapper {
    private final ModelMapper mapper;

    @Override
    public Role toEntity(RoleDTO dto) {
        return mapper.map(dto,Role.class);
    }

    @Override
    public RoleDTO toDto(Role entity) {
        return mapper.map(entity,RoleDTO.class);
    }
}
