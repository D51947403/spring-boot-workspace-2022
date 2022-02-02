package com.singraul.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.app.model.Product;
import com.singraul.app.repos.ProductRepository;


@RestController
@RequestMapping("/product-rest-api")
public class ProductController {

	@Autowired
	ProductRepository prodRepo;

	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {

		return prodRepo.save(product);
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") long id) {
		return prodRepo.findById(id).get();
	}
}
