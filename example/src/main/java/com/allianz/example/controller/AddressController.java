package com.allianz.example.controller;

import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressRequestDTO request) {
        AddressDTO createdAddress = addressService.save(request);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<AddressDTO> addresses = addressService.getAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<AddressDTO> getAddressByUUID(@PathVariable UUID uuid) {
        AddressDTO address = addressService.getByUUID(uuid);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
