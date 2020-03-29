<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String pizza = (String)request.getAttribute("pizza");
	String topping = (String)request.getAttribute("topping");
	String side = (String)request.getAttribute("side");
	int price = (int)request.getAttribute("price"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body>
	<h3>주문 내역</h3>
	피자는 <span class="pizza"><%= pizza %>></span>,
	토핑은 <span class="topping"><%= topping %></span>,
	사이드는 <span class="side"><%= side %></span> 주문하셨습니다.
	<br><br>
	
	<%= price %>
	
	<h3 style="color:pink">즐거운 식사시간 되세요 ~</h3>
</body>
</html>