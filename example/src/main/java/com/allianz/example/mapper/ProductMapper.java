package com.allianz.example.mapper;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper implements IBaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {

    @Override
    public ProductDTO entityToDTO(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setBuyPrice(entity.getBuyPrice());
        dto.setColor(entity.getColor());
        dto.setQuantity(entity.getQuantity());
        dto.setSellPrice(entity.getSellPrice());
        dto.setTax(entity.getTax());

        return dto;
    }

    @Override
    public ProductEntity dtoToEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setBuyPrice(dto.getBuyPrice());
        entity.setColor(dto.getColor());
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());
        entity.setTax(dto.getTax());

        return entity;
    }

    @Override
    public List<ProductDTO> entityListToDTOList(List<ProductEntity> productEntities) {
        List<ProductDTO> dtoList = new ArrayList<>();

        for(ProductEntity entity: productEntities){
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public List<ProductEntity> dtoListTOEntityList(List<ProductDTO> productDTOS) {
        List<ProductEntity> entityList = new ArrayList<>();

        for(ProductDTO productDTO: productDTOS){
            entityList.add(dtoToEntity(productDTO));
        }
        return entityList;
    }

    @Override
    public ProductEntity requestDTOToEntity(ProductRequestDTO dto) {
        ProductEntity entity = new ProductEntity();

        entity.setId(dto.getId());
        entity.setUuid(dto.getUuid());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());
        entity.setBuyPrice(dto.getBuyPrice());
        entity.setColor(dto.getColor());
        entity.setQuantity(dto.getQuantity());
        entity.setSellPrice(dto.getSellPrice());
        entity.setTax(dto.getTax());

        return entity;
    }
}
