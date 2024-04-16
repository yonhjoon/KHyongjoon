package staticex;

public class Student2 {

	private static int serialNum = 1000; // private 변수로 변경
	int ID;
	String Name;
	int grade;
	String address;
	
	public Student2() {
		serialNum++;
		ID = serialNum;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	public static int getSerialNum() { //serialNum의 get() 메서드
		int i = 10;
		return serialNum;
	}
	
	public static void setserialNum(int serialNum) { // serialNum의 set() 메서드
		Student2.serialNum = serialNum;
	}
	
	
	
}
	
