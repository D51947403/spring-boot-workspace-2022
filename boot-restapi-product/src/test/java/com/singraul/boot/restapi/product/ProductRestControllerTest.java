package com.singraul.boot.restapi.product;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.singraul.boot.restapi.product.entity.Product;
import com.singraul.boot.restapi.product.repos.ProductRepository;

@SpringBootTest
class ProductRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductRepository repository;
	
	@Test
	public void testGetAllProduct() throws Exception {
		Product product = new Product();
		product.setProdId(10);
		product.setProdName("MacBook");
		product.setPrice(5000);
		product.setProdDesc("This is awesome");
		
		List<Product> products =Arrays.asList(product);
		
		when(repository.findAll()).thenReturn(products);
		
		mockMvc.perform(get("/product-rest-api/products").contextPath("/product-rest-api"))
		.andExpect(status().isOk());
	}
	
	

}
