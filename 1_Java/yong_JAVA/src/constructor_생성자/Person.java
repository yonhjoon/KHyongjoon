package constructor_생성자;

public class Person {

	String name; //이름
	float height; // 키
	float weight; //몸무게
	
//	public Person() { // 자바 컴파일러가 자동으로 제공하는 '디폴트 생성자' -- 생성자를 만들지않아도 자동으로 생성자가 만들어진다.
//		
//	}
	
//	public Person() {} //디폴트 생성자 직접 추가
//	
//	public Person(String pname) { // 사람 '이름을 매게변수로 입력'받아서 Person 클래스를 생성하는 '생성자'
//		name = pname;
//	}
	
	public Person() {} // 디폴트 생성자
	
	public Person(String pname) { // 이름을 매게변수로 입력받은 생성사
		name = pname;
	}
	
	public Person(String pname,float pheight, float pweight ) { // 이름 , 키, 몸무게를 매게변수로 입력받은 생성자
		name = pname;
		height = pheight;
		weight = pweight;
	}
	
	
	
	
	
	
}
