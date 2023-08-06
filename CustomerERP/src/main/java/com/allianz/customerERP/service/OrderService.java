package com.allianz.customerERP.service;

import com.allianz.customerERP.database.entity.CustomerEntity;
import com.allianz.customerERP.database.entity.OrderEntity;
import com.allianz.customerERP.database.entity.ProductEntity;
import com.allianz.customerERP.database.repository.OrderRepository;
import com.allianz.customerERP.database.repository.ProductRepository;
import com.allianz.customerERP.util.EOrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    // Method to create a new order for a customer with a list of products
    public boolean createOrder(CustomerEntity customer, List<ProductEntity> productEntityList) {
        if (customer == null || productEntityList == null) return false;
        OrderEntity order = new OrderEntity();
        order.setCustomer(customer);
        order.setProductList(productEntityList);
        orderRepository.save(order);
        return true;
    }

    // Method to get all orders from the database
    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }

    // Method to get orders by their status (e.g., WAITING, APPROVED, REJECTED)
    public List<OrderEntity> getByStatus(EOrderStatus status) {
        return orderRepository.getOrderEntitiesByStatus(status);
    }

    // Method to get an order by its UUID
    public OrderEntity getByUuid(UUID uuid) {
        return orderRepository.findByUuid(uuid);
    }

    // Method to delete an order with the specified UUID
    public boolean deleteOrderEntity(UUID uuid) {
        if (uuid == null) return false;
        orderRepository.deleteByUuid(uuid);
        return true;
    }

    // Method to update an existing order's customer and product list using the provided UUID
    public boolean updateOrderEntity(UUID uuid, OrderEntity order) {
        if (uuid == null || order == null) return false;
        OrderEntity orderEntity = orderRepository.findByUuid(uuid);
        if (orderEntity == null) return false;
        orderEntity.setCustomer(order.getCustomer());
        orderEntity.setProductList(order.getProductList());
        orderEntity.setStatus(order.getStatus());
        orderRepository.save(orderEntity);
        return true;
    }

    // Method to add a product to an existing order
    public boolean addProduct(UUID productUuid, UUID orderUuid) {
        if (orderUuid == null || productUuid == null || productRepository.findByUuid(productUuid).getOrderCount() == 0)
            return false;
        OrderEntity orderEntity = orderRepository.findByUuid(orderUuid);
        productRepository.findByUuid(productUuid).setOrderCount(1);
        if (orderEntity == null) return false;
        ProductEntity productEntity = productRepository.findByUuid(productUuid);
        if (orderEntity.getProductList().contains(productEntity)) {
            for (ProductEntity productEntity1 : orderEntity.getProductList()) {
                if (productEntity1.getUuid().equals(productUuid))
                    productEntity1.setOrderCount(productEntity1.getOrderCount() + 1);
            }
        } else
            orderEntity.getProductList().add(productEntity);
        orderRepository.save(orderEntity);
        return true;
    }

    // Method to calculate the total price of an order based on the products and their order counts
    public void calculateTotalPrice(UUID uuid) {
        OrderEntity orderEntity = orderRepository.findByUuid(uuid);
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (ProductEntity productEntity : orderEntity.getProductList()) {
            BigDecimal productPrice = productEntity.getPrice().multiply(BigDecimal.valueOf(productEntity.getOrderCount()));
            totalPrice = totalPrice.add(productPrice);
        }
        orderEntity.setTotalPrice(totalPrice);
        orderRepository.save(orderEntity);
    }

    // Method to control the order status and update it based on product stock availability
    public OrderEntity controlOrderStatus(UUID uuid){
        OrderEntity order = orderRepository.findByUuid(uuid);
        if (order == null) return null;
        if (order.getStatus() == EOrderStatus.WAITING) {
            for (ProductEntity productEntity : order.getProductList()) {
                if (productEntity.getStock() < productEntity.getOrderCount()) {
                    order.setStatus(EOrderStatus.REJECTED);
                    orderRepository.save(order);
                    calculateTotalPrice(orderRepository.findByUuid(uuid).getUuid());
                    return order;
                } else {
                    order.setStatus(EOrderStatus.APPROVED);
                    productEntity.setStock(productEntity.getStock() - productEntity.getOrderCount());
                    orderRepository.save(order);
                }
            }
        }
        calculateTotalPrice(orderRepository.findByUuid(uuid).getUuid());
        return order;
    }
}
