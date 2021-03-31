package lecture;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo3 {
	static int N, M, result = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//�����ڰ� ��� ������ �н����� �ִ밪(0<=N<=1000)
		M = Integer.parseInt(br.readLine());//��Ŀ�� ����� �н����� ����
		
		int[] attack = new int[M];//��Ŀ�� ����� �н����� ���� �迭
		StringTokenizer st = new StringTokenizer(br.readLine());//��Ŀ�� ����� �н������
		
		for (int i = 0; i < M; i++) {
			attack[i] = Integer.parseInt(st.nextToken());//��Ŀ�� �õ��� �н����� ����
		}
	
		//��� ������ �н����� �ĺ��� ��Ŀ�� ����� �н����带 ���ϸ鼭 �����Ÿ� ����ϱ�(min)
		for (int i = 0; i < N; i++) {//������ �н����� ����
			int safeDistance = Integer.MAX_VALUE;//�����Ÿ�
			
			for (int j = 0; j < attack.length; j++) {//�����Ÿ� ���
				int tmp = 0; //���. ���� �ٸ� ��Ʈ �� ����� ����
				tmp = countDiffBit(i, attack[j]);				
				safeDistance = Math.min(safeDistance, tmp);				
			}
			
			result = Math.max(safeDistance, result);			
		}
			System.out.println(result);		
	}

	//�н����� �ĺ��� ��Ŀ�� ����� �н����带 ���ϸ鼭 �����Ÿ� ����ϱ�(min)
	private static int countDiffBit(int admin, int hacker) {
		//^(xor):exclusive or
		int tmp = admin ^ hacker;///���� �ٸ� ��Ʈ�� 1�� ����
		int cnt = 0;
		//xor�� ����� ������ ���ڿ� ��ȯ -> char[]
		char[] s = Integer.toBinaryString(tmp).toCharArray();
		for (int i = 0; i < s.length; i++) {
			if(s[i] == '1')
				cnt++;
		}
		return cnt;
	}

}
