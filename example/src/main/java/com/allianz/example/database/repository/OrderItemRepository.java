package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
    OrderItemEntity findByUuid(UUID uuid);
    OrderItemEntity deleteByUuid(UUID uuid);
}