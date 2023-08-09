package com.allianz.example.controller;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerRequestDTO request) {
        CustomerEntity createdCustomer = customerService.createCustomer(request);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/get/{uuid}")
    public ResponseEntity<CustomerDTO> getCustomerByUUID(@PathVariable UUID uuid) {
        CustomerDTO customer = customerService.getByUUID(uuid);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable UUID uuid, @RequestBody CustomerRequestDTO request) {
        CustomerEntity updatedCustomer = customerService.updateCustomer(uuid, request);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID uuid) {
        customerService.deleteCustomer(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

