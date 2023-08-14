package com.allianz.example.mapper;


import com.allianz.example.database.entity.TaxEntity;

import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;

import com.allianz.example.util.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TaxMapper implements BaseMapper<TaxDTO, TaxEntity, TaxRequestDTO> {
    @Override
    public TaxDTO entityToDTO(TaxEntity entity) {

        TaxDTO taxDTO = new TaxDTO();
        taxDTO.setUuid(entity.getUuid());
        taxDTO.setCreationDate(entity.getCreationDate());
        taxDTO.setId(entity.getId());
        taxDTO.setUpdatedDate(entity.getUpdatedDate());
        taxDTO.setCode(entity.getCode());
        taxDTO.setName(entity.getName());
        taxDTO.setRate(entity.getRate());


        return taxDTO;
    }

    @Override
    public TaxEntity dtoToEntity(TaxDTO dto) {
        TaxEntity entity = new TaxEntity();
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setId(dto.getId());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());

        return entity;
    }

    @Override
    public List<TaxDTO> entityListToDTOList(List<TaxEntity> taxEntities) {
        List<TaxDTO> dtos = new ArrayList<>();
        for (TaxEntity entity: taxEntities) {
            dtos.add(entityToDTO(entity));
        }
        return dtos;
    }

    @Override
    public List<TaxEntity> dtoListTOEntityList(List<TaxDTO> taxDTOS) {
        List<TaxEntity> entities = new ArrayList<>();
        for (TaxDTO dto: taxDTOS) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    @Override
    public TaxEntity requestDTOToEntity(TaxRequestDTO dto) {
        TaxEntity entity = new TaxEntity();
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        entity.setCode(dto.getCode());


        return entity;
    }

    @Override
    public TaxEntity requestDTOToExistEntity(TaxRequestDTO dto, TaxEntity entity) {
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setRate(dto.getRate());
        return entity;
    }

    @Override
    public List<TaxEntity> requestDTOListTOEntityList(List<TaxRequestDTO> taxRequestDTOS) {
        return null;
    }
}
