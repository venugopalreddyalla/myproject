package org.inetsolv.domain;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class EmployeeInfoTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	@NotNull
	@Min(value=1000,message="Please Enter Correct Employee Id...")
	@Max(value=9999,message="Please Enter Correct Employee Id...")
	private Integer userId;

	public EmployeeInfoTbl() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

}