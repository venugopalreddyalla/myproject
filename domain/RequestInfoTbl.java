package org.inetsolv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RequestInfoTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer rowNum;
	@NotNull
	private Integer requestId;
	@NotBlank(message="Request Info Must Not Be Blank...")
	@Pattern(regexp = "[a-zA-Z]", message = "Request Must Be A Letters...")
	private String requestInfo;
	private Timestamp dateInfo;
	
	

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public RequestInfoTbl() {
	}

	public Timestamp getDateInfo() {
		return this.dateInfo;
	}

	public void setDateInfo(Timestamp dateInfo) {
		this.dateInfo = dateInfo;
	}

	public String getRequestInfo() {
		return this.requestInfo;
	}

	public void setRequestInfo(String requestInfo) {
		this.requestInfo = requestInfo;
	}

	public Integer getRowNum() {
		return this.rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

}