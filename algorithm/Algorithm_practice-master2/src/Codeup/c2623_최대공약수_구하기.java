package Codeup;

import java.util.Scanner;

public class c2623_�ִ�����_���ϱ� {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int answer = 0;
		
		
		if(a>=b) {
			for(int i=1; i<=a; i++) {
				if(a%i==0 && b%i==0) {
					answer = i;
				}
			}		
		}
		
		if(b>a) {
			for(int i=1; i<=b; i++) {
				if(a%i==0 && b%i==0) {
					answer = i;
				}
			}		
		}
		
		System.out.println(answer);

		sc.close();
		
	}

}
