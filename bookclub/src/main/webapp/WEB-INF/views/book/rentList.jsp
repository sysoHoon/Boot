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
            <h4 style="text-align: center;">도서 대여 목록</h4>
            <table style ="width:85%; margin: auto;">
                <tr>   <!-- 첫번째 행, 제목행(가운데 정렬) -->
                   <th >대여번호</th>   
                   <th >회원번호</th>   
                   <th >도서코드</th>   
                   <th>대출일</th>
                   <th >반납예정일</th>
                   <th >반납일</th>
                   <th >연체일수</th>
                </tr>
               
               <c:forEach var="vo" items="${list }">
                <tr>
                   <td class="center">${vo.rent_no }</td>
                   <td class="center">${vo.mem_idx }</td>
                   <td class="center">${vo.bcode }</td>
                   <td class="center">${vo.rent_date }</td>
                   <td class="center">${vo.exp_date }</td>
                   <td class="center">${vo.return_date }</td>
                   <td class="center">${vo.delay_days }</td>
                </tr>
               </c:forEach>
               
            </table>
            <hr>
            <div style="text-align: center;">
            	현재 연체 중인 건수 : <c:out value="${delay_cnt }"/><br>
            	대출 중인 건수 : <c:out value="${rent_cnt }"/>
            </div>
             <hr>
        </section>
<jsp:include page="../footer.jsp"/> 
</body>
</html>