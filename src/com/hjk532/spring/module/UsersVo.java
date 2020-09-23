package com.hjk532.spring.module;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import jdk.nashorn.internal.objects.annotations.Getter;
@Repository
public class UsersVo extends Users implements Serializable {
	private static final long serialVersionUID = 1321391444239124550L;
	Operator operator;
    Users user=(Users)this;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    @Getter
    public Users getUsers() {
		return this.user;
	}
}
