package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcMySQL {

	public static void main(String[] args) throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";
	
		//jdbc url
		//jdbc:protocol name, mysql:db이름. localhost:db server 주소. 3306:port, scott:schema 이름
		String url = "jdbc:mysql://localhost:3306/scott?serverTimezone=UTC&characterEncoding=UTF-8";
		
		String user = "scott";
		String password = "tiger";
		
		String query = "select empid, fname, phone from emp";
		
		//1.Driver 등록
		Class.forName(driver);	
		
		//2. Connection 생성 - network 연결
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3.Statement  생성
		Statement stat = con.createStatement();
		
		//4.Query  실행
		ResultSet rs = stat.executeQuery(query);
		
		//5. 결과 처리
		while(rs.next()) {
			String empid = rs.getString(1);
			String fname = rs.getString(2);
			String phone = rs.getString(3);
			
			System.out.println(empid + "--" + fname + "--" + phone);
		}
		
		//6. 마무리
		rs.close();
		stat.close();
		con.close();
		
	}

}
















