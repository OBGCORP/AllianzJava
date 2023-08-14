package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonMapper implements BaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {
    @Autowired
    @Lazy
    AddressMapper addressMapper;

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
        personDTO.setAddressList(addressMapper.entityListToDTOList(entity.getAddressList()));

        return personDTO;
    }



    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity person = new PersonEntity();
        person.setTc(dto.getTc());
        person.setName(dto.getName());
        person.setSurname(dto.getSurname());
        person.setId(dto.getId());
        person.setUuid(dto.getUuid());
        person.setBirthYear(dto.getBirthYear());
        person.setCreationDate(dto.getCreationDate());
        person.setUpdatedDate(dto.getUpdatedDate());
        person.setAddressList(addressMapper.dtoListTOEntityList(dto.getAddressList()));


        return person;
    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        List<PersonDTO> PersonDTOS = new ArrayList<>();
        for (PersonEntity person: personEntities) {
            PersonDTOS.add(entityToDTO(person));
        }
        return PersonDTOS;
    }

    @Override
    public List<PersonEntity> dtoListTOEntityList(List<PersonDTO> personDTOS) {
        List<PersonEntity> orderEntities = new ArrayList<>();
        for (PersonDTO personDTO: personDTOS) {
            orderEntities.add(dtoToEntity(personDTO));
        }
        return orderEntities;

    }


    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity person = new PersonEntity();
        person.setId(dto.getId());
        person.setUuid(dto.getUuid());
        person.setCreationDate(dto.getCreationDate());
        person.setUpdatedDate(dto.getUpdatedDate());
        person.setName(dto.getName());
        person.setSurname(dto.getSurname());
        person.setTc(dto.getTc());
        person.setBirthYear(dto.getBirthYear());
        person.setAddressList(addressMapper.requestDTOListTOEntityList(dto.getAddressList()));

        return person;
    }

    @Override
    public PersonEntity requestDTOToExistEntity(PersonRequestDTO dto, PersonEntity entity) {
        return null;
    }

    @Override
    public List<PersonEntity> requestDTOListTOEntityList(List<PersonRequestDTO> personRequestDTOS) {
        return null;
    }
}
