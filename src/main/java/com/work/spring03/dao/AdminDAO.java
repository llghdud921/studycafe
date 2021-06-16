package com.work.spring03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.work.spring03.controller.MemberController;
import com.work.spring03.dto.Amember;
import com.work.spring03.dto.Member;

@Repository
public class AdminDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	/* spring di : setter injection */
	private FactoryDAODataSource factory;

	@Autowired
	public void setFactory(FactoryDAODataSource factory) {
		this.factory = factory;
	}

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	/**
	 * 기본생성자
	 */
	private AdminDAO() {
	}

	/**
	 * 로그인 인증
	 */
	public String loginCheck(String email, String password) {
		String sql = "select Name from amembers where Email=? and Password=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String n = rs.getString("Name");
				return n;
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	/** 관리자 회원가입 */
	   public int admin_insert(Amember dto) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      String sql = "insert into amembers(Email,Password,Name) values(?,?,?) ";
	      
	      try {
	         conn = factory.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1,dto.getEmail());
	         pstmt.setString(2,dto.getPassword());
	         pstmt.setString(3,dto.getName());
	         
	         return pstmt.executeUpdate(); 
	         
	      } catch(SQLException e) {
	         System.out.println("Error : " + e.getMessage());
	         e.printStackTrace();
	      } finally {
	         factory.close(conn, pstmt);
	      }
	      return 0;
	   }
}
