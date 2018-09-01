package org.inetsolv.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RequestId {

	@NotNull(message="Request Id Must Not Be Null...")
	@Min(value=1000,message="Request Id Must Be 4 Numbers....")
	@Max(value=9999,message="Request Id Must Be 4 Numbers....")
	private Integer reqId;

	public Integer getReqId() {
		return reqId;
	}

	public void setReqId(Integer requestId) {
		this.reqId = requestId;
	}
	
}
