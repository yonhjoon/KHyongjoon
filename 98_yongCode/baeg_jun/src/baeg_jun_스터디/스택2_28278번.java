package baeg_jun_스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 스택2_28278번 {
		Scanner sc = new Scanner(System.in);
		
		// push X: 정수 X를 큐에 넣는 연산이다.
		// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 
		//      만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// size: 큐에 들어있는 정수의 개수를 출력한다.
		// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
		// front: 큐의 가장 앞에 있는 정수를 출력한다. 
		//        만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		// back: 큐의 가장 뒤에 있는 정수를 출력한다. 
		//       만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		
		//알고리즘 분류 : Q
		
		static int[] q = new int[2000000]; //
		
		static int size = 0;
		static int front = 0;
		static int back = 0;
		
		static StringBuilder sb = new StringBuilder();
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			StringTokenizer st;
			int N = Integer.parseInt(br.readLine());
			
			while(N-- > 0) {
				st = new StringTokenizer(br.readLine(), "");
				
				switch(st.nextToken()) {
				case "push" : push(Integer.parseInt(st.nextToken())); break;
				case "pop" : pop(); break;
				case "size" : size(); break;
				case "empty" : empty(); break;
				case "front" : front(); break;
				case "back" : back(); break;
				}
			}
			System.out.println(sb);
			
	}
		
		static void push(int n) {
			q[back] = n;
			back++;
			size++;
		}
		
		static void pop() {
			if(size == 0) {
				sb.append(-1).append('\n');
			} else {
				sb.append(q[front]).append('\n');
				size--;
				front++;
			}
		}
		
		static void size() {
			sb.append(size).append('\n');
		}

}
