package org.inetsolv.controller;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.inetsolv.domain.RequestId;
import org.inetsolv.domain.RequestTbl;
import org.inetsolv.service.Request_Tbl_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestController {

	@Autowired
	private Request_Tbl_Service request_Tbl_Service;

	@RequestMapping(path = "/beforesubmit", method = RequestMethod.GET)
	public String requestLogin(Model model) {
		model.addAttribute("requestTbl", new RequestTbl());
		model.addAttribute("requestId", new RequestId());
		
		return "requestlogin";
	}
	
	@RequestMapping(path = "/statuslogin", method = RequestMethod.GET)
	public String statusLogin(Model model) {

		model.addAttribute("requestId", new RequestId());
		return "statuslogin";
	}

	@RequestMapping(path = "/aftersubmit", method = RequestMethod.POST)
	public String requestaftersubmit(@Validated RequestTbl requestTbl, Errors errors, HttpServletRequest request) {

		if (errors.hasErrors()) {
			return "requestlogin";
		}
		Calendar calendar = Calendar.getInstance(request.getLocale());
		requestTbl.setDate(new Timestamp(calendar.getTimeInMillis()));
		request_Tbl_Service.requestTbl(requestTbl);

		return "aftersubmit";
	}

}
