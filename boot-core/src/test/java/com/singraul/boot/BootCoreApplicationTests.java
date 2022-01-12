package com.singraul.boot;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.singraul.boot.service.PaymentService;
import com.singraul.boot.service.PaymentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class  BootCoreApplicationTests {

	@Autowired
	PaymentService  paymentService;
	@Autowired
	PaymentServiceImpl paymentServiceImpl;
	
	// Testing if PaymentService Object is being created 
	@Test
	public void testDependencyInjection() {
		assertNotNull(paymentServiceImpl);
	}
	// Testing if PaymentServiceImpl Object is being created 
	@Test
	public void testDependencyInjectionImpl() {
		assertNotNull(paymentServiceImpl);
	}


}
