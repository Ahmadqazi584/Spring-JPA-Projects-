package com.springjpa.Scenario3.service;

import com.springjpa.Scenario3.model.OrderProduct;
import com.springjpa.Scenario3.payload.OrderProductDTO;
import com.springjpa.Scenario3.payload.ProductDTO;

import java.util.List;

public interface OrderProductService {

    List<OrderProductDTO> getAllOrderProducts();
    OrderProductDTO getOrderProductById(long id);

}
