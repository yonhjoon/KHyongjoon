package cooperation_메소드;

public class Taxi {
	
	String TaxiNumber; // 택시이름
	int Km; // 거리
	int money; // 요금
	
	public Taxi(String TaxiNumber) {
		this.TaxiNumber = TaxiNumber;
	}
	
	public void take(int money) {
		this.money += money;
		Km ++;
	}
	public void showInfi() {
		System.out.println(TaxiNumber + "의 손님은" + Km + "명이고 요금은" + money + "입니다.");
	}
}
