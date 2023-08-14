package com.allianz.example.service;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class ProductService extends BaseService<ProductEntity, ProductDTO,
        ProductRequestDTO, ProductMapper, ProductEntityRepository> {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductEntityRepository productEntityRepository;


    @Override
    public ProductMapper getMapper() {
        return productMapper;
    }

    @Override
    public ProductEntityRepository getRepository() {
        return productEntityRepository;
    }
}
