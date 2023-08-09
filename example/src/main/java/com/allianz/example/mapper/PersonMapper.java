package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.dbutil.BaseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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

        return personDTO;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(dto.getId());
        personEntity.setTc(dto.getTc());
        personEntity.setName(dto.getName());
        personEntity.setBirthYear(dto.getBirthYear());
        personEntity.setSurname(dto.getSurname());
        personEntity.setCreationDate(dto.getCreationDate());
        personEntity.setUpdatedDate(dto.getUpdatedDate());

        return personEntity;
    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        List<PersonDTO> personDTOList = new ArrayList<>();

        for(PersonEntity personEntity : personEntities){
            personDTOList.add(entityToDTO(personEntity));
        }
        return personDTOList;
    }

    @Override
    public List<PersonEntity> dtoListTOEntityList(List<PersonDTO> personDTOS) {
        List<PersonEntity> personEntityList = new ArrayList<>();

        for(PersonDTO personDTO : personDTOS){
            personEntityList.add(dtoToEntity(personDTO));
        }
        return personEntityList;
    }

    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(dto.getId());
        personEntity.setName(dto.getName());
        personEntity.setTc(dto.getTc());
        personEntity.setCreationDate(dto.getCreationDate());
        personEntity.setUpdatedDate(dto.getUpdatedDate());
        personEntity.setSurname(dto.getSurname());

        return personEntity;
    }
}

