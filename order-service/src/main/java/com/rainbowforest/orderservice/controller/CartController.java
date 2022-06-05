package com.rainbowforest.orderservice.controller;

import com.rainbowforest.orderservice.domain.Cart;
import com.rainbowforest.orderservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CartController {

   private final CartService cartService;

   @GetMapping("/cart/items/{id}")
   public ResponseEntity getCart(@RequestParam(value = "id") Long cartId) {
      return new ResponseEntity(cartService.getCartItems(cartId), HttpStatus.OK);
   }

   @GetMapping("/cart/items")
   public ResponseEntity getCartItems(@RequestParam(value = "userId") Long userId) {
      return new ResponseEntity(cartService.getCartProducts(userId), HttpStatus.OK);
   }


   @PostMapping("/cart")
   public void addProductToCart(@RequestParam("productId") Long productId,
                                 @RequestParam("quantity") Integer quantity,
           @RequestParam("userId") Long userId){
                        cartService.addProductToCart(productId,userId,quantity);
   }


   @DeleteMapping("/cart")
   public void deleteCart(@RequestParam(value = "productId") Long productId,@RequestParam(value = "cartId") Long cartId) {
      cartService.removeProductFromCart(productId, cartId);
   }
    



}