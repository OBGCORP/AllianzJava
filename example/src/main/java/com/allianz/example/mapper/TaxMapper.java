package com.allianz.example.mapper;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxMapper implements IBaseMapper<TaxDTO, TaxEntity, TaxRequestDTO> {

    @Override
    public TaxDTO entityToDTO(TaxEntity entity) {
        TaxDTO dto = new TaxDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setRate(entity.getRate());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public TaxEntity dtoToEntity(TaxDTO dto) {
        TaxEntity entity = new TaxEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<TaxDTO> entityListToDTOList(List<TaxEntity> taxEntities) {
        List<TaxDTO> dtoList = new ArrayList<>();

        for(TaxEntity taxEntity : taxEntities){
            dtoList.add(entityToDTO((taxEntity)));
        }
        return dtoList;
    }

    @Override
    public List<TaxEntity> dtoListTOEntityList(List<TaxDTO> taxDTOS) {
        List<TaxEntity> entityList = new ArrayList<>();

        for(TaxDTO taxDTO : taxDTOS){
            entityList.add(dtoToEntity(taxDTO));
        }
        return entityList;
    }

    @Override
    public TaxEntity requestDTOToEntity(TaxRequestDTO dto) {
        TaxEntity entity = new TaxEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }
}
