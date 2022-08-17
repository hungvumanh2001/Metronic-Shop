package com.example.metronicshop.service;

import com.example.metronicshop.model.Cart;

import java.util.Optional;

public interface CartService {
    void save(Cart cart);
    Iterable<Cart> getNumberCart(Long id,int status);
    void deleteCart(Long id);
    Cart findProductId(Long productId,Long userId);
    Optional<Cart> findById(Long id);
    Iterable<Cart> findAllUserId(Long id);
    Iterable<Cart> listUserOrder(Long id,int status);
}
