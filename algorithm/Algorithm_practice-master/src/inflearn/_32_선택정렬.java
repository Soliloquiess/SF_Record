package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _32_�������� {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		Scanner sc = new Scanner(System.in);
		
		 //freopen("input.txt", "rt", stdin);
	    int []a = new int[101];
	    int n, tmp, idx, i, j;
//	    scanf("%d", &n);
	    n = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    for (i = 0; i < n; i++) {
//	        scanf("%d", &a[i]);
	        a[i] = Integer.parseInt(st.nextToken());
	    }
	    for (i = 0; i < n - 1; i++) {
	        idx = i;
	        for (j = i + 1; j < n; j++) {
	            if (a[j] < a[idx]) idx = j;		//a[j]�� ��� �ٲ�� ����. �� ������ idx�� ���� ���� ���� ��ġ�� ��.
	        }
	        //j�������� �迭 ������ �� ���� ��ġ �ٲٴ� ����.

	        tmp = a[i];
	        a[i] = a[idx];		//idx�� �迭�� �ε���.
	        a[idx] = tmp;
	    }
	    for (i = 0; i < n; i++) {
	        System.out.printf("%d ", a[i]);
	    }
//	    return 0;
	}
}
