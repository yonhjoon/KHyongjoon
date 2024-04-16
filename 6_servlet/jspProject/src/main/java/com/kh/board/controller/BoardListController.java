package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.common.vo.PageInfo;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/list.bo")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//-----------------------------------페이징 처리---------------------------------------
		//총 게시글 수(전체게시글 수) 알아야 페이징처리를 할 수 있다.
		int listCount; //현재 총 게시글 수
		int currentPage; // 현재 페이지를 알수있는 방법(사용자가 요청한 페이지 1페이지면 1페이지 2페이지면 2페이지)
		int pageLimit; // 페이지 하단에 보여질 페이징바의 갯수
		int boardLimit; // 한 페이지내에 보여질 게시글 최대갯수
		//위 4개의 값을 기준으로 아래 3개의 값을 구해야함
		
		int maxPage; // 가장 마지막 페이지 (총 페이지의 수 랑 같다 (listCount % boardLimit))
		int startPage; // 페이징바의 시작수
		int endPage; // 페이징바의 마지막 끝수
		
		// * listCount : 총 게시글 수
		listCount = new BoardService().selectListCount();
		
		// * currentPage : 현재 페이지를 알수있는 방법(사용자가 요청한 페이지 1페이지면 1페이지 2페이지면 2페이지)
		currentPage = Integer.parseInt(request.getParameter("cpage")); 
	
		// * pageLimit : 페이지 하단에 보여질 페이징바의 갯수
		pageLimit = 10;
		
		// * boardLimit : 한 페이지내에 보여질 게시글 최대갯수
		boardLimit = 10;
		
		/**
		 * maxPage : 제일 마지막 페이지 수(총 페이지 수)
		 * 
		 * 총 게시글수(listCount)  voardLimit       나눈 수      총 페이지
		 *  100                    10          => 10         10
		 *  101                    10          => 10.1       11
		 *  105                    10          => 10.5       11
		 *  
		 *  총게시글 갯수 / boardLimit = > 올림처리(소수점있어서)
		 */
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		//(double)listCount / boardLimit)  (소수점이므로 더블로 형변환한다)
		// -> Math.ceil (올림처리)
		// -> (int) (올림처리해도 double 라 int형으로 형변환 한다)
		
		/**
		 * *startPage : 페이징바 시작수
		 * 
		 * startPage = ((currentPage -1) / pageLimit) * pageLimit + 1;
		 */
		
		startPage = ((currentPage -1) / pageLimit) * pageLimit + 1;
		
		/**
		 * endPage : 페이징바의 끝수
		 * 
		 * pageLimit : 10이라는 가정하에
		 * 
		 * startPage : 1 => endPage : 10
		 * startPage : 11 => endPage : 20
		 * startPage : 21 => endPage : 30
		 */
		
		endPage = startPage + pageLimit -1;
		
		//startPage가 11이면 endPage는 20이다(만약 maxPage가 13이라면?)
		endPage = endPage > maxPage ? maxPage : endPage;
		// 삼항연산자
		// 조건식 ? 반환값1 : 반환값2
		// 물음표(?) 앞의 조건식에 따라 결괏값이 참(true)이면 반환값1을 반환하고, 
		// 결괏값이 거짓(false)이면 반환값2를 반환합니다.
		// 이때 반환값에는 값뿐만 아니라 수식, 함수 호출 등 여러 가지 형태의 명령문이 올 수 있습니다.
	
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = new BoardService().selectList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
