package com.singraul.boot.restapi.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.boot.restapi.product.entity.Product;
import com.singraul.boot.restapi.product.repos.ProductRepository;

@RestController
public class ProductRestController {
	@Autowired
	ProductRepository prodRepository;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getAllProduct() {
		return prodRepository.findAll();
	}

	@RequestMapping(value = "/products/{prodId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("prodId") int prodId) {
		return prodRepository.findById(prodId).get();
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product createProduct(Product product) {
		return prodRepository.save(product);
	}

	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public Product updateProduct(Product product) {
		// save method first check object in table
		// if present then it update
		// and if not it will create
		return prodRepository.save(product);
	}

	@RequestMapping(value = "/products/{prodId}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("prodId") int prodId) {
		prodRepository.deleteById(prodId);
	}

}
