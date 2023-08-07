package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.dbutil.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper implements IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {


    @Override
    public PersonDTO entityToDTO(PersonEntity entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setTc(entity.getTc());
        personDTO.setName(entity.getName());
        personDTO.setSurname(entity.getSurname());
        personDTO.setId(entity.getId());
        personDTO.setUuid(entity.getUuid());
        personDTO.setBirthYear(entity.getBirthYear());
        personDTO.setCreationDate(entity.getCreationDate());
        personDTO.setUpdatedDate(entity.getUpdatedDate());

        return null;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setUuid(dto.getUuid());
        personEntity.setCreationDate(dto.getCreationDate());
        personEntity.setUpdatedDate(dto.getUpdatedDate());
        personEntity.setId(dto.getId());
        personEntity.setName(dto.getName());
        personEntity.setSurname(dto.getSurname());
        personEntity.setTc(dto.getTc());
        personEntity.setBirthYear(dto.getBirthYear());

        return personEntity;
    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (PersonEntity p : personEntities) {
            personDTOList.add(entityToDTO(p));
        }
        return personDTOList;
    }

    @Override
    public List<PersonEntity> dtoListTOEntityList(List<PersonDTO> personDTOS) {
        List<PersonEntity> personEntityList = new ArrayList<>();
        for (PersonDTO p : personDTOS) {
            personEntityList.add(dtoToEntity(p));
        }
        return personEntityList;
    }

    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity personEntity1 = new PersonEntity();
        personEntity1.setUuid(dto.getUuid());
        personEntity1.setCreationDate(dto.getCreationDate());
        personEntity1.setUpdatedDate(dto.getUpdatedDate());
        personEntity1.setId(dto.getId());
        personEntity1.setName(dto.getName());
        personEntity1.setSurname(dto.getSurname());
        personEntity1.setTc(dto.getTc());
        personEntity1.setBirthYear(dto.getBirthYear());

        return personEntity1;
    }
}
