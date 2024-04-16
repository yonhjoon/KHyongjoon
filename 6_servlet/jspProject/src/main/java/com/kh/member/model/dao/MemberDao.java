package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member.model.vo.Member;

public class MemberDao {
   private Properties prop = new Properties();
   
   public MemberDao() {
      String filePath = MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath();
      
      try {
         prop.loadFromXML(new FileInputStream(filePath));
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public Member loginMember(Connection conn, String userId, String userPwd) {
      // select문 -> Member객체(한행) 조회 => ResultSet 객체
      
      Member m = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("loginMember");
      
      try {
         pstmt = conn.prepareStatement(sql); //미완성 sql
         pstmt.setString(1, userId);
         pstmt.setString(2, userPwd);
         
         rset = pstmt.executeQuery(); // 조회결과가 있다면 한 행 반환 | 없다면 반환 X
         if(rset.next()) {
            m = new Member(
                  rset.getInt("user_no"),
                  rset.getString("user_id"),
                  rset.getString("user_pwd"),
                  rset.getString("user_name"),
                  rset.getString("phone"),
                  rset.getString("email"),
                  rset.getString("address"),
                  rset.getString("interest"),
                  rset.getDate("enroll_date"),
                  rset.getDate("modify_date"),
                  rset.getString("status"));                                                
         }
         
         
      } catch (SQLException e) {
         
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return m;
   }
   
   public int insertMember(Connection conn, Member m) {
	   //insert문 => 처리된 행 수 => 트랜잭션처리
	   
	   int result = 0;
	   
	   PreparedStatement pstmt = null;
	   String sql = prop.getProperty("insertMember"); //미완성
	   
	   try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, m.getUserId());
		pstmt.setString(2, m.getUserPwd());
		pstmt.setString(3, m.getUserName());
		pstmt.setString(4, m.getPhone());
		pstmt.setString(5, m.getEmail());
		pstmt.setString(6, m.getAddress());
		pstmt.setString(7, m.getInterest());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	 return result;
   }
   
   public int updateMember(Connection conn, Member m) {
	   //update문 이니깐 처리된 함수가 반환된다 그래서 int형으로 반환한다
	   int result = 0; //반환될거 하나 만들어주고
	   
	   PreparedStatement pstmt = null;
	   String sql = prop.getProperty("updateMember");
	   
	   try {
		pstmt = conn.prepareStatement(sql);// 미완성 sql
		
		pstmt.setString(1, m.getUserName());
	    pstmt.setString(2, m.getPhone());
	    pstmt.setString(3, m.getEmail());
	    pstmt.setString(4, m.getAddress());
	    pstmt.setString(5, m.getInterest());
	    pstmt.setString(6, m.getUserId());
	    
	    result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	   
	   return result;
   }
   
   public Member selectMember(Connection conn,String userId) {
	   //우리는 여기서 어떤 쿼리를 날리것인가?
	   // select -> 유니크한 Id : resultset(한행) -> Member객체
	   
	   Member m = null;
	   
	   PreparedStatement pstmt = null;
	   ResultSet rset = null;//결과값이오는 셀렉트문
	   String sql = prop.getProperty("selectMember");
	   
	   try {
		pstmt = conn.prepareStatement(sql); // 미완성된  sql
		pstmt.setString(1, userId);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			m = new Member(
                  rset.getInt("user_no"),
                  rset.getString("user_id"),
                  rset.getString("user_pwd"),
                  rset.getString("user_name"),
                  rset.getString("phone"),
                  rset.getString("email"),
                  rset.getString("address"),
                  rset.getString("interest"),
                  rset.getDate("enroll_date"),
                  rset.getDate("modify_date"),
                  rset.getString("status")
                ); 
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	   
	   return m;
   }
   
   public int updatePwdMember(Connection conn, String userId, String userPwd, String updatePwd) {
		//update =>처리된 행수 => 트랜잭션
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql); //미완성
			
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

   
   public int deleteMember(Connection conn, String userId, String userPwd) {
		//delete(update) -> 처리된 행수 -> 트랜잭션
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
   public int idCheck(Connection conn, String checkId) {
		//select => ResultSet 한행 => int
		int count = 0;
		
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				count = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
	}
   
}