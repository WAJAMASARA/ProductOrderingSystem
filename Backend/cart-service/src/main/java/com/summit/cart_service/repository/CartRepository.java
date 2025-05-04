package com.summit.cart_service.repository;

import com.summit.cart_service.model.Cart;

import org.springframework.data.jpa.repository.JpaRepository;




public interface CartRepository extends JpaRepository<Cart, Long> {

}
