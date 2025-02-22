package com.springjpa.Scenario3.controller;

import com.springjpa.Scenario3.model.Order;
import com.springjpa.Scenario3.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = service.getAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
        Order order = service.getOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable long orderId) {
        Order getOrder = service.getOrderById(orderId);
        order.setId(orderId);
        Order updateOrder = service.updateOrder(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> insertOrder(@RequestBody Order order) {
        Order insertOrder = service.insertOrder(order);
        return new ResponseEntity<>(insertOrder, HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Order> deleteOrder(@PathVariable long orderId) {
        Order deleteOrder = service.deleteOrder(orderId);
        return new ResponseEntity<>(deleteOrder, HttpStatus.OK);
    }
}
