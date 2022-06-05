package com.rainbowforest.orderservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;
    private String productName;
    private BigDecimal price;
    private String discription;
    private String imageUrl;

}
