package com.capgemini.pecunia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.pecunia.entity.AccountDetails;

public interface AccountDao extends JpaRepository<AccountDetails,String> {
	//jpql query to get the details of a particular accountid
	@Query("select det from AccountDetails det where accountId=?1")
	AccountDetails selectById(@Param("c") String s1);
}
