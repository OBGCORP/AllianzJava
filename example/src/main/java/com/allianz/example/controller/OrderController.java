package com.allianz.example.controller;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderRequestDTO request) {
        OrderEntity createdOrder = orderService.createOrder(request);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/get/{uuid}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable UUID uuid) {
        OrderDTO order = orderService.getByUUID(uuid);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable UUID uuid, @RequestBody OrderRequestDTO request) {
        OrderEntity updatedOrder = orderService.updateOrder(uuid, request);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID uuid) {
        orderService.deleteOrder(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
