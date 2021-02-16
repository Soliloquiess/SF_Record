package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_ž {
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

// ž�� ����
class topInfo {
	int pos; // ��ġ
	int val; // ����

	public topInfo(int pos, int val) {
		super();
		this.pos = pos;
		this.val = val;
	}

}

public class BJ2493_ž {

	static int N; // ž�� ����
	static Stack<topInfo> tops; // ž�� ���� stack

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int num; // ž�� ���̸� ���� ����

		// input & solution
		N = Integer.parseInt(br.readLine());
		tops = new Stack<topInfo>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			num = Integer.parseInt(st.nextToken()); // ž�� ����
			
			// ���ÿ� ����� ���� �ִ� ���
			while (!tops.isEmpty()) {
				
				// ���� �ֻ� �ִ� ž�� ���̺��� �۰ų� ���� ���
				if (tops.peek().val >= num) {
					sb.append(tops.peek().pos + " "); // �ش��ϴ� ž�� ��ǥ�� sb�� append
					break; // pop�� ���� �ʰ� while�� Ż��
				}
				
				// ���� �ֻ� �ִ� ž�� ���̺��� ū ���
				tops.pop();
			}
			
			// ���ÿ� ����� ���� ���� ���
			if (tops.isEmpty()) {
				sb.append(0 + " "); // '0'�� sb�� append
			}
			
			// �ݺ��� �� �̹��� �޴� ž�� ������ ���ÿ� �߰�
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