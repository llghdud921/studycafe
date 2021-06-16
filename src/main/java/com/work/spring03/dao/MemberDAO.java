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
import com.work.spring03.exception.AuthenticationException;

@Repository
public class MemberDAO {
	/* spring di : setter injection */
	private FactoryDAODataSource factory;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	public void setFactory(FactoryDAODataSource factory) {
		this.factory = factory;
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	// 기본 생성자
	private MemberDAO() {
	}

	// 로그인
	public Member loginCheck(String email, String password) throws AuthenticationException {
		String sql = "select name,gender,use,R_time from members where email=? and password=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString("name"), rs.getString("gender"), rs.getInt("use"), rs.getInt("R_time"));
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}  finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	// 회원가입
	public int insert(Member dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into members(Email,Password,Name,Phone,R_Time,Gender,Use,S_Time) values(?,?,?,?,?,?,?,?) ";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setInt(5, dto.getRTime());
			pstmt.setString(6, dto.getGender());
			pstmt.setInt(7, dto.getUse());
			pstmt.setInt(8, dto.getSTime());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

	// 내정보조회
	public Member myinfo(String email) {
		String sql = "select * from members where email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			String name = null;
			String phone = null;
			String password = null;
			if (rs.next()) {
				name = rs.getString("name");
				phone = rs.getString("phone");
				password = rs.getString("password");
				return new Member(email, password, name, phone);
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}

		return null;
	}

	// 번호로 이메일 찾기
	public String searchidCheck(String name, String phone) {
		String sql = "select email from members where name=? and phone=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); // 물음표에 들어가는 것은 setString
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("email"); // rs는 와서 서비스로 간다
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	// 이메일,번호로 패스워드 찾기
	public String searchpwCheck(String name, String email, String phone) {
		String sql = "select password from members where name=? and email=? and phone=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); // 물음표에 들어가는 것은 setString
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("password"); // rs는 와서 서비스로 간다
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	// 아이디 중복확인
	public boolean selectUserid(String userid) {
		String sql = "select name from members where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	// 사용중 표시
	public void member_seat(String name, int use) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update members set use=? ";
		sql += "where name=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, use);
			pstmt.setString(2, name);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}

	}

	// 사용 확인
	public int user_seat(String name) {
		// TODO Auto-generated method stub
		String sql = "select use from members where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				if (rs.getInt("use") == 1)
					return 1;
				return 0;
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return 0;
	}

	// 잔여시간 확인
	public int user_Rtime(String name) {
		// TODO Auto-generated method stub
		String sql = "select R_time from members where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("R_time");
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return 0;
	}

	/* members 테이블 좌석 정보 업데이트 */
	public int memberTicket_update(String name, int time) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update members set R_time = ?";
		sql += "where name=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, time);
			pstmt.setString(2, name);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

	// 미사용 처리
	public void member_seat_out(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update members set use=? ";
		sql += "where name=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, 0);
			pstmt.setString(2, name);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}

	}

	// 잔여시간 입력
	public void user_Rtime_insert(String name, int rtime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update members set R_time=? ";
		sql += "where name=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, rtime);
			pstmt.setString(2, name);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
	}

	// 누적시간 조회
	public int user_STime(String name) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "select S_time from members where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("S_time");
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return 0;
	}

	// 누적시간 입력
	public void user_Stime_update(String name, int stime) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update members set S_time=? ";
		sql += "where name=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, stime);
			pstmt.setString(2, name);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}

	}

	/* 내 정보 수정 */
	public int update(Member dto, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update members set name=?, password=?, phone=? where email=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, email);

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	/** 아이디(이메일) 중복 확인 */
	public boolean idcheck(String email) {
		String sql = "select * from members where email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean idcheck = true;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			String name = null;
			String phone = null;
			String password = null;
			if (rs.next()) {
				idcheck = false;
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}

		return idcheck;
	}

	// 멤버리스트 받아오기 - 사용중, 미사용 구분
	public ArrayList<Member> selectMemberList(int i) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select name, R_time, phone from members where use=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member dto = new Member();
				dto.setName(rs.getString("name"));
				dto.setRTime(rs.getInt("R_time"));
				dto.setPhone(rs.getString("phone"));

				list.add(dto);
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

	// 멤버리스트 받아오기
	public ArrayList<Member> selectMemberwholeList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select name, R_time, phone from members";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member dto = new Member();
				dto.setName(rs.getString("name"));
				dto.setRTime(rs.getInt("R_time"));
				dto.setPhone(rs.getString("phone"));

				list.add(dto);
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

	// 세부내역 조회
	public Member selectMemberdetail(String name) {
		// TODO Auto-generated method stub
		String sql = "select email,gender,phone,R_time,s_time from members where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return new Member(rs.getString("email"), rs.getString("gender"), name, rs.getString("phone"),
						rs.getInt("R_time"), rs.getInt("s_time"));
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}

		return null;
	}

	// 이름으로 성별
	public String seat_genderselect(String name) {
		// TODO Auto-generated method stub
		String sql = "select gender from members where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getString("gender");
			}
		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}

		return null;
	}

	// 회원 탈퇴
	public int delete(Member dto, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from members where email=?";

		try {
			conn = factory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

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
