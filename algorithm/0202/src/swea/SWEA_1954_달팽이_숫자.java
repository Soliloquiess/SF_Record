package swea;

import java.util.Scanner;

public class SWEA_1954_������_���� {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int answer = 1;
		
		// �׽�Ʈ���̽�(T)�� �� ���� �ݺ�
		for(int k=0; k<T; k++) {
			
			// �� ���̽��� �迭, ���� �ʱ�ȭ
			int N = scan.nextInt();
			int [][]arr = new int[N][N];
			int col = 0;	// ��
			int row = -1;	// ��
			int flag = 1;	// ��ġ ����(1, -1)
			int number = 1;	// �� �ֱ�
			int count = N;	// �� ���� ���ڰ� N, N-1, N-1, N-2, N-2, ... �� ����
			System.out.println("#" + answer);
			answer +=1;
			while(true) {
				
				// -> , <- ����
				for(int i=0; i<N; i++) {
					row += flag;	// �� ����
					arr[col][row] = number;
					number += 1;	// ���� 1�� ����
				}
				
				// ->, <-�� ���� �� ������ �ϳ��� ����
				N -= 1;
				if(N == 0)	break;	// ������ �˰����� ���� ����
				
				// �� , �� ����
				for(int i=0; i<N; i++) {
					col += flag;
					arr[col][row] = number;
					number +=1;
				}
				flag *= (-1);	// -> , �� �� ���� �Ŀ��� ��, ���� �����ؾ� �� 
			}
			
			for(int i=0; i<count; i++) {
				for(int j=0; j<count; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
		
		scan.close();
		
	}

}