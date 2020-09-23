package com.hjk532.spring.module;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
@Repository
public class TypeVo extends Type implements Serializable{
	private static final long serialVersionUID = 6083815962511892152L;

	public Type getType() {
		return (Type)this;
	}
}
