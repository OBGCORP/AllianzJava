package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper implements BaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
    private final PersonMapper personMapper;

    @Autowired
    public AddressMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    @Override
    public AddressDTO entityToDTO(AddressEntity entity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCreationDate(entity.getCreationDate());
        addressDTO.setUuid(entity.getUuid());
        addressDTO.setId(entity.getId());
        addressDTO.setAddress(entity.getAddress());
        addressDTO.setTitle(entity.getTitle());
        addressDTO.setUpdatedDate(entity.getUpdatedDate());
        addressDTO.setPerson(personMapper.entityToDTO(entity.getPerson()));

        return addressDTO;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDTO dto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCreationDate(dto.getCreationDate());
        addressEntity.setUuid(dto.getUuid());
        addressEntity.setId(dto.getId());
        addressEntity.setAddress(dto.getAddress());
        addressEntity.setTitle(dto.getTitle());
        addressEntity.setUpdatedDate(dto.getUpdatedDate());
        addressEntity.setPerson(personMapper.dtoToEntity(dto.getPerson()));

        return addressEntity;

    }

    @Override
    public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
        List<AddressDTO> addressDTOList = new ArrayList<>();

        for (AddressEntity addressEntity:addressEntities) {
            addressDTOList.add(entityToDTO(addressEntity));
        }
        
        return addressDTOList;
    }

    @Override
    public List<AddressEntity> dtoListTOEntityList(List<AddressDTO> addressDTOS) {
        List<AddressEntity> addressList = new ArrayList<>();

        for (AddressDTO addressDTO:addressDTOS) {
            addressList.add(dtoToEntity(addressDTO));
        }

        return addressList;


    }

    @Override
    public AddressEntity requestDTOToEntity(AddressRequestDTO dto) {
        AddressEntity entity = new AddressEntity();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<AddressEntity> requestDTOListTOEntityList(List<AddressRequestDTO> addressRequestDTOS) {
        return null;
    }

    @Override
    public AddressEntity requestDTOToExistEntity(AddressRequestDTO dto, AddressEntity entity) {
        return null;
    }
}
