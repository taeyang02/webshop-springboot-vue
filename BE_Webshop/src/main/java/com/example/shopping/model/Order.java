package com.example.shopping.model;

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
@Table(name = "`order`")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number", length = 12)
    private String phoneNumber;

    @Column(name = "create_by", length = 45)
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modified_by", length = 45)
    private String modifiedBy;

    @Column(name = "modified_date")
    private Instant modifiedDate;

    @Column(name = "status")
    private Byte status;

}