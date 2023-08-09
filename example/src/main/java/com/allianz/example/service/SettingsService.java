package com.allianz.example.service;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.SettingsEntityRepository;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.SettingsDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class SettingsService {

    @Autowired
    SettingsEntityRepository settingsEntityRepository;

    @Autowired
    SettingsMapper settingsMapper;

    public SettingsEntity createSettings(String key, String value) {
        SettingsEntity settingsEntity = new SettingsEntity();

        settingsEntity.setKey(key);
        settingsEntity.setValue(value);

        settingsEntityRepository.save(settingsEntity);

        return settingsEntity;
    }

    public List<SettingsDTO> getAllSettings() {
        List<SettingsEntity> settingsEntities = settingsEntityRepository.findAll();
        return settingsMapper.entityListToDTOList(settingsEntities);
    }

    public SettingsDTO getByUUID(UUID uuid) {
        SettingsEntity settingsEntity = settingsEntityRepository.findByUuid(uuid);

        if (settingsEntity != null) {
            return settingsMapper.entityToDTO(settingsEntity);
        } else {
            throw new EntityNotFoundException("Settings not found with UUID: " + uuid);
        }
    }

    public SettingsEntity updateSettings(UUID uuid, String key, String value) {
        if (uuid != null) {
            SettingsEntity settingsEntity = settingsEntityRepository.findByUuid(uuid);

            settingsEntity.setKey(key);
            settingsEntity.setValue(value);

            return settingsEntityRepository.save(settingsEntity);
        } else {
            throw new EntityNotFoundException("Settings not found with UUID: " + uuid);
        }
    }

    public void deleteSettings(UUID uuid) {
        settingsEntityRepository.deleteByUuid(uuid);
    }
}

