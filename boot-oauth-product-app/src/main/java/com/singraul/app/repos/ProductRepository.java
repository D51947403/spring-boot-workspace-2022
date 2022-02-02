package com.singraul.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
