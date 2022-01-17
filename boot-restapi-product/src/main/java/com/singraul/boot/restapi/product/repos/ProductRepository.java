package com.singraul.boot.restapi.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singraul.boot.restapi.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
