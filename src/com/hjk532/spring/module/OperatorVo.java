package com.hjk532.spring.module;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
@Repository
public class OperatorVo extends Operator implements Serializable{
	private static final long serialVersionUID = -835025631629968047L;
	public Operator getOperator() {
		return (Operator)this;
	}
}
