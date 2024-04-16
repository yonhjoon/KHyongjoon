
package com.kh.notice.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.notice.model.vo.Notice;

public class NoticeDao {
	private Properties prop = new Properties();
	
	public NoticeDao() {
		String filePath = NoticeDao.class.getResource("/db/sql/notice-mapper.xml").getPath();
		// 경로안에 파일을 가져와라
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
			// 경로안에있는 코드를 가져오기 위해서 xml 파일을 loadFromXML 로 가져온다
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Notice> selectNoticeList(Connection conn){
		//select -> ResultSet(여러행) ->  ArrayList<Notice>
		
		ArrayList<Notice> list = new ArrayList<>();
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		//으로 키값을 가져오면된다 (키값은 따로 만들어놓은 xml파일이다)
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset =pstmt.executeQuery();
			// 바로 executeQuery 보내준다.
			// 그리고 무조건 rset 에 담아준다.
			
			//한개일수도있고 몇개일지 모르니 다 뽑아줘야 된다
			// rset.next() => 다음객체에 값이 있는지 없는지 알 수 있음 / 다음객체가 비어있을 때 알수있음
			while(rset.next()) { // 값이 있다면 가져와 -> 값이 없을때까지 (값이 flate 나올때까지)
				list.add(new Notice( // Notice 의 담긴값을 list안에 넣을려고 만든거다.
						rset.getInt("notice_no"),
						rset.getString("notice_title"),
						rset.getString("user_id"),
						rset.getInt("count"),
						rset.getDate("create_date")
					));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int insertNotice(Connection conn, Notice n ) {
		//insert -> 처리된 행 수 -> 트랜잭션처리
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, Integer.parseInt(n.getNoticeWriter()) );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int increaseCount(Connection conn, int noticeNo) {
		// 수정이니 update문 -> 결과는 처리된 행의 수 -> 그리고 트랜잭션처리 하면된다
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public Notice selectNotice(Connection conn, int noticeNo){
		//select -> ResultSet(한행) -> Notice
		
		Notice n = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			 
			// rset.next() => 다음객체에 값이 있는지 없는지 알 수 있음/ 다음객체가 비어있을 때까지 반복추출
			if(rset.next()) {
				n = new Notice(
							rset.getInt("notice_no"),
							rset.getString("notice_title"),
							rset.getString("notice_content"),
							rset.getString("user_id"),
							rset.getDate("create_date")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}	
		return n;
	}
	
	public int updateNotice(Connection conn, Notice n) {
		// update 문 => 결과는 처리된 행 수 => 트랜잭션처리 해줘야한다.
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql =prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql); // 미완성
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNo());
			//완성된 sql
			
			result = pstmt.executeUpdate(); // insert, update delete 할때
//			pstmt.executeQuery(); --> select 할때
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteNotice(Connection conn, int noticeNo) {
		// 실제로 필요없는 데이터를 삭제할 경우 실제로 db에서 삭제해준다
		// 그게아니라 게시글 회원정보같은 중요한 정보는 실제로 안지우고 지워진 척 하는 처리만해준다
		// update -> 처리된 행 수 -> 트랜젝션 처리
		
		int result = 0;
		
		PreparedStatement pstmt = null; //sql날리기 위해서
		String sql =prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
}