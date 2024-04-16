package staticex;

public class Student3 {
	
	public static int serialNum = 1000;
	public int studentID;
	public String studentName;
	public int grade;
	public String address;
	public int card = 100;
	
	public Student3() {
		serialNum += 100;
		return studentID;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.serialNum += (serialNum + card) ;
	}
	
	
	
	
}


