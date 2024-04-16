package com.kh.common;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AjaxTextController
 */
@WebServlet("/jqAjax.do")
public class AjaxTextController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTextController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	
		//여러개를 응답하고싶지만 할 수 없다.
		//response.getWriter().print(name);
		//response.getWriter().print(age);
		
		/*
		 * JSON(자바스크립트에서 객체를 표기했던 방법, 실제로는 파일형식을 의미한다)
		 * ajax통신시 데이터전송에 가장 많이 사용되는 포맷형식중 하나
		 * 
		 * {key:value, key:value ... } => JSONObject
		 * [value, value, value ...] => JSONArray
		 */
		
		// JSONArray 방식
//		JSONArray jArr = new JSONArray();
//		jArr.add(name);
//		jArr.add(age);
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jArr);
		
		// JSONObject방식
//		JSONObject jobj = new JSONObject(); // {}
//		jobj.put("name", name); // {name : 장용준}
//		jobj.put("age", age); // {name : 장용준, age : 27}
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jobj);
		
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member(1, "장용준", "01011112222"));
		list.add(new Member(2, "윤세련", "01022223333"));
		list.add(new Member(3, "장세윤", "01033334444"));
		
		// 이렇게 보낼수도있다 하지만 너무 귀찮다 너무 많다
//		JSONArray jArr = new JSONArray();
//		for(Member m : list) {
//			JSONObject jobj = new JSONObject();
//			jobj.put("userNo", m.getUserNo());
//			jobj.put("userName", m.getUserName());
//			jobj.put("phone", m.getPhone());
//			
//			jArr.add(jobj);
//		}
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jArr);
		
		// 조금 더 간편한 방식
		response.setContentType("text/html; charset=UTF-8");
		 new Gson().toJson(list, response.getWriter());
		// response.getWriter() 을 list 형식으로 Json으로 바꿔준다
				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
