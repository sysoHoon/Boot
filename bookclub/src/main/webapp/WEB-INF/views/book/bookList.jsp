<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OUR BOOKCLUB</title>
    <link rel="stylesheet" href="../resources/css/hrdkorea.css">
</head>
<body>
<jsp:include page="../header.jsp"/>   

        <section>
            <h4 style="text-align: center;">도서 목록 조회/수정</h4>
            <table style ="width:85%; margin: auto;">
                <tr>   <!-- 첫번째 행, 제목행(가운데 정렬) -->
                   <th >도서코드</th>   <!-- 4개의 칸(열) -->
                   <th>제목</th>
                   <th >저자</th>
                   <th >출판사</th>
                   <th >출판일</th>
                </tr>
               
               <c:forEach var="vo" items="${list }">
                <tr>
                   <td class="center">${vo.bcode }</td>
                   <td class="center">${vo.title }</td>
                   <td class="center">${vo.writer }</td>
                   <td class="center">${vo.publisher }</td>
                   <td class="center">${vo.pdate }</td>
                </tr>
               </c:forEach>
               
            </table>
        </section>
    <footer>
    	<div>
        HRDKREA Copyright&copy2022 All rights reserved. Human Resources Development Service of Korea;
    	</div>
    </footer>
</body>
</html>