package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillMapper implements IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {
    @Override
    public BillDTO entityToDTO(BillEntity entity) {
        BillDTO dto = new BillDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setBillNo(entity.getBillNo());
        dto.setBillDate(entity.getBillDate());
        dto.setTaxAmount(entity.getTaxAmount());
        dto.setTaxRate(entity.getTaxRate());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setOrder(entity.getOrder());
        dto.setTotalSellNetPrice(entity.getTotalSellNetPrice());
        dto.setTotalSellPrice(entity.getTotalSellPrice());

        return dto;
    }

    @Override
    public BillEntity dtoToEntity(BillDTO dto) {
        BillEntity entity = new BillEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setBillNo(dto.getBillNo());
        entity.setBillDate(dto.getBillDate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTaxRate(dto.getTaxRate());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setOrder(dto.getOrder());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setTotalSellPrice(dto.getTotalSellPrice());

        return entity;
    }

    @Override
    public List<BillDTO> entityListToDTOList(List<BillEntity> billEntities) {
        List<BillDTO> dtoList = new ArrayList<>();

        for(BillEntity billEntity: billEntities){
            dtoList.add(entityToDTO(billEntity));
        }

        return dtoList;
    }

    @Override
    public List<BillEntity> dtoListTOEntityList(List<BillDTO> billDTOS) {
        List<BillEntity> entityList = new ArrayList<>();

        for(BillDTO billDTO : billDTOS){
            entityList.add(dtoToEntity(billDTO));
        }

        return entityList;
    }

    @Override
    public BillEntity requestDTOToEntity(BillRequestDTO dto) {
        BillEntity entity = new BillEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setBillNo(dto.getBillNo());
        entity.setBillDate(dto.getBillDate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setTaxRate(dto.getTaxRate());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setOrder(dto.getOrder());
        entity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        entity.setTotalSellPrice(dto.getTotalSellPrice());

        return entity;
    }
}
