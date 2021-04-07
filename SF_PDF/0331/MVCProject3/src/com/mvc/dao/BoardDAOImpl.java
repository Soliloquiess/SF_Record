package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mvc.vo.Board;

//BoardDAO의 메소드를 구현한 객체.
//Service에서 들어온 요청을 최종적으로 처리하는 객체
//DB 작업 수행(CRUD)
public class BoardDAOImpl implements BoardDAO {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/testdb2?serverTimezone=UTC&characterEncoding=UTF-8";
	String user = "ssafy";
	String password = "ssafy";
	String query = "select num, name, wdate, title, count from board order by num desc";

	ArrayList<Board> list;// select 한 결과를 담아놓을 자료구조

	public BoardDAOImpl() {
		try {
			Class.forName(driver);// register driver
			list = new ArrayList<>();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Board> selectAll() {
		try {
			list.clear();

			Connection con = DriverManager.getConnection(url, user, password);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				String count = rs.getString(5);
				
				Board b = new Board(num, null, name, wdate, title, null, count);
				list.add(b);
			}

			// 6. 마무리
			rs.close();
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;// ->service로 감
	}

	@Override
	public Board selectOne(String num) {
		Board b = null;

		return b;
	}

	@Override
	public void insert(Board b) {
	}

	@Override
	public void delete(String num) {
	}

	@Override
	public void countUp(String num) {
	}

}
