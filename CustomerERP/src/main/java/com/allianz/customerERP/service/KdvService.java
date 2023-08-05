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

    public boolean createKdv(String type, BigDecimal percent) {
        if (type == null || percent == null) return false;
        KdvEntity kdv = new KdvEntity();
        kdv.setType(type);
        kdv.setPercent(percent);
        kdvRepository.save(kdv);
        return true;
    }

    public List<KdvEntity> getAll() {
        return kdvRepository.findAll();
    }

    public List<KdvEntity> getAllByTypeIContains(String type) {
        return kdvRepository.findAllByTypeContainsIgnoreCase(type);
    }

    public boolean deleteKdv(UUID uuid) {
        if (uuid == null) return false;
        kdvRepository.deleteByUuid(uuid);
        return true;
    }

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
