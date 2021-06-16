package com.work.spring03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.work.spring03.controller.MemberController;

@Repository
public class FactoryDAODataSource {
	private DataSource ds;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// JDBC : javax.sql.DataSource
	public FactoryDAODataSource() {
		try {
			ds = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/Oracle");
			logger.info("### factory ds : " + ds);
		} catch(NamingException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close(Connection conn, Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
