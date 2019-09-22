package com.targa.lab.myboutique.repository;

import com.targa.lab.myboutique.entities.Cart;
import com.targa.lab.myboutique.enumeration.CartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByStatus(CartStatus status);

    List<Cart> findByStatusAndCustomerId(CartStatus status, Long customerId);
}