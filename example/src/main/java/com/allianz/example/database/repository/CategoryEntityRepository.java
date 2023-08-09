package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByUuid(UUID uuid);
    CategoryEntity deleteByUuid(UUID uuid);
}
