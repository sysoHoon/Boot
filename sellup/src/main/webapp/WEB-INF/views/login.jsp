<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript">
	function goHome() {
		location.href='./';		/* 요청 url 변경 */
	}
	
	function findid(){
		location.href = 'member/find_id_Form.do';
	}
</script>
</head>
<body>
<script>
		var alertm='<c:out value="${alertm}" />'
		if(alertm!="")
			alert(alertm);
</script>
<%@ include file="header.jsp" %>
<div>
	<!-- action :입력을 처리할 페이지, 
		 method : query string(GET) or form data(POST) -->
	<form action="login" method="post" >
		<label for="id">아이디</label><br>
		<input type="text" name="id" id="id" placeholder="이메일" required="required">
		<button type = "button" id = "find_id" onclick = "findid()">아이디 찾기</button><br><br>
		<label for="pw">패스워드</label><br>
		<input type="password" name="pw" id="pw" placeholder="패스워드" required="required"><br><br>
		<button type="submit">로그인</button> 
		<button type="button" onclick="goHome()">홈</button> 
	</form>
</div>
</body>
</html>