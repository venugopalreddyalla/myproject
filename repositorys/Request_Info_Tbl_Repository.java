package org.inetsolv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.inetsolv.domain.RequestInfoTbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class Request_Info_Tbl_Repository extends JdbcDaoSupport {

	@Autowired
	public Request_Info_Tbl_Repository(DataSource dataSource) {
		setDataSource(dataSource);
	}

	public RequestInfoTbl saveRequestInfo(RequestInfoTbl requestInfo) {
		String sql = "insert into REQUEST_INFO_TBL VALUES(?,?,?,?)";
		getJdbcTemplate().update(sql, requestInfo.getRowNum(), requestInfo.getRequestId(), requestInfo.getRequestInfo(),
				requestInfo.getDateInfo());
		return requestInfo;
	}

	public List<RequestInfoTbl> getAllRequestInfo(Integer requestId) {

		String sql = "select *from REQUEST_INFO_TBL where REQUEST_ID="+requestId+" order by date_info desc";
		List<RequestInfoTbl> list = getJdbcTemplate().query(sql, new RowMapper<RequestInfoTbl>() {

			public RequestInfoTbl mapRow(ResultSet rs, int rowNum) throws SQLException {

				RequestInfoTbl requestInfoTbl = new RequestInfoTbl();
				requestInfoTbl.setRowNum(rs.getInt("ROW_NUM"));
				requestInfoTbl.setRequestId(rs.getInt("REQUEST_ID"));
				requestInfoTbl.setRequestInfo(rs.getString("REQUEST_INFO"));
				requestInfoTbl.setDateInfo(rs.getTimestamp("DATE_INFO"));
				return requestInfoTbl;

			}

		}

		);

		return list;
	}

}
