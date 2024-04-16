package staticex;

public class StudentTest4 {

	public static void main(String[] args) {
		Student2 Lee = new Student2();
		Lee.setName("이지원");
		System.out.println(Student2.getSerialNum()); //serialNum값을 가져오기 위해 get() 메서드를 클래스 이름으로 직접 호출
		System.out.println(Lee.Name + " 학번 : " + Lee.ID);
		
		Student2 Son = new Student2();
		Son.setName("손수경");
		System.out.println(Student2.getSerialNum()); //serialNum값을 가져오기 위해 get() 메서드를 클래스 이름으로 직접 호출
		System.out.println(Son.Name + " 학번 : " + Son.ID);
		
	}

}
