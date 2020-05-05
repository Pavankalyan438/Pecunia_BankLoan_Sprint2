package com.capgemini.pecunia;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.pecunia.dao.GetAllRequestsDao;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.GetAllRequestsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PecuniaBankgetAllLoansApplicationTests {
	@Autowired
	private GetAllRequestsService service;
	@MockBean
	private GetAllRequestsDao dao;

	@Test
	public void getAllRequestsTest() {
		Mockito.when(dao.findAll())
				.thenReturn(Stream.of(new LoanRequests("111111111111", 10000, 18, 899, 8, "pending", "study", 3))
						.collect(Collectors.toList()));
		assertEquals(1, service.getAllRequests().size());
		//assertEquals(2,  service.getAllRequests().size());

	}

}
