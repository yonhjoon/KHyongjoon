package com.kh.Controller;



import java.util.ArrayList;

import com.kh.MemberService.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

//Controller : View를 통해서 사용자가 요청한 기능에 대해서 처리하는 담당
//해당 메소드로 전달된 데이터[가공처리후] dao로 전달하며 호출
// dao로부터 반환받은 결과 성공인지 실패인지 판단 후 응답화면 결정(view메소드 호출)
public class MemberController {

	/*
	 * 사용자의 추가요청을 처리해주는 메소드
	 * @param 책이름 ~ 발행일 : 사용자가 입력했던 정보들이 담겨있는 매게변수
	 * */
	
	public void insertMember(String name, String author, String publisher, String date) {
		//view로부터 전달받은 값을 바로 dao쪽으로 전달x
				// 어딘가(Member객체(vo))에 담아서 전달
				
				//방법1) 기본생성자로 생성 후 각 필드마다 setter를 이용해서 데이터 저장
				//방법2) 매개변수 있는 생성자로 전부 전달해서 생성
		Member m = new Member(name,author,publisher,date);
		
		int result = new MemberService().insertMember(m);
		
	}
	
	/**
	 * 사용자모두를 조회하는 메소드
	 */
	public void selectList() {
		//ArrayList를 왜 써야하는가?
		// = 조회된 결과값이 여러개일경우 쓰인다 (sql 에서 불러오는값이 SELECT * ... ORDER BY USERNAME 이므로 모든 이름 즉 여러개를 가져오기때문)
		// 조회된 결과값이 한개 이면 Array로 담을수있다. 
		
		ArrayList<Member> list = new MemberService().selectList();
		
		//조회된 결과에 따라서 사용자가 보게될 응답화면 지정
		if(list.isEmpty()) { //결과가 없을때
			new MemberMenu().displayNoData("전체 조회된결과가 없음");
		} else {
			new MemberMenu().displayMemberList(list);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
