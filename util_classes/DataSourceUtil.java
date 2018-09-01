package org.inetsolv.util;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceUtil {

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		driverManagerDataSource.setUsername("venu");
		driverManagerDataSource.setPassword("reddy1996");
		return driverManagerDataSource;
	}

}
