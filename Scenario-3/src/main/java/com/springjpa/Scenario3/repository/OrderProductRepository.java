package com.springjpa.Scenario3.repository;

import com.springjpa.Scenario3.model.Order;
import com.springjpa.Scenario3.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    List<OrderProduct> findByOrderId(long orderId);  // Fetch all products by order ID

}
