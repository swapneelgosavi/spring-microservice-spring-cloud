package com.swapgo.turnovercalservice.controller;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.swapgo.turnovercalservice.feignproxy.SecurityDetailsServiceProxy;
import com.swapgo.turnovercalservice.model.SecurityDetail;
import com.swapgo.turnovercalservice.model.TurnoverDetail;

@RestController
public class ServiceController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private SecurityDetailsServiceProxy proxy;
	
	@GetMapping("/get-turnover")
	public TurnoverDetail getDetails() {
		TurnoverDetail tod = new TurnoverDetail();
		
		List<SecurityDetail> securityDetails =  proxy.getSecurityDetail();

		logger.info("{}", securityDetails);   //to test Sleuth
		
		BigDecimal totalTurnover = securityDetails.stream()
				.map(x->x.getTurnover()).reduce(new BigDecimal(0.0),(a,b) -> a.add(b));
		
		tod.setTotalTurnover(totalTurnover);
		
		SecurityDetail secDetailMax = securityDetails.stream().max(Comparator.comparing(SecurityDetail::getTurnover)).get();
		tod.setMaxTurnover(secDetailMax.getTurnover());
		tod.setMaxTurnoverScriptName(secDetailMax.getScriptName());
		
		SecurityDetail secDetailMin = securityDetails.stream().min(Comparator.comparing(SecurityDetail::getTurnover)).get();
		tod.setMinTurnover(secDetailMin.getTurnover());
		tod.setMinTurnoverScriptName(secDetailMin.getScriptName());

		tod.setPort(secDetailMax.getPort());
		
		return tod;
	}
	
	@GetMapping("/get-turnover/{scriptName}")
	public SecurityDetail  getScriptDetails(@PathVariable String scriptName) {
		SecurityDetail securityDetail = proxy.getScriptDetails(scriptName);
		securityDetail.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return securityDetail;
	}
	
	
}
