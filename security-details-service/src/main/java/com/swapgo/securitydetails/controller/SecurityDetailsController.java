package com.swapgo.securitydetails.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.swapgo.securitydetails.configuration.TurnOverConfiguration;
import com.swapgo.securitydetails.model.SecurityDetail;
import com.swapgo.securitydetails.repository.SecurityDetailsRepository;

@RestController
public class SecurityDetailsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TurnOverConfiguration turnOverConfiguration;

	@Autowired
	private SecurityDetailsRepository securityDetailsRepository;

	@Autowired
	private Environment environment;

	@GetMapping("/getsecurity")
	public List<SecurityDetail> getSecurityDetail() {

		List<SecurityDetail> securityDetail = securityDetailsRepository.findByTurnoverRange(turnOverConfiguration.getMinTurnOver(), 
				turnOverConfiguration.getMaxTurnOver());


		List<SecurityDetail> list = securityDetail.stream().map(x-> {x.setPort(Integer.parseInt(environment.getProperty("local.server.port"))); return x;}).collect(Collectors.toList());

		logger.info("{}", list);  //to test Sleuth
		
		return list;
	}

	@GetMapping("/getsecurity/turnover-range")
	public TurnOverConfiguration getTurnoverRange() {
		return turnOverConfiguration;
	}
	
	@GetMapping("/getsecurity/{scriptName}")
	public SecurityDetail getScriptDetails(@PathVariable String scriptName) {
		return securityDetailsRepository.findByScriptName(scriptName).get();
	}
	
	/*
	@GetMapping("/fault-tolerance-data")
	@HystrixCommand(fallbackMethod="fallbackRetrieveData")
	public SecurityDetail retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}

	public String fallbackRetrieveData() {
		return "Found some issue";
	}
	*/

	
	



}
