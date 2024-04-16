package inheritance;

public class CustomerTest2 {
	public static void main(String[] args) {
		VIPCustomer Kim = new VIPCustomer(10020, "김유신", 10000); // 하위 클래스 생성
//		Kim.setCustomerID(10020);
//		Kim.setCustomerName("김유신");
		Kim.bonusPoint = 10000;
		System.out.println(Kim.showCustomerInfo());

	}

}
