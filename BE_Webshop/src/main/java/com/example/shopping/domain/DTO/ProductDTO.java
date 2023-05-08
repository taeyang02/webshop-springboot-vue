package com.example.shopping.domain.DTO;

import com.example.shopping.domain.model.Category;
import com.example.shopping.domain.model.Product;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link Product} entity
 */
@Data
public class ProductDTO implements Serializable {
    private Long id;
    private String createBy;
    private Instant createDate;
    private String modifiedBy;
    private Instant modifiedDate;
    private String description;
    private Byte available;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String size;
    private String image;
    private Integer quantitySold;
    private Boolean status;
    private Category category;
}