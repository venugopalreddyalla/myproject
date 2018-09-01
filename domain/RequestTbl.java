package org.inetsolv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class RequestTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	private long requestId;

	@NotBlank(message = "Name Must Not Be Blank...")
	@Pattern(regexp = "[a-zA-Z ]*")
	private String name;

	@NotNull(message = "Mobile Num Must Not Be Null...")
	@Min(value=1000000000,message="Invalid Mobile Number... Num Min 10dig")
	@Max(value = 99999999999999l, message = "Invalid Mobile Number...")
	private Long mobileNum;

	@NotBlank(message = "Request Info Must Not Be Blank...")
	@Pattern(regexp = "[a-zA-Z .]*", message = "Request Must Be In Between A-Z Letters Only...")
	private String requestInfo;

	private Timestamp date;

	public RequestTbl() {
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}