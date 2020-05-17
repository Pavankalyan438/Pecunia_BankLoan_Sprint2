package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication

//annotation used to enable the eureka server and allows services to register
@EnableEurekaServer


public class PecuniaBankEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PecuniaBankEurekaServerApplication.class, args);
	}

}
