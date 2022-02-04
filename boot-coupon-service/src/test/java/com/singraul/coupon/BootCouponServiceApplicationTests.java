package com.singraul.coupon;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BootCouponServiceApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	public void testGetCouponCodeWithoutAuth_unauthorized() throws Exception {
		mvc.perform(get("/coupon-rest-api/coupon/SUPERSALE")).andExpect(status().isUnauthorized());
	}
	
	@Test
	public void testGetCouponCodeWithoutAuth_forbidden() throws Exception {
		mvc.perform(get("/coupon-rest-api/coupon/SUPERSALE")).andExpect(status().isForbidden());
	}

	@Test
	// default user role is USER
	//@WithMockUser
	@WithUserDetails("singrauld@yahoo.com")
	public void testGetCouponCodeWithoutAuth_success() throws Exception {
		mvc.perform(get("/coupon-rest-api/coupon/SUPERSALE")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles= {"ADMIN"})
	public void testCreateCoupon_withoutCsrf_Forbidden() throws Exception {
		mvc.perform(post("/coupon-rest-api/coupon/")
		.content("{\"code\":\"SUPERSALE-ONE\",\"discount\":50.000,\"expDate\":\"26-Jun-2022\"}")
		.contentType(MediaType.APPLICATION_JSON))	
		.andExpect(status().isForbidden());
	}
	
	@Test
	@WithMockUser(roles= {"ADMIN"})
	public void testCreateCoupon_withCsrf_success() throws Exception {
		mvc.perform(post("/coupon-rest-api/coupon/")
		.content("{\"code\":\"SUPERSALETWO\",\"discount\":50.000,\"expDate\":\"26-Jun-2022\"}")
		.contentType(MediaType.APPLICATION_JSON).with(csrf().asHeader()))	
		.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser (roles= {"ADMIN"})
	public void testCors() throws Exception {
		mvc.perform(options("/coupon-rest-api/coupon/")
				.header("Access-Control-Request-Method", "POST")
				.header("Origin", "www.mainaha.com"))
		 .andExpect(header().exists("Access-Control-Allow-Origin"))
		 .andExpect(header().string("Access-Control-Allow-Origin", "*"))
		 .andExpect(header().exists("Access-Control-Allow-Methods"))
		 .andExpect(header().string("Access-Control-Allow-Methods", "POST") );
				
	}
}
