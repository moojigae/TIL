package notice.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {

	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDAO().selectList(conn);
		close(conn);
		
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDAO().insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Notice noticeDetail(String no) {
		Connection conn = getConnection();
		
		NoticeDAO nDAO = new NoticeDAO();
		
		int result = nDAO.updateCount(conn, no); // 조회수 업데이트 용
		
		Notice notice = null;
		if(result > 0) {
			notice = new NoticeDAO().noticeDetail(conn, no);
			
			if(notice != null) {
				commit(conn); // 조회수 업데이트에 관한 커밋
			} else { 
				rollback(conn);
			}
		}
		
		close(conn);
		return notice;
	}

	public int noticeUpdate(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDAO().noticeUpdate(conn, n);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}
