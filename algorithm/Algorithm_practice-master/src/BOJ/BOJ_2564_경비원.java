package BOJ;

//public class BOJ_2564_���� {
//
//}
import java.util.Scanner;

/**
 * @author YSM
 *
 */
public class BOJ_2564_���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();	//����
		int c = sc.nextInt();	//�迭 ����
		int n = sc.nextInt();	//������ ����
		
		int[] pos = new int[n+1];
		
		// 0,0 �������� ��� ������ �������� �Ÿ��� �Է�.
		// ���� �𷯸��� �Ÿ� ����� �������� �Ѵ�.
		for(int i = 0; i <= n; i++) {
			int block = sc.nextInt();	//����ġ(��������)
			int point = sc.nextInt();	//�Ÿ�?
			switch(block) {
			case 1:	//�Z
				pos[i] = point;
				break;
			case 2:	//��
				pos[i] = 2*r + c - point;
				break;
			case 3:	//��
				pos[i] = 2*(r + c) - point;
				break;
			case 4:	//��
				pos[i] = r + point;
				break;
			}
		}
		int totalDistance = 0;
		for( int i = 0; i < n; i++) {
			int tmp = Math.abs(pos[i]-pos[n]); // �ݽð�
			int tmp2 = 2*(r+c) - tmp; // �ð�
			totalDistance += tmp < tmp2 ? tmp : tmp2;
		}
		System.out.println(totalDistance);
	}
}

/*

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ���� X�� ��ġ ��� �ٱ�~
		String[] line = br.readLine().split(" ");
		int R = Integer.parseInt(line[0]);
		int C = Integer.parseInt(line[1]);

		int N = Integer.parseInt(br.readLine());
		int[] dist = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			line = br.readLine().split(" ");
			int w = Integer.parseInt(line[0]);
			int d = Integer.parseInt(line[1]);

			//���� 0 ��ġ�� �������� �ð���� �Ÿ� ���
			if (w == 1) {
				dist[i] = 2 * R + C - d;
			} else if (w == 2) {
				dist[i] = d;
			} else if (w == 3) {
				dist[i] = 2 * R + C + d;
			} else if (w == 4) {
				dist[i] = R + C - d;
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			dist[i] = Math.abs(dist[i] - dist[N]);  // �������� ��ġ�� �������� �Ÿ� ���
			dist[i] = Math.min(dist[i], 2*R+2*C - dist[i]);
			answer += dist[i];
		}

		System.out.println(answer);
	}

}
*/
