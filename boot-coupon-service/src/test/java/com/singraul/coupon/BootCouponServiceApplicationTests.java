package com.singraul.coupon;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
class BootCouponServiceApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	public void testGetCouponCodeWithoutAuth_forbidden() throws Exception {
		mvc.perform(get("/coupon-rest-api/coupon/SUPERSALE")).andExpect(status().isForbidden());
	}

	@Test
	// default user role is USER
	@WithMockUser
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
}
