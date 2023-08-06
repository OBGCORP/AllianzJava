package com.allianz.customerERP.service;

import com.allianz.customerERP.database.entity.KdvEntity;
import com.allianz.customerERP.database.entity.OrderEntity;
import com.allianz.customerERP.database.entity.ProductEntity;
import com.allianz.customerERP.database.repository.KdvRepository;
import com.allianz.customerERP.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    KdvRepository kdvRepository;

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

    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    public boolean deleteProduct(UUID uuid) {
        if (uuid == null) return false;
        productRepository.deleteByUuid(uuid);
        return true;
    }

    public ProductEntity getByUuid(UUID uuid) {
        return productRepository.findByUuid(uuid);
    }

    public List<ProductEntity> getAllByNameIContains(String name) {
        return productRepository.findAllByNameContainsIgnoreCase(name);
    }

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
