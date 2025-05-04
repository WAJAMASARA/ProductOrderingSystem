package com.summit.cart_service.service;


import com.summit.cart_service.dto.CartDTO;

import java.util.List;
public interface CartService {
    List<CartDTO> getAllCarts();
    CartDTO getCartById(Long id);
    CartDTO createCart(CartDTO cartDTO);
    CartDTO updateCart(Long id, CartDTO cartDTO);
    void deleteCart(Long id);
}
