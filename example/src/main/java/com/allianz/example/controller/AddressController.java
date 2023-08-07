package com.allianz.example.controller;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("adress-by-uuid/{uuid}")
    public ResponseEntity<AddressDTO> getAddressByUUID(@PathVariable UUID uuid){
        AddressDTO address = addressService.getDTOByUuid(uuid);

        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @DeleteMapping("delete-by-uuid/{uuid}")
    public ResponseEntity<Boolean> deleteAddress(@PathVariable UUID uuid){
        boolean isDeleted = addressService.deleteEntityByUuid(uuid);

        if(isDeleted){
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }

}
