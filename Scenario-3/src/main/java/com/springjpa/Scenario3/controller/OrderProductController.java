package com.springjpa.Scenario3.controller;

import com.springjpa.Scenario3.model.Order;
import com.springjpa.Scenario3.model.OrderProduct;
import com.springjpa.Scenario3.payload.OrderProductDTO;
import com.springjpa.Scenario3.service.OrderProductService;
import com.springjpa.Scenario3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

    @Autowired
    private OrderProductService service;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderProductDTO>> getAllOrderProducts() {
        List<OrderProductDTO> orderProductList = service.getAllOrderProducts();
        return new ResponseEntity<>(orderProductList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderProductDTO> getOrderProductById(@PathVariable long id) {
        OrderProductDTO orderProductDTO = service.getOrderProductById(id);
        return new ResponseEntity<>(orderProductDTO, HttpStatus.OK);
    }

}
