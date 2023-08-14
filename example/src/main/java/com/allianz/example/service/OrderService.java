package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class OrderService extends BaseService<OrderEntity, OrderDTO,
        OrderRequestDTO, OrderMapper, OrderEntityRepository> {

    private OrderMapper orderMapper;

    private OrderEntityRepository orderEntityRepository;

    public OrderService(OrderMapper orderMapper, OrderEntityRepository orderEntityRepository) {
        this.orderMapper = orderMapper;
        this.orderEntityRepository = orderEntityRepository;
    }

    @Override
    public OrderMapper getMapper() {
        return null;
    }

    @Override
    public OrderEntityRepository getRepository() {
        return null;
    }

}
