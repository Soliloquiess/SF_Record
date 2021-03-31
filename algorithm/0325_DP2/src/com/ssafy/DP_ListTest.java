package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

/*
 
LIS : ���Ұ� n���� �迭�� �Ϻ� ���Ҹ� ��󳻼� �κ� ������ ������� ��
������ ���Ҵ� ���� ���Һ��� �� ũ�ٴ� ������ ������ ���̰� �ִ��� �κм���.

LIS[n]:��ü ������ n��° ������ �������� �� ��������� ���� ������ ����.
 */
public class DP_ListTest {
	/*
	 static String src = "6\r\n"+ "3 2 6 4 5 1"
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//������ ����
		int [] arr = new int[N];//���ҵ� ����, ������ ��
		int[] LIS = new int[N]; //�� ���Ҹ� �������� ������ ���� �������
		
		for(int i =0; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		
		/*���翵 ����� �ڵ�*/
		for(int k =0; k<N; k++) {
			LIS[k] =1;	//�ڽŸ����� �����Ǵ� lis;
			for(int i =0 ;i<k; i++) {
				if(arr[i]<arr[k])
					LIS[k] = Math.max(LIS[k], LIS[i]+1);
			}
		}
		
		System.out.println(Arrays.toString(LIS));
		
		/*������ ����� �ڵ� */
//		Arrays.fill(LIS, 1);
//		int max=0; //�ϳ��� �� �������� max �����ϰ�
//		for(int i =0; i<N; i++) {
//			LIS[i]=1;//������ �ݺ� �����ϱ� �׳� �ȿ��� ���� ������.
//			//�ڱ� ȥ�� ������ ���� ���̷� �ʱ�ȭ(�ڽŸ����� �����Ǵ� lis)
//			for(int j =0; j<=i-1;j++) {	//�� �պ��� �ڽ��� ������ ���ҵ�� ��
//				if(arr[j]<arr[i] && LIS[i]<LIS[j]+1) {
//					LIS[i] = LIS[j]+1;	//i��°�� ���� �ִ°�. ���� lis�� i��°
//				}
//			}
//			if(max<LIS[i]) max = LIS[i];
//		}
//		System.out.println(max);
		/* 4 1 4 3 2*/
//		N2�� NlogN���� �ٲٱ⸸ �ص� ���.
//		N�� 10���̸� N2�� 100�� 
//		NlogN�� 10���� ���� log10��
	}
}