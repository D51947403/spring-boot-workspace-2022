package com.singraul.boot.sum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.singraul.boot.sum.service.SumService;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootCoreSumApplicationTests {

	@Autowired
	SumService  sumService;
	// Testing if sum method is returning proper result or not 
	@Test
	public void testSum() {	
	assertEquals(sumService.sum(4, 5) ,9);
	}

}
