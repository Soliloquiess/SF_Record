package com.mvc.service;

import java.util.ArrayList;

import com.mvc.dao.BoardDAO;
import com.mvc.dao.BoardDAOImpl;
import com.mvc.vo.Board;

//3-BoardService의 메소드를 구현한 객체.
//Controller에서 들어온 요청을 처리하는 객체
//DAO에게 요청사항을 전달함
public class BoardServiceImpl implements BoardService{
	BoardDAO dao;//인터페이스 타입으로 레퍼런스 선언 
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	public ArrayList<Board> selectAll() {	
		return dao.selectAll();
	}

	@Override
	public Board selectOne(String num) {
		return dao.selectOne(num);
	}

	@Override
	public void insert(Board b) {
		dao.insert(b);
	}

	@Override
	public void delete(String num) {
		dao.delete(num);
	}

}
