<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String dept = request.getParameter("dept");
		String employee = request.getParameter("employee");
		String comment = request.getParameter("comment");
		
		
		out.println(dept+"<br>");
		out.println(employee+"<br>");
		out.println(comment+"<br>");
		
		//üũ�ڽ��� ���߼����� �ȴ�?
		String[] ides = request.getParameterValues("ide"); 
		/* getParameterValues�� �迭 �޾ƿ�.
		/ide��� ���̵��� �Ķ���� �������µ� üũ�ڽ����� value �־��µ� �� ������� �ްڴ�.
		getparameter�ϸ� �ϳ��� �޴µ� getparametervalues�� ������ �޾ƿ´�.
		 */
		 //ide�� �迭
		if(ides.length > 0){
			for(String ide:ides){
				out.println(ide+"<br>");
			}
		}
		 
	%>
</body>
</html>