package com.allianz.example.controller;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    BillService billService;

    @PostMapping("/create")
    public ResponseEntity<BillEntity> createBill(@RequestBody BillRequestDTO request) {
        BillEntity createdBill = billService.createBill(request);
        return new ResponseEntity<>(createdBill, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BillDTO>> getAllBills() {
        List<BillDTO> bills = billService.getAllBills();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<BillDTO> getBillByUUID(@PathVariable UUID uuid) {
        BillDTO bill = billService.getByUUID(uuid);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<BillEntity> updateBill(@PathVariable UUID uuid, @RequestBody BillRequestDTO request) {
        BillEntity updatedBill = billService.updateBill(uuid, request);
        return new ResponseEntity<>(updatedBill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteBill(@PathVariable UUID uuid) {
        billService.deleteBill(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

