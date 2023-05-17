package com.example.shopping.domain.dto;

import com.example.shopping.domain.model.Order;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Order} entity
 */
@Data
public class OrderDTO implements Serializable {
    private Long id;
    private String address;
    private String phoneNumber;
    private String createBy;
    private Instant createDate;
    private String modifiedBy;
    private Instant modifiedDate;
    private Boolean status;
}