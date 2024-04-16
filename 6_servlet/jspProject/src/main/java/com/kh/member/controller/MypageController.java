package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MypageController
 */
@WebServlet("/myPage.me")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 전에 url쳐서 직접요청도 가능하다. 그러다보니 로그인 체킹을 해야한다
		// 로그인 후에만 요청받도록 한다.
		// (포워딩방식)
		
		//세센값내부에 loginUser가 있는지 확인해보자.
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) { // 로그인이 안되있는 상태
			session.setAttribute("alerMsg", "로그인 후 이용가능한 서비스입니다");
			response.sendRedirect(request.getContextPath());
			
		} else { //로그인이 되어있는 상태
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage.jsp");
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
