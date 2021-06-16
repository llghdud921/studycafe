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
import com.work.spring03.controller.TicketController;

@Repository
public class TicketDAO {

	/* spring di : setter injection */
	private FactoryDAODataSource factory;
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

	@Autowired
	public void setFactory(FactoryDAODataSource factory) {
		this.factory = factory;
	}

	private static TicketDAO instance = new TicketDAO();

	public static TicketDAO getInstance() {
		return instance;
	}

	public TicketDAO() {
	}

	// 총 결제 금액
	public int payCheck(int money) {
		String sql = "select U_Money from utilmanager";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("U_Money");
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return 0;
	}

	// 총 결제 금액
	public int payroomCheck(int money) {
		String sql = "select U_Money from utilmanager";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("U_Money");
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return 0;
	}

	/* util manager 테이블 좌석 정보 업데이트 */
	public int ticket_update(String name, String time) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update utilmanager set Name = ?,R_time = ?";
		sql += "where t_number=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, time);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
}
