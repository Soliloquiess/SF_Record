package SWEA;

import java.util.*;

public class SWEA_1228_암호문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			LinkedList<Integer> List = new LinkedList<>();
			int N = sc.nextInt(); // 원본 암호문의 길이
			
			// 원본 암호문 입력
			for (int i = 0; i < N; i++)
				List.add(sc.nextInt());
			
			int count = sc.nextInt(); // 명령어 개수
			
			// 명령어 개수만큼 반복
			for (int i = 0; i < count; i++) {
				String order = sc.next();
				int X = sc.nextInt(); // 앞에서부터의 위치
				int Y = sc.nextInt(); // 삽입될 숫자 개수
				for (int j = 0; j < Y; j++) {
					List.add(X, sc.nextInt());
					X += 1;
				}
			}
			
            //출력
			System.out.printf("#%d ",tc);
			for(int i=0;i<10;i++) {
				System.out.print(List.poll() + " ");
			}
			System.out.println();
		}
	}
}