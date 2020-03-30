package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDAO {
	private Properties prop = new Properties();
	
	public MemberDAO() {
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(Member m, Connection conn) {
		/*
		 * query : 
		 * 		select *
		 * 		from member
		 * 		where  userId = ? and userPwd = ?
		 * */
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			
			rset = pstmt.executeQuery(); // rset은 무조건 0~1개 담겨져 있음 
			if(rset.next()) {
				loginUser = new Member(rset.getString("user_Id"),
										rset.getString("user_pwd"),
										rset.getString("user_name"),
										rset.getString("nickName"),
										rset.getString("phone"),
										rset.getString("email"),
										rset.getString("address"),
										rset.getString("interest"),
										rset.getDate("enroll_date"),
										rset.getDate("modify_date"),
										rset.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getNickName());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getAddress());
			pstmt.setString(8, m.getInterest());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
}


