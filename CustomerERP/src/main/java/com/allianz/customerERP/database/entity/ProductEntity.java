package com.allianz.customerERP.database.entity;

import com.allianz.customerERP.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "product_uuid"))
@Data
public class ProductEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private BigDecimal nonKdvAppliedPrice = BigDecimal.ZERO;
    @Column
    private Boolean isKdvApplied;
    @Column
    private BigDecimal price;
    @Column
    private Integer stock;
    @Column
    private int orderCount;
    @ManyToOne
    @JoinColumn(name = "kdv_id")
    private KdvEntity kdv;
}
