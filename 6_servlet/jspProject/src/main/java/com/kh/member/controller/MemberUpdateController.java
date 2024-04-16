package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
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
		
		Member m = new Member(userId, userName, phone, email, address, interest);
	
		Member updateMem = new MemberService().updateMember(m);
		
		if(updateMem == null) { //업데이트 실패
			//에러문구 담아서 에러페이지 포워딩
			request.setAttribute("errorMsg", "회원정보 수정에 실패하셨습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}else { // 업데이트 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem);
			session.setAttribute("alertMsg", "성공적으로 수정하였습니다.");
			
			// url 재요청 => 마이페이지 재요청(/kh/myPage.me)
			response.sendRedirect(request.getContextPath() + "/myPage.me");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
