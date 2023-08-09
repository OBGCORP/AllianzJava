package com.allianz.example.mapper;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerMapper implements IBaseMapper<SellerDTO, SellerEntity, SellerRequestDTO> {
    @Override
    public SellerDTO entityToDTO(SellerEntity entity) {
        SellerDTO dto = new SellerDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setTc(entity.getTc());
        dto.setShopName(entity.getShopName());
        dto.setTaxNumber(entity.getTaxNumber());
        dto.setTaxOffice(entity.getTaxOffice());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public SellerEntity dtoToEntity(SellerDTO dto) {
        SellerEntity entity = new SellerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setEmail(dto.getEmail());
        entity.setShopName(dto.getShopName());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setTc(dto.getTc());

        return entity;
    }

    @Override
    public List<SellerDTO> entityListToDTOList(List<SellerEntity> sellerEntities) {
        List<SellerDTO> dtoList = new ArrayList<>();

        for(SellerEntity sellerEntity: sellerEntities){
            dtoList.add(entityToDTO(sellerEntity));
        }
        return dtoList;
    }

    @Override
    public List<SellerEntity> dtoListTOEntityList(List<SellerDTO> sellerDTOS) {
        List<SellerEntity> entityList = new ArrayList<>();

        for(SellerDTO dto : sellerDTOS){
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public SellerEntity requestDTOToEntity(SellerRequestDTO dto) {
        SellerEntity entity = new SellerEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setEmail(dto.getEmail());
        entity.setShopName(dto.getShopName());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setTaxNumber(dto.getTaxNumber());
        entity.setTaxOffice(dto.getTaxOffice());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setTc(dto.getTc());

        return entity;
    }
}
