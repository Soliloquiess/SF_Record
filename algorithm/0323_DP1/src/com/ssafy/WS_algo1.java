package com.ssafy;

public class WS_algo1 {
	public static void main(String[] args) {
		int N = 8;
		//1.���ؾ��ϴ� ���� �������� �� �� �Ẹ��
		//N���� ����Ʈ�� ĥ�� �� �ִ� ����� ��
		
		
		//2.���� ������ ���� �迭(N)�� ����.
		int [][] D = new int[N+1][2];
		D[1][0] = 1;	//�����	//1������(0���� �����Ƿ�)
		D[1][1] = 1;	//1������ ����� �� �ִ� �Ķ��� ������
		
		for(int i =2; i<=N; i++) {
			D[i][0] = D[i-1][0] +D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		System.out.println(D[N][0]+D[N][1]);
	}
}
