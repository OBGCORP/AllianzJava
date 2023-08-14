package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;

import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillMapper implements BaseMapper<BillDTO, BillEntity, BillRequestDTO> {
    private final OrderMapper orderMapper;

    @Autowired
    public BillMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public BillDTO entityToDTO(BillEntity entity) {
        BillDTO billDTO = new BillDTO();
        billDTO.setBillDate(entity.getBillDate());
        billDTO.setBillNo(entity.getBillNo());
        billDTO.setId(entity.getId());
        billDTO.setTaxRate(entity.getTaxRate());
        billDTO.setTaxAmount(entity.getTaxAmount());
        billDTO.setUuid(entity.getUuid());
        billDTO.setCreationDate(entity.getCreationDate());
        billDTO.setUpdatedDate(entity.getUpdatedDate());
        billDTO.setTotalSellNetPrice(entity.getTotalSellNetPrice());
        billDTO.setTotalSellPrice(entity.getTotalSellPrice());
        billDTO.setOrder(orderMapper.entityToDTO(entity.getOrder()));

        return billDTO;


    }

    @Override
    public BillEntity dtoToEntity(BillDTO dto) {
        BillEntity entity = new BillEntity();
        entity.setBillDate(dto.getBillDate());
        entity.setBillNo(dto.getBillNo());
        entity.setId(dto.getId());
        entity.setTaxRate(dto.getTaxRate());
        entity.setTaxAmount(dto.getTaxAmount());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        return entity;
    }

    @Override
    public List<BillDTO> entityListToDTOList(List<BillEntity> billEntities) {
        List<BillDTO> billDTOList = new ArrayList<>();
        for (BillEntity billEntity : billEntities) {
            billDTOList.add(entityToDTO(billEntity));
        }
        return billDTOList;
    }


    @Override

    public List<BillEntity> dtoListTOEntityList(List<BillDTO> billDTOS) {
        List<BillEntity> billEntityList = new ArrayList<>();
        for (BillDTO billDTO : billDTOS) {
            billEntityList.add(dtoToEntity(billDTO));
        }
        return billEntityList;
    }

    @Override
    public BillEntity requestDTOToEntity(BillRequestDTO dto) {
        BillEntity billEntity = new BillEntity();
        billEntity.setBillNo(dto.getBillNo());
        billEntity.setTotalSellNetPrice(dto.getTotalSellPrice());
        billEntity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        billEntity.setId(dto.getId());
        billEntity.setCreationDate(dto.getCreationDate());
        billEntity.setUpdatedDate(dto.getUpdatedDate());
        billEntity.setUuid(dto.getUuid());
        return billEntity;
    }

    @Override
    public List<BillEntity> requestDTOListTOEntityList(List<BillRequestDTO> billRequestDTOS) {
        return null;
    }

    @Override
    public BillEntity requestDTOToExistEntity(BillRequestDTO dto, BillEntity entity) {
        return null;
    }
}
