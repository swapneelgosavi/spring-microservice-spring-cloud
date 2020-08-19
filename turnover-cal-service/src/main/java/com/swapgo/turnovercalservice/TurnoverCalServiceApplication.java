package com.swapgo.turnovercalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.swapgo.turnovercalservice")
@EnableDiscoveryClient
public class TurnoverCalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurnoverCalServiceApplication.class, args);
	}

	//Added for enable Spring Sleuth: Assigning Id to each request and log
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
