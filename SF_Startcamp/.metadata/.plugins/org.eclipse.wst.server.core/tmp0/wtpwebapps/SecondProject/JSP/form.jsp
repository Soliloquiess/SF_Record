<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과 화면</h1>
	<%
	//자바 코드가 들어가는 곳.
	//1.html에서 보내온 값을 받을 것
	
	String num = request.getParameter("num"); 
	String name = request.getParameter("name");
	
	//2. 받은 값을 화면에 출력
	
	out.println("num: "+num+"<br>");
	out.println("name: "+name+"<br>");
	//브라우저에서 보여지는거라 태그밖에 인식 안됨.
	/* println은 콘솔같은거라 인식 안되서 태그로 줄바꿈 해줘야됨.*/
	
	//2-1. 받은 이름을 기준으로 서로 다른 메시지를 출력.(tom ->code:abc,bill->code:xyz)
	//기본형 데이터는 == 로 비교 가능.(int a=7, b=7; if(a==b)))
	//참조형 데이터는 같은지 비교할 떄 equals() 사용
	//String은 같은지 비교할 떄 == 쓰면 안되고 equals를 사용해야됨.
	if(name.equals("tom")){
		out.println("code:abc");
	}else if(name.equals("bill")){
		out.println("code:xyz");
	}else{
		out.println("code:qqq");
	}
	
	 //3. 이전화면으로 링크 걸기.
	
	%>
	
	<a href = "form.html">back</a>
</body>
</html>