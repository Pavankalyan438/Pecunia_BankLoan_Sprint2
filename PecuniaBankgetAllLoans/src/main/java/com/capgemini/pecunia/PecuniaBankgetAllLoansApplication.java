package com.capgemini.pecunia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//configuration used to register this service in the eureka server
@EnableEurekaClient
//this is used describe and document the RESTful API's
@EnableSwagger2
public class PecuniaBankgetAllLoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankgetAllLoansApplication.class, args);
	}

}
