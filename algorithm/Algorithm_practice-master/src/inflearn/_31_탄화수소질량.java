package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _31_źȭ�������� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc= new Scanner(System.in);

//		char a[10];
		char [] a = new char [10];
		int c = 0, h = 0, i, pos;	//c=ź���� ���� , h=������ ���� pos= ������.
//		scanf("%s", &a);
		String str = br.readLine();
		a = str.toCharArray();
		if (a[1] == 'H') {
			c = 1;
			pos = 1;
		}
		else {
			for (i = 1; a[i] != 'H'; i++) {
				c = c * 10 + (a[i] - 48);		//a[i]-48�� �ƽ�Ű �ڵ勚����
			}
			pos = i;	//H�� ��ġ.
		}
		//������ ź�� ��ġ ���Ѱ�

		//�� ���� ���� ���ϱ�

		if (a[pos + 1] == '\0') h = 1; 
		//�ڹٶ� �̰� �Ǵ� ��(�������� +1�� ���ε� �α��� ���°� ���ص�)
		else {
			for (i = pos + 1; i<a.length; i++) {
				h = h * 10 + (a[i] - 48);
			}
		}
		System.out.printf("%d\n", c * 12 + h);
//		printf("%d\n", c * 12 + h);
	}
}

