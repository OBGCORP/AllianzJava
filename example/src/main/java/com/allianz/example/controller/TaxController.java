package com.allianz.example.controller;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.service.TaxService;
import com.allianz.example.util.BaseController;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseMapper;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("taxes")
public class TaxController extends BaseController<TaxEntity, TaxDTO, TaxRequestDTO, TaxService> {

    @Autowired
    TaxService taxService;
    @Override
    protected TaxService getService() {
        return taxService;
    }

}
