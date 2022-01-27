package com.singraul.random.value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootRandomValuePropertySourceApplication {


	public static void main(String[] args) {
		
		 ConfigurableApplicationContext context = SpringApplication.run(BootRandomValuePropertySourceApplication.class, args);
	        MyAppProperties myAppPropsbean = context.getBean(MyAppProperties.class);
	        
		    System.out.println(myAppPropsbean);
		
	}
}
