package org.inetsolv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.inetsolv.domain.RequestTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class Request_Tbl_Repository extends JdbcDaoSupport {

	@Autowired
	public Request_Tbl_Repository(DataSource dataSource) {

		setDataSource(dataSource);

	}

	public RequestTbl requestTbl(RequestTbl requestTbl) {
		String sql = "insert into REQUEST_TBL VALUES(?,?,?,?,?)";
		getJdbcTemplate().update(sql, requestTbl.getRequestId(), requestTbl.getName(), requestTbl.getMobileNum(),
				requestTbl.getRequestInfo(), requestTbl.getDate());
		return requestTbl;
	}

	public List<RequestTbl> getAllRequests() {
		String sql = "select *from REQUEST_TBL";

		return getJdbcTemplate().query(sql, new RowMapper<RequestTbl>() {

			public RequestTbl mapRow(ResultSet rs, int rowNum) throws SQLException {
				RequestTbl requestTbl = new RequestTbl();
				requestTbl.setRequestId(rs.getInt("REQUEST_ID"));
				requestTbl.setName(rs.getString("REQUEST_NAME"));
				requestTbl.setMobileNum(rs.getLong("MOBILE_NUM"));
				requestTbl.setRequestInfo(rs.getString("REQUEST_INFO"));
				requestTbl.setDate(rs.getTimestamp("DATE_INFO"));

				return requestTbl;
			}

		});

	}

	public List<RequestTbl> getSingleRequest(Integer requestId) {

		String sql = "select *from REQUEST_TBL WHERE REQUEST_ID =" + requestId;

		return getJdbcTemplate().query(sql, new RowMapper<RequestTbl>() {

			public RequestTbl mapRow(ResultSet rs, int rowNum) throws SQLException {

				RequestTbl requestTbl = new RequestTbl();
				requestTbl.setRequestId(rs.getInt("REQUEST_ID"));
				requestTbl.setRequestInfo(rs.getString("REQUEST_INFO"));
				requestTbl.setDate(rs.getTimestamp("DATE_INFO"));
				return requestTbl;
			}

		});

	}

	public void updateRecord(RequestTbl requestTbl) {
		String sql = "update REQUEST_TBL set REQUEST_INFO=? ,DATE_INFO=? where REQUEST_ID=?";
		getJdbcTemplate().update(sql, requestTbl.getRequestInfo(), requestTbl.getDate(),requestTbl.getRequestId());
		
	}

}
