<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>welcome</h1>
<h3>환영합니다. <%= request.getParameter("id") %>님!!!</h3>
패스워드는 <%= request.getParameter("pass") %>...
<br>
<a href="Login.html">back</a>
</body>
</html>