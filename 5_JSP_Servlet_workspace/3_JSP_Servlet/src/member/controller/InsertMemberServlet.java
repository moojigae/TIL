package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet(urlPatterns = "/insert.me", name = "InsertMemberServlet")
// "/insert.me" 하나만 있을 때는 urlPatterns 생략이 가능 했지만 name을 넣어서
// 들어가는 이름으로 맵핑시키기 때문에 urlPatterns와 name이 꼭 들어가야한다
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("joinUserId");
		String userPwd = request.getParameter("joinUserPwd");
		String checkPwd = request.getParameter("joinUserPwd2");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interest = request.getParameterValues("interest");
		
		String interests = String.join(", ", interest);
		Member m = new Member(userId,userPwd,userName,nickName,phone,email,address,interests ,null,null,null);
	
//		System.out.println(m);
		
		int result = new MemberService().insertMember(m);
		
		String page="";
		String msg="";
		if(result > 0) {
			page = "/";
			msg = "회원가입에 성공했습니다.";
//			request.setAttribute("msg", "회원가입에 성공했습니다.");
//			
//			RequestDispatcher view = request.getRequestDispatcher(request.getContextPath());
//			
//			view.forward(request, response);
		} else {
			page = "views/common/errorPage.jsp";
			msg = "회원가입에 실패했습니다";
//			request.setAttribute("msg", "회원가입에 실패했습니다.");
//			RequestDispatcher view = request.getRequestDispatcher("views/comon/errorPage.jsp");
//			view.forward(request, response);
		}
		
		request.setAttribute("msg", msg);
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
