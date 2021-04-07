package basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParameterServlet")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//username
		response.setContentType("text/html; charset=utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println(username);
		response.getWriter().append("username : " + username);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		StringBuilder sb = new StringBuilder();
		
		String username = request.getParameter("username");
		System.out.println(username);
		sb.append("username : " + username);
		
		String password = request.getParameter("password");
		System.out.println(password);
		sb.append(" password : " + password);
		
		String[] hobby = request.getParameterValues("hobby");
		for (String str : hobby) {
			System.out.println(str);		
			sb.append(" hobby : " + str);
		}
		
		response.getWriter().write(sb.toString());
	}

}
