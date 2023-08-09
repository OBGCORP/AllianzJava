package com.allianz.example.database.repository;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.SettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SettingsEntityRepository extends JpaRepository<SettingsEntity, Long> {
    SettingsEntity findByUuid(UUID uuid);
    SettingsEntity deleteByUuid(UUID uuid);
}