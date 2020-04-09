package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.Reply;

public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new BoardDAO().getListCount(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Board> selectList(int currentPage, int boardLimit) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDAO().selectList(conn, currentPage, boardLimit);
		
		close(conn);
		
		return list;
	}

	public int insertBoard(Board board) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Board detailBoard(String bid) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateCount(conn, bid);
		
		Board board = null;
		if(result > 0) {
			board = new BoardDAO().detailBoard(conn, bid);
			
			if(board != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}
		close(conn);
		return board;
	}

	public int updateBoard(Board b) {
		Connection conn = getConnection();
		
		int result = new BoardDAO().updateBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList selectTList(int i) {
		Connection conn = getConnection();
		
		ArrayList list = null;
		BoardDAO dao = new BoardDAO();
		
		if(i==1) {
			list=dao.selectBList(conn);
		} else {
			list= dao.selectFList(conn);
		}
		
		close(conn);
		
		return list;
	}

	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		BoardDAO dao = new BoardDAO();
		
		int result1 = dao.insertThBoard(conn, b);
		int result2 = dao.insertAttachMent(conn, fileList);
		
		if(result1 > 0 && result2 >0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1;
	}

	public ArrayList<Attachment> selectThumbnail(String bid) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = new BoardDAO().selectThumbnail(conn, bid);
		
		close(conn);
		return list;
	}

	public ArrayList<Reply> selectReplyList(String bid) {
		Connection conn = getConnection();
		ArrayList<Reply> list = new BoardDAO().selectReplyList(conn, bid);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Reply> insertReply(Reply r) {
		Connection conn = getConnection();
		BoardDAO bDAO = new BoardDAO();
		
		int result = bDAO.insertReply(conn, r);
		ArrayList<Reply> rList = null;
		
		if(result >0) {
			commit(conn);
			rList = bDAO.selectReplyList(conn, String.valueOf(r.getRefBid()));
		} else {
			rollback(conn);
		}
		
		return rList;
	}

}
