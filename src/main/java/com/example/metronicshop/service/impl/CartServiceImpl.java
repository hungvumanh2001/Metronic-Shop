package com.example.metronicshop.service.impl;

import com.example.metronicshop.model.Cart;
import com.example.metronicshop.repository.CartRepository;
import com.example.metronicshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Iterable<Cart> getNumberCart(Long id,int status) {
        return cartRepository.findAllByUserIdAndStatus(id,status);
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart findProductId(Long productId,Long userId) {
        return cartRepository.findByProductIdAndUserId(productId,userId);
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Iterable<Cart> findAllUserId(Long id) {
        return cartRepository.findAllByUserId(id);
    }

    @Override
    public Iterable<Cart> listUserOrder(Long id, int status) {
        return cartRepository.findAllByProduct_ProductTypeUserIdAndStatus(id,status);
    }


}
