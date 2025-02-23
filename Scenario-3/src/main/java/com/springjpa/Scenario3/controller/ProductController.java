package com.springjpa.Scenario3.controller;

import com.springjpa.Scenario3.model.Product;
import com.springjpa.Scenario3.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = service.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable long productId) {
        Product product = service.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        Product saveProduct = service.insetProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long productId) {
        Product getProduct = service.getProductById(productId);
        product.setId(productId);
        Product updateProduct = service.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);

    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long productId) {
        Product deleteProduct = service.deleteProduct(productId);
        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
    }

}
