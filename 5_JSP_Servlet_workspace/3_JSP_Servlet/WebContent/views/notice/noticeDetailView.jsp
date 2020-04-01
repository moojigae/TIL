<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice" %>
<% Notice notice = (Notice)request.getAttribute("notice"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.outer{
		width: 600px; height: 500px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.tableArea {width:450px; height:350px; margin-left:auto; margin-right:auto;}
	#updateNoBtn, #cancelBtn, #deleteNoBtn{background: #B2CCFF; color: white; border-radius: 15px; width: 80px; heigth: 25px; text-align: center; display: inline-block;}
	#updateNoBtn:hover, #cancelBtn:hover, #deleteNoBtn:hover{cursor: pointer;}
	#cancelBtn{background: #D1B2FF;}
	#deleteNoBtn{background: #D5D5D5;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지사항</h2>
		<div class="tableArea">
			<form action="views/notice/noticeUpdateForm.jsp" id="detailForm" name="detailForm" readonly>
				<table>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="50" name="title" value="<%= notice.getnTitle() %>" readonly></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<%= loginUser.getNickName() %>
						</td>
						<th>작성일</th>
						<td><input type="date" name="date" value="<%= notice.getnDate() %>" readonly></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" cols="60" rows="15" style="resize:none;" readonly><%= notice.getnContent() %></textarea>
							<%= notice.getnContent() %>
						</td>
					</tr>
				</table>
			
				<br>
				
				<div align="center">
					<button type="submit" id="insertNoBtn">등록</button>
					<div onclick="location.href='javascript:history.go(-1);'" id="cancelBtn">취소</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>