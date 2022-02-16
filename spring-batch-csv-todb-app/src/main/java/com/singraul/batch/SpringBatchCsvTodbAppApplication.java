package com.singraul.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchCsvTodbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchCsvTodbAppApplication.class, args);
	}

}
