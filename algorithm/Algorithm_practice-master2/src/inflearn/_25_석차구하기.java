package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _25_�������ϱ� {
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc = new Scanner(System.in);
		int i, j,  n;
		int []a = new int[200];
		int []b= new int[200];
//		scanf("%d", &n);
		st= new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());

		st= new StringTokenizer(br.readLine()," ");
		for (i = 1; i <= n; i++) {
//			scanf("%d", &a[i]);		//pdf ���� a[1]���� a[5]���� 1 �� ��
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = 1;				//���� 1�� �ʱ�ȭ(ó���� �迭 ���� 1��)
		}
		for (i = 1; i <= n; i++) {	
			for (j = 1; j <= n; j++) {		//a[i] �� a[j] �� ��
				if (a[j] > a[i]) b[i]++;	//�� �պ���  j ������Ű�鼭 j�� �� ũ�� i���� ����.
			}
		}
		for (i = 1; i <= n; i++) {
			System.out.printf("%d ", b[i]);
		}
	}	
}