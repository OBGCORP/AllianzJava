package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper implements BaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {

    private final PersonMapper personMapper;
    private final OrderMapper orderMapper;

    @Autowired
    @Lazy
    public CustomerMapper(PersonMapper personMapper, OrderMapper orderMapper) {
        this.personMapper = personMapper;
        this.orderMapper = orderMapper;
    }


    @Override
    public CustomerDTO entityToDTO(CustomerEntity entity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(entity.getId());
        customerDTO.setCompanyName(entity.getCompanyName());
        customerDTO.setCreationDate(entity.getCreationDate());
        customerDTO.setUuid(entity.getUuid());
        customerDTO.setIsCorporate(entity.getIsCorporate());
        customerDTO.setUpdatedDate(entity.getUpdatedDate());
        customerDTO.setTaxNumber(entity.getTaxNumber());
        customerDTO.setTaxOffice(entity.getTaxOffice());
        customerDTO.setPerson(personMapper.entityToDTO(entity.getPerson()));
        customerDTO.setOrderList(orderMapper.entityListToDTOList(entity.getOrderList()));

        return customerDTO;
    }

    @Override
    public CustomerEntity requestDTOToExistEntity(CustomerRequestDTO dto, CustomerEntity entity) {
        return null;
    }

    @Override
    public CustomerEntity dtoToEntity(CustomerDTO dto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setUpdatedDate(dto.getUpdatedDate());
        customerEntity.setId(dto.getId());
        customerEntity.setCompanyName(dto.getCompanyName());
        customerEntity.setCreationDate(dto.getCreationDate());
        customerEntity.setUuid(dto.getUuid());
        customerEntity.setIsCorporate(dto.getIsCorporate());
        customerEntity.setTaxNumber(dto.getTaxNumber());
        customerEntity.setTaxOffice(dto.getTaxOffice());
        customerEntity.setPerson(personMapper.dtoToEntity(dto.getPerson()));
        customerEntity.setOrderList(orderMapper.dtoListTOEntityList(dto.getOrderList()));

        return customerEntity;
    }

    @Override
    public List<CustomerDTO> entityListToDTOList(List<CustomerEntity> customerEntities) {


        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (CustomerEntity customer : customerEntities) {
            customerDTOS.add(entityToDTO(customer));
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerEntity> dtoListTOEntityList(List<CustomerDTO> customerDTOS) {
        List<CustomerEntity> customerEntities = new ArrayList<>();
        for (CustomerDTO customerDTO : customerDTOS) {
            customerEntities.add(dtoToEntity(customerDTO));
        }
        return customerEntities;
    }

    @Override
    public CustomerEntity requestDTOToEntity(CustomerRequestDTO dto) {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(dto.getId());
        customer.setCompanyName(dto.getCompanyName());
        customer.setCreationDate(dto.getCreationDate());
        customer.setUuid(dto.getUuid());
        customer.setIsCorporate(dto.getIsCorporate());
        customer.setUpdatedDate(dto.getUpdatedDate());
        customer.setTaxNumber(dto.getTaxNumber());
        customer.setTaxOffice(dto.getTaxOffice());
        customer.setPerson(personMapper.requestDTOToEntity(dto.getPerson()));
        customer.setOrderList(orderMapper.requestDTOListTOEntityList(dto.getOrderList()));

        return customer;
    }

    @Override
    public List<CustomerEntity> requestDTOListTOEntityList(List<CustomerRequestDTO> customerRequestDTOS) {
        return null;
    }
}
