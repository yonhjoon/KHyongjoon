package cooperation_메소드;

public class TakeTrans {

	public static void main(String[] args) { //학생 두명 생성
		Student_학생클래스구현 studentJames = new Student_학생클래스구현("James",5000);
		Student_학생클래스구현 studentTomas = new Student_학생클래스구현("Tomas",10000);
		Student_학생클래스구현 studentJang = new Student_학생클래스구현("Jang",30000);
		 
		Bus bus100 = new Bus(100); //노선 번호가 100인 버스 생성
		studentJames.takeBus(bus100); //James이 100번 버스를 탐
		studentJames.showInfo(); // James 정보 출력
		bus100.showInfo(); // 버스정보출력
		
		Subway subwayGerrn = new Subway("2호선"); //노선 번호가 2호선인 지하철 생성
		studentTomas.takeSubway(subwayGerrn); // Tomas가 2호선을 탐
		studentTomas.showInfo();  // Tomas 정보출력
		subwayGerrn.showInfo(); // 지하철 정보 출력
		
		Taxi tx = new Taxi("5885");
		studentJang.takeTaxi(tx);
		studentJang.showInfo();
		tx.showInfi();	}

}
