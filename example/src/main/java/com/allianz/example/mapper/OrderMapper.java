package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements IBaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {

    @Override
    public OrderDTO entityToDTO(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setCustomer(entity.getCustomer());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setTotalSellPrice(entity.getTotalSellPrice());
        dto.setOrderItemList(entity.getOrderItemList());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public OrderEntity dtoToEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCustomer(dto.getCustomer());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setOrderItemList(dto.getOrderItemList());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<OrderDTO> entityListToDTOList(List<OrderEntity> orderEntities) {
        List<OrderDTO> dtoList = new ArrayList<>();

        for(OrderEntity orderEntity: orderEntities){
            dtoList.add(entityToDTO(orderEntity));
        }
        return dtoList;
    }

    @Override
    public List<OrderEntity> dtoListTOEntityList(List<OrderDTO> orderDTOS) {
        List<OrderEntity> entityList = new ArrayList<>();

        for(OrderDTO orderDTO: orderDTOS){
            entityList.add(dtoToEntity(orderDTO));
        }
        return entityList;
    }

    @Override
    public OrderEntity requestDTOToEntity(OrderRequestDTO dto) {
        OrderEntity entity = new OrderEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCustomer(dto.getCustomer());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setTotalSellPrice(dto.getTotalSellPrice());
        entity.setOrderItemList(dto.getOrderItemList());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }
}
