package com.allianz.example.service;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    TaxEntityRepository taxEntityRepository;

    public ProductEntity createProduct(ProductRequestDTO request) {
        ProductEntity productEntity = new ProductEntity();
        if (request.getTax() != null) {
            TaxEntity taxEntity = taxEntityRepository.findById(request.getTax().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + request.getTax().getId()));
            productEntity.setTax(taxEntity);
        }

        productEntity.setBuyPrice(request.getBuyPrice());
        productEntity.setCode(request.getCode());
        productEntity.setName(request.getName());
        productEntity.setQuantity(request.getQuantity());
        productEntity.setBuyPrice(request.getBuyPrice());
        productEntity.setColor(request.getColor());
        productEntity.setCategoryList(request.getCategory());
        productEntity.setSellPrice(request.getSellPrice());

        productEntityRepository.save(productEntity);

        return productEntity;
    }

    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = productEntityRepository.findAll();
        return productMapper.entityListToDTOList(productEntities);
    }

    public ProductDTO getByUUID(UUID uuid) {
        ProductEntity productEntity = productEntityRepository.findByUuid(uuid);

        if (productEntity != null) {
            return productMapper.entityToDTO(productEntity);
        } else {
            throw new EntityNotFoundException("Product not found with UUID: " + uuid);
        }
    }

    public ProductEntity updateProduct(UUID uuid, ProductRequestDTO request) {
        if (uuid != null) {
            ProductEntity productEntity = productEntityRepository.findByUuid(uuid);

            productEntity.setBuyPrice(request.getBuyPrice());
            productEntity.setCode(request.getCode());
            productEntity.setName(request.getName());
            productEntity.setQuantity(request.getQuantity());
            productEntity.setBuyPrice(request.getBuyPrice());
            productEntity.setColor(request.getColor());
            productEntity.setCategoryList(request.getCategory());
            productEntity.setSellPrice(request.getSellPrice());
            productEntity.setTax(request.getTax());

            return productEntityRepository.save(productEntity);
        } else {
            throw new EntityNotFoundException("Product not found with UUID: " + uuid);
        }
    }

    public void deleteProduct(UUID uuid) {
        productEntityRepository.deleteByUuid(uuid);
    }
}
