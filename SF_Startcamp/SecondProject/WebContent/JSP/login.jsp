<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>�α��� ���</h1>
	<%
		//id�� tommy�̰�, pass�� 12345�̸� "�α��� ����: ~�� ȯ���մϴ�.
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		if(id.equals("tommy") && pass.equals("12345")){
			out.println("�α��� ����: "+id+"�� ȯ���մϴ�");
		}else{
			out.println("code:qqq");
		}
		
	%>
</body>
</html>