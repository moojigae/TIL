package member.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member m) {
		Connection conn = getConnection();
		
		Member loginUser = new MemberDAO().loginMember(m, conn);
		close(conn);
		
		return loginUser;
	}

	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDAO().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int idCheck(String userId) {
		Connection conn = getConnection();
		
		int result = new MemberDAO().idCheck(conn, userId);
		close(conn); // commit이나 rollback할게 없기 때문에 바로 connection 닫아줌
		return result;
		
	}

	public Member selectMember(String loginUserId) {
		Connection conn = getConnection();
		
		Member member = new MemberDAO().selectMember(conn, loginUserId);
		close(conn);
		return member;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updateMember(conn, member);
		
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
