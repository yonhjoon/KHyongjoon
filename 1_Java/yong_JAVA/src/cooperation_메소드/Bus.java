package cooperation_메소드;

public class Bus {

	int busNumber;  // 버스번호
	int passengerCount; // 승객 수
	int money; // 버스 수입
	
	
	public Bus(int busNumber) { // 버스번호를 매게변수로 받는 생성자
		this.busNumber = busNumber; 
	}
	
	public void take(int money) { // 승객이 버스에 탄 경우를 구현한 메소드
		this.money += money; // 버스 수입 증가
		passengerCount ++; // 승객 수 증가
	}

	public void showInfo() {
		System.out.println(busNumber + "번 버스의 승객은 : " + passengerCount + "명이고 수입은 : " + money + "이다.");
	}
}
