package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.TaxDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaxService {

    @Autowired
    TaxEntityRepository taxEntityRepository;

    @Autowired
    TaxMapper taxMapper;

    public TaxEntity createTax(String name, String code, BigDecimal rate){
        TaxEntity tax = new TaxEntity();

        tax.setName(name);
        tax.setCode(code);
        tax.setRate(rate);

        taxEntityRepository.save(tax);

        return tax;
    }

    public List<TaxDTO> getAllTaxes() {
        List<TaxEntity> taxEntities = taxEntityRepository.findAll();
        return taxMapper.entityListToDTOList(taxEntities);
    }

    public TaxDTO getByUUID(UUID uuid) {
        TaxEntity taxEntity = taxEntityRepository.findByUuid(uuid);

        if (taxEntity != null) {
            return taxMapper.entityToDTO(taxEntity);
        } else {
            throw new EntityNotFoundException("Tax not found with UUID: " + uuid);
        }
    }

    public TaxEntity updateTax(UUID uuid,String name, String code, BigDecimal rate) {
        if(uuid != null){
            TaxEntity taxEntity = taxEntityRepository.findByUuid(uuid);

            taxEntity.setName(name);
            taxEntity.setCode(code);
            taxEntity.setRate(rate);

            return taxEntityRepository.save(taxEntity);
        } else {
            throw new EntityNotFoundException("Address not found with UUID: " + uuid);
        }
    }

    public void deleteTax(UUID uuid) {
        taxEntityRepository.deleteByUuid(uuid);
    }
}
