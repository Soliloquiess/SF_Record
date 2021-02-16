package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	public static void main(String[] args) throws Exception, IOException {
		Stack<int[]> st = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stt = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			int v = Integer.parseInt(stt.nextToken());
			while (!st.isEmpty()) {
				if (st.peek()[1] >= v) {
					System.out.print(st.peek()[0] + " ");
					break;
				}
				st.pop();
			}
			if (st.isEmpty()) {
				System.out.print("0 ");
			}
			st.push(new int[] { i, v });
		}
	}
}


/*


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 탑의 정보
class topInfo {
	int pos; // 위치
	int val; // 높이

	public topInfo(int pos, int val) {
		super();
		this.pos = pos;
		this.val = val;
	}

}

public class BJ2493_탑 {

	static int N; // 탑의 갯수
	static Stack<topInfo> tops; // 탑을 담을 stack

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int num; // 탑의 높이를 담을 변수

		// input & solution
		N = Integer.parseInt(br.readLine());
		tops = new Stack<topInfo>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			num = Integer.parseInt(st.nextToken()); // 탑의 높이
			
			// 스택에 저장된 값이 있는 경우
			while (!tops.isEmpty()) {
				
				// 스택 최상에 있는 탑의 높이보다 작거나 같은 경우
				if (tops.peek().val >= num) {
					sb.append(tops.peek().pos + " "); // 해당하는 탑의 좌표를 sb에 append
					break; // pop을 하지 않고 while문 탈출
				}
				
				// 스택 최상에 있는 탑의 높이보다 큰 경우
				tops.pop();
			}
			
			// 스택에 저장된 값이 없는 경우
			if (tops.isEmpty()) {
				sb.append(0 + " "); // '0'을 sb에 append
			}
			
			// 반복문 중 이번에 받는 탑의 정보를 스택에 추가
			tops.push(new topInfo(i, num));
		}

		// output
		bw.write(sb + "");
		bw.flush();
		bw.close();
		br.close();

	}
}

*/