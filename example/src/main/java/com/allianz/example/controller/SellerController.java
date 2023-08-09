package com.allianz.example.controller;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/create")
    public ResponseEntity<SellerEntity> createSeller(@RequestBody SellerRequestDTO request) {
        SellerEntity createdSeller = sellerService.createSeller(request);
        return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SellerDTO>> getAllSellers() {
        List<SellerDTO> sellers = sellerService.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @GetMapping("/get/{uuid}")
    public ResponseEntity<SellerDTO> getSellerByUUID(@PathVariable UUID uuid) {
        SellerDTO sellerDTO = sellerService.getByUUID(uuid);
        return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<SellerEntity> updateSeller(@PathVariable UUID uuid, @RequestBody SellerRequestDTO request) {
        SellerEntity updatedSeller = sellerService.updateSeller(uuid, request);
        return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteSeller(@PathVariable UUID uuid) {
        sellerService.deleteSeller(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
