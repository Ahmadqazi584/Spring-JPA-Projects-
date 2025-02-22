package com.springjpa.Scenario3.service.impl;

import com.springjpa.Scenario3.exceptionhandler.ResourceNotFound;
import com.springjpa.Scenario3.model.Order;
import com.springjpa.Scenario3.model.OrderProduct;
import com.springjpa.Scenario3.payload.OrderProductDTO;
import com.springjpa.Scenario3.payload.ProductDTO;
import com.springjpa.Scenario3.repository.OrderProductRepository;
import com.springjpa.Scenario3.repository.OrderRepository;
import com.springjpa.Scenario3.service.OrderProductService;
import com.springjpa.Scenario3.service.ProductService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    private OrderRepository orderRepository;
    private OrderProductRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public OrderProductServiceImpl(OrderRepository orderRepository, OrderProductRepository repository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderProductDTO> getAllOrderProducts() {
        List<OrderProduct> orderProductList = repository.findAll();
        if (orderProductList.isEmpty()) throw new ResourceNotFound("no any order of product found!");

        List<OrderProductDTO> orderProductDTOList = new ArrayList<>();
        for (OrderProduct orderProduct : orderProductList) {
            long orderId = orderProduct.getOrder().getId();
            LocalDateTime orderDate = orderProduct.getOrder().getOrderDate();

            OrderProductDTO orderProductExists = null;
            for (OrderProductDTO dto : orderProductDTOList) {
                if (dto.getOrderId() == orderId) {
                    orderProductExists = dto;
                    break;
                }
            }

            if (orderProductExists == null) {
                orderProductExists = modelMapper.map(orderProduct.getOrder(), OrderProductDTO.class);
                orderProductExists.setOrderId(orderId);
                orderProductExists.setOrderDate(orderDate);
                orderProductExists.setProducts(new ArrayList<>());

                orderProductDTOList.add(orderProductExists);
            }

            ProductDTO productDTO = modelMapper.map(orderProduct.getProduct(), ProductDTO.class);
            productDTO.setProductId(orderProduct.getProduct().getId());
            productDTO.setName(orderProduct.getProduct().getName());
            productDTO.setPrice(orderProduct.getProduct().getPrice());
            productDTO.setQuantity(orderProduct.getQuantity());

            orderProductExists.getProducts().add(productDTO);
        }

        return orderProductDTOList;
    }


    @Override
    public OrderProductDTO getOrderProductById(long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("order of product not exist!"));

        long orderId = order.getId();
        LocalDateTime localDate = order.getOrderDate();

        List<OrderProduct> orderProductList = repository.findByOrderId(orderId);  // Fetch all products by order ID

        OrderProductDTO orderProductDTO = new OrderProductDTO();
        orderProductDTO.setOrderId(orderId);
        orderProductDTO.setOrderDate(localDate);
        orderProductDTO.setProducts(new ArrayList<>());

        for (OrderProduct op : orderProductList) {
            ProductDTO productDTO = modelMapper.map(op.getProduct(), ProductDTO.class);
            productDTO.setProductId(op.getProduct().getId());
            productDTO.setName(op.getProduct().getName());
            productDTO.setPrice(op.getProduct().getPrice());
            productDTO.setQuantity(op.getQuantity());

            orderProductDTO.getProducts().add(productDTO);
        }

        return orderProductDTO;
    }

}
