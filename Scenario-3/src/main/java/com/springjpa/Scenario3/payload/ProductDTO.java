package com.springjpa.Scenario3.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private long productId;
    private String name;
    private int price;
    private int quantity;

}
