package com.kh.Test2401232;

public class Book {
	//필드 -> private으로 한다 (외부의 접근을 차단)
	private String title;
	private String author;
	private String date;
	private int number;
	
	//생성자
	public Book(String title, String author, String date, int number) {
		super();//부모 생성자 한테 상속받는것 //없어도 기본생성자 호출되니깐 상관xx 
				//왜냐하면 지금은 부모한테 상속받는게 없으니깐
		this.title = title;
		this.author = author;
		this.date = date;
		this.number = number;
	}
	
	
	
	//private으로 선언된 필드에 접근하기위해 getter/setter메소드 사용해야됨.
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}



	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", date=" + date + ", number=" + number + "]";
	}
	
	

}
