<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList, com.mvc.vo.Board" %>
<html><body>
<% 
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
%>
		<center>
		<img src="image/f1.jpg">
		<h1>MVC 게시판</h1>			
				
		<TABLE BORDER=1 CELLSPACING=1 CELLPADDING = 1><TR>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>번호</th>
		<th width=200 bgcolor=#113366><font color=#ffffee size=2>제목</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>글쓴이</th>
		<th width=150 bgcolor=#113366><font color=#ffffee size=2>날짜</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>조회수</th>

	  	<% for(Board b : list){ %>
		    <tr bgcolor=pink>
			   <td align=center bgcolor=pink>&nbsp;<font size=2><%= b.getNum() %></td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2>
		      	<a href=read.bod?num=<%= b.getNum() %>><%= b.getTitle() %></a>
		      </td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2><%= b.getName() %></td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2><%= b.getWdate() %></td>
		       
		      <td align=center bgcolor=pink>&nbsp;<font size=2><%= b.getCount() %></td>	       
		    </tr>
	   <%} %>
	   
</table>
<br></br>
<a href=insertForm.bod>새글쓰기</a>
</body></html>