package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14_������_�Ҽ� {
		

	static int reverse(int x) {		//�־��� ���� ������ ����.
		int res = 0, tmp;
		while (x > 0) {
			tmp = x % 10;		//52 ����  1ȸ tmp= 2 res=  2ȸ�� tmp=5
			res = res * 10 + tmp;
			x = x / 10;			//x=5�ǹǷ� �ٽ� ���� �ö󰡰�  2ȸ�� 5/10 = 0.5= 0�̴ϱ� while�� �������� 
		}
		return res;
	}
	
	static Boolean isPrime(int x) {		//x�� ������ ���� ¥���� ���ڵ��� �־����� �ȴ�.(������ ���� �Ҽ� �Ǻ�)
		int i;
		if (x == 1) return false;	//1�� �Ҽ��� �ƴϹǷ� �׻� false(����ϸ� �ȵ�.)
		boolean flag = true;	//ó���� ��.
		for (i = 2; i < x; i++) {
			if (x % i == 0) {		//���� ������ i�� x�� ���
				flag = false;		//�Ҽ��ƴϴϱ� false ���Ѽ� ��� �ȵǰ� �Ѵ�.
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) throws IOException {
		
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n, num, i, tmp;
			n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			for (i = 1; i <= n; i++) {
				num = Integer.parseInt(st.nextToken());
				tmp = reverse(num);	//���� ������ �Ҽ����� Ȯ���Ѵ�.
				if (isPrime(tmp)) System.out.printf("%d ", tmp);	//tmp�� �Ҽ����� Ȯ���ϴ� isprime �׸��� tmp�� ����ϸ� ��.
			}
		}
}