package com.capgemini.pecunia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.LoanRequests;

@Repository
public interface LoanRequestDao extends JpaRepository<LoanRequests, Integer>{
	

}
