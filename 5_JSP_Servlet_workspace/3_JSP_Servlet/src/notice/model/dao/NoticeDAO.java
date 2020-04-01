package notice.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import notice.model.vo.Notice;

public class NoticeDAO {
	
	private Properties prop = new Properties();
	
	public NoticeDAO() {
		String fileName = NoticeDAO.class.getResource("/sql/notice/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public ArrayList<Notice> selectList(Connection conn){
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		Notice notice = null;
		
		String query = prop.getProperty("selectList");
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
//			select만 query 
			
			while(rset.next()) {
				notice = new Notice(rset.getInt("NNO"),
									rset.getString("NTITLE"),
									rset.getString("NCONTENT"),
									rset.getString("NWRITER"),
									rset.getInt("NCOUNT"),
									rset.getDate("NDATE"));
				list.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}


	public int insertNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNotice");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, n.getnTitle());
			pstmt.setString(2, n.getnContent());
			pstmt.setString(3, n.getnWriter());
			pstmt.setDate(4, n.getnDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public Notice noticeDetail(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Notice notice = null;
		
		String query = prop.getProperty("detailNotice");
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice(rset.getString("ntitle"),
									rset.getString("nwriter"),
									rset.getString("ncontent"),
									rset.getDate("ndate"));
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return notice;
		
	}


	public int noticeUpdate(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("noticeUpdate");
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, n.getnTitle());
			pstmt.setDate(2, n.getnDate());
			pstmt.setString(3, n.getnContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
