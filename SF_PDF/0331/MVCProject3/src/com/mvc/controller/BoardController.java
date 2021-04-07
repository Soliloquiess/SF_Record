package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.service.BoardService;
import com.mvc.service.BoardServiceImpl;
import com.mvc.vo.Board;
//2-Controller
//FrontController에게서 요청을 넘겨 받아 Service한테 작업을 넘김
//Service한테서 답이 오면 답을 가지고 jsp로 넘어감
public class BoardController {	
	BoardService service;//인터페이스 타입으로 레퍼런스 선언
	
	public BoardController() {
		service = new BoardServiceImpl();
	}	
	
	public void list(HttpServletRequest request, HttpServletResponse response) {
		//1.Service한테 data 받음
		ArrayList<Board> list = service.selectAll();
		
		//2.request에 데이터 저장
		request.setAttribute("list", list);
		
		//3.view로 넘어가기(forward 방식)		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list3.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	public void read(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		service.selectOne(num);
		
	}


	public void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}	

}









