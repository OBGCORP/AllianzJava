package com.allianz.customerERP.model;

import com.allianz.customerERP.database.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CustomerDTO {
    private UUID uuid;
    private String name;
    private String email;
    public CustomerDTO() {
        this.uuid = UUID.randomUUID();
    }
}
