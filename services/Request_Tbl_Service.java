package org.inetsolv.service;

import java.util.List;

import org.inetsolv.domain.RequestTbl;
import org.inetsolv.repository.Request_Tbl_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Request_Tbl_Service {

	@Autowired
	private Request_Tbl_Repository request_Tbl_Repository;
	private Integer requestId = 1111;

	public RequestTbl requestTbl(RequestTbl requestTbl) {

		requestTbl.setRequestId(requestId);

		RequestTbl requestTbl2 = request_Tbl_Repository.requestTbl(requestTbl);
		requestId++;
		return requestTbl2;
	}

	public List<RequestTbl> getAllRequests() {

		List<RequestTbl> allRequests = request_Tbl_Repository.getAllRequests();
		return allRequests;
	}

	public List<RequestTbl> getSingleRequest(Integer requestId) {

		return request_Tbl_Repository.getSingleRequest(requestId);
	}
	
	public void updateRecord(RequestTbl requestTbl) {
		request_Tbl_Repository.updateRecord(requestTbl);
	}

}
