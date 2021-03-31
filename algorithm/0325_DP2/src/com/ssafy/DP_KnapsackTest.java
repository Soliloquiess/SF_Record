package com.ssafy;

import java.util.Scanner;

public class DP_KnapsackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int [] weights = new int[N+1];//������ ��������
		int [] profits = new int[N+1];//������ ��ġ ����
		int [][]D = new int[N+1][W+1];//�ش� ���Ǳ��� �����Ͽ� �ش� ���Ը� ���� ���� �ִ� ��ġ
		
		for(int i =1; i<=N;i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
			
		}
		for(int i =1; i<=N;i++) {	//ù ���Ǻ��� ����
			for(int w = 1; w<=W;W++)// ���� 1���� ����
			{
				if(weights[i]<=w) {//���濡 ���� �� �ִ� ��Ȳ
					//������
					Math.max(D[i-1][w-weights[i]]+profits[i],D[i-1][w]);	//�ڽ��� ���鼭 ����� ��ġ.
					//����
					D[i][w] = D[i-1][w];
					
				}else {	//���濡 ���� ���ϴ� ��Ȳ
					D[i][w] = D[i-1][w];
					
				}
				//�ð����⵵��? for 2�� ���鼭 ������ �����Ѵ� ġ�� n2
				//�ٵ� ������̸� ������ 30���� �ǵ� 2�� 30���̿���. ������ ū ����.
				//����ϴ� �������� � ���԰�ġ���� ������ �𸥴�.
				//������ ���� �ֵ鵵 ����. ���ʿ��� �� ���� �� ����. DP�� �� ����ϴµ� ����Ʈ�ϰ� ���Ѵ�(����Ʈ�� ��Ž)
			}
			
		}
		System.out.println(D[N][W]);
		
	}
}