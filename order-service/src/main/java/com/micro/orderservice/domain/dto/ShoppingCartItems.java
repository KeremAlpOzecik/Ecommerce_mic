package com.micro.orderservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItems {

    private Product products;
    private int quantity;
    private Long cartId;


}
