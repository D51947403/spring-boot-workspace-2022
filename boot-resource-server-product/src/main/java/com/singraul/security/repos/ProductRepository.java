package com.singraul.security.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.security.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
