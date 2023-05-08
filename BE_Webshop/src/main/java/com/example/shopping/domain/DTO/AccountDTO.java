package com.example.shopping.domain.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.example.shopping.domain.model.Account} entity
 */
@Data
public class AccountDTO implements Serializable {
    private Long id;
    private String createBy;
    private Instant createDate;
    private String modifiedBy;
    private Instant modifiedDate;
    private String address;
    private Instant dob;
    private String email;
    private String fullname;
    private Byte gender;
    private String password;
    private String phoneNumber;
    private Byte status;
    private String username;
}