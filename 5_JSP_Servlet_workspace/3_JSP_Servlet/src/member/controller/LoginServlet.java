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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
	
		//System.out.println(userId + ", " + userPwd);
		
		Member m = new Member(userId,userPwd);
	
		Member loginUser = new MemberService().loginMember(m);
		
		if(loginUser != null) {
//			request는 한 번만 쓸 수 있기 때문에 틀린 코드
//			request.setAttribute("loginUser", loginUser);
//			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//			view.forward(request, response);
			
//			request에 로그인을 하는 것을 요청하기 때문에 로그인만 되고 request는 종료됨
//			로그인이 된 후 request가 종료된 상태에서 로그인 후 해야하는 작업이 필요한 경우 다시 로그인을 해야하는 상황이 발생
//			로그인 상태를 유지하기 위해 session에 담음
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(600);// 10분동안 session 유지
			
			
//			response.sendRedirect("index.jsp");
//			로그인을하면 index.jsp로 url이 나오는데 이 부분 수정을 위해 아래 코드를 넣으면 주소에 index.jsp 없어짐
			response.sendRedirect(request.getContextPath());
			
//			sendRedirect는 request의 데이터(request, response)를 담는 영역을 새로 만들기 때문에 
//			보낼 데이터가 있다면 request영역에 (request, response)데이터를 담아봤자 새로운 객체를 만들어서 소용이 없음
//			하지만, session에 sendRedirect를 통해 데이터를 담기 때문에 request영역에 새로 만드는건 영향을 주지 않고 데이터가 살아있음
			
			
		} else {
			request.setAttribute("msg", "로그인 실패");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// post방식으로 들어오면 get에서 작업하도록 넘겨줌
	}

}
