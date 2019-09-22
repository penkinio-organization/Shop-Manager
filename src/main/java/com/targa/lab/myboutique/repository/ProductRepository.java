package com.targa.lab.myboutique.repository;

import com.targa.lab.myboutique.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}