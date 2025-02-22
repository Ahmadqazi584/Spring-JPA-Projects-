package com.springjpa.Scenario3.service;

import com.springjpa.Scenario3.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(long id);
    Order insertOrder(Order order);
    Order updateOrder(Order order);
    Order deleteOrder(long id);

}
