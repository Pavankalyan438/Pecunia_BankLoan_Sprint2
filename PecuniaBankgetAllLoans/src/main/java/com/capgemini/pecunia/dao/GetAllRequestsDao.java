package com.capgemini.pecunia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.LoanRequests;

//Jpa repository with LoanRequests as the class and Integer as the primary  key of the table
@Repository
public interface GetAllRequestsDao extends JpaRepository<LoanRequests, Integer> {

}
