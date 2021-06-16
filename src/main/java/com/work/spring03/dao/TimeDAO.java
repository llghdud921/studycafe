package com.work.spring03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.work.spring03.controller.TicketController;
import com.work.spring03.dto.Seat;
import com.work.spring03.dto.Time;
import com.work.spring03.dto.memberjoin;

@Repository
public class TimeDAO {
	
	 /* spring di : setter injection */
	   private FactoryDAODataSource factory;
	   private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	   
	   @Autowired
	   public void setFactory(FactoryDAODataSource factory) {
	      this.factory = factory;
	   }
	   
	   private static TimeDAO instance = new TimeDAO();
	   
	   public static TimeDAO getInstance() {
	      return instance;
	   }
	   
	   public TimeDAO() {}

	public void timeinsertIn(String date,String time,String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into times(tid,day,in_time,name) values(t_ID.NEXTVAL,?,?,?) ";
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,date);
			pstmt.setString(2,time);
			pstmt.setString(3,name);
			
			 pstmt.executeUpdate(); 
			
		} catch(SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		
	}

	public void timeinsertout(String nowTime, String name,String useTime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update times set out_time=?, use_time=? where tid =(select Max(tid) from times where name=?)";
		
		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,nowTime);
			pstmt.setString(2,useTime);
			pstmt.setString(3,name);

			 pstmt.executeUpdate(); 
			
		} catch(SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		
	}

	public String intimeSelect(String name) {
		// TODO Auto-generated method stub
		String sql = "select in_time from times where tid= (select Max(tid) from times where name=?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString("in_time");
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public ArrayList<Time> selectMemberdetailList(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Time> list = new ArrayList<Time>();
		String sql = "select day, in_time, out_time, use_time from times where name=? order by tid";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				Time tdto = new Time();
				
				tdto.setDay(rs.getString("day"));
				tdto.setInTime(rs.getString("in_time"));
				tdto.setOutTime(rs.getString("out_time"));
				tdto.setUseTime(rs.getString("use_time"));
				
				list.add(tdto);
			}
			return list;

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}finally {
			factory.close(conn, pstmt,rs);
		}

		return null;
	}
	
	public ArrayList<memberjoin> selectticketList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<memberjoin> list = new ArrayList<memberjoin>();
		String sql = "select t.day,m.gender from times t, members m where t.name= m.name ";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				memberjoin jdto = new memberjoin();
				jdto.setDay(rs.getString("day"));
				jdto.setGender(rs.getString("gender"));
				
				list.add(jdto);
			}
			return list;

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}finally {
			factory.close(conn, pstmt,rs);
		}

		return null;
	}

}
