package org.inetsolv.service;

import java.util.List;

import org.inetsolv.domain.EmployeeInfoTbl;
import org.inetsolv.repository.Employee_Tbl_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Employee_Tbl_Service {
	@Autowired
	private Employee_Tbl_Repository employee_Tbl_Repository;

	public List<EmployeeInfoTbl> findEmployee(Integer empId) {

		List<EmployeeInfoTbl> findEmployee = employee_Tbl_Repository.findEmployee(empId);
		return findEmployee;

	}
}
