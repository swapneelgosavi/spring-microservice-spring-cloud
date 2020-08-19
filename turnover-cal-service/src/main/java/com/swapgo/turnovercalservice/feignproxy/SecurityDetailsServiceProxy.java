package com.swapgo.turnovercalservice.feignproxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.swapgo.turnovercalservice.model.SecurityDetail;


//@FeignClient(name="security-details-service", url="localhost:8080")
//@FeignClient(name="security-details-service")    //uncomment this to send request directly
@FeignClient(name="netflix-zuul-api-gateway-server")   //to route request thru Zuul Server
@RibbonClient(name="security-details-service")
public interface SecurityDetailsServiceProxy {

	//uncomment this to send request directly
	/*
	@GetMapping("/getsecurity")
	public List<SecurityDetail> getSecurityDetail();
	
	@GetMapping("/getsecurity/{scriptName}")
	public SecurityDetail getScriptDetails(@PathVariable String scriptName);
	*/ 
	
	@GetMapping("/security-details-service/getsecurity")
	public List<SecurityDetail> getSecurityDetail();
	
	@GetMapping("/security-details-service/getsecurity/{scriptName}")
	public SecurityDetail getScriptDetails(@PathVariable String scriptName);
}
