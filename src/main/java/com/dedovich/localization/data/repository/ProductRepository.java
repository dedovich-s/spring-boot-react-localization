package com.dedovich.localization.data.repository;

import com.dedovich.localization.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
