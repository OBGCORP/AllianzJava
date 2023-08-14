package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.OrderItemDTO;

import com.allianz.example.model.requestDTO.OrderItemRequestDTO;

import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper implements BaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {

    private final ProductMapper productMapper;

    @Autowired
    public OrderItemMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public OrderItemDTO entityToDTO(OrderItemEntity entity) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setUuid(entity.getUuid());
        orderItemDTO.setCreationDate(entity.getCreationDate());
        orderItemDTO.setId(entity.getId());
        orderItemDTO.setUpdatedDate(entity.getUpdatedDate());
        orderItemDTO.setQuantity(entity.getQuantity());
        orderItemDTO.setSellPrice(entity.getSellPrice());
        orderItemDTO.setProduct(productMapper.entityToDTO(entity.getProduct()));

        return orderItemDTO;
    }

    @Override
    public OrderItemEntity dtoToEntity(OrderItemDTO dto) {
        OrderItemEntity orderItem = new OrderItemEntity();
        orderItem.setUuid(dto.getUuid());
        orderItem.setCreationDate(dto.getCreationDate());
        orderItem.setId(dto.getId());
        orderItem.setUpdatedDate(dto.getUpdatedDate());
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setSellPrice(dto.getSellPrice());
        // orderItem.setProduct(productMapper.dtoToEntity(dto.getProduct()));


        return orderItem;
    }

    @Override
    public List<OrderItemDTO> entityListToDTOList(List<OrderItemEntity> orderItemEntities) {
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (OrderItemEntity orderItem : orderItemEntities) {
            orderItemDTOS.add(entityToDTO(orderItem));
        }
        return orderItemDTOS;
    }

    @Override
    public List<OrderItemEntity> dtoListTOEntityList(List<OrderItemDTO> orderItemDTOS) {
        List<OrderItemEntity> orderItem = new ArrayList<>();
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            orderItem.add(dtoToEntity(orderItemDTO));
        }
        return orderItem;
    }

    @Override
    public OrderItemEntity requestDTOToExistEntity(OrderItemRequestDTO dto, OrderItemEntity entity) {
        return null;
    }

    @Override
    public OrderItemEntity requestDTOToEntity(OrderItemRequestDTO dto) {
        OrderItemEntity entity = new OrderItemEntity();
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setId(dto.getId());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());
        entity.setProduct(productMapper.dtoToEntity(dto.getProduct()));

        return entity;
    }

    @Override
    public List<OrderItemEntity> requestDTOListTOEntityList(List<OrderItemRequestDTO> orderRequestDTOS) {
        return null;
    }
}
