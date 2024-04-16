package com.kh.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	// 1. Connection 객체 생성한 후 Connection객체 반환시켜주는 getConnection메소드
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		//읽어드리고자하는 classes폴더내의 driver.properties파일의 물리적인 경로 가져오기
		String filePath = JDBCTemplate.class.getResource("/db/driver/driver.properties").getPath();
		//System.out.println(filePath);
		
		try {
			prop.load(new FileInputStream(filePath));
			
			// jdbc driver등록
			Class.forName(prop.getProperty("driver"));
			
			//드라이버객체에서 커넥션 꺼내야됨
			//접속하고자하는 db의 url, 계정명, 비밀번호 제시해서 Connection객체 생성
			conn = DriverManager.getConnection(prop.getProperty("url"),
										prop.getProperty("username"),
										prop.getProperty("password"));
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// 2. Connection객체 전달받아서 commit처리해주는 메소드
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// 널이 아니여야되고 이미 반납하지않았어야 한다
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. Connection객체 전달받아서 rollback처리해주는 메소드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// 널이 아니여야되고 이미 반납하지않았어야 한다
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2. Connection객체 전달받아서 close처리해주는 메소드
	
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				// 널이 아니여야되고 이미 반납하지않았어야 한다
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. Statement관련 객체 전달받아서 반납시켜주는 메서드
	
	// Statement 는 sql 로 받아야한다
	// 메소드이름이 같아도 괜찮다 왜? 이것이 오버로딩이라서
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				// 널이 아니여야되고 이미 반납하지않았어야 한다
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 6. ResultSet객체 전달받아서 반납시켜주는 메서드
	// ResultSet 는 sql 로 받아야한다
	// 메소드이름이 같아도 괜찮다 왜? 이것이 오버로딩이라서
	public static void close(ResultSet rest) {
		try {
			if (rest != null && !rest.isClosed()) {
				// 널이 아니여야되고 이미 반납하지않았어야 한다
				rest.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
