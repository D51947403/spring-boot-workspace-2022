package com.singraul.boot.restapi.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.singraul.boot.restapi.product.entity.Product;

@SpringBootTest
class BootRestapiProductApplicationTests {
	@SuppressWarnings("deprecation")
	@Test
	void testGetApi() {
	RestTemplate  rest = new RestTemplate();
	Product product = rest.getForObject("http://localhost:8080/product-rest-api/products/102", Product.class);
	System.out.println("product "+product);
	   Assert.notNull(product);
	   Assert.hasText(product.getProdName(), "Torch");
	}
	

}
