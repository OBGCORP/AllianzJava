package com.allianz.customerERP.service;

import com.allianz.customerERP.database.entity.KdvEntity;
import com.allianz.customerERP.database.repository.KdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class KdvService {
    @Autowired
    KdvRepository kdvRepository;

    // Method to create a new KDV (Value Added Tax) entry with the given type and percentage
    public boolean createKdv(String type, BigDecimal percent) {
        if (type == null || percent == null) return false;
        KdvEntity kdv = new KdvEntity();
        kdv.setType(type);
        kdv.setPercent(percent);
        kdvRepository.save(kdv);
        return true;
    }

    // Method to get all KDV entries from the database
    public List<KdvEntity> getAll() {
        return kdvRepository.findAll();
    }

    // Method to get KDV entries whose type contains the specified search string (case-insensitive)
    public List<KdvEntity> getAllByTypeIContains(String type) {
        return kdvRepository.findAllByTypeContainsIgnoreCase(type);
    }

    // Method to delete a KDV entry with the specified UUID
    public boolean deleteKdv(UUID uuid) {
        if (uuid == null) return false;
        kdvRepository.deleteByUuid(uuid);
        return true;
    }

    // Method to update an existing KDV entry's type and percentage using the provided UUID
    public boolean updateKdv(UUID uuid, KdvEntity kdv) {
        if (uuid == null || kdv == null) return false;
        KdvEntity kdvEntity = kdvRepository.findByUuid(uuid);
        if (kdvEntity == null) return false;
        kdvEntity.setType(kdv.getType());
        kdvEntity.setPercent(kdv.getPercent());
        kdvRepository.save(kdvEntity);
        return true;
    }
}
