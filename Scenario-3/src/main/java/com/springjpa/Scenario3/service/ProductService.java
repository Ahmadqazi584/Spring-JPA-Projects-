package com.springjpa.Scenario3.service;


import com.springjpa.Scenario3.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(long id);
    Product insetProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(long id);

}
