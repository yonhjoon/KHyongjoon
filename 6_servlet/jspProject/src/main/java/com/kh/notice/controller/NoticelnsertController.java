package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.notice.model.vo.Notice;
import com.kh.notice.service.NoticeService;

/**
 * Servlet implementation class NoticelnsertController
 */
@WebServlet("/insert.no")
public class NoticelnsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticelnsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//데이터추출 -> 객체로 만들어서 서비스로 전달
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		//로그인한 회원 정보를 얻어내는방법
		//1. input type="hidden"으로 처음부터 요청시 숨겨서 전달하는 방법
		//
		//2. session영역에서 저장되어있는 회원객체로부터 얻어오는 방법
		// 무조건 session 요페이지로 가게되있어 하면 session 쓰는게 좋다
		HttpSession session = request.getSession();
		
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		
		Notice n = new Notice();
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		n.setNoticeWriter(String.valueOf(userNo));
		//insertNotice()
		
		int result = new NoticeService().insertNotice(n);
		
		// 응답페이지
		if(result == 0) {//실패시 -> error
			request.setAttribute("errorMsg", "공지사항등록에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}else { //성공시 -> list.no
			session.setAttribute("alertMsg", "공지사항을 등록하였습니다.");
			// 등록이 됬다고 알람창이 나오게할거면  해도되는데
			// 다른페이지가는게 아니라 리다리렉트 하면된다
			response.sendRedirect(request.getContextPath() + "/list.no");
			
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
