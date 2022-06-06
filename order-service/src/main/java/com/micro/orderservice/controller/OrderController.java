package com.micro.orderservice.controller;

import com.micro.orderservice.domain.Order;
import com.micro.orderservice.domain.dto.User;
import com.micro.orderservice.feignclient.UserClient;
import com.micro.orderservice.domain.Item;
import com.micro.orderservice.http.header.HeaderGenerator;
import com.micro.orderservice.service.CartService;
import com.micro.orderservice.service.OrderService;
import com.micro.orderservice.utilities.OrderUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
@RequiredArgsConstructor
@RestController
public class OrderController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private OrderService orderService;


    private final CartService cartService;

    @Autowired
    private HeaderGenerator headerGenerator;
    
    @PostMapping(value = "/order/{userId}/cart/{cartId}")
    public ResponseEntity<Order> saveOrder(
    		@PathVariable("userId") Long userId,
    		@RequestParam("cartId") Long cartId,
    		HttpServletRequest request){
    	
        List<Item> cart = cartService.getCartItems(cartId);
        User user = userClient.getUserById(userId);
        if(cart != null && user != null) {
        	Order order = this.createOrder(cartId, userId);
        	try{
                orderService.saveOrder(order);
                cartService.removeCart(cartId);
                return new ResponseEntity<Order>(
                		order, 
                		headerGenerator.getHeadersForSuccessPostMethod(request, order.getId()),
                		HttpStatus.CREATED);
            }catch (Exception ex){
                ex.printStackTrace();
                return new ResponseEntity<Order>(
                		headerGenerator.getHeadersForError(),
                		HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
  
        return new ResponseEntity<Order>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }
    
    private Order createOrder(Long cartId,Long userId) {
        Order order = new Order();
        order.setCartId(cartId);
        order.setUserId(userId);
        order.setTotal(OrderUtilities.countTotalPrice(cartService.getCartItems(cartId)));
        order.setOrderedDate(LocalDate.now());
        order.setStatus("PAYMENT_EXPECTED");
        return order;
    }
}
