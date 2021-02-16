package SWEA;

import java.util.*;

public class SWEA_9229번_한빈이와_Spot_Mart  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr = new int[N];
			for(int i=0;i<N;i++) arr[i] = sc.nextInt();
			
			int max = 0;
			int sum = 0;
			
			//배열 2개 선택해서 M보다 작거나 같으면서 max찾기
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					sum = arr[i] + arr[j];
					if(sum<=M&& max<sum) max = sum;
				}
			}
			if(max==0) System.out.printf("#%d %d\n",tc,-1);
			else System.out.printf("#%d %d\n",tc,max);
		}
	}
}