package inheritance;

public class CustomerTest {

	public static void main(String[] args) {
		Customer Lee = new Customer(0, null);
		Lee.setCustomerID(10010);  //customerID  ------ 
		Lee.setCustomerName("이순신"); //customerName  --ID 와 Name 는 protected 변수 이므로 set메서드 호출
		Lee.bonusPoint = 1000;
		System.out.println(Lee.showCustomerInfo());
		
		VIPCustomer Kim = new VIPCustomer(0, null, 0);
		Kim.setCustomerID(10020);  //customerID  ------ 
		Kim.setCustomerName("김유신"); //customerName  --ID 와 Name 는 protected 변수 이므로 set메서드 호출
		Kim.bonusPoint = 10000;
		System.out.println(Kim.showCustomerInfo());
		
		
		
		
	}

}
