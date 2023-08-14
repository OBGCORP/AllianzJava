package com.allianz.example.mapper;


import com.allianz.example.database.entity.SellerEntity;

import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;

import com.allianz.example.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SellerMapper implements BaseMapper<SellerDTO, SellerEntity, SellerRequestDTO> {
    @Override
    public SellerDTO entityToDTO(SellerEntity entity) {
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setUuid(entity.getUuid());
        sellerDTO.setCreationDate(entity.getCreationDate());
        sellerDTO.setId(entity.getId());
        sellerDTO.setUpdatedDate(entity.getUpdatedDate());
        sellerDTO.setEmail(entity.getEmail());
        sellerDTO.setTc(entity.getTc());
        sellerDTO.setName(entity.getName());
        sellerDTO.setShopName(entity.getShopName());
        sellerDTO.setTaxNumber(entity.getTaxNumber());
        sellerDTO.setTaxOffice(entity.getTaxOffice());

    return sellerDTO;
    }

    @Override
    public SellerEntity dtoToEntity(SellerDTO dto) {
        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setUuid(dto.getUuid());
        sellerEntity.setCreationDate(dto.getCreationDate());
        sellerEntity.setId(dto.getId());
        sellerEntity.setUpdatedDate(dto.getUpdatedDate());
        sellerEntity.setEmail(dto.getEmail());
        sellerEntity.setTc(dto.getTc());
        sellerEntity.setName(dto.getName());
        sellerEntity.setShopName(dto.getShopName());
        sellerEntity.setTaxNumber(dto.getTaxNumber());
        sellerEntity.setTaxOffice(dto.getTaxOffice());

        return sellerEntity;
    }

    @Override
    public List<SellerDTO> entityListToDTOList(List<SellerEntity> sellerEntities) {

        List<SellerDTO> dtos = new ArrayList<>();
        for (SellerEntity sellerEntity: sellerEntities) {
            dtos.add(entityToDTO(sellerEntity));
        }
        return dtos;
    }

    @Override
    public List<SellerEntity> dtoListTOEntityList(List<SellerDTO> sellerDTOS) {
        List<SellerEntity> entities = new ArrayList<>();
        for (SellerDTO dto: sellerDTOS) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    @Override
    public SellerEntity requestDTOToEntity(SellerRequestDTO dto) {

        SellerEntity entity = new SellerEntity();
        entity.setSurname(dto.getSurname());
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        return entity;
    }

    @Override
    public SellerEntity requestDTOToExistEntity(SellerRequestDTO dto, SellerEntity entity) {

        return null;
    }

    @Override
    public List<SellerEntity> requestDTOListTOEntityList(List<SellerRequestDTO> sellerRequestDTOS) {
        return null;
    }
}
