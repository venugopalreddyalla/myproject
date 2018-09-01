package org.inetsolv.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RequestStatus {

	private String presntStatus;
	private String completedStatus;
	@NotNull
	@Min(value=1000,message="Invalid Request Id...")
	@Max(value=9999,message="Invalid Request Id...")
	private Integer requestId;
	
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public String getPresntStatus() {
		return presntStatus;
	}
	public void setPresntStatus(String presntStatus) {
		this.presntStatus = presntStatus;
	}
	public String getCompletedStatus() {
		return completedStatus;
	}
	public void setCompletedStatus(String completedStatus) {
		this.completedStatus = completedStatus;
	}
	
}
