package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.repository.OrderItemRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderEntity createOrder(OrderRequestDTO request) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderStatus(request.getOrderStatus());
        orderEntity.setOrderItemList(request.getOrderItemList());
        orderEntity.setCustomer(request.getCustomer());
        orderEntity.setTotalSellPrice(request.getTotalSellPrice());

        orderEntityRepository.save(orderEntity);

        return orderEntity;
    }

    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> orderEntities = orderEntityRepository.findAll();
        return orderMapper.entityListToDTOList(orderEntities);
    }

    public OrderDTO getByUUID(UUID uuid) {
        OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid);

        if (orderEntity != null) {
            return orderMapper.entityToDTO(orderEntity);
        } else {
            throw new EntityNotFoundException("Order not found with UUID: " + uuid);
        }
    }

    public OrderEntity updateOrder(UUID uuid, OrderRequestDTO request) {
        if (uuid != null) {
            OrderEntity orderEntity = orderEntityRepository.findByUuid(uuid);

            orderEntity.setOrderStatus(request.getOrderStatus());
            orderEntity.setOrderItemList(request.getOrderItemList());
            orderEntity.setCustomer(request.getCustomer());
            orderEntity.setTotalSellPrice(request.getTotalSellPrice());

            return orderEntityRepository.save(orderEntity);
        } else {
            throw new EntityNotFoundException("Order not found with UUID: " + uuid);
        }
    }

    public void deleteOrder(UUID uuid) {
        orderEntityRepository.deleteByUuid(uuid);
    }
}
