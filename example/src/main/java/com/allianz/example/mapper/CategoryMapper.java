package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper implements IBaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO> {
    @Override
    public CategoryDTO entityToDTO(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();

        dto.setId(entity.getId());
        dto.setUuid(entity.getUuid());
        dto.setName(entity.getName());
        dto.setCreationDate(entity.getCreationDate());
        dto.setUpdatedDate(entity.getUpdatedDate());
        dto.setProductList(entity.getProductList());

        return dto;
    }

    @Override
    public CategoryEntity dtoToEntity(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setProductList(dto.getProductList());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<CategoryDTO> entityListToDTOList(List<CategoryEntity> categoryEntities) {

        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            categoryDTOList.add(entityToDTO(categoryEntity));
        }
        return categoryDTOList;
    }

    @Override
    public List<CategoryEntity> dtoListTOEntityList(List<CategoryDTO> categoryDTOS) {

        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        for (CategoryDTO categoryDTO : categoryDTOS) {
            categoryEntityList.add(dtoToEntity(categoryDTO));
        }
        return categoryEntityList;
    }

    @Override
    public CategoryEntity requestDTOToEntity(CategoryRequestDTO dto) {

        CategoryEntity entity = new CategoryEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setUuid(dto.getUuid());
        entity.setCreationDate(dto.getCreationDate());
        entity.setProductList(dto.getProductList());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }
}
