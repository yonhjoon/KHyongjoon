package Array;

public class ArrayTest2 {

	public static void main(String[] args) {
		
		double[] data = new double[5]; //double형으로 길이 5인 배열 선언
		
		data[0] = 10.0; // 첫번쨰 값에 10.0 대입
		data[1] = 20.0; // 두번째 값에 20.0 대입
		data[2] = 30.0; // 세번째 값에 30.0 대입
		
		for (int i = 0; i < data.length; i++) { //length 전체 배열 길이만큼 반복
			System.out.println(data[i]);
		}
	}

}
