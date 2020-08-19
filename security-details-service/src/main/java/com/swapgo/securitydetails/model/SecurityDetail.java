package com.swapgo.securitydetails.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SecurityDetail {

	@Id
	@GeneratedValue
	private int id;
	private String scriptName;
	private String securityFullName;
	private BigDecimal turnover;
	private double faceValue;
	private int port;
	
	
	public SecurityDetail() {
		super();
	}
	public SecurityDetail(int id, String scriptName, String securityFullName, BigDecimal turnover, 
			double faceValue) {
		super();
		this.id = id;
		this.scriptName = scriptName;
		this.securityFullName = securityFullName;
		this.turnover = turnover;
		this.faceValue = faceValue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScriptName() {
		return scriptName;
	}
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
	public String getSecurityFullName() {
		return securityFullName;
	}
	public void setSecurityFullName(String securityFullName) {
		this.securityFullName = securityFullName;
	}
	public BigDecimal getTurnover() {
		return turnover;
	}
	public void setTurnover(BigDecimal turnOver) {
		this.turnover = turnOver;
	}

	public double getFaceValue() {
		return faceValue;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setFaceValue(double faceValue) {
		this.faceValue = faceValue;
	}
	
	@Override
	public String toString() {
		return "SecurityDetail [id=" + id + ", scriptName=" + scriptName + ", securityFullName=" + securityFullName
				+ ", turnover=" + turnover + ", faceValue=" + faceValue + ", port=" + port + "]";
	}
	
	
}
