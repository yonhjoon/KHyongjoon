package com.kh.notice.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;
import static com.kh.common.JDBCTemplate.*;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList(){
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		return list;
	}
	
	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
//	조회수 올리는거
	public Notice increaseCount(int noticeNo) {
		Connection conn = getConnection();
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		
		Notice n = null;
		if (result > 0) { // 성공
			commit(conn);
			n = new NoticeDao().selectNotice(conn, noticeNo);
		} else { // 실패
			rollback(conn);
		}
		
		close(conn);
		return n;
	}
	
	// 공지사항 수정하기
	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
		
		close(conn);
		return n;
	}
	
	// 리턴이 뭘로될까? (모르면 복습꼭해라 좀 새끼야)
	//전달하고자하는게 update이다 전달되는건 행의 수 이니 int 이다
	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		int result = new NoticeDao().updateNotice(conn, n);
		
		//트랜잭션처리 필요한 경우
		// insert, update, delete
		if(result > 0) {
			commit(conn); // 이대로 db에 저장하겠다
		}else {
			rollback(conn); // 문제가 있으니 롤백하겠다
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		
		if(result > 0) {
			commit(conn); // 이대로 db에 저장하겠다
		}else {
			rollback(conn); // 문제가 있으니 롤백하겠다
		}
		
		close(conn);
		
		return result;
	}
	
}