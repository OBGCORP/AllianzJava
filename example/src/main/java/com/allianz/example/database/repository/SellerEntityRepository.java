package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.entity.TaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SellerEntityRepository extends JpaRepository<SellerEntity, Long> {
    SellerEntity findByUuid(UUID uuid);
    SellerEntity deleteByUuid(UUID uuid);
}