package com.allianz.example.controller;

import com.allianz.example.database.entity.SellerEntity;

import com.allianz.example.model.SellerDTO;

import com.allianz.example.model.requestDTO.SellerRequestDTO;

import com.allianz.example.service.SellerService;

import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;

public class SellerController extends BaseController<SellerEntity, SellerDTO, SellerRequestDTO, SellerService> {

    @Autowired
    SellerService sellerService;
    @Override
    protected SellerService getService() {
        return sellerService;
    }
}
