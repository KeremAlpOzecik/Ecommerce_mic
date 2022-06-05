package com.rainbowforest.orderservice.domain.dto;

import com.rainbowforest.orderservice.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItems {

    private Product products;
    private int quantity;


}
