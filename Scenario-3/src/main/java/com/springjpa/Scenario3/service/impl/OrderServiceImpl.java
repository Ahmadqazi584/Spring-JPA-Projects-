package com.springjpa.Scenario3.service.impl;

import com.springjpa.Scenario3.exceptionhandler.ResourceNotFound;
import com.springjpa.Scenario3.model.Order;
import com.springjpa.Scenario3.repository.OrderRepository;
import com.springjpa.Scenario3.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = repository.findAll();
        if (orderList.isEmpty()) throw new ResourceNotFound("no any order found!");
        return orderList;
    }

    @Override
    public Order getOrderById(long id) {
        Optional<Order> order = repository.findById(id);
        if (order.isEmpty()) throw new ResourceNotFound("no such order exists!");
        return order.get();
    }

    @Override
    public Order insertOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Order deleteOrder(long id) {
        Order getOrder = getOrderById(id);
        repository.deleteById(id);
        return getOrder;
    }
}
