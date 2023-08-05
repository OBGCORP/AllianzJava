package com.allianz.customerERP.database.repository;

import com.allianz.customerERP.database.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByNameContainsIgnoreCase(String name);
    void deleteByUuid(UUID uuid);
    ProductEntity findByUuid(UUID uuid);
}
