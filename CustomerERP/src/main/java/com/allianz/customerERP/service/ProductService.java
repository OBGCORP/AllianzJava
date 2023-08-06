package com.allianz.customerERP.service;

import com.allianz.customerERP.database.entity.KdvEntity;
import com.allianz.customerERP.database.entity.ProductEntity;
import com.allianz.customerERP.database.repository.KdvRepository;
import com.allianz.customerERP.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    KdvRepository kdvRepository;

    // Method to create a new product with the provided information
    public boolean createProduct(String name, Boolean isKdvApplied, BigDecimal price,
                                 Integer stock, KdvEntity kdv) {
        if (name == null || isKdvApplied == null || price == null || stock == null ||
                kdv == null) return false;
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(name);
        productEntity.setIsKdvApplied(isKdvApplied);
        productEntity.setPrice(price);
        productEntity.setStock(stock);
        productEntity.setKdv(kdvRepository.findByUuid(kdv.getUuid()));
        productEntity.setOrderCount(1);
        kdvTruePrice(productEntity);
        productRepository.save(productEntity);
        return true;
    }

    // Method to get all products from the database
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    // Method to delete a product with the specified UUID
    public boolean deleteProduct(UUID uuid) {
        if (uuid == null) return false;
        productRepository.deleteByUuid(uuid);
        return true;
    }

    // Method to get a product by its UUID
    public ProductEntity getByUuid(UUID uuid) {
        return productRepository.findByUuid(uuid);
    }

    // Method to get products whose name contains the specified search string (case-insensitive)
    public List<ProductEntity> getAllByNameIContains(String name) {
        return productRepository.findAllByNameContainsIgnoreCase(name);
    }

    // Method to update an existing product with the provided information using the provided UUID
    public boolean updateProduct(UUID uuid, ProductEntity productEntity) {
        if (uuid == null || productEntity == null) return false;
        ProductEntity product = productRepository.findByUuid(uuid);
        if (product == null) return false;
        product.setName(productEntity.getName());
        product.setKdv(productEntity.getKdv());
        product.setPrice(productEntity.getPrice());
        product.setIsKdvApplied(productEntity.getIsKdvApplied());
        product.setNonKdvAppliedPrice(productEntity.getNonKdvAppliedPrice());
        product.setStock(productEntity.getStock());
        productRepository.save(product);
        return true;
    }

    // Method to calculate the true price of a product after applying or removing KDV
    public void kdvTruePrice(ProductEntity product) {
        BigDecimal kdv = product.getKdv().getPercent();
        BigDecimal price = product.getPrice();
        BigDecimal totalPrice;
        BigDecimal kdvPrice;
        if (!product.getIsKdvApplied()) {
            product.setNonKdvAppliedPrice(price);
            kdvPrice = (price.multiply(kdv)).divide(new BigDecimal(100), MathContext.DECIMAL32);
            totalPrice = price.add(kdvPrice);
            product.setPrice(totalPrice);
        } else {
            totalPrice = price;
            BigDecimal nonKdvPrice = (totalPrice.multiply(new BigDecimal(100))).divide((new BigDecimal(100)).add(kdv), MathContext.DECIMAL32);
            kdvPrice = totalPrice.subtract(nonKdvPrice);
            product.setNonKdvAppliedPrice(nonKdvPrice);
        }
    }
}
