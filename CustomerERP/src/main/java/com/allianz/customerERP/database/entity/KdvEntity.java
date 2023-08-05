package com.allianz.customerERP.database.entity;

import com.allianz.customerERP.util.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "kdv_uuid"))
@Data
public class KdvEntity extends BaseEntity {
    @Column
    private String type;
    @Column
    private BigDecimal percent;
}
