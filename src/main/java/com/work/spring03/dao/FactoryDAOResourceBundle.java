package com.work.spring03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class FactoryDAOResourceBundle {
	private ResourceBundle resource;
	
	public FactoryDAOResourceBundle() {
		resource = ResourceBundle.getBundle("dbserver");
		
		try {
			Class.forName(resource.getString("driver"));
		} catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(resource.getString("url"), resource.getString("username"), resource.getString("password"));
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
