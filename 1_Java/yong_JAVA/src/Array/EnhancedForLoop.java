package Array;

public class EnhancedForLoop {

	public static void main(String[] args) {
		
		/*
		 *  	for (변수 : 배열){
		 *  		 반복 실행문;
		 *  	}
		 */
		
		String[] strArray = {"JAVA","Android","C","JavaScrip","Pyrhon"};
		
		for(String lang : strArray) {
			System.out.print(lang+" ");
		}
		System.out.println("\n"+strArray.length);
		
		for ( String leng : strArray) {
			System.out.print(leng.length()+ " ");
		}
		
		
	// "JAVA","Android","C","JavaScrip","Pyrhon" --> strArray --> lang 이 순서로 간다
		// lang 변수에는 배열의 각 요소가 대입
	}

}
