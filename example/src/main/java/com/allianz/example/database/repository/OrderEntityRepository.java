package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findByUuid(UUID uuid);
    OrderEntity deleteByUuid(UUID uuid);
}