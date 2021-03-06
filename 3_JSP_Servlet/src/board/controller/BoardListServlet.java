package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글의 총 개수 + 각 페이지(1, 2, ...) 게시글 목록(각 페이지에 맞는 목록)
		BoardService service = new BoardService(); // 두 개의 서비스를 호출하기 때문에 참조변수로 생성
		
		// 게시글 총 개수
		int listCount = service.getListCount(); // 넘겨줄 것 없이 가지고 오기만 하면 됨. 개수를 가지고 오기 때문에 int 반환
		System.out.println(listCount);
		
		// 페이징 처리
		/*
		 *  boardLimit : 한 페이지에 보이는 게시글 수 
		 * 
		 * -------게시글 1--------
		 * -------게시글 2--------
		 * -------게시글 3--------
		 * -------게시글 4--------
		 * -------게시글 5--------
		 * 		
		 * 	currentPage : 현재 보고 있는 페이지
		 *	   < 1  [2]  3  4  5  6  7  8  9 10 >
		 *	startPage : 한 페이징 안에서 시작 페이지 넘버      
		 *	pageLimit : 10개씩 보여지는 페이지 넘버
		 *		11 12 13 14 15 16 17 18 19 20
		 *				endPage : 한 페이징 안에서 마지막 페이지 넘버
		 *								  41 maxPage
		 * */
		int currentPage;   	// 현재 페이지
		int pageLimit = 10;		// 한 페이지에 표시될 페이징 수  
		int maxPage;		// 전체 페이지 중 가장 마지막 페이지
		int startPage;		// 페이징 된 페이지 중 시작 페이지
		int endPage;		// 페이징 된 페이지 중 마지막 페이지
		int boardLimit = 10;		// 한 페이지에 보일 게시글 수 
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		maxPage = (int)((double)listCount / boardLimit + 0.9);
		
		startPage = (((int)((double)currentPage / pageLimit + 0.9))-1) * pageLimit + 1;
		
		endPage = pageLimit + startPage -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		
		ArrayList<Board> list = service.selectList(currentPage, boardLimit);
		
		String page = null;
		if(list != null) {
			page = "views/board/boardListView.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회에 실패하였습니다.");
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
