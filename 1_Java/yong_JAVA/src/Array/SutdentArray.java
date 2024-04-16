package Array;

public class SutdentArray {
	public static void main(String[] args) {
		Student[] sd = new Student[3];
		
		sd[0] = new Student(1001,"James");
		sd[1] = new Student(1002,"Tomas");
		sd[2] = new Student(1003,"Edward");
		
		for (int i =0; i < sd.length; i++) {
			sd[i].showInfo();
		}
	}

}
