package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByUuid(UUID uuid);
    ProductEntity deleteByUuid(UUID uuid);

}
