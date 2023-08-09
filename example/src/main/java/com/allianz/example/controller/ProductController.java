package com.allianz.example.controller;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductRequestDTO request) {
        ProductEntity createdProduct = productService.createProduct(request);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/get/{uuid}")
    public ResponseEntity<ProductDTO> getProductByUUID(@PathVariable UUID uuid) {
        ProductDTO productDTO = productService.getByUUID(uuid);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable UUID uuid, @RequestBody ProductRequestDTO request) {
        ProductEntity updatedProduct = productService.updateProduct(uuid, request);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID uuid) {
        productService.deleteProduct(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
