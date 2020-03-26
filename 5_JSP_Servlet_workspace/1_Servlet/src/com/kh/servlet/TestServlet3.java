package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet3 extends HttpServlet {
	
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
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>개인 정보 출력 화면</title>");
		out.println("<style>");
		out.println("h2{color:red;}");
		out.println("span.name{color:orange; font-weight:bold;}");
		out.println("span.gender{color:yellow; font-weight:bold; background-color:black;}");
		out.println("span.age{color:green; font-weight:bold;}");
		out.println("span.city{color:blue; font-weight:bold;}");
		out.println("span.height{color:navy; font-weight:bold;}");
		out.println("span.food{color:purple; font-weight:bold;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>개인취향 테스트 결과(POST)</h2>");
		out.printf("<span class='name'>%s</span>님은", name);
		out.printf("<span class='age'>%s</span>이시며", age);
		out.printf("<span class='city'>%s</span>에 사는", city);
		out.printf("<span class='height'>%s</span>cm인", height);
		out.printf("<span class='gender'>%s</span>입니다.", gender);
		out.print(" 좋아하는 음식은<span class='food'>");
		for(int i = 0; i < food.length; i++) {
			if(i == 0) {
				out.printf("%s", food[i]);
			} else {
				out.printf(", %s", food[i]);
			}
		}
		out.println("</span>입니다.");
		out.println("<hr>");
		out.println("<h3>" + age + "에 맞는 선물 추천</h3>");
		out.println("'" + recommendation + "' 선물은 어떠신가요?");
		out.println("</body>");
		out.println("</html>");
	}
	
	
}
