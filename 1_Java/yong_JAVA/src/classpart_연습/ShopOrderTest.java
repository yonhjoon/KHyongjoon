package classpart_연습;

public class ShopOrderTest {

	public static void main(String[] args) {
		
		ShopOrder so = new ShopOrder();
		
		so.number = 201803120001L;
		so.ID = "abc123";
		so.date = "2018년 3월 12일" ;
		so.name = "홍길순";
		so.ProductNumber = "PD0345-12";
		so.address = "서울시 영등포구 여의도동 20번지";
		
		
		
		

		System.out.println("주문번호 : " + so.number + "\n주문자 아이디 : " + so.ID + "\n주문 날짜 : " + so.date + "\n주문자 이름 : " + so.name + "\n주문 상품 번호"
				+ so.ProductNumber + "\n배송 주소 : " + so.address);
	}

}
