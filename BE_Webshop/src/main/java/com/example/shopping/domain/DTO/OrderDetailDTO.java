package com.example.shopping.domain.DTO;

import com.example.shopping.domain.model.OrderDetail;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link OrderDetail} entity
 */
@Data
public class OrderDetailDTO implements Serializable {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private String size;
    private Byte status;
}