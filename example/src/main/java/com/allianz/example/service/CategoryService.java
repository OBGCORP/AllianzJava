package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.CategoryDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryEntity createCategory(String name) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(name);
        return categoryEntityRepository.save(categoryEntity);
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryEntityRepository.findAll();
        return categoryMapper.entityListToDTOList(categoryEntities);
    }

    public CategoryDTO getByUUID(UUID uuid) {
        CategoryEntity categoryEntity = categoryEntityRepository.findByUuid(uuid);
        if (categoryEntity != null) {
            return categoryMapper.entityToDTO(categoryEntity);
        } else {
            throw new EntityNotFoundException("Category not found with UUID: " + uuid);
        }
    }

    public CategoryEntity updateCategory(UUID uuid, String name) {
        CategoryEntity categoryEntity = categoryEntityRepository.findByUuid(uuid);
        if (categoryEntity != null) {
            categoryEntity.setName(name);
            return categoryEntityRepository.save(categoryEntity);
        } else {
            throw new EntityNotFoundException("Category not found with UUID: " + uuid);
        }
    }

    public void deleteCategory(UUID uuid) {
        categoryEntityRepository.deleteByUuid(uuid);
    }
}
