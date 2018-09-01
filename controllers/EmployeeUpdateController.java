package org.inetsolv.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.inetsolv.domain.EmployeeInfoTbl;
import org.inetsolv.domain.RequestId;
import org.inetsolv.domain.RequestInfoTbl;
import org.inetsolv.domain.RequestStatus;
import org.inetsolv.domain.RequestTbl;
import org.inetsolv.service.Employee_Tbl_Service;
import org.inetsolv.service.Request_Info_Tbl_Service;
import org.inetsolv.service.Request_Tbl_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeUpdateController {
	@Autowired
	private Employee_Tbl_Service employee_Tbl_Service;
	@Autowired
	private Request_Tbl_Service request_Tbl_Service;
	@Autowired
	private Request_Info_Tbl_Service request_Info_Tbl_Service;

	@RequestMapping(path = "/employee", method = RequestMethod.GET)
	public String employeePage(Model model) {
		model.addAttribute("employeeInfoTbl", new EmployeeInfoTbl());
		return "employeepage";
	}

	@RequestMapping(path = "/requestdeatils", method = RequestMethod.POST)
	public String requestDetails(@Validated EmployeeInfoTbl employeeInfoTbl, Errors errors, Model model) {

		if (errors.hasErrors()) {
			return "employeepage";
		}
		List<EmployeeInfoTbl> findEmployee = employee_Tbl_Service.findEmployee(employeeInfoTbl.getUserId());

		if (findEmployee.size() == 0) {
			errors.rejectValue("userId", "402", "Please Enter A Valid User Id...");
			return "employeepage";

		} else {
			List<RequestTbl> allRequests = request_Tbl_Service.getAllRequests();
			model.addAttribute("allRequests", allRequests);
			model.addAttribute("requestId", new RequestId());

			return "requestdeatils";
		}
	}

	@RequestMapping(path = "/updaterequest", method = RequestMethod.POST)
	public String updateRequest(@Validated RequestId requestId, Errors errors, Model model) {

		List<RequestTbl> request = request_Tbl_Service.getSingleRequest(requestId.getReqId());

		List<RequestInfoTbl> allRequestInfo = request_Info_Tbl_Service.getAllRequestInfo(requestId);

		model.addAttribute("request", request);
		model.addAttribute("allRequestInfo", allRequestInfo);

		model.addAttribute("requestStatus", new RequestStatus());

		if (request.size() == 0) {
			errors.rejectValue("reqId", "402", "Please Enter A Valid User Id...");
			List<RequestTbl> allRequests = request_Tbl_Service.getAllRequests();
			model.addAttribute("allRequests", allRequests);
			return "requestdeatils";
		}

		return "updaterequest";
	}

	@RequestMapping(path = "/afterupdate", method = { RequestMethod.POST })
	public String afterUpdate(@Validated RequestStatus requestStatus, Errors errors, Model model,
			HttpServletRequest httpServletRequest) {

		if (errors.hasErrors()) {
			List<RequestTbl> allRequests = request_Tbl_Service.getAllRequests();
			model.addAttribute("allRequests", allRequests);
			model.addAttribute("requestId", new RequestId());
			errors.rejectValue("requestId", "402", "Please Enter A Valid User Id...");
			return "requestdeatils";
		}

		Calendar calendar = Calendar.getInstance(httpServletRequest.getLocale());
		Timestamp date = new Timestamp(calendar.getTimeInMillis());

		List<RequestTbl> singleRequest = request_Tbl_Service.getSingleRequest(requestStatus.getRequestId());

		if (singleRequest.size() == 0) {
			List<RequestTbl> allRequests = request_Tbl_Service.getAllRequests();
			model.addAttribute("allRequests", allRequests);
			model.addAttribute("requestId", new RequestId());
			errors.rejectValue("requestId", "402", "Please Enter A Valid User Id...");
			return "requestdeatils";
		}
		for (RequestTbl requestTbl : singleRequest) {
			RequestInfoTbl requestInfoTbl = new RequestInfoTbl();
			requestInfoTbl.setRequestId(requestStatus.getRequestId());
			requestInfoTbl.setRequestInfo(requestTbl.getRequestInfo());
			requestInfoTbl.setDateInfo(requestTbl.getDate());
			request_Info_Tbl_Service.saveRequestInfo(requestInfoTbl);
			requestTbl.setDate(date);
			requestTbl.setRequestInfo(requestStatus.getPresntStatus());
			request_Tbl_Service.updateRecord(requestTbl);
		}
		RequestInfoTbl requestInfoTbl = new RequestInfoTbl();
		requestInfoTbl.setDateInfo(date);
		requestInfoTbl.setRequestId(requestStatus.getRequestId());
		requestInfoTbl.setRequestInfo(requestStatus.getCompletedStatus());

		request_Info_Tbl_Service.saveRequestInfo(requestInfoTbl);

		return "afterupdate";
	}

}
