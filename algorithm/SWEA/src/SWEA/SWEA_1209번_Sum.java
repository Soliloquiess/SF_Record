package SWEA;

//public class SWEA_1209��_Sum {
//
//}
import java.util.Scanner;

public class SWEA_1209��_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			
			int[][] arr = new int[100][100];
			
			int max = 0;
			int sum = 0;
			
			//�迭 �Է�
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			//�� ��
			for(int i=0;i<100;i++) {
				sum = 0;
				for(int j=0;j<100;j++) {
					sum += arr[i][j];
				}
				if(max <= sum) {
					max = sum;
				}
			}
			
			sum = 0;
			
			//�� ��
			for(int j=0;j<100;j++) {
				sum = 0;
				for(int i=0;i<100;i++) {
					sum += arr[i][j];
				}
				if(max <= sum) {
					max = sum;
				}
			}
			
			sum = 0;
			
			//���ʿ��� ������ �밢��
			for(int i=0;i< 100;i++) {
				sum += arr[i][i];
			}
			
			if(max<=sum) max = sum;
			
			sum = 0;
			
			//�����ʿ��� ���� �밢��
			for(int i=99, j=0;i>=0;i--,j++) {
				sum += arr[j][i];
			}
			
			if(max<=sum) max = sum;
			
			System.out.printf("#%d %d",tc,max);
			System.out.println();
		}
	}
}