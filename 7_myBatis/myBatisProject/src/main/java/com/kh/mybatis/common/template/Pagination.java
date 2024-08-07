package com.kh.mybatis.common.template;

import com.kh.mybatis.common.vo.PageInfo;

public class Pagination {
	/*
	   총 게시글 수(전체게시글 수) 알아야 페이징처리를 할 수 있다.
	 int listCount; //현재 총 게시글 수
	 int currentPage; // 현재 페이지를 알수있는 방법(사용자가 요청한 페이지 1페이지면 1페이지 2페이지면 2페이지)
	 int pageLimit; // 페이지 하단에 보여질 페이징바의 갯수
	 int boardLimit; // 한 페이지내에 보여질 게시글 최대갯수
	 값을 전달 받아 maxPage, startPage, endPage값을
	 구하고 하나의 pageInfo객체로 만들어서 반환
	 //위 4개의 값을 기준으로 아래 3개의 값을 구해야함
		
	 int maxPage; // 가장 마지막 페이지 (총 페이지의 수 랑 같다 (listCount % boardLimit))
	 int startPage; // 페이징바의 시작수
	 int endPage; // 페이징바의 마지막 끝수
	 */
	public static PageInfo getPageInfo(int listCount,int currentPage,int pageLimit, int boardLimit) {
		int maxPage =(int) Math.ceil((double)listCount / boardLimit); // 가장 마지막페이징(총 페이지 수)
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1; // 페이징바의 시작
		int endPage = startPage + pageLimit - 1; // 페이징바의 끝수
	
		endPage = endPage > maxPage ? maxPage : endPage;
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		return pi;
		
	}
}
