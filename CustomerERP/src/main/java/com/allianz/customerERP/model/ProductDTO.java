package com.allianz.customerERP.model;

import com.allianz.customerERP.database.entity.KdvEntity;
import com.allianz.customerERP.database.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class ProductDTO {
    private UUID uuid;
    private String name;
    private BigDecimal nonKdvAppliedPrice;
    private Boolean isKdvApplied;
    private BigDecimal price;
    private Integer stock;
    private KdvEntity kdv;
    private OrderEntity order;
    public ProductDTO() {
        this.uuid = UUID.randomUUID();
    }
}
