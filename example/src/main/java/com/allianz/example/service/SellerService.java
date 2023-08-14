package com.allianz.example.service;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class SellerService extends BaseService<SellerEntity,SellerDTO,
        SellerRequestDTO, SellerMapper, SellerEntityRepository> {

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private SellerEntityRepository sellerEntityRepository;


    @Override
    public SellerMapper getMapper() {
        return sellerMapper;
    }

    @Override
    public SellerEntityRepository getRepository() {
        return sellerEntityRepository;
    }
}
