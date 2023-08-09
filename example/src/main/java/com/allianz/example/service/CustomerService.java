package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    PersonEntityRepository personEntityRepository;

    public CustomerEntity createCustomer(CustomerRequestDTO request) {
        CustomerEntity customerEntity = new CustomerEntity();

        PersonEntity personEntity = personEntityRepository.findById(request.getPerson().getId())
                .orElseThrow(() -> new EntityNotFoundException("Person not found with ID: " + request.getPerson().getId()));

        customerEntity.setPerson(personEntity);
        customerEntity.setIsCorporate(request.getIsCorporate());
        customerEntity.setCompanyName(request.getCompanyName());
        customerEntity.setTaxNumber(request.getTaxNumber());
        customerEntity.setTaxOffice(request.getTaxOffice());
        customerEntity.setOrderList(request.getOrderList());

        customerEntityRepository.save(customerEntity);

        return customerEntity;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerEntityRepository.findAll();
        return customerMapper.entityListToDTOList(customerEntities);
    }

    public CustomerDTO getByUUID(UUID uuid) {
        CustomerEntity customerEntity = customerEntityRepository.findByUuid(uuid);

        if (customerEntity != null) {
            return customerMapper.entityToDTO(customerEntity);
        } else {
            throw new EntityNotFoundException("Customer not found with UUID: " + uuid);
        }
    }

    public CustomerEntity updateCustomer(UUID uuid, CustomerRequestDTO request) {
        if (uuid != null) {
            CustomerEntity customerEntity = customerEntityRepository.findByUuid(uuid);

            customerEntity.setPerson(request.getPerson());
            customerEntity.setIsCorporate(request.getIsCorporate());
            customerEntity.setCompanyName(request.getCompanyName());
            customerEntity.setTaxNumber(request.getTaxNumber());
            customerEntity.setTaxOffice(request.getTaxOffice());
            customerEntity.setOrderList(request.getOrderList());

            return customerEntityRepository.save(customerEntity);
        } else {
            throw new EntityNotFoundException("Customer not found with UUID: " + uuid);
        }
    }

    public void deleteCustomer(UUID uuid) {
        customerEntityRepository.deleteByUuid(uuid);
    }
}

