package com.hjk532.spring.module;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class Users implements Serializable {
	private static final long serialVersionUID = -6049199405859512200L;
	Integer userId;
	Integer opId;
	String userAccount;
	String userPassword;
	Integer userAuthority;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOpId() {
		return opId;
	}

	public void setOpId(Integer opId) {
		this.opId = opId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(Integer userAuthority) {
		this.userAuthority = userAuthority;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", opId=" + opId + ", userAccount=" + userAccount + ", userPassword="
				+ userPassword + ", userAuthority=" + userAuthority + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Users) {
			Users user=(Users)obj;
			if(user.getOpId()==this.opId &&
					user.getUserAccount().equals(this.userAccount) &&
					user.getUserAuthority()==this.userAuthority && 
					user.getUserPassword().equals(this.userPassword) &&
					user.getUserId()==this.userId
					)return true;
		}
		return false;
	}
}
