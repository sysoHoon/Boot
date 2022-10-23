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
        <h3 style="text-align: center;">도서대여</h3>
       <form action="rent" method="post" > 
           <!-- action 설정된 url로 입력요소에 작성된 데이터를 서버로 전송
                form 태그 속성 method="post" 있을때 와 없을때 차이점이 있습니다. -->
           <table style="width: 70%;margin:auto">
               <tr>
                   <td class="col1_title">대여NO</td>
                   <td><input type="text"name="rentno"size="17" 
                   placeholder="자동생성" disabled="disabled">
                   </td> <!-- 입력요소 데이터 식별하는 속성은 name -->
               </tr>
               <tr style="background-color: pink;">
               	 	<td colspan="2">
               	 	[도서대여 문제] 회원확인 버튼은 입력된 회원번호를 tbl_bookrent 테이블에서 조회하여  <br> 
               	 	'존재하지 않는 회원번호 입니다.','도서대여 가능합니다.','대여 중인 도서가 있습니다.' 중에서<br>
               	 	 해당되는 1개 메시지를 id="checkmsg" 에 출력합니다.(현재 동작 안함)
               	 	</td>
               </tr>
               <tr style="background-color: pink;">
                <td class="col1_title">회원번호</td>
                <td><input type="text"name="mem_idx" size="17" placeholder="회원번호 입력" disabled="disabled">
                <button id="memidx_check" type="button" style="font-size: 0.7em">회원확인</button>
                <br>&nbsp;&nbsp;&nbsp;<span id="checkmsg" style="color:red"></span>
                </td>
                <!-- required="redquired 간단히 표현" -->
            </tr>
            <tr>
                <td class="col1_title">도서코드</td>
                <td>
                	<c:if test="${bclist==null }">
					모든 도서가 대여 중입니다.                	
       	          	</c:if>
                	<select name="bcode">
                	<c:forEach var="bc" items="${bclist }">
                		<option value="${bc }">
                		<c:out value="${bc }"/>
                		</option>
                	</c:forEach>
                	</select>
                </td>
            </tr>
            <tr>
                <td class="col1_title">대여일자</td>
                <td><input type="date"name="rent_date" id="rent_date"></td>
            </tr>
            <tr>
                <td class="col1_title">반납예정일자</td>
                <td><input type="date" name="exp_date" id="exp_date"></td>
            </tr>
            <tr><td colspan="2" style="text-align: center;">
            <button onclick="valid_check()" type="button">대여<br>BOOKRENT</button></td>
            </tr>
           </table>
       </form>
    </section>
<jsp:include page="../footer.jsp"/> 
 <script type="text/javascript" src="../resources/js/bookrent.js"></script>
</body>
</html>