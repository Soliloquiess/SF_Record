<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	
	<!-- header호출 -->
	<jsp:include page="../common/header.jsp" />
	<!-- js호출 -->
	<script type="text/javascript" src ="../js/join.js"></script>
</head>
<body>
<!-- nav 호출 -->
<jsp:include page="../common/nav.jsp" />

<!-- contents start -->
<!-- contents end -->
<table class="table table-bordered">
  <tr>
    <td>아이디</td>
    <td>비밀번호</td>
    <td>이름</td>
    <td>나이</td>
    <td>이메일</td>
    <td>전화번호</td>
    <td>삭제</td>
  </tr>
  <c:forEach var="vo" items="${list}">
    	  <tr>
    	    <td><a href="/memberList.do?num=${vo.id}">${vo.id}</a></td>
    	    <td>${vo.pass}</td>
    	    <td>${vo.name}</td>
    	    <td>${vo.age}</td>
    	    <td>${vo.email}</td>
    	    <td>${vo.phone}</td>
    	    <td><input type="button" value="삭제" class="btn btn-warning" onclick="deleteFn(${vo.num})"></td>
    	  </tr>    	 
  </c:forEach>
  <tr>
  <td colspan="8" align="right"><input type="button" value="회원가입" class="btn btn-primary" onclick="location.href='member/memberRegister.html'"/></td>
  </tr>
</table>

<!-- footer호출 -->
<jsp:include page="../common/footer.jsp" />

</body>
</html>