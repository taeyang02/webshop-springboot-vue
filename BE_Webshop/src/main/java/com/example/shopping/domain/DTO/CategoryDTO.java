package com.example.shopping.domain.DTO;

import com.example.shopping.domain.model.Category;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Category} entity
 */
@Data
public class CategoryDTO implements Serializable {
    private Long id;
    private String createBy;
    private Instant createDate;
    private String modifiedBy;
    private Instant modifiedDate;
    private String code;
    private String name;
}