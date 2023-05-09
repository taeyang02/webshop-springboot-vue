package com.example.shopping.domain.dto;

import com.example.shopping.domain.model.ERole;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.example.shopping.domain.model.Role} entity
 */
@Data
public class RoleDTO implements Serializable {
    private Long id;
    private String createBy;
    private Instant createDate;
    private String modifiedBy;
    private Instant modifiedDate;
    @Enumerated
    private ERole name;
}