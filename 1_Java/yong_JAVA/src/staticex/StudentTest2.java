package staticex;

public class StudentTest2 { // 학번 확인ㅂ2

	
	public static void main(String[] args) {
		Student1 Lee = new Student1();
		Lee.setStudentName("이지원");
		System.out.println(Lee.serialNum);
		System.out.println(Lee.studentName + "학번 : " + Lee.studentID);
	
		Student1 Son = new Student1();
		Son.setStudentName("손수경");
		System.out.println(Son.serialNum);
		System.out.println(Son.studentName + "학번 : " + Son.studentID);
	}
}
