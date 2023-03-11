package com.example.shopping.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private Instant modifiedDate;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "dob")
    private Instant dob;

    @Column(name = "email")
    private String email;

    @Column(name = "fullname", length = 100)
    private String fullname;

    @Column(name = "gender")
    private Byte gender;

    @Column(name = "password", nullable = false, length = 130)
    private String password;

    @Column(name = "phone_number", length = 12)
    private String phoneNumber;

    @Column(name = "status")
    private Byte status;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

}