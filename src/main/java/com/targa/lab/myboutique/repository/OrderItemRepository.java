package com.targa.lab.myboutique.repository;

import com.targa.lab.myboutique.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}