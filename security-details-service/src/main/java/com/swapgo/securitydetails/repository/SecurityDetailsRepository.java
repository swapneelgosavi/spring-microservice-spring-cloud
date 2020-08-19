package com.swapgo.securitydetails.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swapgo.securitydetails.model.SecurityDetail;

public interface SecurityDetailsRepository extends JpaRepository<SecurityDetail, Integer>{

	@Query("select s from SecurityDetail s where s.turnover between :minTurnover and :maxTurnover")
	public List<SecurityDetail> findByTurnoverRange(BigDecimal minTurnover, BigDecimal maxTurnover);
	
	public Optional<SecurityDetail> findByScriptName(String scriptName);
}
