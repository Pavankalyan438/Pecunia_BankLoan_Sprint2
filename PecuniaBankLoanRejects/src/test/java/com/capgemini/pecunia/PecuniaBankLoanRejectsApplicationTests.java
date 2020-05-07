package com.capgemini.pecunia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.Entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PecuniaBankLoanRejectsApplicationTests {

	
	@Test
	public void allRejectsTestFail() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:1003/loan/allreqrejects";
		URI uri = new URI(baseUrl);
		ResponseEntity<List> result = restTemplate.exchange(uri, HttpMethod.GET, null, List.class);
		assertEquals(500, result.getStatusCodeValue());
	}
	@Test
	public void allRejectsTestPass() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:1003/loan/allreqrejects";
		URI uri = new URI(baseUrl);
		ResponseEntity<List> result = restTemplate.exchange(uri, HttpMethod.GET, null, List.class);
		assertEquals(200, result.getStatusCodeValue());
	}
	

}
