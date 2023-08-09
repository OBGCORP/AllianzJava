package com.allianz.example.controller;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryEntity> createCategory(@RequestParam String name) {
        CategoryEntity createdCategory = categoryService.createCategory(name);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/get/{uuid}")
    public ResponseEntity<CategoryDTO> getCategoryByUUID(@PathVariable UUID uuid) {
        CategoryDTO category = categoryService.getByUUID(uuid);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable UUID uuid, @RequestParam String name) {
        CategoryEntity updatedCategory = categoryService.updateCategory(uuid, name);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID uuid) {
        categoryService.deleteCategory(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

