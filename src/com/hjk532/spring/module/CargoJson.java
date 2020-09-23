package com.hjk532.spring.module;

import java.io.Serializable;
import java.util.List;

public class CargoJson  implements Serializable{
	
	private static final long serialVersionUID = -1191350370807140977L;
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
	
	public void setData(List<Cargo> data) {
		this.data.append("[");
		for(Cargo cargo:data) {
			this.data.append("{\"orderId\":");
			this.data.append(cargo.getOrderId());
			this.data.append(", \"cargoName\":");
			this.data.append("\"");
			this.data.append(cargo.getCargoName());
			this.data.append("\"");
			this.data.append(", \"cargoAmount\":");
			this.data.append(cargo.getCargoAmount());
			this.data.append(", \"oNum\":");
			this.data.append(cargo.getoNum());
			this.data.append(", \"tNum\":");
			this.data.append(cargo.gettNum());
			this.data.append(", \"productDate\":");
			this.data.append("\"");
			this.data.append(cargo.getProductDate());
			this.data.append("\"");
			this.data.append(", \"lastOptime\":");
			this.data.append("\"");
			this.data.append(cargo.getLastOptime());
			this.data.append("\"");
			this.data.append("}");
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
	public CargoJson(String msg, List<CargoVo> data, int code, int count) {
		super();
		this.msg = msg;
		this.data=new StringBuffer("");
		this.data.append("[");
		for(Cargo cargo:data) {
			this.data.append("{\"orderId\":");
			this.data.append(cargo.getOrderId());
			this.data.append(", \"cargoName\":");
			this.data.append("\"");
			this.data.append(cargo.getCargoName());
			this.data.append("\"");
			this.data.append(", \"cargoAmount\":");
			this.data.append(cargo.getCargoAmount());
			this.data.append(", \"oNum\":");
			this.data.append(cargo.getoNum());
			this.data.append(", \"tNum\":");
			this.data.append(cargo.gettNum());
			this.data.append(", \"productDate\":");
			this.data.append("\"");
			this.data.append(cargo.getProductDate());
			this.data.append("\"");
			this.data.append(", \"lastOptime\":");
			this.data.append("\"");
			this.data.append(cargo.getLastOptime());
			this.data.append("\"");
			this.data.append("},");
		}
		this.data.deleteCharAt(this.data.length()-1);
		this.data.append("]");
		this.code = code;
		this.count = count;
	}
	
	public CargoJson() {
		super();
	}
	
	@Override
	public String toString() {
		return "{\"code\":" + code  + ", \"msg\":" + msg + ", \"count\":" + count + ", \"data\":" + data + "}";
	}
	
}
