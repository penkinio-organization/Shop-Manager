package com.targa.lab.myboutique.repository;

import com.targa.lab.myboutique.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}