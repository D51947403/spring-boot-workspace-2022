package com.singraul.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.singraul.boot.country.Country;

@SpringBootTest
class BootCoreDemoApplicationTests {

	@Autowired 
	Country  country;
	@Test
	void testCounty() {
		Assert.hasText("India", country.getCountryName());
	}

}
