package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13_���帹�̻����ڸ��� {
	
	static int []ch = new int[10];
	static int res=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//freopen("input.txt", "rt", stdin);
		int i, digit, max = -2147000000;
		char [] a = new char[101];
		//�Էµ� ���� �о��. string���� �о�� int������ �� �а� ��Ʈ�� ������ �о��!
//		scanf("%s", &a);
		
		String str =br.readLine();
		a = str.toCharArray();
		for (i = 0; i<str.length(); i++) {
			digit = a[i] - 48;	//�ƽ�Ű ���� 0�� 48�̹Ƿ� -48�ϸ� �� ���� 0�� ��.
			ch[digit]++;
		}
		for (i = 0; i <= 9; i++) {
			if (ch[i] >= max) {
				max = ch[i];
				res = i;		//�� �ε��� ��ȣ�� ����(���� ���� i(0���� 9���� �����̴�))
				//res = ch[i]�� ���� �� ���� ���� ���� �ߺ�Ƚ���� ����.
				//ch[i]�� i��� �ְ� ���� Ƚ��
			}
		}

		//�ٵ� 3�� 7�� 5�� 7�� �������� 5�� ���� �Ǿ���.max �� ������ 
		//�׷��� ch[i]>=max�� �ϸ� 3�� 7�ε� 5�� 7�϶� ch[i]>=max�� max���� ���Ƶ� max���� �ٲ�Ƿ� 5�� �ٲ����(�����������Ƿ�)
		System.out.printf("%d\n", res);
	}
}
