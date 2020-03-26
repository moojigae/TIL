package com.kh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet4 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); // post방식 일 때는 데이터 하나라도 받기 전에 인코딩 먼저 해줘야함
		
		String name = req.getParameter("name"); // input에 name에 들어있는 값을 가지고 옴
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String city = req.getParameter("city");
		String height = req.getParameter("height");
		String[] food = req.getParameterValues("food");

		String recommendation = "";
		switch(age) {
		case "10대 미만" : recommendation = "뽀로로"; break;
		case "10대" : recommendation = "펭수"; break;
		case "20대" : recommendation = "둘리"; break;
		case "30대" : recommendation = "핑구"; break;
		case "40대" : recommendation = "돈"; break;
		case "50대" : recommendation = "집"; break;
		}
		
		// JSP는 HTML과 다르게 데이터를 받아와서 출력할 수 있음
		// 서블릿에서 데이터를 보내야 받을 수 있음
		// 화면으로 데이터를 보내 줄 작업을 해야만 화면에서 데이터를 받을 수 있기 때문에 해당 작업 필요
		// 보낼 데이터 담기
		req.setAttribute("name", name); // ("변수명", 보낼 객체)
		req.setAttribute("gender",gender);
		req.setAttribute("age", age);
		req.setAttribute("city", city);
		req.setAttribute("height", height);
		String foods = String.join(", ", food);
		req.setAttribute("foods", foods);
		req.setAttribute("recommendation", recommendation);
		
		// 어디로 보낼지 지정
		RequestDispatcher view = req.getRequestDispatcher("servlet/testServlet4End.jsp");
		// 보내기
		view.forward(req, resp);
		
		
		
		
		
		

	}
}
