package com.hjk532.spring.module;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class TypeJson implements Serializable{

	private static final long serialVersionUID = -3604336509975051223L;
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
	
	public void setData(List<Type> data) {
		this.data.append("[");
		for(Type Type:data) {
			this.data.append("{\"typeNum\":");
			this.data.append(Type.getTypeNum());
			this.data.append(", \"typeName\":");
			this.data.append(Type.getTypeName());
			this.data.append(", \"typeDescrib\":");
			this.data.append("\"");
			this.data.append(Type.getTypeDescrib());
			this.data.append("\"");
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
	public TypeJson(String msg, List<TypeVo> data, int code, int count) {
		super();
		this.msg = msg;
		this.data=new StringBuffer("");
		this.data.append("[");
		for(Type Type:data) {
			this.data.append("{\"typeNum\":");
			this.data.append(Type.getTypeNum());
			this.data.append(", \"typeName\":");
			this.data.append(Type.getTypeName());
			this.data.append(", \"typeDescrib\":");
			this.data.append("\"");
			this.data.append(Type.getTypeDescrib());
			this.data.append("\"");
			this.data.append("},");
		}
		this.data.deleteCharAt(this.data.length()-1);
		this.data.append("]");
		this.code = code;
		this.count = count;
	}
	
	public TypeJson() {
		super();
	}
	
	@Override
	public String toString() {
		return "{\"code\":" + code  + ", \"msg\":" + msg + ", \"count\":" + count + ", \"data\":" + data + "}";
	}
	
}
