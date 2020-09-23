package com.hjk532.spring.module;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Repository;
@Repository
public class Log implements Serializable{
	private static final long serialVersionUID = -4352778876130607854L;
	String logId;
	Date generateTime;
	Integer opId;
	String cargoList;
	Integer logStatus;
	
	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public Date getGenerateTime() {
		return generateTime;
	}

	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	public String getCargoList() {
		return cargoList;
	}

	public void setCargoList(String cargoList) {
		this.cargoList = cargoList;
	}

	public Integer getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}

	@Override
	public String toString() {
		return "Log [logId=" + logId + ", generateTime=" + generateTime + ", opId=" + opId + ", cargoList=" + cargoList
				+ ", logStatus=" + logStatus + "]";
	}

	
	
}
