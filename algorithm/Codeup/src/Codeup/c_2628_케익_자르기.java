package Codeup;

import java.util.Scanner;

public class c_2628_����_�ڸ��� {
	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
		    int a, b, c, d, t;
//		    scanf("%d%d%d%d", &a, &b, &c, &d);
		    a=sc.nextInt();
		    b=sc.nextInt();
		    c=sc.nextInt();
		    d=sc.nextInt();
		    if (a < b) {
		    	t = a; a = b; b = t;    // a�� b�� ũ�Ⱑ �ݴ��� swap! 
		    }
		    
		    int k = 0;    // k : a�� b ���̿� �ִ� ���� ���� 
		    if (a < c || c < b) k++; 
		    if (a < d || d < b) k++;
		    
		    System.out.print(k == 1 ? "cross" : "not cross");  // k == 1�̸� Cross, �ƴϸ� Not Cross 
		   

	}
}
