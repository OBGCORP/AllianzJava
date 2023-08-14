package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements BaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {

    private final CustomerMapper customerMapper;
    private final OrderItemMapper orderItemMapper;

    @Autowired
    public OrderMapper(CustomerMapper customerMapper, OrderItemMapper orderItemMapper) {
        this.customerMapper = customerMapper;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {

        OrderDTO order = new OrderDTO();
        order.setOrderStatus(entity.getOrderStatus());
        order.setId(entity.getId());
        order.setTotalSellPrice(entity.getTotalSellPrice());
        order.setUuid(entity.getUuid());
        order.setId(entity.getId());
        order.setCreationDate(entity.getCreationDate());
        order.setUpdatedDate(entity.getUpdatedDate());
        order.setOrderStatus(entity.getOrderStatus());
        order.setCustomer(customerMapper.entityToDTO(entity.getCustomer()));
        order.setOrderItemList(orderItemMapper.entityListToDTOList(entity.getOrderItemList()));

        return order;


    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity order = new OrderEntity();
        order.setOrderStatus(dto.getOrderStatus());
        order.setId(dto.getId());
        order.setTotalSellPrice(dto.getTotalSellPrice());
        order.setUuid(dto.getUuid());
        order.setId(dto.getId());
        order.setCreationDate(dto.getCreationDate());
        order.setUpdatedDate(dto.getUpdatedDate());
        order.setOrderStatus(dto.getOrderStatus());
        order.setCustomer(customerMapper.dtoToEntity(dto.getCustomer()));
        order.setOrderItemList(orderItemMapper.dtoListTOEntityList(dto.getOrderItemList()));

        return order;

    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities) {
            orderDTOS.add(entityToDTO(orderEntity));
        }
        return orderDTOS;
    }

    @Override
    public List<OrderEntity> dtoListTOEntityList(List<OrderDTO> orderDTOS) {
        List<OrderEntity> orderEntities = new ArrayList<>();
        for (OrderDTO order : orderDTOS) {
            orderEntities.add(dtoToEntity(order));
        }
        return orderEntities;

    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {
        OrderEntity order = new OrderEntity();
        order.setId(dto.getId());
        order.setCreationDate(dto.getCreationDate());
        order.setUuid(dto.getUuid());
        order.setUpdatedDate(dto.getUpdatedDate());
        order.setOrderStatus(dto.getOrderStatus());
        order.setCustomer(customerMapper.requestDTOToEntity(dto.getCustomer()));
        order.setOrderItemList(orderItemMapper.requestDTOListTOEntityList(dto.getOrderItemList()));

        return order;
    }

    @Override
    public List<OrderEntity> requestDTOListTOEntityList(List<OrderRequestDTO> orderRequestDTOS) {
        List<OrderEntity> orderEntities = new ArrayList<>();
        for (OrderRequestDTO orderRequest : orderRequestDTOS) {
            orderEntities.add(requestDTOToEntity(orderRequest));
        }
        return orderEntities;

    }

    @Override
    public OrderEntity requestDTOToExistEntity(OrderRequestDTO dto, OrderEntity entity) {
        return null;
    }
}
