package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseMapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderItemMapper implements IBaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {
    @Override
    public OrderItemDTO entityToDTO(OrderItemEntity entity) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setId(entity.getId());
        orderItemDTO.setUuid(entity.getUuid());
        orderItemDTO.setCreationDate(entity.getCreationDate());
        orderItemDTO.setQuantity(entity.getQuantity());
        orderItemDTO.setUpdatedDate(entity.getUpdatedDate());
        orderItemDTO.setProduct(entity.getProduct());
        orderItemDTO.setSellPrice(entity.getSellPrice());

        return orderItemDTO;
    }

    @Override
    public OrderItemEntity dtoToEntity(OrderItemDTO dto) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();

        orderItemEntity.setId(dto.getId());
        orderItemEntity.setUuid(dto.getUuid());
        orderItemEntity.setCreationDate(dto.getCreationDate());
        orderItemEntity.setQuantity(dto.getQuantity());
        orderItemEntity.setUpdatedDate(dto.getUpdatedDate());
        orderItemEntity.setProduct(dto.getProduct());
        orderItemEntity.setSellPrice(dto.getSellPrice());

        return orderItemEntity;
    }

    @Override
    public List<OrderItemDTO> entityListToDTOList(List<OrderItemEntity> orderItemEntities) {
        List<OrderItemDTO> dtoList = new ArrayList<>();

        for(OrderItemEntity orderItemEntity: orderItemEntities){
            dtoList.add(entityToDTO(orderItemEntity));
        }
        return dtoList;
    }

    @Override
    public List<OrderItemEntity> dtoListTOEntityList(List<OrderItemDTO> orderItemDTOS) {
        List<OrderItemEntity> entityList = new ArrayList<>();

        for(OrderItemDTO orderItemDTO: orderItemDTOS){
            entityList.add(dtoToEntity(orderItemDTO));
        }
        return entityList;
    }

    @Override
    public OrderItemEntity requestDTOToEntity(OrderItemRequestDTO dto) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();

        orderItemEntity.setId(dto.getId());
        orderItemEntity.setUuid(dto.getUuid());
        orderItemEntity.setCreationDate(dto.getCreationDate());
        orderItemEntity.setQuantity(dto.getQuantity());
        orderItemEntity.setUpdatedDate(dto.getUpdatedDate());
        orderItemEntity.setProduct(dto.getProduct());
        orderItemEntity.setSellPrice(dto.getSellPrice());

        return orderItemEntity;
    }
}
