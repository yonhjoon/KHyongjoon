
public class BufferedReader {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		String s = br.readLine();
		int i = Integer.parseInt(br.readLine());
		
		// 1) 입력은 readLine();이라는 메소드를 사용한다. 
		// 2) String으로 리턴 값이 고정되어 있기 때문에, 다른 타입으로 입력을 받고자 한다면 반드시 형변환이 필요하다
		// 3) 예외처리를 반드시 필요로 한다. readLine()시 마다 try / catch문으로 감싸주어도 되고, 
		//    throws IOException 을 통한 예외처리를 해도 된다.(대부분의 경우에 후자를 사용한다.)
		
		
		// - 데이터 가공
		// BufferedReader를 통해 읽어온 데이터는 개행문자 단위(Line 단위)로 나누어진다. 
		// 만약 이를 공백 단위로 데이터를 가공하고자 하면 따로 작업을 해주어야 한다. 
		// 이때 사용하는 것이 StringTokenizer나 String.split() 함수이다.
		
		// StringTokenizer 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// String.split() 함수
		String arr[] = s.split(" ");
		
//		StringTokenizer의 nextToken() 함수를 쓰면 
//		／／　readLine()을 통해 입력 받은 값을 공백 단위로 구분하여 순서대로 호출할 수 있다.
//		String.split() 함수를 사용하면, 배열에 공백단위로 끊어 데이터를 저장하여 사용할 수 있다.
	}

}
