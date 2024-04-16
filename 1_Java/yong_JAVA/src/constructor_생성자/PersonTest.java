package constructor_생성자;

public class PersonTest {
	
	public static void main(String[] args) {
		Person personKim = new Person(); //생성자 : 클래스를 처음 만들 떄 멤버변수(속성들)나 상수를 초기화를 하는것
		personKim.name = "김유신";
		personKim.height = 185.0F;
		personKim.weight = 80.5F;
		
		Person personLee = new Person("이순신", 175.4F,75.3F); // 인스턴스 변수 초기화와 동시에 클래스 생성
		Person personJang = new Person("장용준",178.8F,75.4F);
		
		System.out.println("이름 : " + personLee.name + " 키 : " + personLee.height + " 몸무게 : " + personLee.weight);
		System.out.println("이름 : " + personKim.name+ " 키 : " + personKim.height + " 몸무게 : " + personKim.weight);
		System.out.println("이름 : " + personJang.name + " 키 : " + personJang.height + " 몸무게 : " + personJang.weight);
	}
}


