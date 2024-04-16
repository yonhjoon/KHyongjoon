package cooperation_메소드;

public class Subway {
	
	String LineNumber; //노선
	int passengerCount; // 승객 수
	int money; // 수입액
	
	
	public Subway(String LineNumber) { //지하철 노선 번호를 매게변수로 받은 생성자
		this.LineNumber = LineNumber;
	}
	
	public void take(int money) { // 승객이 지하철을 탄 경우에 구현한 메소드
		this.money += money; // 수입증가
		passengerCount++; //승객 수 증가
	}
	
	public void showInfo() { // 지하철 벙보 출력하느 메서드
		System.out.println(LineNumber + "의 승객은 " + passengerCount + "명이고 , 수입은 : " + money + "입니다");
		
	}

}
