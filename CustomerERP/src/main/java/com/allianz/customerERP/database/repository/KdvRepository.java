package com.allianz.customerERP.database.repository;

import com.allianz.customerERP.database.entity.CustomerEntity;
import com.allianz.customerERP.database.entity.KdvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KdvRepository extends JpaRepository<KdvEntity, Long> {
    List<KdvEntity> findAllByTypeContainsIgnoreCase(String type);
    void deleteByUuid(UUID uuid);
    KdvEntity findByUuid(UUID uuid);
}
