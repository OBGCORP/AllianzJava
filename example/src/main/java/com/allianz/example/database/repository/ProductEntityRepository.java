package com.allianz.example.database.repository;

import com.allianz.example.database.entity.ProductEntity;

import com.allianz.example.util.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import java.util.UUID;

@Repository
public interface ProductEntityRepository extends IBaseRepository<ProductEntity> {

}