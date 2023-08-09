package com.allianz.example.controller;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @PostMapping("/create")
    public ResponseEntity<OrderItemEntity> createOrderItem(@RequestBody OrderItemRequestDTO request) {
        OrderItemEntity createdOrderItem = orderItemService.createOrderItem(request);
        return new ResponseEntity<>(createdOrderItem, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        List<OrderItemDTO> orderItems = orderItemService.getAllOrderItems();
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

    @GetMapping("/get/{uuid}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable UUID uuid) {
        OrderItemDTO orderItem = orderItemService.getByUUID(uuid);
        return new ResponseEntity<>(orderItem, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<OrderItemEntity> updateOrderItem(@PathVariable UUID uuid, @RequestBody OrderItemRequestDTO request) {
        OrderItemEntity updatedOrderItem = orderItemService.updateOrderItem(uuid, request);
        return new ResponseEntity<>(updatedOrderItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable UUID uuid) {
        orderItemService.deleteOrderItem(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
