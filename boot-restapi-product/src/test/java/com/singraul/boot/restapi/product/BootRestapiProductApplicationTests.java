package com.singraul.boot.restapi.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.singraul.boot.restapi.product.entity.Product;

@SpringBootTest
class BootRestapiProductApplicationTests {
	RestTemplate  rest = new RestTemplate();
	@SuppressWarnings("deprecation")
	@Test
	void testGetApi() {
	
	Product product = rest.getForObject("http://localhost:8080/product-rest-api/products/102", Product.class);
	System.out.println("product "+product);
	   Assert.notNull(product);
	   Assert.hasText(product.getProdName(), "Torch");
	}
	@Test
  void testCreateProduct() {
	  
	 Product  productObj = new Product();
	 productObj.setProdName("Samasung Galaxy");
	 productObj.setProdDesc("This is best mobile in 4GB RAM memory.");
	 productObj.setPrice(12000);

	Product postForObject = rest.postForObject("http://localhost:8080/product-rest-api/products/", productObj, Product.class);
	
	Assert.notNull(postForObject);
	Assert.notNull(postForObject.getProdId());
	Assert.hasText("Samasung Galaxy", postForObject.getProdName());
  }
	
}
