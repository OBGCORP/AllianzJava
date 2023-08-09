package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BillEntityRepository extends JpaRepository<BillEntity, Long> {
    BillEntity findByUuid(UUID uuid);
    BillEntity deleteByUuid(UUID uuid);
}
