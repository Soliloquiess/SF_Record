package Codeup;

//public class c_2631_����_ã�� {
//
//}
import java.util.Scanner;

public class c_2631_����_ã�� {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		int count = 0;
		int arrplus = 0;
		
		while(arrplus<n) {
			for(int i=arrplus; i<n; i++) {
				sum = sum + arr[i];
				if(sum==k) {
					count++;
					break;
				}
				if(sum>k) {
					break;
				}
			}
			sum = 0;
			arrplus++;
		}
		
		System.out.println(count);
		sc.close();
	}

}
