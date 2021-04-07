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
public class BoardDAOImpl implements BoardDAO{
	
	String driver = "com.mysql.cj.jdbc.Driver";
		
	//jdbc url
	//jdbc:protocol name, mysql:db이름. localhost:db server 주소. 3306:port, scott:schema 이름
	String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC&characterEncoding=UTF-8";
	//"jdbc:mysql://localhost:3306/(여기가 쓰는 디비)?serverTimezone=UTC&characterEncoding=UTF-8";	?쿼리스트링 뒤는 옵션사항.
	
	String user = "root";
	String password = "mysql";

	//이 3가지가 디비 접속하기 위한 정보들 얘들이 있어야 커넥션 가능
	
	String query = "select num,name,wdate,title,count from board order by num desc";
	
	ArrayList<Board> list;//select 한 결과를 담아놓을 자료구조	
	
	public BoardDAOImpl(){
		try {
			//register driver
			Class.forName(driver);	
			list = new ArrayList<>();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public ArrayList<Board> selectAll() {
		try {
			list.clear();

			//2. Connection 생성 - network 연결
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(query);
			
			//5. 결과 처리
			while(rs.next()) {	//한행 한행 처리
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				String count = rs.getString(5);
				Board b = new Board(num, null, name, wdate, title, null, count);
				list.add(b);
				
			}
			
			//6. 마무리
			rs.close();
			stat.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;//->service로  감 데이터가 다 담긴걸 리턴함. 서비스에서 얘가 담긴걸 이요
	}

	@Override
	public Board selectOne(String num) {
		Board b = null;
		
		return b;
	}

	@Override
	public void insert(Board b) {}

	@Override
	public void delete(String num) {}

	@Override
	public void countUp(String num) {}

}







