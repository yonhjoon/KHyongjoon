package com.kh.spring.member.conteoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

@Controller
public class MemberController {
	// 맵핑을 처리할 메서드만 만들어주면된다
	
//	private MemberService memberService = new MemberServiceImpl();
	/*
	 * 기존 객체 생성 방식
	 * 객체간 결합도가 높아짐 (소스코드 수정이 일어날 경우 하나하나 전부 다 바꿔줘야한다. 즉 유지보수가 힘들어진다)
	 *  -(결합도가 낮을수록 좋아짐! 이유는 낮아질수록 객체들의 의존도가 높아져서 유지보수가 쉬워짐)
	 * 서비스가 동시에 매우 많은 횟수요청이 될 경우 그만큼 객체가 생성된다.
	 * 
	 * Spring의 DI(Dependency Injection)를 이용한 방식
	 * 객체를 생성해서 주입해준다.
	 * new라는 객체생성 키워드없이 @Autowired 라는 어노테이션 만으로 사용해야한다.
	 */
	
	@Autowired //주입받아서 쓸거야 할떄 쓰는거
	private MemberService memberService; //인터페이스 라 바뀌어도 상관없음
	
	
	/**
	 * Spring에서 파라미터를 받는 방법
	 * 1.HttpServletRequest를 활용해서 전달받기(jsp/servlet방식)
	 * 해당 메소드의 매개변수로 HttpServletRequest를 작성해두면
	 * 스피링컨테이너가 해당 메소드를 호출시 자동으로 객체생성해서 매개변수로 주입해준다.
	 */
	
//	@RequestMapping("login.me") // 맵핑역활  @RequestMapping("서블릿주소")
//	public String loginMember(HttpServletRequest request) {
//		String userId =request.getParameter("userId");
//		String userPwd =request.getParameter("userPwd");
//		
//		System.out.println("userId : " + userId);
//		System.out.println("userPwd : " + userPwd);
//		
//		return "main";
//		// WEB-INF/ views/main.jsp 랑 같다
//		// servlet-context.xml 의 beans 설정을 해야된다
//	}
	
	
	/**
	 * 2. @RequestParam 어노테이션을 이용하는 방법
	 * request.getParameter("키")로 벨류를 추출하는 역활을 대신해주는 어노테이션
	 * value속성의 벨류로 jsp에서 작성했던 name속성값을 담으면 알아서 해당 매개변수로 받아올 수 있다.
	 * 만약, 넘어온값이 비어있는 형태라면 defaultValue속성으로 기본값을 지정할 수 있다
	 */
	
//	@RequestMapping("login.me") // 맵핑역활  @RequestMapping("서블릿주소")
//	public String loginMember(@RequestParam(value="userId", defaultValue="testId") String Id,@RequestParam String userPwd) {
//		//@RequestParam 이 생략되어있다 적지않아도 적용이되어있다
//		
//		System.out.println("userId : " + Id);
//		System.out.println("userPwd : " + userPwd);
//		
//		return "main";
//		// WEB-INF/ views/main.jsp 랑 같다
//		// servlet-context.xml 의 beans 설정을 해야된다
//	}
	
	
	/**
	 * 3.커맨드 객체 방식 (통으로받는다 라고 생각하면된다)
	 * 
	 * 해당 메소드의 매개변수로
	 * 요청시 전달값을 담고자하는 VO 클래스의 타입을 세팅 후
	 * 요청시 전달값의 키값(jsp의 name속성값)을 vo클래스에 담고자하는 필드명으로 작성
	 */
	
	
//	@RequestMapping("login.me") // 맵핑역활  @RequestMapping("서블릿주소")
//	public String loginMember(Member m) {
//		
//		System.out.println("userId : " + m.getUserId());
//		System.out.println("userPwd : " + m.getUserPwd());
//		
//		//원래 해야하는거
//		Member loginUser = memberService.loginMember(m);
//		
//		if(loginUser == null) {
//			System.out.println("로그인실패");
//		}else {
//			System.out.println("로그인성공");
//		}
//		
//		return "main";
//		// WEB-INF/ views/main.jsp 랑 같다
//		// servlet-context.xml 의 beans 설정을 해야된다
//	}

	/*
	 * 요청퍼리 후 응답데이터를 담고 포워딩 또는 url재요청 처피하는 방법
	 * 포워딩할 응답뷰로 전달하고자하는 데이터를 맵형식(k-v)으로 담을 수 있는 영역
	 * Model객체는 requestScope
	 * request.setAttribute->model.addAttribute()
	 */

//	@RequestMapping("login.me") // 맵핑역활  @RequestMapping("서블릿주소")
//	public String loginMember(Member m, Model model,HttpSession session) {
//		Member loginUser = memberService.loginMember(m);
//		
//		if(loginUser == null) { // 로그인 실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
//			model.addAttribute("errorMsg", "로그인실패");
//			
//			// /WEB-INF/views/common/errorPage.jsp
//			return "common/errorPage";
//			
//		}else {// 로그인 성공=> sessionScope에 로그인유저 담아서 메인으로 url재요청
//			
//			// redirect 재요청url
//			session.setAttribute("loginUser", loginUser);
//			return "redirect:/";
//		}
//	}
	
	//2. 스프링에서 제공하는 ModelAndView객체사용
	
	@RequestMapping("login.me") // 맵핑역활  @RequestMapping("서블릿주소")
	public ModelAndView loginMember(Member m, ModelAndView mv,HttpSession session) {
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser == null) { // 로그인 실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
			mv.addObject("errorMsg", "로그인실패");
			
			// /WEB-INF/views/common/errorPage.jsp
			//return "common/errorPage";
			mv.setViewName("common/errorPage");
			
		}else {// 로그인 성공=> sessionScope에 로그인유저 담아서 메인으로 url재요청
			// redirect 재요청url
			session.setAttribute("loginUser", loginUser);
			//return "redirect:/";
			mv.setViewName("redirect:/ ");
		}
		
		return mv;
	}
	
//	로그아웃!
	@RequestMapping("logout.me") //뭐로 반환할지는 본인마음
	public String logoutMenber(HttpSession session) {
		//로그아웃 ->session에서 loginUser 삭제, 만료
		//session.invalidate(); //만료
		session.removeAttribute("loginUser");
		
		return "redirect:/";
		//리다이렉트(Redirect)는 사용자가 처음 요청한 URL이 아닌, 다른 URL로 보내는 것을 뜻해요. 
		// =>예를 들어, 웹사이트 A의 주소로 접속한 사용자를 웹사이트 B로 이동시키는 것이죠
		// 스프링의 방식차이여서 그냥 받아오냐 redirect로 받느냐의 차이이므로 미리 스프링설정으로 servlet-context.xml 안에 경로 설정을 했으므로 "main"만 적어도
		// 자동으로 WEB-INF/views/main.jsp 로 간다
		//현재 적용 방식은 초기url로 돌아가는것이므로 메인페이지로 가는것이다 다른곳으로 이동하고싶으면 / 뒤에 url주소를 넣으면된다
	}
	
	// 회원가입
	@RequestMapping("enrollForm.me")
	public String enrollForm() {
		return "member/memberEnrollForm";
	}
	
	
	/*
	 * ajax요청에 대한 응답을 위한 controller에는 @ResponseBody어노테이션을 작성해줘야한다.
	 * 기본적인 세팅이 jsp응답으로 되어있기 때문에 @ResponseBody을 작성해주면
	 * 반환값을 http응답 객체에 직접 작성하겠다 라는 의미를 가지고있다.
	 */
	// idCheck ajax요청을 받아줄 controller
	@ResponseBody
	@RequestMapping("idCheck.me")
	public String idCheck(String checkId) {
		int result = memberService.idCheck(checkId);
		
		if(result > 0) {// 이미존재한다면
			return "NNNNN";
		}else { // 존재하지 않는다면
			return "NNNNY";
		}
		
		//return memberService
	}
	
	@RequestMapping("insert.me")
	public String insertMember(Member m) {
		/*
		 * 1. 한글깨짐 문제가 발생 => web.xml에 스프링에서 제공하는 인코딩 필터를 등록해주면된다.
		 * 2. 나이를 입력하지않을 경우 int자료형에 반문자열을 대입해야하는 경우가 발생한다.
		 * => 400에러 발생 Member의 age필드 자료형을 String으로 변경해주면 된다.
		 */
		
		System.out.println(m);
		return "main";
	}


}
