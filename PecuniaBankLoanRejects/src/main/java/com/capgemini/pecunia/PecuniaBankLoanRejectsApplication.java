package com.capgemini.pecunia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PecuniaBankLoanRejectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankLoanRejectsApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();	
	}
}
