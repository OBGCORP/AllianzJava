package com.allianz.example.service;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class SellerService {

    @Autowired
    SellerEntityRepository sellerEntityRepository;

    @Autowired
    SellerMapper sellerMapper;

    public SellerEntity createSeller(SellerRequestDTO request) {
        SellerEntity sellerEntity = new SellerEntity();

        sellerEntity.setName(request.getName());
        sellerEntity.setSurname(request.getSurname());
        sellerEntity.setTc(request.getTc());
        sellerEntity.setEmail(request.getEmail());
        sellerEntity.setShopName(request.getShopName());
        sellerEntity.setTaxNumber(request.getTaxNumber());
        sellerEntity.setTaxOffice(request.getTaxOffice());

        sellerEntityRepository.save(sellerEntity);

        return sellerEntity;
    }

    public List<SellerDTO> getAllSellers() {
        List<SellerEntity> sellerEntities = sellerEntityRepository.findAll();
        return sellerMapper.entityListToDTOList(sellerEntities);
    }

    public SellerDTO getByUUID(UUID uuid) {
        SellerEntity sellerEntity = sellerEntityRepository.findByUuid(uuid);

        if (sellerEntity != null) {
            return sellerMapper.entityToDTO(sellerEntity);
        } else {
            throw new EntityNotFoundException("Seller not found with UUID: " + uuid);
        }
    }

    public SellerEntity updateSeller(UUID uuid, SellerRequestDTO request) {
        if (uuid != null) {
            SellerEntity sellerEntity = sellerEntityRepository.findByUuid(uuid);

            sellerEntity.setTc(request.getTc());
            sellerEntity.setEmail(request.getEmail());
            sellerEntity.setName(request.getName());
            sellerEntity.setSurname(request.getSurname());
            sellerEntity.setTaxNumber(request.getTaxNumber());
            sellerEntity.setTaxOffice(request.getTaxOffice());
            sellerEntity.setShopName(request.getShopName());

            return sellerEntityRepository.save(sellerEntity);
        } else {
            throw new EntityNotFoundException("Seller not found with UUID: " + uuid);
        }
    }

    public void deleteSeller(UUID uuid) {
        sellerEntityRepository.deleteByUuid(uuid);
    }
}

