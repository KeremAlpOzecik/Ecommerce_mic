package com.rainbowforest.orderservice.service;

import com.rainbowforest.orderservice.domain.Cart;
import com.rainbowforest.orderservice.domain.Item;
import com.rainbowforest.orderservice.domain.dto.Product;
import com.rainbowforest.orderservice.domain.dto.ShoppingCartItems;
import com.rainbowforest.orderservice.feignclient.ProductClient;
import com.rainbowforest.orderservice.repository.CartRepository;
import com.rainbowforest.orderservice.repository.ItemRepository;
import com.rainbowforest.orderservice.utilities.CartUtilities;
import com.rainbowforest.orderservice.utilities.OrderUtilities;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CartService {
    private  final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    private final ProductClient productClient;

    public void addProductToCart(Long productId,Long userId ,Integer quantity) {

        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart();
        }
        Item item = new Item();
        item.setProductId(productId);
        item.setQuantity(quantity);
        Product product = productClient.getProductById(productId);
        item.setSubTotal(CartUtilities.getSubTotalForItem(product, quantity));
        item.setCartId(cart.getId());
        Item save = itemRepository.save(item);
        cart.setTotal(OrderUtilities.countTotalPrice(itemRepository.findAllByCartId(cart.getId())));
        cart.setUserId(userId);
            cart.setItemId(save.getId());
        cartRepository.save(cart);


    }
    public List<ShoppingCartItems> getCartProducts(Long id) {
        List<ShoppingCartItems> shoppingCartItems = new ArrayList<>();
        Cart cart = getCart(id).get();

        List<Item> items = itemRepository.findAllByCartId(cartRepository.findByUserId(id).getId());
        for (Item item : items) {
            Product product = productClient.getProductById(item.getProductId());
            shoppingCartItems.add(new ShoppingCartItems(product, item.getQuantity()));
        }
        return shoppingCartItems;
    }
    public Optional<Cart> getCart(Long cartId) {
        return cartRepository.findById(cartId);
    }
    public List<Item> getCartItems(Long cartId) {
        return itemRepository.findAllByCartId(cartId);
    }


    public void removeProductFromCart(Long productId, Long cartId) {
        List<Item> byCartId = itemRepository.findAllByCartId(cartId);
        for (Item item : byCartId) {
            if (item.getProductId().equals(productId)) {
                itemRepository.delete(item);
            }
        }
    }


    public void removeCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

}



