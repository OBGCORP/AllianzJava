package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.TaxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TaxEntityRepository extends JpaRepository<TaxEntity, Long> {
    TaxEntity findByUuid(UUID uuid);
    TaxEntity deleteByUuid(UUID uuid);

}