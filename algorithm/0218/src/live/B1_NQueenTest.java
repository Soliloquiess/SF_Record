package live;

import java.util.Scanner;

public class B1_NQueenTest {
	static int ans, N;
	static int[] col;
	
	//���� �࿡�� ���� �ʴ� ���
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new int[N+1];
		setQueen(0);
		System.out.println(ans);
	}
	public static void setQueen(int rowNo) {
		
		// ���� ��尡 �������� ������ ���ư���
		if(!isAvailable(rowNo)) {
			return;
		}
		
		if(rowNo==N) {
			ans++;
			return;
		}
		
		//�ڽĳ���� ������ �Ļ�
		for(int i = 1; i<=N;i++) {
			col[rowNo+1] = i;
			setQueen(rowNo+1);
		}
	}
	
	private static boolean isAvailable(int rowNo) {
		for(int i = 1; i<rowNo;i++) {
			//���� ���� �������� ��ġ�� false
			if(col[rowNo]==col[i] || Math.abs(col[rowNo]-col[i])==rowNo-i) return false;
		}
		return true;
	}
}