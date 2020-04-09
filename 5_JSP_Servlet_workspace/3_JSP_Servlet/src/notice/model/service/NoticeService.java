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
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Notice detailNotice(String no) {
		Connection conn = getConnection();
		
		Notice notice = null;
		int result = new NoticeDAO().updateCount(conn, no);
		if(result > 0) {
			notice = new NoticeDAO().detailNotice(conn, no);
			
			if(notice != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		
		close(conn);
		return notice;
	}

	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDAO().updateNotice(conn, n);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

}
