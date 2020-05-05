package com.capgemini.pecunia;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.pecunia.dao.LoanRequestDao;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.LoanRequestService;
@RunWith(SpringRunner.class)
@SpringBootTest

public class PecuniaBankLoanApplicationTests {
	@Autowired
	 LoanRequestService service;
	@MockBean
	 LoanRequestDao dao;
	@Test
	public void contextLoads() {
		LoanRequests loanreq=new LoanRequests("111111111111", 10000, 33, 900, 5, "pending", "study",1);
		when(dao.save(loanreq)).thenReturn(loanreq);
		
		assertEquals(loanreq,dao.save(loanreq));
	}

}


	