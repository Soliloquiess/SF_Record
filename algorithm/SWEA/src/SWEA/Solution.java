package SWEA;


import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();//�׽�Ʈ���̽� �Է�
		
		for(int i=1;i<=T;i++) {
			int sum = 0; //������ ��
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			//�迭 �Է�
			for(int j=0;j<N;j++) {
				String str = sc.next();
				for(int k=0;k<str.length();k++) {
					arr[j][k] = str.charAt(k) - '0';
				}
			}
			
			
			//��� �ﰢ��
			for(int d=0;d<N/2;d++) {
				for(int e = N/2-d; e<=(N/2+d);e++) {
					sum += arr[d][e];
				}
			}
			
			//�ϴ� �ﰢ��
			for(int d=N/2;d>=0;d--) {
				for(int e = N/2-d; e<=N/2+d;e++) {
					sum += arr[N-d-1][e];
				}
			}
			System.out.printf("#%d %d",i,sum);
			System.out.println("");
		}
	}
}