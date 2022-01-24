package com.singraul.boot.restapi.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.singraul.boot.restapi.product.entity.Product;
import com.singraul.boot.restapi.product.repos.ProductRepository;

@RestController
public class ProductRestController {
	@Autowired
	ProductRepository prodRepository;
	
	private static final Logger log=LoggerFactory.getLogger(ProductRestController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getAllProduct() {
		log.info("Method : getAllProduct ");
		return prodRepository.findAll();
	}

	@RequestMapping(value = "/products/{prodId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("prodId") int prodId) {
		log.info("Method : getProduct ");
		log.info("Parameter : prodId "+prodId);
		return prodRepository.findById(prodId).get();
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		log.info("Method : createProduct ");
		return prodRepository.save(product);
	}

	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		log.info("Method : updateProduct ");
		// save method first check object in table
		// if present then it update
		// and if not it will create
		return prodRepository.save(product);
	}

	@RequestMapping(value = "/products/{prodId}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("prodId") int prodId) {
		log.info("Method : getProduct ");
		log.info("Parameter : prodId "+prodId);
		prodRepository.deleteById(prodId);
	}

}
