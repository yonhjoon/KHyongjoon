package inheritance;

public class VIPCustomer extends Customer{
	// VIP 고객 관련 기능을 구현할때만 필요한 멤버변수
	private int agentID; // VIP 고객 담당 상담원 아이디
	double saleRatio; // 할인율

	public VIPCustomer(int customerID, String customerName,  int agentID) {
		super(customerID, customerName); // 컴파일러가 자동을 ㅗ추가하는 코드. 상위클래스의 Customer()가 호출됨
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		System.out.println("VIPCustomr(int, String, int) 생성자 호출 "); // 하위 클래스 생성할 떄 콘솔 출력문
	}
	
	// VIP 고객에게만 필요한 메서드
	public int getAgentID() {
		return agentID;
	}
}
