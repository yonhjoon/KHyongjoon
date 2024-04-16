package com.kh.study240221;

public class Book {

	//필드
	// 자료형 필드명;
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;
	
	
	// 생성자
	// 메소드 오버로딩으로 인해 여러개의 생성자를 생성할 수 있다.
	public Book() {
		super();
	}

	public Book(String title, String publisher, String author) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}

	public Book(String title, String publisher, String author, int price, double discountRate) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}

	// 메소드 
	// 접근제한자 반환형 메소드명(매게변수){
	// 실행할 코드
	// }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", publisher=" + publisher + ", author=" + author + ", price=" + price
				+ ", discountRate=" + discountRate + "]";
	}

}
