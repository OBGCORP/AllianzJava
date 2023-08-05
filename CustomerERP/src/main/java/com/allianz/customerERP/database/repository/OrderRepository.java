package com.allianz.customerERP.database.repository;

import com.allianz.customerERP.database.entity.OrderEntity;
import com.allianz.customerERP.util.EOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    void deleteByUuid(UUID uuid);
    OrderEntity findByUuid(UUID uuid);
    List<OrderEntity> getOrderEntitiesByStatus(EOrderStatus status);
}
