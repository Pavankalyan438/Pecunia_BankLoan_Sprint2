package com.capgemini.pecunia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PecuniaBankUpdateBalanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankUpdateBalanceApplication.class, args);
	}

}
