<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 결과</h1>
	<%
		//id가 tommy이고, pass가 12345이면 "로그인 성공: ~님 환영합니다.
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		if(id.equals("tommy") && pass.equals("12345")){
			out.println("로그인 성공: "+id+"님 환영합니다");
		}else{
			out.println("code:qqq");
		}
		
	%>
</body>
</html>