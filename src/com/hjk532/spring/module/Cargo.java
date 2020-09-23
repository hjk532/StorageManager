package com.hjk532.spring.module;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Cargo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3877957376214036493L;
	Integer orderId;
	String cargoName;
	Integer cargoAmount;
	Integer oNum;
	Integer tNum;
	Date productDate;
	Date lastOptime;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer id) {
		orderId = id;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public Integer getCargoAmount() {
		return cargoAmount;
	}

	public void setCargoAmount(Integer cargoAmount) {
		this.cargoAmount = cargoAmount;
	}

	public Integer getoNum() {
		return oNum;
	}

	public void setoNum(Integer oNum) {
		this.oNum = oNum;
	}

	public Integer gettNum() {
		return tNum;
	}

	public void settNum(Integer tNum) {
		this.tNum = tNum;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Date getLastOptime() {
		return lastOptime;
	}

	public void setLastOpttime(Date lastOptime) {
		this.lastOptime = lastOptime;
	}

	@Override
	public String toString() {
		return "货单id=" + orderId + ", 货物名称=" + cargoName + ", 货物数量=" + cargoAmount + ", 操作员编号="
				+ oNum + ", 类型编号=" + tNum + ", 生产日期=" + productDate + ", 更新时间=" + lastOptime;
	}
	
}
