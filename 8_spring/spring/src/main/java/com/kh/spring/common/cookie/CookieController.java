package com.kh.spring.common.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	/*
	 * cookie
	 * 브라우저에 저장되는 데이터 조각, 주로 사용자를 식별하고 상태정보를 기억하는데 사용된다.
	 * 쿠키는 클라리언트(브라우저)의 로컬 저장소에 저장이된다.
	 * 저장된 쿠키정보는 서버에 http요청시 헤더에 담겨 함께 전송이 된다.    로컬스트리지
	 * 
	 * 쿠키는 보안성이 낮고 개인정보 유출에 취약할 수 있다. 따라서 중요정보를 저장하는데 사용하려면 보안적인 조취가 필요하다.
	 */
	
	@RequestMapping("create")
	public String create(HttpServletResponse response) {
		// 쿠키는 객체를 생성한 다음 응답정보에 첨부할 수 있다
		// 저장할때는 name, value속성을 필수로 작성해야한다.
		Cookie ck = new Cookie("test","jangyongjoon");//쿠키 라는 객체 생성
//		ck.setMaxAge(60 * 60 * 24); //(24시간) 굳이 주진않는다
		//초 단위로 저장할 수 있다. 즉 시간저장 (60초 곱하기 60 =1시간 곱하기 24시간 즉 하루를 설정하는거다)
		response.addCookie(ck); // 응답정보 f12 에플리케이션 쿠키에 있다
		
		Cookie ck2 = new Cookie("test2","SE");//쿠키 라는 객체 생성
		response.addCookie(ck2); // 응답정보  f12 에플리케이션 쿠키에 있다
		
		Cookie ck3 = new Cookie("id","joon");//쿠키 라는 객체 생성
		response.addCookie(ck3); // 응답정보  f12 에플리케이션 쿠키에 있다
		
		return "cookie/create"; // 리턴을 cookie폴더안에 create.jsp 으로
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletResponse response) {
		// 쿠키는 삭제 명령어가 따로 없음
		// 0초로 만료시간을 지정후 덮어쓰기를 진행하면 된다
		
		Cookie ck = new Cookie("test","jangyongjoon");//쿠키 라는 객체 생성
		ck.setMaxAge(0); //시간을 0초로 설정
		response.addCookie(ck); // 응답정보 f12 에플리케이션 쿠키에 있다
		
		return "cookie/delete"; // 리턴을 cookie폴더안에 create.jsp 으로
	}
	
	
	
}
