package com.dedovich.localization.data.repository;

import com.dedovich.localization.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
