package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12_�������Ѱ���_Large {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, sum = 0, cnt = 1, digit = 9, res = 0;
		//n�� �ִ� ���� sum�� ������ cnt�� ī��Ʈ(1�ڸ� ���� 2�ڸ� ����) digit�� �ڸ����� ����.(���ϴ� ��)
		/*
		1*9 =9
		2 90�����
		3  900�����
		4 9000�����
		256�� ���ε�� 256-99 = 157
		���ڸ����� 9���ϱ� 1*9 �ϰ� ���ڸ����� 90���ϱ� 2*90�ϰ�
		���ڸ����� 157���� �ִ°� �׷� 157*3 �ϸ� �Ǵ°� �̷������� ����.
		�׷� ����ġ �ؼ� 660 ���

		*/
		n= Integer.parseInt(br.readLine());
		while (sum + digit < n) {	//n�� 1�̸� �⺻ cnt�� 1�̴ϱ� �״�� 1 ���
			//digit�� �ڸ��� ���� (1�� 9�� 2�� 90�� ...
			sum = sum + digit;
			res = res + (cnt * digit);
			cnt++;
			digit = digit * 10;
		}
		//256�� 999���� �����ϱ� while������ ������ n���� 256-99 =157�� �ڸ��� cnt�� 3 �� �����ָ� ��,.
		res = res + ((n - sum) * cnt);
		System.out.printf("%d\n", res);
	}
}
