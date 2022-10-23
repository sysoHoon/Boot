<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
        <h4 class="header-item">도서대여 시스템 ver1.0</h4>
</header>
<nav>
<c:set var="context" value="${pageContext.request.contextPath }"/>
    <ul class="container">
            <li><a href="list">도서목록</a></li>
            <li><a href="rentList">대여현황</a></li>
            <li><a href="rent">도서대여</a></li>
            <li><a href='./'>홈으로</a></li>
      </ul>
</nav>
<div>
<div>
:::도서 대출 시스템 요구사항:::</div>
<ol>
	<li>회원 1명은 1권의 책을 14일 동안 대출할 수 있습니다.</li>
	<li>새로운 책 대출은 대여 중인 책을 반납해야 가능하다.</li>
	<li>대출(tbl_bookrent) 테이블에서 컬럼 return_date IS NULL 이면 대출 중인 상태 입니다.</li>
</ol>
<hr>
<script type="text/javascript">
	const alerm = '<c:out value="${alertm}"/>'
	if(alerm !='')
		alert(alerm)
</script>
</div>