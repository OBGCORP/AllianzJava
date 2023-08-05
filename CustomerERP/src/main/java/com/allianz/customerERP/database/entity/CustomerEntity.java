package com.allianz.customerERP.database.entity;

import com.allianz.customerERP.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "customer_uuid"))
@Data
public class CustomerEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String email;
}
