package com.swapgo.securitydetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
//@EnableHystrix
public class SecurityDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDetailsServiceApplication.class, args);
	}
	
	
	//Added for enable Spring Sleuth: Assigning Id to each request and log
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}	

}
