package SWEA;

import java.util.*;

public class SWEA_1983_������_�����ű�� {
	 static String[] score={"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // �׽�Ʈ ���̽��� ����
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt(); //�л� ��
			int K = sc.nextInt(); //�˰���� �л��� ��ȣ
			
			double find_score = 0.0; //K��ȣ�� ������ ã�� ���� ����
			Double[] result = new Double[N];
			
			//�Է¹ޱ�
			for(int i=0;i<N;i++) {
				int mid_score = sc.nextInt();//�߰���� ����
				int final_score = sc.nextInt();//�⸻��� ����
				int sub_score = sc.nextInt();//���� ����
				double sum = 0.35 * mid_score + 0.45 * final_score + 0.20 * sub_score; //����
				result[i] = sum;
				if(i+1==K) find_score = sum;
			}
			
			Arrays.sort(result, Collections.reverseOrder());
			
			int index = 0;
			for(int i=0;i<result.length;i++) {
				if(result[i]==find_score) {
					index = i;
				}
			}
			
			index = index / (N/10);
			
			System.out.printf("#%d %s\n",tc,score[index]);
			
			
			
			
			
			
		}
	}
}
