package SWEA;
//
//public class SWEA_1926_������_369���� {
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1926_������_369���� {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int n = sc.nextInt();
		int n = Integer.parseInt(br.readLine());
		for(int i = 1; i <= n; i++) {
			String s = String.valueOf(i);
			int cnt = 0;
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9')
					cnt++;
			}
			if(cnt == 0)
				System.out.print(s);
			else if(cnt == s.length()) {//3,6,9, 33 36 39 �ϋ� ����
				for(int j = 0; j < s.length(); j++) {
					System.out.print("-");
				}
			}
			else	//10�̻󿡼��� 3,6,9 ���� ã�� ��
				System.out.print("-");
			System.out.print(" ");
		}
	}
}