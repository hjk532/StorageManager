package com.hjk532.spring.module;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class UsersJson implements Serializable{

	private static final long serialVersionUID = 2731193690408983666L;
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
	
	public void setData(List<Users> data) {
		this.data.append("[");
		for(Users users:data) {
			this.data.append("{\"userId\":");
			this.data.append(users.getUserId());
			this.data.append(", \"opId\":");
			this.data.append("\"");
			this.data.append(users.getOpId());
			this.data.append("\"");
			this.data.append(", \"userAccount\":");
			this.data.append("\"");
			this.data.append(users.getUserAccount());
			this.data.append("\"");
			this.data.append(", \"userPassword\":");
			this.data.append(users.getUserPassword());
			this.data.append(", \"userAuthority\":");
			this.data.append(users.getUserAuthority());
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
	public UsersJson(String msg, List<UsersVo> data, int code, int count) {
		super();
		this.msg = msg;
		this.data=new StringBuffer("");
		this.data.append("[");
		for(Users users:data) {
			this.data.append("{\"userId\":");
			this.data.append(users.getUserId());
			this.data.append(", \"opId\":");
			this.data.append("\"");
			this.data.append(users.getOpId());
			this.data.append("\"");
			this.data.append(", \"userAccount\":");
			this.data.append("\"");
			this.data.append(users.getUserAccount());
			this.data.append("\"");
			this.data.append(", \"userPassword\":");
			this.data.append(users.getUserPassword());
			this.data.append(", \"userAuthority\":");
			this.data.append(users.getUserAuthority());
			this.data.append("},");
		}
		this.data.deleteCharAt(this.data.length()-1);
		this.data.append("]");
		this.code = code;
		this.count = count;
	}
	
	public UsersJson() {
		super();
	}
	
	@Override
	public String toString() {
		return "{\"code\":" + code  + ", \"msg\":" + msg + ", \"count\":" + count + ", \"data\":" + data + "}";
	}
	
}
