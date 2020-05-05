package com.capgemini.pecunia;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
		LoanDisbursal loandis=new LoanDisbursal();
		when(dao.save(loandis)).thenReturn(loandis);
		assertEquals(loandis,dao.save(loandis));
	}
	}


