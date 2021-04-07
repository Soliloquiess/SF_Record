package com.mvc.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.controller.BoardController;

//1-FrontController:
//1)클라이언트로부터 들어오는 요청 받기.
//2)받은 요청을 구분해서 Controller에게 작업을 넘김.

// http://localhost:port/mvc/list.bod(초기화면)
// http://localhost:port/mvc/detail.bod(상세화면)

@WebServlet("*.bod")
public class BoardFrontController extends HttpServlet {	
	BoardController con;
	
    public BoardFrontController() {
       con = new BoardController();
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		//1.client에서 server로 보내는 한글처리
    	request.setCharacterEncoding("utf-8");
    	
    	//2.client가 보내는 url을 구분
    	//ex) http://localhost:port/mvc/list.bod(초기화면)
    	String reqString = request.getServletPath();//맨마지막 값 /list.bod
    	System.out.println(reqString);
    	
    	if(reqString.equals("/list.bod")) {//초기화면(목록)
    		con.list(request, response);
    		
    	}else if(reqString.equals("/read.bod")) {//상세화면(글읽기)
    		con.read(request, response);
    		
    	}else if(reqString.equals("/delete.bod")) {//삭제
    		con.delete(request, response);    		
    	} 	
    	
	}
	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
