package com.capgemini.pecunia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.pecunia.dao.UpdateBalanceDao;
import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.service.UpdateBalanceService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PecuniaBankUpdateBalanceApplicationTests {
	@Autowired
	UpdateBalanceService service;
	@MockBean
	UpdateBalanceDao dao;
	@Test
	public void updateBalanceTest() {
		String expected="Sufficient Account Balance is not found to pay EMI, deposit money in your account to pay month emi";
		
		LoanDisbursal loandis=new LoanDisbursal("111111111111", 100, 5, 988, 6, "accepted", "study", 150, 55);
	
		
		assertEquals(expected,service.updateBalance(loandis));
	}
	
	}


