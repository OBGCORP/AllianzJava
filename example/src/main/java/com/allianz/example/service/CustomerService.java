package com.allianz.example.service;


import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class CustomerService extends BaseService<CustomerEntity,
        CustomerDTO, CustomerRequestDTO, CustomerMapper, CustomerEntityRepository> {

    @Autowired
    private CustomerEntityRepository customerEntityRepository;

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public CustomerMapper getMapper() {
        return customerMapper;
    }

    @Override
    public CustomerEntityRepository getRepository() {
        return customerEntityRepository;
    }
}
