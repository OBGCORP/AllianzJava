package com.allianz.example.mapper;


import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.entity.ProductEntity;

import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapper implements BaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {

    private final TaxMapper taxMapper;
    private final CategoryMapper categoryMapper;
    @Autowired
    @Lazy
    public ProductMapper(TaxMapper taxMapper, CategoryMapper categoryMapper) {
        this.taxMapper = taxMapper;
        this.categoryMapper = categoryMapper;
    }



    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setUuid(entity.getUuid());
        productDTO.setCreationDate(entity.getCreationDate());
        productDTO.setId(entity.getId());
        productDTO.setUpdatedDate(entity.getUpdatedDate());
        productDTO.setName(entity.getName());
        productDTO.setQuantity(entity.getQuantity());
        productDTO.setCode(entity.getCode());
        productDTO.setColor(entity.getColor());
        productDTO.setTax(taxMapper.entityToDTO(entity.getTax()));
        productDTO.setBuyPrice(entity.getBuyPrice());
        productDTO.setSellPrice(entity.getSellPrice());
        Set<CategoryDTO> categoryDTOS = new HashSet<>(categoryMapper.entityListToDTOList(new ArrayList<>(entity.getCategoryList())));
        productDTO.setCategoryList(categoryDTOS);


        return productDTO;


    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity product = new ProductEntity();
        product.setUuid(dto.getUuid());
        product.setCreationDate(dto.getCreationDate());
        product.setId(dto.getId());
        product.setUpdatedDate(dto.getUpdatedDate());
        product.setName(dto.getName());
        product.setQuantity(dto.getQuantity());
        product.setCode(dto.getCode());
        product.setColor(dto.getColor());
        product.setTax(taxMapper.dtoToEntity(dto.getTax()));
        product.setBuyPrice(dto.getBuyPrice());
        product.setSellPrice(dto.getSellPrice());
        Set<CategoryEntity> categoryDTOS = new HashSet<>(categoryMapper.dtoListTOEntityList(new ArrayList<>(dto.getCategoryList())));
        product.setCategoryList(categoryDTOS);

        return product;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {
        List<ProductDTO> dtos = new ArrayList<>();
        for (ProductEntity entity: productEntities) {
            dtos.add(entityToDTO(entity));
        }
        return dtos;
    }

    @Override
    public List<ProductEntity> dtoListTOEntityList(List<ProductDTO> productDTOS) {
        List<ProductEntity> entities = new ArrayList<>();
        for (ProductDTO dto: productDTOS) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {

        ProductEntity entity = new ProductEntity();
        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setId(dto.getId());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setCode(dto.getCode());
        entity.setColor(dto.getColor());
        entity.setTax(taxMapper.requestDTOToEntity(dto.getTax()));
        entity.setBuyPrice(dto.getBuyPrice());
        entity.setSellPrice(dto.getSellPrice());
        Set<CategoryEntity> categoryDTOS = new HashSet<>(categoryMapper.requestDTOListTOEntityList(new ArrayList<>(dto.getCategoryList())));
        entity.setCategoryList(categoryDTOS);

        return entity;
    }

    @Override
    public ProductEntity requestDTOToExistEntity(ProductRequestDTO dto, ProductEntity entity) {
        return null;
    }

    @Override
    public List<ProductEntity> requestDTOListTOEntityList(List<ProductRequestDTO> productRequestDTOS) {
        return null;
    }
}
