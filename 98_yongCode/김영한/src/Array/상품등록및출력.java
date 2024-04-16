package Array;

import java.util.Scanner;

public class 상품등록및출력 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("등록할 상품의 갯수 : ");
		int number = sc.nextInt();
		String[] productNames = new String[number]; //상품 이름을 저장할 String 배열
		int[] productPrices = new int[number]; //상품 가격을 저장할 int 배열
		int productCount = 0; // 현재 등록된 상품의 개수를 저장할 int 변수
		
		while(true) {
			System.out.print("1.상품 등록 | 2.상품 목록 | 3.종료 \n");
			System.out.print("메뉴를 입력하세요 : ");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				if(productCount == number) {
					System.out.println("더 이상 상품을 등록할 수 없습니다.");
					continue;
				}
				System.out.print("상품 이름을 입력하세요: ");
				productNames[productCount] = sc.next();
				
				System.out.print("상품 가격을 입력하세요: ");
				productPrices[productCount] = sc.nextInt();
				
				productCount++;
			} else if(menu == 2) {
				if(productCount == 0) {
					System.out.println("등록된 상품이없습니다 되돌아갑니다.");
					continue;
				}
				for(int i = 0; i < productCount; i++) {
					System.out.println(productNames[i] + ": " + productPrices[i] 
							+ "원");

				}
				
			}
			
		}
		
		
		
	}

}
