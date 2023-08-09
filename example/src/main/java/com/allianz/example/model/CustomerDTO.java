package com.allianz.example.model;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.util.BaseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
@Data
public class CustomerDTO extends BaseDTO {

    private PersonEntity person;

    private Boolean isCorporate;

    private String companyName;

    private String taxNumber;

    private String taxOffice;

    private List<OrderEntity> orderList;

}
