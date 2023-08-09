package com.allianz.example.controller;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/taxes")
public class TaxController {

    @Autowired
    TaxService taxService;

    @PostMapping("/create")
    public ResponseEntity<TaxEntity> createTax(@RequestBody TaxRequestDTO request) {
        TaxEntity createdTax = taxService.createTax(request.getName(), request.getCode(), request.getRate());
        return new ResponseEntity<>(createdTax, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaxDTO>> getAllTaxes() {
        List<TaxDTO> taxes = taxService.getAllTaxes();
        return new ResponseEntity<>(taxes, HttpStatus.OK);
    }

    @GetMapping("/get/{uuid}")
    public ResponseEntity<TaxDTO> getTaxByUUID(@PathVariable UUID uuid) {
        TaxDTO taxDTO = taxService.getByUUID(uuid);
        return new ResponseEntity<>(taxDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<TaxEntity> updateTax(@PathVariable UUID uuid, @RequestBody TaxRequestDTO request) {
        TaxEntity updatedTax = taxService.updateTax(uuid, request.getName(), request.getCode(), request.getRate());
        return new ResponseEntity<>(updatedTax, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteTax(@PathVariable UUID uuid) {
        taxService.deleteTax(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

