package com.micro.orderservice.utilities;

import java.math.BigDecimal;

import com.micro.orderservice.domain.dto.Product;

public class CartUtilities {

    public static BigDecimal getSubTotalForItem(Product product, int quantity){
       return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
    }
}
