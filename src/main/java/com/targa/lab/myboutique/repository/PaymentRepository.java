package com.targa.lab.myboutique.repository;

import com.targa.lab.myboutique.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}