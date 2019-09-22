package com.targa.lab.myboutique.repository;

import com.targa.lab.myboutique.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByEnabled(Boolean enabled);
}