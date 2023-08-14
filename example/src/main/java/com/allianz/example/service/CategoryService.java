package com.allianz.example.service;


import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.mapper.CategoryMapper;

import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class CategoryService extends BaseService<CategoryEntity, CategoryDTO,
        CategoryRequestDTO, CategoryMapper, CategoryEntityRepository> {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryEntityRepository categoryEntityRepository;


    @Override
    public CategoryMapper getMapper() {
        return categoryMapper;
    }

    @Override
    public CategoryEntityRepository getRepository() {
        return categoryEntityRepository;
    }
}
