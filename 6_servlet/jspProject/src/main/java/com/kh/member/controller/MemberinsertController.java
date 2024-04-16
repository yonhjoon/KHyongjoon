package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberinsertController
 */
@WebServlet("/insert.me")
public class MemberinsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberinsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 추출해서 변수 및 객체 저장
		//이 요청안에는 사용자가보낸 값들이 담겨있다
		String userId = request.getParameter("userId"); //"입력한 아이디"
		String userPwd = request.getParameter("userPwd"); //"입력한 비밀번호"
		// String userPwdCheck = request.getParameter("userPwdCheck"); 넘기는값이므로 쓸 필요없다
		String userName = request.getParameter("userName"); // "입력한 이름"
		// 여기서 부터는 필수X
		String phone = request.getParameter("phone"); // "010-1111-1111" || ""
		// input값이라 무조건 입력하지만 빈값일수도있다
		String email = request.getParameter("email"); // "adasd@naver.com" || ""
		// input값이라 무조건 입력하지만 빈값일수도있다
		String address = request.getParameter("address"); // "서울시 양천구" || ""
		// input값이라 무조건 입력하지만 빈값일수도있다
		
		String[] interestArr = request.getParameterValues("interest"); //["등산", "영화"] || null
		//여러개를 받아올때는 배열로
		
		//String[] ==> String 으로 변경
		// ["등산", "영화"] == > "등산,영화" 로 바꿀것이다
		String interest = "";
		if(interestArr != null) {
			interest = String.join(", ", interestArr);
			//interesstArr 요 배열안에있는걸 ", " 으로 구분한다 => "등산, 영화"
		}
		
		Member m = new Member(userId, 
							  userPwd, 
							  userName, 
							  phone, 
							  email, 
							  address, 
							  interest);
		
		// 3) sql요청 => service => dao => sql실행
		
		int result = new MemberService().insertMember(m);
		
		// 4) 결과값에 따른 페이지 변환
		
		if(result > 0) { //회원가입 성공
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 성공하였습니다.");
			
			//jsp url 재요청 => index페이지로
			response.sendRedirect(request.getContextPath());
			
		} else { // 회원가입 실패
			// 이곳으로온다면 실패한것이므로 에러문구가 보여지는 에러페이지로 보낸다
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
