<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/gallery.css?v=3">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modal.css">
<style type="text/css">
</style>
</head>
<body>
<%@ include file="../header.jsp" %>
<div>
 	<c:forEach items="${list }" var="vo" varStatus="main">
	<div class="slideshow-container">  <!-- css 파일참고 -->

		<div id="item${main.count }">
		<c:forEach items="${vo.filename }" var="pic" varStatus="stat">
			<!-- 업로드한 3개의 파일명을 리스트로 애트리뷰트에서 가져오기 -->
			<div class="mySlides fade" style="margin: auto;">
				<%-- <div class="numbertext">${stat.count} / </div> --%>
				<img src="/uploads/${pic}" width="400px" height="400px" style="object-fit:cover">
				<!-- /uploads/ url 경로는 ApplicationConfig 에서 설정합니다.  -->
				
			</div>
		</c:forEach>
		<!-- Next and previous buttons -->
		<div style="text-align:center;padding-top: 30px;">
			<c:forEach items="${vo.filename }" var="no" varStatus="stat">
			  <span class="dot" onclick="currentSlide(${main.count },${stat.count})"></span>
			</c:forEach>
		</div>	
		<div class="reportbtn">
		<a href="javascript:rmodalSet()"><img class="report" alt="리폿" src="${pageContext.request.contextPath }/resources/images/report.png"></a>
		</div>
		<div>${vo.id}</div>
		<div>${vo.content}</div>
		</div>
		
		<a class="prev" onclick="plusSlides(${main.count },-1)">&#10094;</a> 
		<a class="next" onclick="plusSlides(${main.count },1)">&#10095;</a>
	</div>
	
	</c:forEach>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/gallery.js"> </script>
	<%@ include file="../common/modal.jsp" %>
</body>
</html>








