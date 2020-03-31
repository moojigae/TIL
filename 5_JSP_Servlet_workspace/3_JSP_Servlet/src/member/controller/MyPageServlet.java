package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/myPage.me")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 내 정보를 가지고 화면에 뿌리는 경우 정보 수정 후 db에 수정하는 데이터를 넣은 경우
		// 화면에는 세션의 정보가 뿌려지기 때문에 db에 수정된 내용이 화면에는 보이지 않는 문제점이 있음
		HttpSession session = request.getSession();
		Member sessionMember = (Member)session.getAttribute("loginUser");
		String loginUserId = sessionMember.getUserId();
		
		Member member = new MemberService().selectMember(loginUserId);
		
		String page = null;
		if(member != null) {
			page = "views/member/memberView.jsp";
			request.setAttribute("member", member);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원조회에 실패했습니다");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
