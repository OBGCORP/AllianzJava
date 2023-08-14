package com.allianz.example.service;


import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class OrderItemService extends BaseService<OrderItemEntity, OrderItemDTO,
        OrderItemRequestDTO, OrderItemMapper, OrderItemEntityRepository> {

    @Autowired
    private OrderItemEntityRepository orderItemEntityRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;


    @Override
    public OrderItemMapper getMapper() {
        return orderItemMapper;
    }

    @Override
    public OrderItemEntityRepository getRepository() {
        return orderItemEntityRepository;
    }
}
