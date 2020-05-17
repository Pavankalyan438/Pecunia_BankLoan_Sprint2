package com.capgemini.pecunia.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.GetAllRequestsDao;
import com.capgemini.pecunia.entity.LoanRequests;
@Service
public class GetAllRequestsServiceImp implements GetAllRequestsService{
@Autowired
GetAllRequestsDao dao;



// method used to display all the loan requests that employee have added into
// requests data base, it gives Arraylist as the return type
	@Override
	public ArrayList<LoanRequests> getAllRequests() {

		return (ArrayList<LoanRequests>) dao.findAll();
	}

}
