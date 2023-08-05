package com.allianz.customerERP.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class KdvDTO {
    private UUID uuid;
    private String type;
    private BigDecimal percent;
    public KdvDTO() {
        this.uuid = UUID.randomUUID();
    }
}
