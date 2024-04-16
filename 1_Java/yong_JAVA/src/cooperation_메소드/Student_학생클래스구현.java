package cooperation_메소드;

public class Student_학생클래스구현 {

	public String studentName; //학생이름
	public int grade; // 학년
	public int money; // 학생이 가지고있는 돈
	
	
	public Student_학생클래스구현(String studentName,int money) { //학생 이름과 가진 돈을 매게변수로 받는 생성자
		this.studentName = studentName;
		this.money = money;
	}
	
	public void takeBus(Bus bus) { // 학생이 버스타면 1000원을 지불하는 기능을 구현한 메소드
		bus.take(1000);
		this.money -= 1000;
	}
	
	public void takeSubway(Subway subway) { // 학생이 지하철타면 1500원을 지불하는 기능을 구현한 메소드
		subway.take(1500);
		this.money -= 1500;
	}
	
	public void takeTaxi(Taxi taxi) {
		taxi.take(10000);
		this.money -= 10000;
	}
	
	public void showInfo() {
		System.out.println(studentName + "님의 남은 돈은 : " + money + "입니다.");
	}
	
}
