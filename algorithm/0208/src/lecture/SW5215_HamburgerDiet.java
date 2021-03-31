package lecture;

import java.util.Scanner;

public class SW5215_HamburgerDiet {
	static int R[][], maxCal;//R[][]:����Ằ ������ Į�θ� ������ �迭
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//tc no
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();//��� ����
			maxCal = sc.nextInt();//���� ����
			
			R = new int[N][2];//[0]���� ���� ����, [1]Į�θ�
			for (int i = 0; i < N; i++) {
				R[i][0] = sc.nextInt();//����
				R[i][1] = sc.nextInt();//Į�θ�
			}
			
			//�� ��Ằ ������ ����� �׶��� �������� �ְ��� �� ã��
			int idx = 0;//������ ��� ��ȣ
			int score = 0;//������. ��Ḧ ������ ���� ������ �ö�.
			
			int max = find(idx, score, maxCal);
			System.out.println("#" + tc + " " + max);			
		}//for
	}//main

	//idx��° ��Ḧ ����ؼ�(�������� �ְ� ������ �ִ�) ������ ������� �� 
	//Į�θ� üũ �� ������ �����ϴ� �Լ� 
	//idx:����� ��� ��ȣ, score: idx��° ��Ḧ ����������� ������, remain:�����ִ� ��� ���� Į�θ�
	private static int find(int idx, int score, int remain) {
		if(remain < 0) {//���� ���� �ȵ�
			return 0;
		}
		if(remain == 0) {//���� ���� �ȿ��� ���� �ϼ�
			return score;//�� ������ ������ ����
		}
		if(idx == R.length) {//��� ��Ḧ ���� ����µ� �� ���
			return score;//�� ������ ������ ����
		}		
		
		//idx��° ��Ḧ ������� ���� ���
		int v1 = find(idx+1, score, remain);//�״��� ���� 
		
		//idx��° ��Ḧ ����� ���-�������� ������ �����ϰ� ���� ���� ��
		//R[idx][0]: idx��° ����� ������. R[idx][1]: idx��° ����� Į�θ�
		int v2 = find(idx+1, score + R[idx][0], remain - R[idx][1] );
		
		return Math.max(v1,  v2);
	}
	
	
	
}
