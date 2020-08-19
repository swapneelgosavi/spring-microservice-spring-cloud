package com.swapgo.securitydetails.configuration;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("security-details-service")
public class TurnOverConfiguration {

	private BigDecimal minTurnover;
	private BigDecimal maxTurnover;
	
	public TurnOverConfiguration() {
		super();
	}
	public TurnOverConfiguration(BigDecimal minTurnover, BigDecimal maxTurnover) {
		super();
		this.minTurnover = minTurnover;
		this.maxTurnover = maxTurnover;
	}
	public BigDecimal getMinTurnOver() {
		return minTurnover;
	}
	public void setMinTurnOver(BigDecimal minTurnOver) {
		this.minTurnover = minTurnOver;
	}
	public BigDecimal getMaxTurnOver() {
		return maxTurnover;
	}
	public void setMaxTurnOver(BigDecimal maxTurnOver) {
		this.maxTurnover = maxTurnOver;
	}
	@Override
	public String toString() {
		return "TurnOverConfiguration [minTurnover=" + minTurnover + ", maxTurnover=" + maxTurnover + "]";
	}
	
	
}
