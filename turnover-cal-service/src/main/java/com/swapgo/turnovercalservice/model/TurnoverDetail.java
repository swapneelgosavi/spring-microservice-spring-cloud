package com.swapgo.turnovercalservice.model;

import java.math.BigDecimal;

public class TurnoverDetail {

	private BigDecimal totalTurnover;
	private BigDecimal maxTurnover;
	private String maxTurnoverScriptName;
	private BigDecimal minTurnover;
	private String minTurnoverScriptName;
	private int port;
	
	public TurnoverDetail() {
		super();
	}
	public BigDecimal getTotalTurnover() {
		return totalTurnover;
	}
	public void setTotalTurnover(BigDecimal totalTurnover) {
		this.totalTurnover = totalTurnover;
	}
	public BigDecimal getMaxTurnover() {
		return maxTurnover;
	}
	public void setMaxTurnover(BigDecimal maxTurnover) {
		this.maxTurnover = maxTurnover;
	}
	public String getMaxTurnoverScriptName() {
		return maxTurnoverScriptName;
	}
	public void setMaxTurnoverScriptName(String maxTurnoverScriptName) {
		this.maxTurnoverScriptName = maxTurnoverScriptName;
	}
	public BigDecimal getMinTurnover() {
		return minTurnover;
	}
	public void setMinTurnover(BigDecimal minTurnover) {
		this.minTurnover = minTurnover;
	}
	public String getMinTurnoverScriptName() {
		return minTurnoverScriptName;
	}
	public void setMinTurnoverScriptName(String minTurnoverScriptName) {
		this.minTurnoverScriptName = minTurnoverScriptName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	

	@Override
	public String toString() {
		return "TurnoverDetail [totalTurnover=" + totalTurnover + ", maxTurnover=" + maxTurnover
				+ ", maxTurnoverScriptName=" + maxTurnoverScriptName + ", minTurnover=" + minTurnover
				+ ", minTurnoverScriptName=" + minTurnoverScriptName + ", port=" + port + "]";
	}
	
	
}
