package com.hjk532.spring.module;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
@Repository
public class CargoVo extends Cargo implements Serializable{
	private static final long serialVersionUID = 6268628618126047431L;
	Operator operator;
	Type type;
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Cargo getCargo() {
		return (Cargo)this;
	}

}
