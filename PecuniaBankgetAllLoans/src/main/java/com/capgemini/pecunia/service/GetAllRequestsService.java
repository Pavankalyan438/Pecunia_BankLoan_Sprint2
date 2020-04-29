package com.capgemini.pecunia.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.capgemini.pecunia.entity.LoanRequests;

public interface GetAllRequestsService {

	ArrayList<LoanRequests> getAllRequests();

}
