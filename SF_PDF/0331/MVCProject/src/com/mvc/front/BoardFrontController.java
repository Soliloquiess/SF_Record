package com.mvc.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.controller.BoardController;

//FrontController:1)클라이언트로부터 들어오는 요청 받기.2받은 요청을 구분해서 Controller에게 작업을 넘김.

// http://localhost:port/mvc/list.bod(초기화면)	사용자가 맨뒤에 뭐라 입력해야 작동하지?
// http://localhost:port/mvc/detail.bod

@WebServlet(urlPatterns= {"*.bod","*.star"})	//url매핑값을 이렇게 넣자. 뭐를 넣든 상관 없다. 유튜브시간엔 /.do이런식으로 넣었다.
public class BoardFrontController extends HttpServlet {
	BoardController con;
	
	//메소드 호출해서 보드 컨트롤러에 넘김.
    public BoardFrontController() {
       con = new BoardController();
    }
    
    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		//1.client에서 server로 보내는 한글처리
    	request.setCharacterEncoding("utf-8");
    	
    	//2.client가 보내는 url을 구분
    	//ex) http://localhost:port/mvc/list.bod(초기화면)
    	String reqString =  request.getServletPath();//맨마지막 값 /list.bod
    	//클라이언트가 주소창에 입력한 값이 매번 다르게 바뀌니까 그게 이건가요
    	System.out.println(reqString);
    	
    	if(reqString.equals("/list.bod")) {//초기화면(목록)
    		con.list(request, response);	//이거 호출 (list에서 작업)
    		
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
