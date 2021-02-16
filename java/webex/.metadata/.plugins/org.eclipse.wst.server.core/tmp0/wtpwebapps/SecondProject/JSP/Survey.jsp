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
		
		//체크박스는 다중선택이 된다?
		String[] ides = request.getParameterValues("ide"); 
		/* getParameterValues로 배열 받아옴.
		/ide라는 아이디가진 파라미터 가져오는데 체크박스마다 value 있었는데 그 밸류들을 받겠다.
		getparameter하면 하나만 받는데 getparametervalues로 여러개 받아온다.
		 */
		 //ide는 배열
		if(ides.length > 0){
			for(String ide:ides){
				out.println(ide+"<br>");
			}
		}
		 
	%>
</body>
</html>