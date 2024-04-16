package singleton;

public class CarFactoryTest {
	public static void main(String[] args) {
		CarFactory factory = new CarFactory(); //싱글톤패턴
		Car mySonata = factory.careateCar();  // 메서드에서 Car 생성
		Car yourSonata = factory.careateCar(); 
		System.out.println(mySonata.getMySonata()); // 10001 출력
		System.out.println(yourSonata.getYourSonata()); // 10002출력
	}
}
