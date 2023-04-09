package com.example.shopping.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class AccountRoleId implements Serializable {
    private static final long serialVersionUID = 1949727630874723722L;
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AccountRoleId entity = (AccountRoleId) o;
        return Objects.equals(this.accountId, entity.accountId) &&
                Objects.equals(this.roleId, entity.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, roleId);
    }

}