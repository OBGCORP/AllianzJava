package com.allianz.example.mapper;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SettingsMapper implements IBaseMapper<SettingsDTO, SettingsEntity, SettingRequestDTO> {

    @Override
    public SettingsDTO entityToDTO(SettingsEntity entity) {
        SettingsDTO dto = new SettingsDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setKey(entity.getKey());
        dto.setValue(entity.getValue());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());

        return dto;
    }

    @Override
    public SettingsEntity dtoToEntity(SettingsDTO dto) {
        SettingsEntity entity = new SettingsEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCreationDate(dto.getCreationDate());

        return entity;
    }

    @Override
    public List<SettingsDTO> entityListToDTOList(List<SettingsEntity> settings) {
        List<SettingsDTO> dtoList = new ArrayList<>();

        for(SettingsEntity entity : settings){
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<SettingsEntity> dtoListTOEntityList(List<SettingsDTO> settingsDTOS) {
        List<SettingsEntity> entityList = new ArrayList<>();

        for(SettingsDTO dto : settingsDTOS){
            entityList.add(dtoToEntity(dto));
        }

        return entityList;
    }

    @Override
    public SettingsEntity requestDTOToEntity(SettingRequestDTO dto) {
        SettingsEntity entity = new SettingsEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setKey(dto.getKey());
        entity.setValue(dto.getValue());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setCreationDate(dto.getCreationDate());

        return entity;
    }
}
