package com.rainbowforest.orderservice.utilities;

import java.math.BigDecimal;

import com.rainbowforest.orderservice.domain.dto.Product;

public class CartUtilities {

    public static BigDecimal getSubTotalForItem(Product product, int quantity){
       return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
    }
}
