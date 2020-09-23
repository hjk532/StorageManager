package com.hjk532.spring.module;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class OperatorJson implements Serializable{
	
	private static final long serialVersionUID = 6496899798177795027L;
	private String msg;
	private StringBuffer data;
	private int code;
	private int count;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getData() {
		return data.toString();
	}
	
	public void setData(List<Operator> data) {
		this.data.append("[");
		for(Operator Operator:data) {
			this.data.append("{\"optNum\":");
			this.data.append(Operator.getOptNum());
			this.data.append(", \"optName\":");
			this.data.append("\"");
			this.data.append(Operator.getOptName());
			this.data.append("\"");
			this.data.append(", \"optGander\":");
			this.data.append("\"");
			this.data.append(Operator.getOptGender());
			this.data.append("\"");
			this.data.append(", \"optAge\":");
			this.data.append(Operator.getOptAge());
			this.data.append(", \"optSalary\":");
			this.data.append(Operator.getOptSalary());
			this.data.append("},");
		}
		this.data.deleteCharAt(this.data.length()-1);
		this.data.append("]");
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public OperatorJson(String msg, List<OperatorVo> data, int code, int count) {
		super();
		this.msg = msg;
		this.data=new StringBuffer("");
		this.data.append("[");
		for(Operator Operator:data) {
			this.data.append("{\"OptNum\":");
			this.data.append(Operator.getOptNum());
			this.data.append(", \"OptName\":");
			this.data.append("\"");
			this.data.append(Operator.getOptName());
			this.data.append("\"");
			this.data.append(", \"OptGander\":");
			this.data.append("\"");
			this.data.append(Operator.getOptGender());
			this.data.append("\"");
			this.data.append(", \"OptAge\":");
			this.data.append(Operator.getOptAge());
			this.data.append(", \"OptSalary\":");
			this.data.append(Operator.getOptSalary());
			this.data.append("},");
		}
		this.data.deleteCharAt(this.data.length()-1);
		this.data.append("]");
		this.code = code;
		this.count = count;
	}
	
	public OperatorJson() {
		super();
	}
	
	@Override
	public String toString() {
		return "{\"code\":" + code  + ", \"msg\":" + msg + ", \"count\":" + count + ", \"data\":" + data + "}";
	}
}
