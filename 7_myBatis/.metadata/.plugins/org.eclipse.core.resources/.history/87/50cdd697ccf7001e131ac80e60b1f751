package com.kh.common.vo;

public class PageInfo {

	//총 게시글 수(전체게시글 수) 알아야 페이징처리를 할 수 있다.
	private int listCount; //현재 총 게시글 수
	private	int currentPage; // 현재 페이지를 알수있는 방법(사용자가 요청한 페이지 1페이지면 1페이지 2페이지면 2페이지)
	private int pageLimit; // 페이지 하단에 보여질 페이징바의 갯수
	private	int boardLimit; // 한 페이지내에 보여질 게시글 최대갯수
	//위 4개의 값을 기준으로 아래 3개의 값을 구해야함
		
	private int maxPage; // 가장 마지막 페이지 (총 페이지의 수 랑 같다 (listCount % boardLimit))
	private int startPage; // 페이징바의 시작수
	private int endPage; // 페이징바의 마지막 끝수
	
	public PageInfo() {
		super();
	}

	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
	
}
