package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11_�������Ѱ��� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, i, cnt = 0, tmp;
		n= Integer.parseInt(br.readLine());
		for (i = 1; i <= n; i++) {
			tmp = i;
			while (tmp > 0) {
				tmp = tmp / 10; //�̰� ���ڸ��� �������°� ���������� 0�� ��.
				//123�̸� 
				//12 �ǰ� ī���� 1 �ǰ�
				//1 �ǰ� ī���� 2���ǰ� �ٽ� ���鼭 
				//0 �ǰ� ī���� 3 �ǰ� �극��ũ �ϰ� �ö󰡼� �ٽ� ���
				//123�̸� ī���� 3�� �Ǵ°� (3�ڸ������ ����)
				cnt++;
			}
		}
		System.out.printf("%d\n", cnt);
	}
	
	
}
