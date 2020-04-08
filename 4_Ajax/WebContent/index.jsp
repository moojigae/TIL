<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.4.1.min.js"></script>
<style>
	body{background:beige;}
	.test{width:300px; min-height:50px; border: 1px solid red;}
</style>
</head>
<body>
	<h1>jQuery를 통한 Ajax 구현</h1>
	
	<h3>1. 버튼 선택 시 전송 값 서버에 출력 </h3>
	이름 : <input type="text" id="myName">
	<button id="nameBth">이름 전송</button>
	<script>
		$('#nameBth').click(function(){
			var name = $('#myName').val();
// 			console.log(name);
			$.ajax({
				url: 'jQueryTest1.do',
				data: {name:name}, 
				// 뒤에 있는 name은 위에 변수 선언한 name이고 앞에 name에 담기
				// 파라미터에 값 담아서 보내기
				type:'post',
				success:function(data){
				// data : 매개변수로 응답 데이터를 받음	
					console.log('서버 성공 시 호출되는 함수');
				},
				error: function(data){
					console.log('서버 전송 실패 시 호출되는 함수');
				},
				complete : function(data){
					console.log('성공 여부에 상관 없이 무조건 호출되는 함수');
				}
			});
		});
	</script> 
	
	<br>
	
	<h3>2. 버튼 선택 시 서버에서 보낸 값 사용자가 수신 </h3>
	<button id="getServerTextBtn">서버에서 보낸 값 확인</button>
	<p class="test" id="p1"></p>
	<script>
		$('#getServerTextBtn').click(function(){
			$.ajax({
				url:"jQueryTest2.do",
				success: function(data){
					console.log(data);
					$('#p1').text(data);
				}
			});
		});
	</script>
	
	<br>
	
	<h3>3. 서버로 기본형 전송 값이 있고 결과로 문자열을 받아 처리</h3>
	<h4>두 개의 값을 더한 결과를 받아옴</h4>
	첫 번째 숫자 : <input type="text" id="firstNum"><br>
	두 번째 숫자 : <input type="text" id="secondNum"><br>
	<button id="plusBtn">더하기</button>
	<p class="test" id="p2"></p>
	<script>
		$('#plusBtn').click(function(){
			var firstNum = $('#firstNum').val();
			var secondNum = $('#secondNum').val();
			
			$.ajax({
				url:"jQuerytest3.do",
				data:{firstNum:firstNum, secondNum:secondNum},
				success: function(data){
					$('#p2').text(data);
					// $('#p2').text(data) : p2영역에 data값을 넣어줌
				}
			});
		});
	</script>
	<br>
	<h3>4. Object형태의 데이터를 서버에 전송, 서버에서 처리 후 서버 console로 출력</h3>
	학생 1 : <input type="text" id="student1"><br>
	학생 2 : <input type="text" id="student2"><br>
	학생 3 : <input type="text" id="student3"><br>
	<button id="studentTest">결과 확인</button>
	<script>
		$('#studentTest').click(function(){
			var student1 = $('#student1').val();
			var student2 = $('#student2').val();
			var student3 = $('#student3').val();
			
			var students = {student1:student1, student2:student2, student3:student3};
			
			$.ajax({
				url:"jQueryTest4.do",
				data : students,
			});
		});
	</script>
	
	<br>
	<h3>5. 서버로 기본형 데이터 전송, 서버에서 객체 반환</h3>
	<h4>유저 번호 보내서 해당 유저 정보 가져오기</h4>
	유저 번호 : <input type="text" id="userNo"><br>
	<button id="getUserInfoBtn">정보 가져오기</button>
	<p class="test" id="p3"></p>
	<textarea class="text" id="textarea3" cols=40 rows=5></textarea>
	<script>
		$('#getUserInfoBtn').click(function(){
			var userNo = $('#userNo').val();
			
			$.ajax({
				url: 'jQueryTest5.do',
				data: {userNo:userNo},
				success: function(data){
					console.log(data);
					
					var resultStr = "";
					
					if(data != null){
						resultStr = data.userNo + ", " + data.userName + ", " + data.userNation;
					} else {
						resultStr = "해당 회원이 없습니다.";
					}
					$('#p3').text(resultStr);
					$('#textarea3').val(resultStr);
				}
			});
		});
	</script>
	
	<h3>6. 서버로 기본 값 전송, 서버에서 리스트 객체 반환</h3>
	<h4>유저 번호 요청 ==> 해당 유저가 있는 경우 유저 정보, 없는 경우 전체 가져오기</h4>
	유저 번호 : <input type="text" id="userNo2"><br>
	<button id="getUserInfoBtn2">정보 가져오기</button>
	<p class="test" id="p4"></p>
	
	<script>
		$('#getUserInfoBtn2').click(function(){
			var userNo = $('#userNo2').val();
			
			$.ajax({
				url: 'jQueryTest6.do',
				data: {userNo:userNo},
				success: function(data){
					console.log(data);
					
					
					var resultStr ="";
					for(var i in data){
			// for in 문에서는 배열에서는 index 객체일 때는 키
						var user = data[i];
						console.log(user);
						
// 						resultStr += user.userNo + ", " + user.userName + ", " + user.userNation + "\n";
//						개행문자는 textarea에는 됨
						resultStr += user.userNo + ", " + user.userName + ", " + user.userNation + "<br>";
					}
					
					$('#p4').text(resultStr);
				}
			});
		});
	</script>
	
	<h3>7. 서버로 데이터 여러 개 전송, 서버에서 리스트 객체 반환</h3>
	<h4>유저 번호 전송 --> 현재 있는 유저 정보만 모아서 출력</h4>
	<h4>10이상의 숫자는 ','로 쓸 수 없다고 가정</h4>
	유저 정보(번호,번호,번호) : <input type="text" id="userNo3"><br>
	<button id="getUserInfoBtn3">정보 가져오기</button>
	<textarea class="test" id="textarea5" cols=40 rows=5></textarea>
	<script>
		$('#getUserInfoBtn3').click(function(){
			$.ajax({
				url: 'jQueryTest7.do',
				data:{userNo:$('#userNo3').val()},
				success: function(data){
					console.log(data);
					
					var resultStr = "";
					for(var i in data){
						var user = data[i];
						console.log(data);
						resultStr += user.userNo + ", " + user.userName + ", " + user.userNation + "\n";
					}
					$('#textarea5').text(resultStr);
				}
			});
		});
	</script>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>