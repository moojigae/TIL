package com.kh.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pizza = req.getParameter("pizza"); // input에 name에 들어있는 값을 가지고 옴
		String[] topping = req.getParameterValues("topping");
		String[] side = req.getParameterValues("side");
		
		int price = 0;
		switch(pizza) {
		case "치즈피자" : price += 5000; break;
		case "콤비네이션피자" : price += 6000; break;
		case "포테이토피자" : price += 7000; break;
		case "고구마피자" : price += 7000; break;
		case "불고기피자" : price += 8000; break;
		}
		for(int i =0; i < topping.length; i++) {
			switch(topping[i]) {
			case "고구마무스" : price += 1000; break;
			case "콘크림무스" : price += 1500; break;
			case "파인애플토핑" : price += 2000; break;
			case "치즈토핑" : price += 2000; break;
			case "치즈크러스트" : price += 2000; break;
			case "치즈바이트" : price += 3000; break;
			}
		}
		for(int i = 0; i < side.length; i++) {
			switch(side[i]) {
			case "오븐구이통닭" : price += 9000; break;
			case "치킨스틱&윙" : price += 4900; break;
			case "치즈오븐스파게티" : price += 4000; break;
			case "새우링&웨지감자" : price += 3500; break;
			case "갈릭포테이토" : price += 3000; break;
			case "콜라" : price += 1500; break;
			case "사이다" : price += 1500; break;
			case "갈릭소스" : price += 500; break;
			case "피클" : price += 300; break;
			case "핫소스" : price += 100; break;
			case "파마산 치즈가루" : price += 100; break;
			}
		}
		
		req.setAttribute("pizza", pizza);
		String toppings =String.join(", ", topping);
		req.setAttribute("topping",toppings);
		String sides = String.join(", ", side);
		req.setAttribute("side", sides);
		req.setAttribute("price", price);
		
		RequestDispatcher view = req.getRequestDispatcher("jsp/04_pizzaEnd.jsp");
		view.forward(req, resp);

	}
}
