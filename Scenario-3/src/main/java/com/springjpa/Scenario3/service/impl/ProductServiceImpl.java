package com.springjpa.Scenario3.service.impl;

import com.springjpa.Scenario3.exceptionhandler.ResourceNotFound;
import com.springjpa.Scenario3.model.Product;
import com.springjpa.Scenario3.repository.ProductRepository;
import com.springjpa.Scenario3.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = repository.findAll();
        if (productList.isEmpty()) throw new ResourceNotFound("no any product found!");
        return productList;
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) throw new ResourceNotFound("no such product exists!");
        return product.get();
    }

    @Override
    public Product insetProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product deleteProduct(long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found!"));
        repository.deleteById(id);
        return product;
    }
}
