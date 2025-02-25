package com.springjpa.Scenario3.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {

    private long orderId;
    private LocalDateTime orderDate;
    private List<ProductDTO> products;

}
