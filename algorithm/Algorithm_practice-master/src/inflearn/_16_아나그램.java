package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16_�Ƴ��׷� {
	static int []a = new int [60];
	static int []b = new int [60];
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n, i;
		String str = br.readLine();

		char []arr = str.toCharArray();
//		scanf("%s", &str);
		for (i = 0; i<arr.length; i++) {
			if (arr[i] >= 65 && arr[i] <= 90)
				a[arr[i] - 64]++; //�ҹ��ڴ� 65~90 a[1]�� �����Ϸ��� 65-64 �ϸ� 1 ����
			
			else a[arr[i] - 70]++; 
			//65~90���̰� �ƴҶ� �������� -70�ϴ°�. �׷��� a[27]���� �ö�.
			//-70�ϴ°� �ҹ��� a�� 97�̰� ���ĺ� ���� 26�� 96�� Z�̹Ƿ� 97�� a�� -27�ؾ� a[27]�� ���尡��
		}

//		scanf("%s", &str);
		String str2 = br.readLine();

		char []arr2 = str.toCharArray();
		for (i = 0; i<arr2.length; i++) {
			if (arr2[i] >= 65 && arr2[i] <= 90)
				b[arr2[i] - 64]++;
			else b[arr2[i] - 70]++;
		}

		for (i = 1; i <= 52; i++) {		//�Ƴ��׷����� �ƴ��� Ȯ��( ���ĺ� �ҹ��� �빮�� ���ϸ� 52)
			if (a[i] != b[i]) {			//������ �ϳ��� �ٸ��� �Ƴ��׷� �ƴ�./
				System.out.print("NO\n");
//				exit(0);
				System.exit(0);
			}
		}
		System.out.print("YES\n");
	}
}