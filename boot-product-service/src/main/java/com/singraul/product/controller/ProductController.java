package com.singraul.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.singraul.product.dto.Coupon;
import com.singraul.product.model.Product;
import com.singraul.product.repos.ProductRepository;

@RestController
@RequestMapping("/product-rest-api")
public class ProductController {

	@Autowired
	ProductRepository prodRepo;

	@Autowired
	RestTemplate restTemplate;

	@Value("${coupon.service.url}")
	private String coupanServiceURL;

	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {

		//Coupon coupon = restTemplate.getForObject(coupanServiceURL + product.getCouponCode(), Coupon.class);

		//product.setPrice(product.getPrice().subtract(coupon.getDiscount()));

		return prodRepo.save(product);
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") long id) {
		return prodRepo.findById(id).get();
	}
}
