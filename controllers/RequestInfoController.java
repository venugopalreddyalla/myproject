package org.inetsolv.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.inetsolv.domain.RequestId;
import org.inetsolv.domain.RequestInfoTbl;
import org.inetsolv.domain.RequestTbl;
import org.inetsolv.service.Request_Info_Tbl_Service;
import org.inetsolv.service.Request_Tbl_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestInfoController {
	
	@Autowired
	private Request_Info_Tbl_Service request_Info_Tbl_Service;
	@Autowired
	private Request_Tbl_Service request_Tbl_Service;
	

	@RequestMapping(path="/requeststatus",method=RequestMethod.POST)
	public String getRequestStatus(@Validated RequestId requestId,Errors errors,HttpServletRequest httpServletRequest) {
		if(errors.hasErrors())
			return "statuslogin";
			
		List<RequestTbl> processingStatus = request_Tbl_Service.getSingleRequest(requestId.getReqId());
		if(processingStatus.size()==0)
			processingStatus=null;
		List<RequestInfoTbl> completedStatus = request_Info_Tbl_Service.getAllRequestInfo(requestId);
		if(completedStatus.size()==0)
			completedStatus=null;
		httpServletRequest.setAttribute("processingStatus", processingStatus);
		httpServletRequest.setAttribute("completedStatus", completedStatus);
		return "requeststatus";
	}
}
