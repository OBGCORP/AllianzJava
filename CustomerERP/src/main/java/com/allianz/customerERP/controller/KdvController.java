package com.allianz.customerERP.controller;

import com.allianz.customerERP.database.entity.KdvEntity;
import com.allianz.customerERP.model.KdvDTO;
import com.allianz.customerERP.service.KdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("kdv")
public class KdvController {
    @Autowired
    KdvService kdvService;

    @GetMapping
    public ResponseEntity<List<KdvEntity>> getAll() {
        return new ResponseEntity<>(kdvService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/type-contains-{type}")
    public ResponseEntity<List<KdvEntity>> getAllByTypeIContains(@PathVariable String type) {
        return new ResponseEntity<>(kdvService.getAllByTypeIContains(type), HttpStatus.OK);
    }

    @Modifying
    @Transactional
    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        return new ResponseEntity<>(kdvService.deleteKdv(uuid), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Boolean> createKdv(@RequestBody KdvDTO kdvDTO) {
        return new ResponseEntity<>(kdvService.createKdv(kdvDTO.getType(), kdvDTO.getPercent()), HttpStatus.CREATED);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<Boolean> updateKdv(@PathVariable UUID uuid, @RequestBody KdvDTO kdvDTO) {
        KdvEntity kdvEntity = new KdvEntity();
        kdvEntity.setPercent(kdvDTO.getPercent());
        kdvEntity.setType(kdvDTO.getType());
        return new ResponseEntity<>(kdvService.updateKdv(uuid, kdvEntity), HttpStatus.OK);
    }

}
