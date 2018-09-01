package org.inetsolv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.inetsolv.domain.EmployeeInfoTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class Employee_Tbl_Repository extends JdbcDaoSupport {

	@Autowired
	public Employee_Tbl_Repository(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public List<EmployeeInfoTbl> findEmployee(Integer empId) {

		String sql = "select * from EMPLOYEE_INFO_TBL WHERE EMPLOYEE_ID="+empId;

		return getJdbcTemplate().query(sql, new RowMapper<EmployeeInfoTbl>() {

			public EmployeeInfoTbl mapRow(ResultSet rs, int rowNum) throws SQLException {

				EmployeeInfoTbl employeeInfoTbl = new EmployeeInfoTbl();
				employeeInfoTbl.setUserId(rs.getInt(1));
				employeeInfoTbl.setName(rs.getString(2));
				return employeeInfoTbl;
			}

		});

	}

}
