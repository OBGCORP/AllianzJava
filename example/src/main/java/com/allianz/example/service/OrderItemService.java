package com.allianz.example.service;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.OrderItemRepository;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Autowired
    ProductEntityRepository productEntityRepository;

    public OrderItemEntity createOrderItem(OrderItemRequestDTO request) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();

        if (request.getProduct() != null) {
            ProductEntity productEntity = productEntityRepository.findById(request.getProduct().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + request.getProduct().getId()));
            orderItemEntity.setProduct(productEntity);
        }

        orderItemEntity.setQuantity(request.getQuantity());
        orderItemEntity.setSellPrice(request.getSellPrice());

        orderItemRepository.save(orderItemEntity);

        return orderItemEntity;
    }

    public List<OrderItemDTO> getAllOrderItems() {
        List<OrderItemEntity> orderItemEntities = orderItemRepository.findAll();
        return orderItemMapper.entityListToDTOList(orderItemEntities);
    }

    public OrderItemDTO getByUUID(UUID uuid) {
        OrderItemEntity orderItemEntity = orderItemRepository.findByUuid(uuid);

        if (orderItemEntity != null) {
            return orderItemMapper.entityToDTO(orderItemEntity);
        } else {
            throw new EntityNotFoundException("Order Item not found with UUID: " + uuid);
        }
    }

    public OrderItemEntity updateOrderItem(UUID uuid, OrderItemRequestDTO request) {
        if (uuid != null) {
            OrderItemEntity orderItemEntity = orderItemRepository.findByUuid(uuid);

            if (request.getProduct() != null) {
                ProductEntity productEntity = productEntityRepository.findById(request.getProduct().getId())
                        .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + request.getProduct().getId()));
                orderItemEntity.setProduct(productEntity);
            }

            orderItemEntity.setQuantity(request.getQuantity());
            orderItemEntity.setSellPrice(request.getSellPrice());

            return orderItemRepository.save(orderItemEntity);
        } else {
            throw new EntityNotFoundException("Order Item not found with UUID: " + uuid);
        }
    }

    public void deleteOrderItem(UUID uuid) {
        orderItemRepository.deleteByUuid(uuid);
    }
}

