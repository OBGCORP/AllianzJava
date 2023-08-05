package com.allianz.customerERP.service;

import com.allianz.customerERP.database.entity.CustomerEntity;
import com.allianz.customerERP.database.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public boolean createCustomer(String name, String email) {
        if (name == null || email == null) return false;
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setEmail(email);
        customerRepository.save(customer);
        return true;
    }

    public List<CustomerEntity> getAll() {
        return customerRepository.findAll();
    }

    public List<CustomerEntity> getAllByNameIContains(String name) {
        return customerRepository.findAllByNameContainsIgnoreCase(name);
    }

    public boolean updateCustomer(UUID uuid, CustomerEntity customerEntity) {
        if (uuid == null || customerEntity == null) return false;
        CustomerEntity existingCustomer = customerRepository.findByUuid(uuid);
        if (existingCustomer == null) return false;
        existingCustomer.setName(customerEntity.getName());
        existingCustomer.setEmail(customerEntity.getEmail());
        customerRepository.save(existingCustomer);
        return true;
    }
    public boolean deleteCustomer(UUID uuid) {
        if (uuid == null) return false;
        customerRepository.deleteByUuid(uuid);
        return true;
    }

}
