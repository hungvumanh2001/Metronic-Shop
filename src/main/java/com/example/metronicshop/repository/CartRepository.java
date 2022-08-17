package com.example.metronicshop.repository;

import com.example.metronicshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Iterable<Cart> findAllByUserIdAndStatus(Long id,int status);
    Iterable<Cart> findAllByUserId(Long userId);
    Cart findByProductIdAndUserId(Long productId,Long userId);
    Iterable<Cart> findAllByProduct_ProductTypeUserIdAndStatus(Long userId,int status);
    Iterable<Cart> findAllByProductId(Long productId);
    Cart findAllById(Long id);
}
