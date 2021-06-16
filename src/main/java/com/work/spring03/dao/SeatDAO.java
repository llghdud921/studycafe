package com.work.spring03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.work.spring03.controller.MemberController;
import com.work.spring03.dto.Member;
import com.work.spring03.dto.Seat;

@Repository
public class SeatDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/* spring di : setter injection */
	private FactoryDAODataSource factory;

	@Autowired
	public void setFactory(FactoryDAODataSource factory) {
		this.factory = factory;
	}

	private static SeatDAO instance = new SeatDAO();

	public static SeatDAO getInstance() {
		return instance;
	}

	public String seat_Check(int snum) {
		// TODO Auto-generated method stub
		String sql = "select SeatTF from seats where T_number=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("SeatTF");
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	public int seat_insert(int seatNum, String name, String gender) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update seats set Name = ?,Gender = ?,seatTF = ?,Use_Time = ?";
		sql += "where t_number=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, "T");
			pstmt.setInt(4, 0);
			pstmt.setInt(5, seatNum);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

	public ArrayList<Seat> selectSeatList() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Seat> list = new ArrayList<Seat>();
		String sql = "select t_number,gender,name,seatTF,use_time from seats";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Seat sdto = new Seat();
				sdto.setTnumber(rs.getInt("t_number"));
				sdto.setGender(rs.getString("gender"));
				sdto.setName(rs.getString("name"));
				sdto.setSeatTF(rs.getString("seatTF"));
				sdto.setUseTime(rs.getInt("use_time"));

				list.add(sdto);
			}

			return list;

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	public int seat_out(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update seats set Name = ?,Gender = ?,seatTF = ?,Use_Time = ?";
		sql += "where t_number=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, null);
			pstmt.setString(2, null);
			pstmt.setString(3, "F");
			pstmt.setInt(4, 0);
			pstmt.setInt(5, num);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

	public int seat_numselect(String name) {
		// TODO Auto-generated method stub
		String sql = "select T_number from seats where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("T_number");
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return 0;

	}

	public String nameselect(int snum) {
		// TODO Auto-generated method stub
		String sql = "select name from seats where T_number=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("name");
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;

	}

}
