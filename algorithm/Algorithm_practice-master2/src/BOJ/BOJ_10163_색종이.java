package BOJ;

//public class BOJ_10163_������ {
//
//}

import java.util.*;

public class BOJ_10163_������ {
	static int N; //������ ����
	static int[][] map; // ��ȭ��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //������ ����
		
		map = new int[10][10]; // ��ȭ�� ũ�� �ִ� ����, ���� 101ĭ
		
		for(int tc=1; tc<=N;tc++) {
			int a =sc.nextInt(); // X��ǥ
			int b =sc.nextInt(); // Y��ǥ
			int c =sc.nextInt(); // �ʺ�
			int d =sc.nextInt(); // ����
			
			//�������� ũ�⸸ŭ Ž���ϸ鼭 x,y��ǥ�� ù ��° �׽�Ʈ���̽��� 1�� ��� 1�Է� 2�� ��� 2 �Է�
			for(int i=a;i<a+c;i++) {
				for(int j=b;j<b+d;j++) {
					map[i][j] = tc;
				}
			}
		}
		
		//�׽�Ʈ���̽��� 1���� N���� Ž���� �ϸ鼭 ���� ���
		for(int rep=1;rep<=N;rep++) {
			int count=0;
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					if(map[i][j]==rep) count++;
				}
			}
			System.out.println(count);
		}
	}
}