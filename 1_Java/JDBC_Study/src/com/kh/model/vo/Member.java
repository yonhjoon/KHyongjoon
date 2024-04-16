package com.kh.model.vo;




/*
 * VO(value object)
 * 한명의 회원(db테이블의 한 행의 데이터)에 대한 데이터를 기록할 수 있는 저장용 객체
 */

public class Member {
	
		//필드는 기본적으로 db컬럼명과 유사하게 작업
		
		private int userNo;
		private String name;
		private String author;
		private String publisher;
		private String date;
		
		
		public Member() { // 아무값도없는 기본 생성자
			super();
		}

		//모든 메게변수가있는 생성자
		public Member(int userNo, String name, String author, String publisher, String date) {
			super();
			this.userNo = userNo;
			this.name = name;
			this.author = author;
			this.publisher = publisher;
			this.date = date;
		}
		
		

		public Member(String name, String author, String publisher, String date) {
			super();
			this.name = name;
			this.author = author;
			this.publisher = publisher;
			this.date = date;
		}

		public int getUserNo() {
			return userNo;
		}

		public void setUserNo(int userNo) {
			this.userNo = userNo;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "Member [userNo=" + userNo + ", name=" + name + ", author=" + author + ", publisher=" + publisher
					+ ", date=" + date + "]";
		}
		
		
	
	
	
	
	
}

