package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.service.BoardService;
import com.mvc.service.BoardServiceImpl;
import com.mvc.vo.Board;

//2-Controller
//FrontController에게서 요청을 넘겨 받아 Service한테 작업을 넘김
//Service한테 답이 오면 jsp로 넘어감.
public class BoardController {	
	BoardService service;	//변수하나선언하면서 인터페이스로 선언(IMPL)인터페이스가 부모고 부모타입으로선언.
	//인터페이스 타입으로 레퍼런스 선언(BoardService) 저 안에있는 4개의 메서드만 호출 가능.
	
	public BoardController() {
		service = new BoardServiceImpl();	//new에서 만드는 건 impl를 만듬.
	}
	
	
	public void list(HttpServletRequest request, HttpServletResponse response) {
		//1.Service한테 data 받음
		ArrayList<Board> list = service.selectAll();//service가 가진 메서드 컨트롤러는 서비스를 부려먹음.
		//2.request에 데이터 저장
		request.setAttribute("list", list);//저장되는 이름, 저장되는 값.
		//리퀘스트는 클라이언트로부터 요청 들어올 떄 생김.
		//3.view로 넘어가기(forward 방식 , 그래야 계속 전달이되서 사용 . 새로 만들어지는게 아니라.), jsp에 전달.			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list3.jsp");//리퀘스트를 전달해주는애getRequestDispatcher
		try {
			dispatcher.forward(request,response);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
	}


	public void read(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String num	= request.getParameter("num"); 
		service.selectOne(num);
		
	}


	public void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}



}









