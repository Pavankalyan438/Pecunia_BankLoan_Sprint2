package com.capgemini.pecunia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.AccountDetails;
@Repository
public interface AccountDao extends JpaRepository<AccountDetails, String> {
	@Query("select det from AccountDetails det where accountId=?1")
	AccountDetails selectById(@Param("c") String s1);

}
