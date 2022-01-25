package com.singraul.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.product.model.Product;

public interface ProductRepository extends JpaRepository<Product , Long> {

}
