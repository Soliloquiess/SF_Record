package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _30_3�ǰ�����_large {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);

		int n, left =77 , right, cur, k = 1, res = 0;

		//����Ʈ�� 77�� ������ �ֳ�..? 1�־ �۵�.

		//���� ���� �����ϹǷ� ���� ���� ��������.
		//12345 ���� 1235 1240 1246 1000

//		scanf("%d", &n);s
		n= Integer.parseInt(br.readLine());
		while (left != 0) {	//0�Ǹ� ����
	
			left = n / (k * 10);	//12345 /10 =1234
			right = n % k;			//12345 %1 =0 (1�� ������ ������ 0�� ��)
			cur = (n / k) % 10;		//cur�� �����ڸ����� ��ġ. 5 ����.
	
	
			if (3 < cur) {			//���� �ڸ����� 3���� ũ�� 
				res = res + ((left + 1) * k);		//lt�� �÷��� +1 ���ְ� *k �����ش�.
			}
			else if (3 == cur) {	//�ڸ����� 3�� ���ٸ�.
				res = res + ((left * k) + (right + 1));		//left�� +1 ���ָ� �ȵ�.(3�̶� ġ�� �� ������ k���ϰ� �ڿ� rt �ִµ�
				//00~45���� ����Ƿ� +1 �����.
			}
	
			else res = res + (left * k);	//3���� ���� ���� lt�� �״�� k���ϸ� ��.
			k = k * 10;
		}
		System.out.printf("%d\n", res);
	}
}