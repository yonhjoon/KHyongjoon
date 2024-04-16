import java.util.Scanner;
public class Array07 {

	public static void main(String[] args) {
		
		/*
		 * 사용자가 입력한 값이 배열에있는지 검색하여
		 * 있으면 "000 치킨 배달 가능" 없으면 000치킨은 없는 메뉴입니다" 를 출력하세요.
		 * 단, 치킨 메뉴가 들어가있는 배열은 본인 스스로 정하세요.
		 * 
		 * ex.
		 * 치킨 이름을 입력하세요 : 양념			치킨 이름을 입력하세요 : 불닭
		 * 양념치킨 배달 가능					불닭치킨은 없는메뉴입니다.
		 */
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("치킨 이름을 입력하세요 : ");
//		int sum = sc.nextInt();
//		
//		String[] arr = {"양념"}; {
//			
//		}while(arr > )
		
		
		Scanner sc = new Scanner(System.in);
		boolean isTrus = false; //거짓
		
		String[] menu = {"후라이드","양념", "간장","반반","핫후라이드","슈프림양념"}; //치킨종류가 들어있는 메뉴배열 생성
		
		System.out.print("치킨 이름을 입력하세요 : ");
		String pick = sc.next(); // 사용자로부터 치킨 입력받음 => 양념이라 해봐야지
		
		for (int i = 0; i < menu.length; i++) { // i 는 0이고 i가 nanu.length보다 작아질때까지  0 1 2 3 4
			if(menu[i].equals(pick)) { // 사용자가 입력한 값을 메뉴에서 발견
				isTrus = true; // siTrue변수 true로 변경
				break;
			}
		}
				
				
				
			
		if (isTrus == false) { //사용자가 입력한 값을 메뉴에서 발견 했을때
		
	}
}
}
