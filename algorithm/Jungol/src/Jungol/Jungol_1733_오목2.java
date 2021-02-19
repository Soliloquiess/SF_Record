package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jungol_1733_����2 {
	public static int [][] m = new int[19+2][19+2]; //�迭�� ��� �׵θ��� 1�� ���
	private static int answerColor=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 1; i<=19;i++) {	// 0���� �� ��, 1~19
			String line = br.readLine();
			for(int j = 1, index=0; j<=19;j++,index+=2) {
				m[i][j] = line.charAt(index) - '0';	//�Է�, 0:����, 1:��,2:��
			}
		}
		for (int r = 1; r<=19;r++) {	//��
			for(int c = 1; c<=19; c++) {	//��
				if(m[r][c] ==0) { continue;}	//���� �������� ������ ����ĭ���� �Ѿ��
				if(complete(r,c)) { // �����̸� true;
					System.out.println(answerColor);
					System.out.println(r+" "+c);
					return;	// ���α׷� ����
				}
			}
		}
		System.out.println(0);
	}	//end of main
	/* r,c, ��ǥ���� �����ϴ� ������ �Ǿ����� Ȯ�� �����̸� true, �ƴϸ� false���� �޼��� */
	 private static int[] dr = {-1,0,1,1}; // ���,��,����,��
	 private static int[] dc = {1,1,1,0}; // ���,��,����,��
	 
	 public static boolean complete(int r, int c) {
		 int color = m[r][c];
dir:	 for(int k = 0; k<dc.length;k++) {	//4���� �������
			 if(m[r-dr[k]][c-dc[k]]==color) { //���� ĭ�� �ٸ�������
				 continue; //������������ �Ѿ�� 
			 }
			 for(int i =1; i<5; i++) {	//�������� Ȯ��
				 if(m[r+dr[k]*i][c+dc[k]*i]!=color) {	//�������̿�����.
					 continue dir; //���� �������� �Ѿ��
				 }	//���� ĭ�� �ٸ�������
			 }	
			 //������
			 answerColor = color;
			 return true;
		 }	//end of for k
		 return false; //���� �ƴ�
	 }
}
