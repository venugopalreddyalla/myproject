package org.inetsolv.service;

import java.util.List;

import org.inetsolv.domain.RequestId;
import org.inetsolv.domain.RequestInfoTbl;
import org.inetsolv.repository.Request_Info_Tbl_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Request_Info_Tbl_Service {

	@Autowired
	private Request_Info_Tbl_Repository request_Info_Tbl_Repository;
	private Integer rowNum = 1;

	public RequestInfoTbl saveRequestInfo(RequestInfoTbl requestInfo) {

		requestInfo.setRowNum(rowNum);
		RequestInfoTbl saveRequestInfo = request_Info_Tbl_Repository.saveRequestInfo(requestInfo);
		rowNum++;
		return saveRequestInfo;
	}

	public List<RequestInfoTbl> getAllRequestInfo(RequestId requestId) {

		List<RequestInfoTbl> allReQuestInfo = request_Info_Tbl_Repository.getAllRequestInfo(requestId.getReqId());

		return allReQuestInfo;
	}

}
