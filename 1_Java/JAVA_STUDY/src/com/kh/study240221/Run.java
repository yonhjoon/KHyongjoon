package com.kh.study240221;

public class Run {

	public static void main(String[] args) {
//		Member m = new Member();
//		m.changeName("장용준");
//		m.printName();
		
		Book b1 = new Book();
		Book b3 = new Book("홍길동전", "한글출판", "허균");
		Book b5 = new Book("홍길동전", "한글출판", "허균",39900,0.1);
		
		System.out.println(b1.toString());
		System.out.println(b3.toString());
		System.out.println(b5.toString());
		
	}

}
