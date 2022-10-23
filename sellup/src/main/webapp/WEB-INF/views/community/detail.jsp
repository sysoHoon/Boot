<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/freeboard.css">  <!-- 상대경로 ../ 한단계 위로 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modal.css">
</head>
<body>  <!-- 문서가 생성될때 실행 -->
<hr>
 <table style="width:700px;margin:auto;">
 	<tr><td width="20%" class="td1">제목</td>
 		<td width="40%" class="input1">${bean.subject}</td>
 		<td width="20%" class="td1">조회수</td>
 		<td class="input1">${bean.readCount}</td>
 	</tr>
 	<tr><td class="td1">작성자</td>
 		<td class="input1">${bean.writer} 
 		<td class="td1">작성날짜</td>
 		<td class="input1">
 		<fmt:parseDate pattern="yyyy-MM-dd" value="${bean.wdate }" var="wdate"/>
 		<fmt:formatDate value="${wdate }" type="both"/>
 		</td>
 	</tr>
 	<tr><td class="td1">내용</td>
 		<td colspan="3" class="input1" style="text-align: left;">
 		<div  style="height: 300px;">
 		<c:set var="content" value="${fn:replace(bean.content,cr,'<br>')}"/>
 		<c:out value="${content}" escapeXml = "false"/>
 		<%-- <pre>${bean.content }</pre> --%>
 		</div>
 		</td>   <!-- 엔터,탭,기호 등 텍스트 그대로 출력할 때 사용 -->
 	</tr>
 	<tr><td colspan="4" align="center"><br>
 	<!--  ** -->

 	<a class="button" href="update?admin_board_id=${bean.admin_board_id }&page=${page}&field=${field}&findText=${findText}">수정</a>  <!-- ** -->
 	<a class="button" onclick="javascript:deleteOk(${bean.admin_board_id },${page });">삭제</a>

 	<a class="button" href="list?page=${page }">목록</a><br><br><br>
 	</td></tr>
 </table>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/community.js"></script>
</body>
</html>









