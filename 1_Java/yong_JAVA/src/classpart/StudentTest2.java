package classpart;

public class StudentTest2 {

	public static void main(String[] args) {
		Student student1 = new Student(); // 첫 번째 학생 호출
		student1.studentName = "안연수";   // studentName : 멤버변수 사용
		
		
		Student student2 = new Student(); // 두 번쨰 학생 호출
		student2.studentName = "안승연";  // studentName : 멤버변수 사용
		
		
		System.out.println(student1);
		System.out.println(student2);
		
		
		/*
		 * 출력시 나오는 classpart.Student@2a139a55 는 student1의 해시코드(hash code) 이다.
		 * 즉 참조변수는 힙(heap) 메모리 안에 저장이되는데
		 * 힙 메모리 안에 생성된 인스턴스의 메모리 주소안에 '참조변수'가 생성된다. 다른말로는  해시코드(hash code)이다.
		 * 그래서 출력시 나오는 classpart.Student@2a139a55 는 student1의 해시코드(hash code) 이다.
		 */

	}

}
