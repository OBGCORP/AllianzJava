package com.allianz.customerERP.model;

import com.allianz.customerERP.database.entity.CustomerEntity;
import com.allianz.customerERP.database.entity.ProductEntity;
import com.allianz.customerERP.util.EOrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDTO {
    private UUID uuid;
    private CustomerEntity customerEntity;
    private List<ProductEntity> productEntityList = new ArrayList<>();
    private EOrderStatus status = EOrderStatus.WAITING;
    public OrderDTO() {
        this.uuid = UUID.randomUUID();
    }
}
