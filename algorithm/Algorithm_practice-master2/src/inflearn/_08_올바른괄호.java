package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _08_�ùٸ���ȣ {
	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i, cnt = 0;
		String str =br.readLine();
		char []a = str.toCharArray();
		
		for (i = 0; i<str.length(); i++) {
			if (a[i] == '(') cnt++;	//(�� ����
			else if (a[i] == ')') cnt--;	//)�� ����.
			if (cnt < 0) break;//���⼭ )���� �Է� �Ǹ� �� ���� ������ �Ѵ�. ������ �̰� �ȳְ� )(�� ������ yes�� ����.
			//Ȥ�� (�� ������ �Ǹ� ������.
		}

		if (cnt == 0) System.out.println("YES");
		else System.out.println("NO");

	}
}