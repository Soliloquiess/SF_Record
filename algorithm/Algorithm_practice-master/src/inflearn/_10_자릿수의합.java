package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10_�ڸ������� {
	static int digit_sum(int x) {
		int sum = 0, tmp;
		while (x > 0) {	//125�� ���̹Ƿ� 
			tmp = x % 10;			//���� x=125�϶� tmp 5 sum 5, �� ���� ���� x=12,tmp=2,sum=7, �� �ѹ������� x=1,tmp=1, sum =8
									//�׸��� 0 �ǰ� sum ����.
			sum = sum + tmp;
			x = x / 10;
		}
		return sum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int n, num, i, sum, max = -2147000000, res = 0;
		
	
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (i = 1; i <= n; i++) {

			num =  Integer.parseInt(st.nextToken());
			sum = digit_sum(num);		//digit_sum �Լ��� num�� �Ѿ.
			if (sum > max) {
				max = sum;
				res = num;
			}
			else if (sum == max) {		//���ϴ� ���� ���� max���� max�� ���� sum���� ������.
				if (num > res) res = num;		//���� ���� ���� num�� ������ res���� ũ�� �ڿ��� ��ü�� ū ���� res�� �־��.
												//�ڸ����� ���� ������ ū �� ���
				//num �� sum���� ���� ����, res�� max�� ���ϴ� ����.
			}
		}
		System.out.printf("%d\n", res);
	}
}