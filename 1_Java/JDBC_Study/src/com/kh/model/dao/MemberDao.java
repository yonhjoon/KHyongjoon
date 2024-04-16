package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

public class MemberDao {

	/**
	 * 사용자가 입력한 정보들을 db에 추가시켜주는 메소드
	 * @param m : 사용자가 입력한 값들이 담겨있는 member객체
	 * @return : insert문 실행 후 처리된 행수
	 */
	public int insertMember(Connection conn, Member m) {
		//insert문 => 처리된 행수(int) => 트랜잭션
		
		int result = 0;
		
		PreparedStatement pstmt = null;  
		//PreparedStatement :  Statement 대신 PreparedStatement 쓰는이유는
		//						''를 일일이 넣어줬어야해서 오타나기쉽고 작성하는시간이 오래걸렸는데
		//                      PreparedStatement 를 쓰면 ''을 일일이안쓰더라도 인식을하여 그렇다 그안에 값을 
		//						?,?,? 안에 넣어줌으로 insert into안에있는 값에 맞춰 넣어야한다 예시는 밑에있다.
		// Statement : (PreparedStatement의 부모관계)Statement 대신 ?가 아니라 ''를 일일이 넣어줬어야하는데
		//             PreparedStatement
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?, ?, ?, ? ,SYSDATE)";
		
			try { 
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getName());
				pstmt.setString(2, m.getAuthor());
				pstmt.setString(3, m.getPublisher());
				pstmt.setString(4, m.getDate());
				
				result = pstmt.executeUpdate();
				//executeUpdate() : INSERT, UPDATE, DELETE와 같은 DML(Data Manipulation Language)에서 
				//				   실행 결과로 영향을 받은 레코드 수를 반환한다. (레코드 수'는 '행의 수' 또는 '기록 수'를 의미 int형으로 대입가능)
				//				  -반환 타입이 int이므로, 쿼리 실행 결과로 반환되는 값을 int로 받아와야 한다.
				//				  -행의 개수를 반환하기 때문에  rs를 사용할 필요 없다.
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}

		return result; // 위에 입력받는 값을 DB에 넣어주는 try catch문에서 넣은값을 반환한다.
	}
	
	public ArrayList<Member> selectList(Connection conn){
		// select문(여러행 조회) -> ResultSet객체 -> ArrayList<Member>에 담기
		
		ArrayList<Member> list = new ArrayList<>(); //비어있는상태
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// ResultSet : SELECT문을 실행하여 테이블로부터 얻은 결과를 저장하고있는 저장소
		
		String sql = "SELECT * FROM MEMBER ORDER BY USERNAME";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
