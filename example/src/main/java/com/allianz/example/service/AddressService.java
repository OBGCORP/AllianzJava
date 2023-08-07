package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService extends BaseService<AddressEntity, AddressDTO, AddressRequestDTO> {

    @Autowired
    AddressEntityRepository addressEntityRepository;

    @Autowired
    AddressMapper addressMapper;

    public AddressDTO save(AddressRequestDTO dto) {

        AddressEntity addressEntity = addressMapper.requestDTOToEntity(dto);

        addressEntityRepository.save(addressEntity);

        return addressMapper.entityToDTO(addressEntity);
    }


    public List<AddressDTO> getAll() {
        List<AddressEntity> addressEntityList = addressEntityRepository.findAll();
        return addressMapper.entityListToDTOList(addressEntityList);
    }

    public AddressDTO getByUUID(UUID uuid) {

        Optional<AddressEntity> address = addressEntityRepository.findByUuid(uuid);

        return address.map(addressEntity -> addressMapper.entityToDTO(addressEntity)).orElse(null);
    }


}
