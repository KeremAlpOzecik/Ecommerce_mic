package com.micro.orderservice.service;

import com.micro.orderservice.domain.Order;

public interface OrderService {
    public Order saveOrder(Order order);
}
