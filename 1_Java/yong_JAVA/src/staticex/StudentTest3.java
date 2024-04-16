package staticex;

public class StudentTest3 { // 클래스 이름으로 static 변수 참조하기

	public static void main(String[] args) {
		Student1 Lee = new Student1();
		Lee.setStudentName("이지원");
		System.out.println(Student1.serialNum); //  serialNum 변수를 직접 클래스 이름으로 참조
		System.out.println(Lee.studentName + " 님의 학번 : " + Lee.studentID);
		
		Student1 Son = new Student1();
		Son.setStudentName("손수연");
		System.out.println(Student1.serialNum); //  serialNum 변수를 직접 클래스 이름으로 참조
		System.out.println(Son.studentName + "님의 학번 : " + Son.studentID);

	}

}
