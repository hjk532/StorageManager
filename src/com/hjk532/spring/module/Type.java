package com.hjk532.spring.module;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class Type implements Serializable {
	private static final long serialVersionUID = 8249842708677408539L;
	Integer typeNum;
	String typeName;
	String typeDescrib;
	public Integer getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(Integer typeNum) {
		this.typeNum = typeNum;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDescrib() {
		return typeDescrib;
	}
	public void setTypeDescrib(String typeDescrib) {
		this.typeDescrib = typeDescrib;
	}
	@Override
	public String toString() {
		return "Type [typeNum=" + typeNum + ", typeName=" + typeName + ", typeDescrib=" + typeDescrib + "]";
	}
	
}
