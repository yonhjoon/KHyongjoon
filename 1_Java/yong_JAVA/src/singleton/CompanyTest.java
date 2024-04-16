package singleton;

public class CompanyTest {

	public static void main(String[] args) {
		Company myCompany1 = Company.getInstance(); // 클래스 이름으로 getInstance() 호출하여 참조변수에 대입
		Company myCompany2 = Company.getInstance(); // 클래스 이름으로 getInstance() 호출하여 참조변수에 대입
		System.out.println(myCompany1 == myCompany2); // 두 변수가 값은 값인지 확인
	}

}
