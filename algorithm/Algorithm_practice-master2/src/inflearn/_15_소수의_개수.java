package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15_�Ҽ���_���� {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, i, j, flag, cnt = 0;
	
		n = Integer.parseInt(br.readLine());
		for (i = 2; i <= n; i++) {
			flag = 1;
			for (j = 2;  j*j <= i; j++) { //for (j = 2;  j < i; j++) �̷��� �ᵵ ������ ��(j<=i�� �ȵȴ�! �ڱ� �ڽ����� ������ ������ 1�� �����ͼ� �Ҽ� �ƴϰ� �ǹǷ�)�ٵ� �̿� ���� �ϸ� Ÿ�Ӹ���Ʈ �ɸ���.
				//j*j�� ������ 
				//36�� ���ε�� 1*36 2*18 3*12 4*9 6*6 ó�� ���ʺκи� Ȯ�εǸ� �������� ���ص� ��� �ִ°� �� �� ����.
				//��Ʈ 36������ ������ ��(��Ʈ i����)
				//j*j<=i���ָ� ������ ȿ�� ���ϱ�
				//���⼭�� <=i�����(��Ʈ�̹Ƿ� 6 6 �϶� �� 36)
				if (i % j == 0) {	//i�� �Ҽ��� �ƴϸ�
					flag = 0;	//false
					break;
				}
			}
			//���ΰ� �ϳ��� ������
			if (flag == 1) cnt++;	//�Ҽ��� ī��Ʈ �߰�
		}
		System.out.printf("%d\n", cnt);
	}
}
