package Array;

import java.util.ArrayList; //ArrayList 클래스 import

public class ArrayListTest {

	public static void main(String[] args) {
		
		// ArrayList<E> 배열이름 = new ArrayList<E>();
		
//		ArrayList<Book> library = new ArrayList<Book>(); //ArrayList 선언
//		
//		//add() 메서드로 요소 값 추가
//		library.add(new Book("태백산맥","조정래"));
//		library.add(new Book("데미안","헤르만 헤세"));
//		library.add(new Book("어떻게 살 것인가","유시민"));
//		library.add(new Book("토지","박경리"));
//		library.add(new Book("어린왕자","생텍쥐페리"));
//		
//		// 배열에 추가된 요소 개수만큼 추가
//		for (int i = 0; i < library.size(); i++) {
//			Book book = library.get(i);
//			book.showInfo();
//		}
//		System.out.println();
//		
//		System.out.println("===향상된 for 이용===\n");
//		for (Book book : library) {
//			book.showInfo();
//		}
//		
//		for (int i = 0; i < library.size(); i++) {
//			Book book = library.get(i);
//			book.showInfo();
//		}
		
		ArrayList<Student> stu = new ArrayList<Student> ();
		
		stu.add(new Student(1000,"James"));
		stu.add(new Student(1001,"Tomas"));
		stu.add(new Student(1002,"Edward"));
		
		for (Student student : stu) {
			student.showInfo();
		}
		
		}

}
