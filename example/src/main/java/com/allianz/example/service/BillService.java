package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillService {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;

    public BillEntity createBill(BillRequestDTO request) {
        BillEntity billEntity = new BillEntity();

        billEntity.setBillNo(request.getBillNo());
        billEntity.setBillDate(request.getBillDate());
        billEntity.setTaxRate(request.getTaxRate());
        billEntity.setTaxAmount(request.getTaxAmount());
        billEntity.setTotalSellNetPrice(request.getTotalSellNetPrice());
        billEntity.setTotalSellPrice(request.getTotalSellPrice());
        billEntity.setOrder(request.getOrder());

        billEntityRepository.save(billEntity);

        return billEntity;
    }

    public List<BillDTO> getAllBills() {
        List<BillEntity> billEntities = billEntityRepository.findAll();
        return billMapper.entityListToDTOList(billEntities);
    }

    public BillDTO getByUUID(UUID uuid) {
        BillEntity billEntity = billEntityRepository.findByUuid(uuid);

        if (billEntity != null) {
            return billMapper.entityToDTO(billEntity);
        } else {
            throw new EntityNotFoundException("Bill not found with UUID: " + uuid);
        }
    }

    public BillEntity updateBill(UUID uuid, BillRequestDTO request) {
        if (uuid != null) {
            BillEntity billEntity = billEntityRepository.findByUuid(uuid);

            billEntity.setBillNo(request.getBillNo());
            billEntity.setBillDate(request.getBillDate());
            billEntity.setTaxRate(request.getTaxRate());
            billEntity.setTaxAmount(request.getTaxAmount());
            billEntity.setTotalSellNetPrice(request.getTotalSellNetPrice());
            billEntity.setTotalSellPrice(request.getTotalSellPrice());
            billEntity.setOrder(request.getOrder());

            return billEntityRepository.save(billEntity);
        } else {
            throw new EntityNotFoundException("Bill not found with UUID: " + uuid);
        }
    }

    public void deleteBill(UUID uuid) {
        billEntityRepository.deleteByUuid(uuid);
    }
}
