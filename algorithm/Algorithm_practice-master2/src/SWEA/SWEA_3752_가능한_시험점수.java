package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

//�κ������� �ƴϴ�. 2�� 100���̱� ����.
//������ ���� N, 2�� 100�� -> �κ����� X
//�Ｚ���״� ���� �߿�. �ٵ� dp�� ���°��� �ٸ�. ������ ��Ұ� ���Ƽ� �Ｚ���׿��� dp�� �� ����.
//��Ž���� �����غ��� �׷� �׸��� �̷������� ���������Ѵ�.
public class SWEA_3752_������_�������� {
//	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static int N;
	static int score[];
	static boolean visited[];
	static int Answer;
	public static void main(String[] args)  throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		//�Է¿� ���� ũ�⵵ ����� ���� �ؼ� �� ������ �־���.
		T = Integer.parseInt(input.readLine());
		for(int t = 1; t<=T;t++) {
			N = Integer.parseInt(input.readLine());
			score = new int[N];
			tokens = new StringTokenizer(input.readLine(), " ");
			int total = 0;
			for(int i = 0; i<N;i++) {
				score[i] = Integer.parseInt(tokens.nextToken());
				total+=score[i];
			}
			//���� �� �ִ� �������� ǥ���� �� �迭.
			visited = new boolean[total+1];
			
			Answer = 0;
			visited[0] = true; //0���� ������ �����Ѵ�.
			solve(0,total);
			output.append("#").append(t).append(" ").append(Answer).append("\n");
		}
	}
	
	static void solve(int n, int max)
	{
		if(n==N) {
			//��~~->��� Ȯ�� - �迭�� ��� üũ �Ǿ��ִ��� ���캸��,.
			for(boolean bool: visited) {
				if(bool) {
					Answer++;
				}
			}
			return;
		}
		for(int i = max; i>=0; i--) {
			if(visited[i]) {
				visited[i+score[n]]=true;	//�ѳ༮ ������ ���� ��ͷ� ���ش�.
			}
		}
		solve(n+1, max);
	}
}


/*
2
3
2 3 5
10
1 1 1 1 1 1 1 1 1 1
 */
//2, 3, 5
// 