package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements IBaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    @Override
    public CustomerDTO entityToDTO(CustomerEntity entity) {

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(entity.getId());
        customerDTO.setPerson(entity.getPerson());
        customerDTO.setUuid(entity.getUuid());
        customerDTO.setOrderList(entity.getOrderList());
        customerDTO.setCompanyName(entity.getCompanyName());
        customerDTO.setIsCorporate(entity.getIsCorporate());
        customerDTO.setTaxNumber(entity.getTaxNumber());
        customerDTO.setCreationDate(entity.getCreationDate());
        customerDTO.setUpdatedDate(entity.getUpdatedDate());
        customerDTO.setTaxOffice(entity.getTaxOffice());

        return customerDTO;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(dto.getId());
        customerEntity.setPerson(dto.getPerson());
        customerEntity.setUuid(dto.getUuid());
        customerEntity.setOrderList(dto.getOrderList());
        customerEntity.setCompanyName(dto.getCompanyName());
        customerEntity.setIsCorporate(dto.getIsCorporate());
        customerEntity.setTaxNumber(dto.getTaxNumber());
        customerEntity.setCreationDate(dto.getCreationDate());
        customerEntity.setUpdatedDate(dto.getUpdatedDate());
        customerEntity.setTaxOffice(dto.getTaxOffice());

        return customerEntity;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<CustomerEntity> customerEntities) {

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (CustomerEntity entity: customerEntities) {
            customerDTOList.add(entityToDTO(entity));
        }

        return customerDTOList;
    }

    @Override
    public List<CustomerEntity> dtoListTOEntityList(List<CustomerDTO> customerDTOS) {
        List<CustomerEntity> customerEntityList = new ArrayList<>();

        for (CustomerDTO dto: customerDTOS) {
            customerEntityList.add(dtoToEntity(dto));
        }

        return customerEntityList;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(dto.getId());
        customerEntity.setPerson(dto.getPerson());
        customerEntity.setUuid(dto.getUuid());
        customerEntity.setOrderList(dto.getOrderList());
        customerEntity.setCompanyName(dto.getCompanyName());
        customerEntity.setIsCorporate(dto.getIsCorporate());
        customerEntity.setTaxNumber(dto.getTaxNumber());
        customerEntity.setCreationDate(dto.getCreationDate());
        customerEntity.setUpdatedDate(dto.getUpdatedDate());
        customerEntity.setTaxOffice(dto.getTaxOffice());

        return customerEntity;
    }
}
