package BOJ;

//public class BOJ_2751_�������ϱ�2 {
//
//}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
 
 
public class BOJ_2751_�������ϱ�2 {	
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		// list �迭 �� �ϳ��� ���� �ȴ�.
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		
		for(int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}
}