package com.hjk532.spring.module;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class Operator implements Serializable {
	private static final long serialVersionUID = -1837130563061029954L;
	Integer optNum;
	String optName;
	String optGender;
	Integer optAge;
	Integer optSalary;
	public Integer getOptNum() {
		return optNum;
	}
	public void setOptNum(Integer optNum) {
		this.optNum = optNum;
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	public String getOptGender() {
		return optGender;
	}
	public void setOptGender(String optGender) {
		this.optGender = optGender;
	}
	public Integer getOptAge() {
		return optAge;
	}
	public void setOptAge(Integer optAge) {
		this.optAge = optAge;
	}
	public Integer getOptSalary() {
		return optSalary;
	}
	public void setOptSalary(Integer optSalary) {
		this.optSalary = optSalary;
	}
	
	@Override
	public String toString() {
		return "Operator [optNum=" + optNum + ", optName=" + optName + ", optGender=" + optGender + ", optAge=" + optAge
				+ ", optSalary=" + optSalary + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Operator) {
			Operator operator=(Operator)obj;
			if(operator.getOptNum()==this.optNum &&
					operator.getOptName().equals(this.optName) &&
					operator.getOptAge()==this.optAge && 
					operator.getOptGender().equals(this.optGender) &&
					operator.getOptSalary()==this.optSalary
					)return true;
		}
		return false;
	}
}
