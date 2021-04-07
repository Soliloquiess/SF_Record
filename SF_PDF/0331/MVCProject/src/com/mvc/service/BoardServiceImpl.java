package com.mvc.service;

import java.util.ArrayList;

import com.mvc.dao.BoardDAO;
import com.mvc.dao.BoardDAOImpl;
import com.mvc.vo.Board;

//BoardService의 메소드를 구현한 객체.
//Controller에서 들어온 요청을 실제로 처리하는 객체
//DAO에게 요청사항을 전달함
public class BoardServiceImpl implements BoardService{
	
	BoardDAO dao; //인터페이스 타입으로 레퍼런스 선언.
	//impl타입으로 하면 안됨. 코드의 유연성 떄문에 그럼 코드 영향 더 받게 하려고 인터페이스 형태로 선언
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	public ArrayList<Board> selectAll() {		
		return dao.selectAll();	//dao에 가서 일 시킴.
	}

	@Override
	public Board selectOne(String num) {
		return dao.selectOne(num);
	}
	//여기서 하는건 dao부려먹는 일밖에 없다.
	@Override
	public void insert(Board b) {
		dao.insert(b);
	}

	@Override
	public void delete(String num) {
		dao.delete(num);
	}

}
